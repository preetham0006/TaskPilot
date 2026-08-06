# 🚀 TaskPilot

> A Spring Boot REST API for efficient task management built using Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL.

TaskPilot is a backend application that enables users to create, retrieve, update, and delete tasks through RESTful APIs. This project started as a Core Java console application and has been migrated to a modern Spring Boot architecture following layered design principles.

---

## ✨ Features

- ✅ Create a new task
- ✅ Retrieve all tasks
- ✅ Retrieve a task by ID
- ✅ Update an existing task
- ✅ Delete a task
- ✅ MySQL database integration
- ✅ Spring Data JPA & Hibernate
- ✅ Layered Architecture
- 🔄 Request Validation *(Coming Soon)*
- 🔄 Global Exception Handling *(Coming Soon)*
- 🔄 DTO Pattern *(Coming Soon)*
- 🔄 JWT Authentication *(Coming Soon)*
- 🔄 React Frontend *(Coming Soon)*

---

# 🛠 Tech Stack

| Technology | Usage |
|------------|------|
| Java 21 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Data JPA | Database Access |
| Hibernate | ORM |
| MySQL | Database |
| Maven | Dependency Management |
| Postman | API Testing |
| Git & GitHub | Version Control |

---

# 🏗 Architecture

```
Client (Postman)

        │

        ▼

TaskController
        │
        ▼
TaskService
        │
        ▼
TaskRepository (JPA)
        │
        ▼
Hibernate
        │
        ▼
MySQL Database
```

The application follows a layered architecture that separates responsibilities into Controller, Service, Repository, and Entity layers, improving maintainability and scalability.

---

# 📂 Project Structure

```
src
 ├── main
 │   ├── java
 │   │    └── com.preetham.taskpilot
 │   │         ├── controller
 │   │         ├── service
 │   │         ├── repository
 │   │         ├── entity
 │   │         ├── dto
 │   │         └── config
 │   └── resources
 │        └── application.properties
 │
 └── test
```

---

# 📡 REST API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/tasks` | Get all tasks |
| GET | `/tasks/{id}` | Get task by ID |
| POST | `/tasks` | Create a task |
| PUT | `/tasks/{id}` | Update a task |
| DELETE | `/tasks/{id}` | Delete a task |

---

# 🗄 Database

Database: **MySQL**

Example Table:

| Column | Type |
|---------|------|
| id | INT (Primary Key, Auto Increment) |
| title | VARCHAR(255) |

---

# ⚙️ Getting Started

## 1️⃣ Clone the Repository

```bash
git clone https://github.com/preetham0006/TaskPilot.git
```

## 2️⃣ Navigate to the Project

```bash
cd TaskPilot
```

## 3️⃣ Configure MySQL

Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskpilot
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
```

## 4️⃣ Run the Application

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

Application runs on

```
http://localhost:8080
```

---

# 🧪 API Testing

The APIs were tested using **Postman**.

Example Request

```
POST /tasks
```

```json
{
    "title":"Learn Spring Boot"
}
```

Example Response

```json
{
    "id": 1,
    "title": "Learn Spring Boot"
}
```

---

# 📈 Roadmap

- [x] Core Java Task Manager
- [x] JDBC Integration
- [x] Spring Boot Migration
- [x] RESTful CRUD APIs
- [ ] Request Validation
- [ ] Global Exception Handling
- [ ] DTO Layer
- [ ] Pagination & Sorting
- [ ] Swagger API Documentation
- [ ] Spring Security
- [ ] JWT Authentication
- [ ] User Management
- [ ] React Frontend
- [ ] Docker Deployment
- [ ] CI/CD Pipeline

---

# 📚 Concepts Demonstrated

- Object-Oriented Programming
- RESTful API Design
- Spring Boot
- Dependency Injection
- Spring Data JPA
- Hibernate ORM
- Repository Pattern
- Layered Architecture
- MySQL Integration
- CRUD Operations
- Git Version Control

---

# 👨‍💻 Author

**Preetham Gowda H R**

- GitHub: https://github.com/preetham0006
- LinkedIn: https://linkedin.com/in/preetham-gowda-62295128a

---

## ⭐ If you found this project useful, consider giving it a star!