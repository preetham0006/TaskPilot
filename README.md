# 🚀 TaskPilot

TaskPilot is a Java-based console Task Management System developed to strengthen core Java concepts while following clean software engineering principles. The project started as a simple CRUD application and is gradually evolving into a complete full-stack task management platform.

## ✨ Features

### Current Features (v1.6.0)

- ✅ Add Tasks
- ✅ Display All Tasks
- ✅ Find Task by ID
- ✅ Search Tasks by Priority
- ✅ Search Tasks by Status
- ✅ Update Task Status
- ✅ Delete Tasks
- ✅ Sort by Priority
- ✅ Sort by Status
- ✅ Sort by Title
- ✅ Persistent Storage using File I/O
- ✅ Automatic Task Loading
- ✅ Automatic Task Saving
- ✅ Graceful Missing File Handling
- ✅ Due Dates
- ✅ OverDue Tasks
- ✅ Due Today
- ✅ Due This Week
- ✅ Upcoming Tasks
- ✅ Dashboard
- ✅ Sort By Due Date
- ✅ Search By Due Date

---

## 🛠 Tech Stack

- Java
- Java Collections Framework
- Java File I/O (NIO Files API)
- Object-Oriented Programming
- Git & GitHub

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