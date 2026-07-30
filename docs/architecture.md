# Architecture - Version 1

## Purpose

This document explains the architecture of Version 1 and the reasoning behind it.

---

# Current Architecture

The application consists of only four components.

```
        User
          │
          ▼
 Console Interface
          │
          ▼
   Task Manager
          │
          ▼
  ArrayList<Task>
```

---

# Components

## User

Interacts with the application through the console.

---

## Console Interface

Responsible for displaying menus and receiving user input.

This layer should **not** contain business logic.

---

## Task Manager

Responsible for handling all task-related operations such as:

- Creating Tasks
- Updating Tasks
- Deleting Tasks
- Viewing Tasks

This layer contains the business logic.

---

## Task

Represents a single unit of work.

A Task stores information such as:

- ID
- Title
- Description
- Priority
- Status

---

# Data Storage

Version 1 stores all tasks in memory using an ArrayList.

No database or file storage is used.

---

# Why this Architecture?

Version 1 is intentionally simple.

The objective is to learn object-oriented programming before introducing persistence, databases, or frameworks.

Keeping the architecture small allows us to understand every component before adding more complexity.

---

# Limitations

- Data is lost when the application closes.
- Only one user can use the application.
- No persistence.
- No networking.
- No authentication.

These limitations will be addressed in future versions.