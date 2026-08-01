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

### TaskManager
- Maintains the collection of tasks.
- Implements CRUD operations.
- Performs searching and sorting.
- Does not know how tasks are stored.

### FileStorage
- Responsible for persistence.
- Saves tasks to `tasks.txt`.
- Loads tasks during application startup.

### Model Layer
Contains the core domain objects:
- Task
- Priority
- TaskStatus

### Comparator Layer
Provides custom sorting strategies:
- PriorityComparator
- StatusComparator