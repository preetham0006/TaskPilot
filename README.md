# 🚀 TaskPilot

TaskPilot is a Java-based console Task Management System developed to strengthen core Java concepts while following clean software engineering principles. The project started as a simple CRUD application and is gradually evolving into a complete full-stack task management platform.

## ✨ Features

### Task Management
- Add new tasks
- Update task status
- Delete tasks
- View all tasks

### Search & Filter
- Search by ID
- Search by Priority
- Search by Status
- Search by Due Date

### Sorting
- Sort by Title
- Sort by Priority
- Sort by Status
- Sort by Due Date

### Due Date Management
- Due Today
- Upcoming Tasks
- Overdue Tasks
- Tasks Due This Week
- Days Remaining

### Dashboard
- Total Tasks
- Completed Tasks
- Pending Tasks
- Overdue Count
- Due Today Count
- Upcoming Count

### Persistence
- Automatic Save
- Automatic Load

### Modern Java Features
- Java Streams API
- Functional Interfaces (Predicate)
- Lambda Expressions
- Method References
- Comparator API

### Categories
- Organize tasks using categories
- Search tasks by category
- Sort tasks by category

Available Categories:
- Work
- Study
- Personal
- Health
- Shopping
- Other

---

## 🛠 Technologies Used

- Java 21+ (Compatible with JDK 25)
- Object-Oriented Programming
- Collections Framework
- Java Streams API
- Functional Interfaces (Predicate)
- Lambda Expressions
- Method References
- Comparator API
- LocalDate API
- File I/O
- Enums

---

## 📂 Project Structure

```
TaskPilot
│
├── comparator
│   ├── PriorityComparator.java
│   └── StatusComparator.java
│
├── docs
│
├── model
│   ├── Task.java
│   ├── Priority.java
│   └── TaskStatus.java
│
├── service
│   └── TaskManager.java
│
├── storage
│   └── FileStorage.java
│
├── ui
│   └── ConsoleUI.java
│
└── Main.java
```

---

## 🏗 Architecture

```
ConsoleUI
     │
     ▼
TaskManager
     │
     ▼
FileStorage
     │
     ▼
tasks.txt
```

---

## 🚀 Getting Started

### Clone Repository

```bash
git clone https://github.com/preetham0006/TaskPilot.git
```

### Run

Compile and execute the project using your preferred Java IDE or VS Code.

---

## 📚 Concepts Covered

- Object-Oriented Programming
- Classes & Objects
- Constructor Overloading
- Enums
- Java Collections
- Comparator API
- File I/O
- Exception Handling
- Package Organization
- Git & GitHub

---

## 🚀 Version History

### v2.2.0
- Added task categories
- Search tasks by category
- Sort tasks by category
- Category persistence in file storage
- Updated console interface

### v2.1.0
- Refactored filtering using Predicate
- Introduced Java Streams API
- Simplified sorting using Streams
- Added Method References
- Improved TaskManager architecture
- Reduced duplicate code

### v2.0.0
- Due Date support
- Dashboard
- Overdue Tasks
- Due Today
- Upcoming Tasks
- Due This Week
- Days Remaining

### v1.x
- CRUD Operations
- Searching
- Sorting
- File Persistence

---

## 🛣 Roadmap

### ✅ Version 1.x

- CRUD Operations
- Searching
- Sorting
- File Persistence

### 🚧 Version 2.x

- Due Dates
- Categories
- Statistics Dashboard
- Task Filtering

### 🚀 Version 3.x

- Streams API
- Functional Programming

### 🌐 Version 4.x

- JDBC
- MySQL Integration

### ⚡ Version 5.x

- Spring Boot REST API

### 🎨 Version 6.x

- React Frontend

---

## 📄 License

This project is licensed under the MIT License.