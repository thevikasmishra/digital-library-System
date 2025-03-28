# Digital Library API 📚


This is a RESTful API for managing a digital library using **Spring Boot, JPA, and MySQL**.

## 🚀 Features
- **CRUD operations** for books
- **Search books** by ID or Title
- **Spring Boot & JPA integration**
- **Deployed on Render (or Railway)**

## HTTP Method	Endpoint	Description	Request Body	Response

POST	/api/v1/books/add	Add a new book	{ "title": "Book Title", "author": "Author Name", "genre": "Fiction", "availability": "Available" }	"Book saved successfully" (201 Created)
PUT	/api/v1/books/update/{id}	Update an existing book	{ "title": "Updated Title", "author": "Updated Author", "genre": "Updated Genre", "availability": "Not Available" }	"Book updated successfully" (200 OK) or "Book not found" (404 Not Found)
DELETE	/api/v1/books/delete/{id}	Delete a book by ID	None	"Book deleted successfully" (200 OK)
GET	/api/v1/books/{id}	Get book details by ID	None	Returns a JSON object of the book or 404 Not Found if not found
GET	/api/v1/books/all	Get a list of all books	None	Returns a JSON array of books


## 🛠️ Setup Instructions
### 1️⃣ Clone the Repository
```sh
git clone
(https://github.com/thevikasmishra/digital-library-System.git
)


