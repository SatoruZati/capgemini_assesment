# capgemini_assesment

Weekly Capgemini Training Assignments — Java backend projects covering Spring Framework, Hibernate/JPA, and JDBC.

---

## Repository Structure

```
capgemini_assesment/
├── spring_IoC_assignment/          # Assignment 1 — Spring IoC & Dependency Injection
├── customer_jdbc_maven/            # Assignment 2 — Customer & Order Management (Hibernate/JPA)
└── 03-03-2026/                     # Assignment 3 — Employee Management System (Spring Boot + JPA)
```

---

## Projects

### 1. `spring_IoC_assignment` — Spring IoC & Dependency Injection

A Maven project demonstrating **Spring Framework's Inversion of Control (IoC)** and **Dependency Injection (DI)** concepts using XML-based configuration.

| Detail | Info |
|---|---|
| **Language** | Java 21 |
| **Framework** | Spring Framework 7.0.3 |
| **Build Tool** | Maven |
| **Config Style** | XML (`applicationContext.xml`, `bean-config.xml`) |
| **Testing** | JUnit Jupiter 5.11 + Spring Test |

**Key Components:**
- `Employee` & `Address` model classes
- `EmployeeService` / `EmployeeServiceImpl` — service layer demonstrating DI
- `TestApp` — bootstraps the Spring context and exercises the service (add, get, update, delete)
- `EmployeeContextTest` — unit tests for the Spring context

---

### 2. `customer_jdbc_maven` — Customer & Order Management System

A Maven project implementing a **Customer and Order Management System** using **Hibernate ORM (JPA)** with PostgreSQL — no Spring, pure JPA/Hibernate.

| Detail | Info |
|---|---|
| **Language** | Java 24 |
| **ORM** | Hibernate 6.4.4 (JPA) |
| **Database** | PostgreSQL |
| **Build Tool** | Maven |
| **Config** | `persistence.xml` |

**Key Components:**
- `Customer` entity — stores name, email, gender, phone, registration date
- `Order` entity — stores order code, product, quantity, price, date; linked to `Customer`
- `CustomerDAO` / `CustomerDAOImpl` — CRUD for customers
- `OrderDAO` / `OrderDAOImpl` — CRUD for orders
- `Main` — demo entry point that inserts, updates, fetches, and deletes customers & orders

---

### 3. `03-03-2026` — Employee Management System (Spring Boot + JPA)

A **Spring Boot** application implementing an **Employee Management System** with full CRUD support across three domains using Hibernate (JPA) and PostgreSQL.

| Detail | Info |
|---|---|
| **Language** | Java 21 |
| **Framework** | Spring Boot 4.0.3 |
| **ORM** | Spring Data JPA / Hibernate |
| **Database** | PostgreSQL |
| **Build Tool** | Maven (Spring Initializr wrapper) |

**Key Components:**
- `Employee` entity — id, employeeCode (unique), name, email, designation, department, joiningDate, active (soft-delete flag)
- `SalaryRecord` entity — employeeCode, baseSalary, bonus, tax, netSalary (auto-calculated), salaryMonth
- `PerformanceReview` entity — employeeCode, rating (1–5), reviewDate, comments
- `EmployeeDAO`, `SalaryRecordDAO`, `PerformanceReviewDAO` — data access layers
- Supports soft-delete, JPQL queries, and full transaction management

**Assignment coverage:**
-  Insert, update, soft-delete employees; fetch by id / employeeCode / all active
-  Salary record CRUD with auto `netSalary = baseSalary + bonus - tax`
-  Performance review CRUD with employee-scoped fetch

---

##  Tech Stack Summary

| Technology | Used In |
|---|---|
| Java 21 | `spring_IoC_assignment` |
| Java 24 | `customer_jdbc_maven` |
| Spring Framework 7 | `spring_IoC_assignment` |
| Spring Boot 4 | `03-03-2026` |
| Hibernate / JPA | `customer_jdbc_maven` |
| PostgreSQL | `customer_jdbc_maven` |
| Maven | All projects |
| JUnit 5 | `spring_IoC_assignment` |
