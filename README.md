# Blogging Application API

A **RESTful Blogging Application** built using **Spring Boot** that allows users to create, manage, and interact with blog posts. The application supports user management, category management, commenting on posts, and structured API responses.

This project demonstrates a layered architecture using **Controller → Service → Repository** design with **DTOs, global exception handling, and RESTful APIs**.

---

## Features

* User registration and management
* Create, update, delete blog posts
* Categorize blog posts
* Comment on blog posts
* Global exception handling
* Structured API responses
* Clean layered architecture
* RESTful API design

---

## Tech Stack

* **Java 8+**
* **Spring Boot**
* **Spring Data JPA**
* **Hibernate**
* **MySQL**
* **Maven**
* **REST APIs**

---

## Project Structure

```
blog-app-api
│
├── controller
│   ├── CategoryController.java
│   ├── CommentController.java
│   ├── PostController.java
│   └── UserController.java
│
├── exception
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFoundException.java
│
├── model
│   ├── Category.java
│   ├── Comment.java
│   ├── Post.java
│   └── User.java
│
├── payloads
│   ├── ApiResponse.java
│   ├── CategoryDto.java
│   ├── PostDto.java
│   └── UserDto.java
│
├── repository
│   ├── CategoryRepository.java
│   ├── CommentRepository.java
│   ├── PostRepository.java
│   └── UserRepository.java
│
├── service
│   ├── CategoryService.java
│   ├── CommentService.java
│   ├── PostService.java
│   └── UserService.java
│
├── service/impl
│   ├── CategoryServiceImpl.java
│   ├── CommentServiceImpl.java
│   ├── PostServiceImpl.java
│   └── UserServiceImpl.java
│
└── BlogAppApiApplication.java
```

---

## API Modules

### User APIs

* Create User
* Update User
* Delete User
* Get User by ID
* Get All Users

### Category APIs

* Create Category
* Update Category
* Delete Category
* Get Category by ID
* Get All Categories

### Post APIs

* Create Post
* Update Post
* Delete Post
* Get Post by ID
* Get All Posts
* Get Posts by Category
* Get Posts by User

### Comment APIs

* Create Comment
* Delete Comment
* Get Comments for Post

---

## Running the Application

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/blogging-application.git
cd blogging-application
```

### 2. Configure Database

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/blog_app
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3. Build the Project

```bash
mvn clean install
```

---

### 4. Run the Application

```bash
mvn spring-boot:run
```

Or run the main class:

```
BlogAppApiApplication.java
```

---

## API Base URL

```
http://localhost:8080/api/
```

Example:

```
GET /api/posts
POST /api/users
POST /api/categories
```

---

## Example JSON Request

### Create User

```
POST /api/users
```

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password"
}
```

---

## Exception Handling

The application uses a **GlobalExceptionHandler** to manage exceptions across the application and return meaningful API responses.

Example:

```
ResourceNotFoundException
```

---

## Future Improvements

* Add Spring Security with JWT authentication
* Pagination and sorting for posts
* Search functionality for blog posts
* Image upload for posts
* API documentation using Swagger/OpenAPI
* Docker containerization
