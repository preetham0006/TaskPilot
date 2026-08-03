# 🚀 TaskPilot

TaskPilot is a Java-based Task Management System built to practice software engineering concepts through incremental versions. It started as a simple console application and has evolved into a database-backed application using JDBC and MySQL.

---

## ✨ Features

- Add Task
- View All Tasks
- Find Task by ID
- Search by Priority
- Search by Status
- Search by Category
- Search by Due Date
- Update Task Status
- Delete Task
- Sort by:
  - Priority
  - Status
  - Title
  - Due Date
  - Category
- Dashboard Statistics
  - Total Tasks
  - Completed Tasks
  - Pending Tasks
  - Overdue Tasks
  - Due Today
  - Upcoming Tasks

---

## 🛠 Tech Stack

- Java 25
- JDBC
- MySQL
- VS Code
- Git & GitHub

---

## 🏗 Project Architecture

```
ConsoleUI
     │
     ▼
TaskManager (Service Layer)
     │
     ▼
TaskRepository
     │
     ▼
DatabaseConnection
     │
     ▼
MySQL
```

---

## 📂 Project Structure

```
src/
├── database/
├── model/
├── repository/
├── service/
├── ui/
└── Main.java
```

---

## 🚀 Concepts Implemented

### Core Java

- OOP
- Enums
- Collections
- Exception Handling
- Java Time API

### Functional Programming

- Streams API
- Lambda Expressions
- Predicate

### Database

- JDBC
- MySQL
- PreparedStatement
- ResultSet
- CRUD Operations

### Software Engineering

- Layered Architecture
- Repository Pattern
- Separation of Concerns

---

## 🎯 Future Enhancements

- Spring Boot REST API
- React Frontend
- User Authentication
- Docker Deployment
- Unit Testing