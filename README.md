# ⚖️ Quantity Measurement Application

A production-grade Java backend application built using **Test Driven Development (TDD)** that evolves from a simple unit comparison utility into a **secure Spring Boot REST API** with database persistence and authentication.

---

## 🚀 Tech Stack

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=flat-square)
![JPA](https://img.shields.io/badge/Spring%20Data-JPA-green?style=flat-square)
![JWT](https://img.shields.io/badge/JWT-Authentication-black?style=flat-square)
![OAuth2](https://img.shields.io/badge/OAuth2-Google-red?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=flat-square)
![JUnit](https://img.shields.io/badge/JUnit-5-yellow?style=flat-square)

---

## 📖 Project Evolution (UC1 → UC18)

This project was built incrementally, following **use-case driven development**, where each UC introduced new concepts and architectural improvements.

---

### 🔵 Phase 1 — Core Measurement System (UC1–UC7)

| UC | Description |
|----|------------|
| UC1 | Basic equality comparison (same unit) |
| UC2 | Equality across different units using conversion |
| UC3 | Support for multiple length units (inch, feet, yard) |
| UC4 | Refactoring for clean and scalable design |
| UC5 | Addition operation with unit normalization |
| UC6 | Addition with conversion handling |
| UC7 | Addition with target unit flexibility |

---

### 🟣 Phase 2 — Generic & Scalable Design (UC8–UC12)

| UC | Description |
|----|------------|
| UC8 | Introduced `Measurable` interface |
| UC9 | Added Weight measurement (kg, g, lb) |
| UC10 | Generic `Quantity<T extends Measurable>` |
| UC11 | Added Volume measurement (litre, ml, gallon) |
| UC12 | Added subtraction and division operations |

---

### 🟠 Phase 3 — Advanced Design & Architecture (UC13–UC15)

| UC | Description |
|----|------------|
| UC13 | Centralized arithmetic logic using `ArithmeticOperation` enum |
| UC14 | Temperature support with restricted arithmetic |
| UC15 | Clean architecture with layered design |

---

### 🟡 Phase 4 — Database Integration (UC16)

| UC | Description |
|----|------------|
| UC16 | JDBC-based persistence with connection pooling |

**Key Concepts:**
- JDBC
- HikariCP connection pooling
- Transaction handling
- SQL queries
- DAO layer

---

### 🟢 Phase 5 — Spring Boot REST API (UC17)

| UC | Description |
|----|------------|
| UC17 | Full Spring Boot backend with REST APIs and JPA |

**Key Features:**
- REST APIs (`/add`, `/convert`, `/history`)
- DTO layer (decoupling API & DB)
- Spring Data JPA
- Global Exception Handling (`@ControllerAdvice`)
- Integration testing (`@SpringBootTest`, `MockMvc`)

---

### 🔐 Phase 6 — Security & Authentication (UC18)

| UC | Description |
|----|------------|
| UC18 | Secure backend with JWT & Google OAuth2 |

---

## 🔐 Authentication & Security

### ✅ Local Authentication
- User Registration (email + password)
- Password encryption using **BCrypt**

### ✅ JWT Authentication
- Stateless authentication
- Token-based access
- Custom JWT filter for request validation

### ✅ Google OAuth2 Login
- Social login integration
- Auto user registration
- Unified JWT flow after login

### ✅ Security Features
- Protected endpoints
- Stateless session management
- Secure environment variables for secrets

---

## ⚙️ Architecture

```
Controller
   ↓
Service
   ↓
Repository (JPA)
   ↓
Database (MySQL)
```

---

## 📐 Supported Measurement Types

| Category | Units |
|----------|------|
| Length | Feet, Inch, Yard |
| Weight | Kilogram, Gram, Pound |
| Volume | Litre, Millilitre, Gallon |
| Temperature | Celsius, Fahrenheit *(no arithmetic)* |

---

## 📊 Key Features

✔ Unit conversion across multiple measurement types  
✔ Arithmetic operations with normalization  
✔ Generic and scalable architecture  
✔ RESTful APIs  
✔ Database persistence  
✔ JWT-based authentication  
✔ Google OAuth login  
✔ Global exception handling  
✔ Clean layered architecture  

---

## 🧠 Concepts Covered

- Development-Driven Test (DDT)
- Object-Oriented Design (Generics, Enums, Interfaces)
- SOLID Principles
- DRY Principle
- Functional Programming (Lambdas)
- N-Tier Architecture
- JDBC & Connection Pooling
- Spring Boot & Dependency Injection
- Spring Data JPA (ORM)
- REST API Design
- Exception Handling
- Authentication & Authorization (JWT, OAuth2)

---

## 🎯 One-Line Summary

> Started as an OOP-based unit conversion system, evolved into a scalable generic measurement engine, then transformed into a Spring Boot REST application with database persistence, and finally secured using JWT and Google OAuth2.

---

## 👨‍💻 Author

**Ayush Gupta**
