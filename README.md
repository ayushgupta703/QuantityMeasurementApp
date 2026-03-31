# ⚖️ Quantity Measurement Application

A production-grade Java backend application built using **Development Driven Testing (DDT)** that evolves from a simple unit comparison utility into a **secure Spring Boot REST API** with database persistence and authentication.

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

## ⚡ Quickstart (TL;DR)

1. **Clone**
   ```bash
   git clone https://github.com/ayushgupta703/QuantityMeasurementApp.git
   cd QuantityMeasurementApp
   ```
2. **Configure database & secrets**
   - Create a MySQL DB (e.g. `quantity_measurement_db`).
   - Set DB + security properties (see **Configuration & Environment Variables** below).
3. **Build & run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
4. **Hit an API** 
   - Conversion: `POST http://localhost:8081/api/v1/quantities/convert`
5. **(Secured APIs)** Obtain a JWT via login/OAuth2, then call protected endpoints with `Authorization: Bearer <token>`.

---

## 🔗 Frontend Integration

This backend is fully integrated with a React frontend application.

Frontend Repository:
https://github.com/ayushgupta703/QuantityMeasurementApp-Frontend

Make sure the backend is running before starting the frontend.

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

## 🛠️ Setup & Run

### ✅ Prerequisites
- **Java 17** or higher installed (`java -version`)
- **Maven** installed (`mvn -version`)
- **MySQL** running locally or accessible remotely

### 🔧 Configure Database
1. Create a MySQL database (for example: `quantity_measurement_db`).
2. Update your Spring Boot configuration (typically `application.properties` or `application.yml`) with:
   - DB URL
   - Username
   - Password
3. Ensure any Flyway/Liquibase or schema initialization (if present) matches your DB name.

### ▶️ Run the Application

From the project root:

```bash
mvn clean install
mvn spring-boot:run
```

By default, the app typically starts on `http://localhost:8081` (check your `server.port` if customized).

### 🧪 Run Tests

```bash
mvn test
```

---

## 🔧 Configuration & Environment Variables

These are typical properties you’ll need to set (in `application.properties`, `application.yml`, or environment variables):

- **Database**
  - `SPRING_DATASOURCE_URL` / `spring.datasource.url`
  - `SPRING_DATASOURCE_USERNAME` / `spring.datasource.username`
  - `SPRING_DATASOURCE_PASSWORD` / `spring.datasource.password`
- **JPA (optional but recommended)**
  - `SPRING_JPA_HIBERNATE_DDL_AUTO` / `spring.jpa.hibernate.ddl-auto`
  - `SPRING_JPA_SHOW_SQL` / `spring.jpa.show-sql`
- **OAuth2 (Google) Defined in `application.yml` (use environment variables for client ID and secret)**
  - `SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_GOOGLE_CLIENT_ID`
  - `SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_GOOGLE_CLIENT_SECRET`
- **Server (optional)**
  - `SERVER_PORT` / `server.port` (defaults to `8081` if not set)

Use environment variables for secrets (JWT secret, DB password, OAuth client secret) instead of committing them to source control.

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

## 📡 API Usage

### Public / Auth APIs

| Endpoint | Method | Description |
|---------|--------|-------------|
| `/auth/register` | `POST` | Register a new user with email/password |
| `/auth/login` | `POST` | Login and receive a JWT |
| `/oauth2/authorization/google` | `GET` | Start Google OAuth2 login flow |

**Sample login request**:

```bash
curl -X POST http://localhost:8081/auth/login \
  -H "Content-Type: application/json" \
  -d '{
        "email": "user@example.com",
        "password": "password123"
      }'
```

Response (simplified):

```json
{
  "token": "<JWT_TOKEN>"
}
```

Use the token in the `Authorization` header for protected endpoints:

```bash
Authorization: Bearer <JWT_TOKEN>
```

### 🔒 Secured Measurement APIs (Require JWT)

| Endpoint | Method | Description |
|---------|--------|-------------|
| `/convert` | `POST` | Convert from one unit to another |
| `/add` | `POST` | Add two quantities (with unit normalization) |
| `/history` | `GET` | Fetch stored operations/history *(secured)* |

**Sample convert request**:

```bash
POST http://localhost:8081/api/v1/quantities/convert \
  "Content-Type: application/json" \
  "Authorization: Bearer <JWT_TOKEN>" \
  {
    "thisQuantityDTO": {
      "value": 1,
      "unit": "FEET",
      "measurementType": "LengthUnit"
    },
    "thatQuantityDTO": {
      "value": 0,
      "unit": "INCHES",
      "measurementType": "LengthUnit"
    }
  }
```

Response (example):

```json
{
    "error": false,
    "errorMessage": null,
    "operation": "CONVERT",
    "resultMeasurementType": "LengthUnit",
    "resultString": null,
    "resultUnit": "INCHES",
    "resultValue": 12.0,
    "thatMeasurementType": "LengthUnit",
    "thatUnit": "INCHES",
    "thatValue": 0.0,
    "thisMeasurementType": "LengthUnit",
    "thisUnit": "FEET",
    "thisValue": 1.0
}
```

---

### 📄 API Documentation

Swagger UI available at:
http://localhost:8081/swagger-ui/index.html

---

## 📐 Supported Measurement Types

| Category | Units |
|----------|------|
| Length | FEET, INCHES, YARDS, CENTIMETERS |
| Weight | KILOGRAM, GRAM, POUND |
| Volume | LITRE, MILLILITRE, GALLON |
| Temperature | CELSIUS, FAHRENHEIT *(no arithmetic)* |

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
