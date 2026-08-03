# Changelog

All notable changes to this project will be documented in this file.

---

# [v2.3.0]

## Added
- Statistics Dashboard
- Category Statistics
- Priority Statistics
- Status Statistics
- Completion Percentage

## Changed
- Improved dashboard analytics
- Introduced Collectors.groupingBy()
- Introduced Collectors.counting()

---

# [v2.2.0]

## Added
- Category enum
- Category field in Task
- Search by Category
- Sort by Category

## Changed
- Updated Task model
- Updated FileStorage for category persistence
- Updated ConsoleUI to support category selection
- Improved task organization

---

## [v2.1.0]

### Added
- Java Streams API
- Method References
- Functional Programming concepts

### Changed
- Refactored filtering using Predicate
- Replaced duplicate loops with generic filtering
- Simplified sorting methods using Streams
- Improved TaskManager readability
- Cleaner architecture

### Fixed
- Removed duplicate filtering logic

---

## [v2.0.0]

### Added

- Due Date support
- Dashboard
- Overdue task detection
- Due Today view
- Due This Week view
- Upcoming Tasks
- Search by Due Date
- Sort by Due Date
- Days Remaining indicator

### Improved

- Task model redesigned with LocalDate
- File persistence updated for due dates

---

## [v1.6.0]

### Added

- Automatic task loading
- Automatic task saving
- File persistence
- Graceful handling of missing tasks.txt

### Improved

- Package organization
- Exception handling
- File management

---

## [v1.5.0]

### Added

- Save tasks to file
- Load tasks from file
- FileStorage module

---

## [v1.3.0]

### Added

- Project package structure
- Comparator-based sorting

---

## [v1.2.0]

### Added

- Search by Priority
- Search by Status
- Sorting by Priority
- Sorting by Status
- Sorting by Title

---

## [v1.1.0]

### Added

- CRUD Operations