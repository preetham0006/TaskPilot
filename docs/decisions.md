# Design Decisions

## Why ArrayList?

ArrayList provides fast iteration and is well suited for a console-based task management application where the number of tasks is relatively small.

---

## Why Enums?

Priority and TaskStatus have a fixed set of values. Enums provide type safety and improve code readability.

---

## Why Comparator?

Sorting strategies are separated from the Task model, making it easier to introduce new sorting methods without modifying existing classes.

---

## Why File Storage?

File persistence was chosen instead of a database to focus on learning Java File I/O before introducing JDBC and SQL.

---

## Why Package Organization?

The project is organized into packages to separate concerns and improve maintainability.