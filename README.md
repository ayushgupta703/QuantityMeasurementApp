# ⚖️ Quantity Measurement Application

A production-grade Java backend application built using **Development Driven Testing (DDT)** that evolves from a simple unit comparison utility into a **secure microservices-based Spring Boot system** with database persistence and authentication.

---

## 🚀 Tech Stack

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-Microservices-blue?style=flat-square)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=flat-square)
![JPA](https://img.shields.io/badge/Spring%20Data-JPA-green?style=flat-square)
![JWT](https://img.shields.io/badge/JWT-Authentication-black?style=flat-square)
![OAuth2](https://img.shields.io/badge/OAuth2-Google-red?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=flat-square)

---

## ⚡ Quickstart (Microservices)

1. **Clone**

```bash
git clone https://github.com/ayushgupta703/QuantityMeasurementApp.git
cd QuantityMeasurementApp
```

2. **Start Services (IMPORTANT ORDER)**

```text
1. Eureka Server
2. Auth Service
3. Measurement Service
4. API Gateway
```

3. **Access APIs via Gateway**

```text
http://localhost:8082
```

---

## 🔗 Frontend Integration

Frontend Repository:
https://github.com/ayushgupta703/QuantityMeasurementApp-Frontend

👉 Frontend communicates ONLY via API Gateway.

---

## 📖 Project Evolution (UC1 → UC21)

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

*(Same as your existing content — unchanged)*

---

## 🖥️ Phase 7 — Frontend Integration (UC19–UC20)

* React + Vite frontend
* Dashboard UI
* API integration
* Authentication handling

---

## 🌐 Phase 8 — Microservices Architecture (UC21)

The application was refactored from a **monolithic architecture** into a **microservices-based system** using Spring Cloud.

---

# ⚙️ Microservices Architecture

## 🧩 Services

### 🔐 Auth Service

* Handles user authentication
* JWT generation & validation
* Google OAuth2 login
* User management

---

### ⚙️ Measurement Service

* Handles all quantity operations
* Public + protected APIs
* Stores user-specific history

---

### 🌐 API Gateway

* Single entry point
* Routes requests to services
* Handles CORS
* Preserves JWT across services

---

### 📡 Eureka Server

* Service discovery
* Dynamic service registration

---

# 🔄 System Flow

```text
Frontend → API Gateway → Eureka → Services → Database
```

---

# 🔐 Authentication Flow

```text
Login → Auth Service → JWT
Frontend stores token
Frontend → Gateway → Services (with JWT)
Services validate token independently
```

---

# 🔑 Key Features

```
✔ Microservices architecture
✔ Service discovery (Eureka)
✔ API Gateway routing
✔ JWT-based authentication
✔ Google OAuth2 login
✔ Stateless security
✔ User-specific data isolation
✔ Frontend + backend integration
```

---

# ⚙️ Configuration

## Required Environment Variables

### Database

* `SPRING_DATASOURCE_URL`
* `SPRING_DATASOURCE_USERNAME`
* `SPRING_DATASOURCE_PASSWORD`

### JWT

* `JWT_SECRET`

### OAuth2 (Google)

* `SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_GOOGLE_CLIENT_ID`
* `SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_GOOGLE_CLIENT_SECRET`

---

# 📡 API Access (via Gateway)

## 🔐 Auth APIs

| Endpoint                                    | Method |
| ------------------------------------------- | ------ |
| `/auth-service/auth/login`                  | POST   |
| `/auth-service/auth/register`               | POST   |
| `/auth-service/oauth2/authorization/google` | GET    |

---

## ⚙️ Measurement APIs

| Endpoint                                             | Method | Access    |
| ---------------------------------------------------- | ------ | --------- |
| `/measurement-service/api/v1/quantities/operation/*` | POST   | Public    |
| `/measurement-service/api/v1/quantities/history`     | GET    | Protected |

---

# 🧠 Concepts Covered

* Microservices Architecture
* API Gateway Pattern
* Service Discovery (Eureka)
* JWT Authentication
* OAuth2 Integration
* Spring Cloud
* REST API Design
* Distributed Systems Basics

---

# 🎯 One-Line Summary

> Started as an OOP-based unit conversion system, evolved into a scalable backend, and finally transformed into a secure microservices architecture using Spring Boot, Spring Cloud, JWT, and OAuth2.

---

## 👨‍💻 Author

**Ayush Gupta**
