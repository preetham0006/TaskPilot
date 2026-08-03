# TaskPilot Architecture

## Layered Architecture

```
ConsoleUI
     │
     ▼
TaskManager
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

## Responsibilities

### ConsoleUI

- Handles user interaction.
- Displays menus.
- Reads user input.

### TaskManager

- Contains business logic.
- Validates operations.
- Maintains the in-memory task list.
- Coordinates with TaskRepository.

### TaskRepository

- Executes SQL queries.
- Performs CRUD operations.
- Maps database rows to Task objects.

### DatabaseConnection

- Creates JDBC connections.
- Manages database connectivity.

### MySQL

- Permanent storage for all tasks.

---

## Design Principles

- Separation of Concerns
- Repository Pattern
- Layered Architecture
- Single Responsibility Principle

---

## Data Flow

```
User
   │
   ▼
ConsoleUI
   │
   ▼
TaskManager
   │
   ▼
TaskRepository
   │
   ▼
JDBC
   │
   ▼
MySQL
```