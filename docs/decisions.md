# Architecture Decisions

This document records important design decisions made during the development of JiraClone.

---

# ADR-001

## Decision

Use a Console Application for Version 1.

---

## Problem

The project is in its initial stage.

The objective is to understand software engineering fundamentals rather than UI development.

---

## Alternatives Considered

- Desktop GUI
- Web Application
- Console Application

---

## Selected Solution

Console Application

---

## Reason

- Easy to build
- Focus on business logic
- No framework dependencies
- Helps understand Core Java concepts

---

## Consequences

Advantages

- Faster development
- Easier debugging
- Simpler architecture

Disadvantages

- Poor user experience
- Not suitable for multiple users


---------------------------------------------------------------------------------------------

# ADR-002

## Decision

Store Tasks in an ArrayList.

---

## Problem

The application needs a way to store tasks while it is running.

---

## Alternatives Considered

- Array
- LinkedList
- HashMap
- Database

---

## Selected Solution

ArrayList

---

## Reason

- Dynamic size
- Easy iteration
- Simple implementation
- Suitable for Version 1

---

## Consequences

Advantages

- Simple
- Fast enough for a small number of tasks

Disadvantages

- Linear search
- Data disappears after application closes
- Not scalable