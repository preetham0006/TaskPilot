# Requirements

## Version

Version 1.0

---

# Functional Requirements

The application shall allow users to:

1. Create a Task.
2. View all Tasks.
3. Update an existing Task.
4. Delete a Task.
5. Mark a Task as Completed.

---

# Non-Functional Requirements

The application should be:

- Simple to use.
- Easy to understand.
- Easy to maintain.
- Modular.
- Extensible for future versions.
- Able to handle invalid user input gracefully.

---

# Core Domain Entity

## Task

A Task represents a unit of work assigned to a developer.

Every task should describe a specific piece of work that needs to be completed.

---

# Task Attributes (Version 1)

| Attribute | Description |
|-----------|-------------|
| Task ID | Unique identifier for every task |
| Title | Short title describing the task |
| Description | Detailed explanation of the task |
| Priority | Indicates the importance of the task |
| Status | Current progress of the task |
| Created Date | Date when the task was created |

---

# Task Status

Version 1 supports the following statuses:

- TODO
- IN_PROGRESS
- COMPLETED

---

# Task Priority

Version 1 supports three priority levels:

- LOW
- MEDIUM
- HIGH

---

# Assumptions

- Only one team is using the application.
- There is no authentication.
- Tasks are managed locally.
- Data persistence is not required in Version 1.
- Only console interaction is supported.

---

# Out of Scope (Version 1)

The following features are intentionally excluded:

- Login
- Database
- Notifications
- Due Dates
- Comments
- File Uploads
- Multiple Projects
- Multiple Users
- Team Management
- Cloud Deployment

These features will be introduced only when the application naturally requires them.

---

# Constraints

- Java Console Application
- Core Java only
- No external frameworks
- No database
- No networking

The objective of Version 1 is to build a strong foundation before introducing advanced technologies.