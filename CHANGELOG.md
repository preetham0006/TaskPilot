# Changelog

## v1.2

### Added

- Search tasks by Priority
- Search tasks by Status
- Reusable displayTasks() method

### Changed

- Refactored ConsoleUI into smaller methods.
- TaskManager now returns List<Task> instead of printing directly.
- Introduced List interface instead of exposing ArrayList.

### Fixed

- Invalid continue statement after refactoring.
- Variable initialization issues during status updates.

---

## v1.1

### Added

- CRUD Operations
- Console-based menu

### Changed

- Introduced ConsoleUI class.

---

## v1.0

Initial project setup.
## v1.3.0

### Added
- Sort tasks by Priority
- Sort tasks by Status
- PriorityComparator
- StatusComparator
- Non-destructive sorting using copied lists

### Changed
- TaskManager now supports sorting operations