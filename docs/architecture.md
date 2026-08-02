# TaskPilot Architecture

## Overview

TaskPilot follows a layered architecture to separate user interaction, business logic, and data persistence.

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

         
## Components

### ConsoleUI
- Handles user interaction.
- Displays menus.
- Accepts user input.
- Coordinates operations between TaskManager and FileStorage.

## TaskManager

TaskManager acts as the core business layer of TaskPilot.

Responsibilities:

- Manage CRUD operations
- Search tasks
- Filter tasks using Predicate
- Sort tasks using Comparator and Streams
- Dashboard calculations
- Due Date management

Filtering Pipeline

Task List
    ↓
Stream
    ↓
Predicate
    ↓
Filtered Result

### FileStorage
- Responsible for persistence.
- Saves tasks to `tasks.txt`.
- Loads tasks during application startup.

### Model Layer
Contains the core domain objects:
- Task
- Priority
- TaskStatus
- Due Date

### Comparator Layer
Provides custom sorting strategies:
- PriorityComparator
- StatusComparator