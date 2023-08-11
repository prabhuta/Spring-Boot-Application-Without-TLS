// function to display all books data
function fetchData() {
	
	// Start the timer
  	console.time('DataFetch');
  	
  // Make a fetch request to retrieve the data
  fetch('/books')
    .then(response => response.json())
    .then(data => {
      // Get the reference to the table body
      const tableBody = document.getElementById('book-table-body');

      // Iterate over the data and create table rows
      data.forEach(book => {
        // Create a new row element
        const row = document.createElement('tr');

        // Create table cells and populate them with data
        row.innerHTML = `
          <td>${book.id}</td>
          <td>${book.title}</td>
          <td>${book.series}</td>
          <td>${book.author}</td>
          <td>${book.language}</td>
          <td>${book.isbn}</td>
          <td>${book.publisher}</td>
          <td>${book.numRatings}</td>
          <td>${book.likedPercent}</td>
          <td>${book.bbeScore}</td>
          <td>${book.bbeVotes}</td>
          <td>${book.price}</td>
        `;

        // Append the row to the table body
        tableBody.appendChild(row);
      });
      // Stop the timer and calculate the elapsed time
      console.timeEnd('DataFetch');
    })
    .catch(error => {
      console.error('Error fetching data:', error);
    });
}

// Call the fetchData function when the page loads
fetchData();


// function to filter by author
function filterTable() {
  const author = document.getElementById('author-filter').value.trim();

  fetch(`/books/author/${author}`)
    .then(response => response.json())
    .then(data => {
		const filteredData = data.filter(book => book.author.toLowerCase().includes(author.toLowerCase()));

      const tableBody = document.getElementById('book-table-body');
      tableBody.innerHTML = '';

      filteredData.forEach(book => {
        const row = document.createElement('tr');
        row.innerHTML = `
          <td>${book.id}</td>
          <td>${book.title}</td>
          <td>${book.series}</td>
          <td>${book.author}</td>
          <td>${book.language}</td>
          <td>${book.isbn}</td>
          <td>${book.publisher}</td>
          <td>${book.numRatings}</td>
          <td>${book.likedPercent}</td>
          <td>${book.bbeScore}</td>
          <td>${book.bbeVotes}</td>
          <td>${book.price}</td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => {
      console.error('Error filtering data:', error);
    });
}


// on clicking Show All
function fetchAndPopulateBooks() {
  // Clear the table body before fetching new data
  const tableBody = document.getElementById('book-table-body');
  tableBody.innerHTML = '';

  // Call the fetchData function to retrieve and populate the book data
  fetchData();
}


// Function to insert book
function insertBook() {
  const form = document.getElementById('insert-book-form');
  const formData = new FormData(form);

  // Check if any required fields are empty
  if (![...formData.values()].every(value => value.trim() !== '')) {
    alert('Please fill in all required fields.');
    return;
  }

  const book = Object.fromEntries(formData.entries());

  fetch('/books', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(book)
  })
    .then(response => {
      if (response.ok) {
        alert('Book inserted successfully!');
        form.reset();
      } else {
        alert('Failed to insert book.');
      }
    })
    .catch(error => {
      console.error('Error inserting book:', error);
    });
}


// function to update book price
function updateBook() {
  const id = document.getElementById('id').value;
  const price = document.getElementById('price').value;

  const updatedBook = {
    price: price
  };

  fetch(`/books/${id}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(updatedBook)
  })
    .then(response => {
      if (response.ok) {
        alert('Book updated successfully!');
        document.getElementById('update-book-form').reset();
      } else {
        alert('Failed to update book.');
      }
    })
    .catch(error => {
      console.error('Error updating book:', error);
    });
}


// function to delete book
function deleteBook() {
  const id = document.getElementById('id').value;
  
  const deletedBook = {
    id:id
  };

  fetch(`/books/${id}`, {
    method: 'DELETE',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(deletedBook)
  })
    .then(response => {
      if (response.ok) {
        alert('Book deleted successfully!');
        document.getElementById('delete-book-info').reset();
      } else {
        alert('Failed to delete book.');
      }
    })
    .catch(error => {
      console.error('Error deleting book:', error);
    });
}