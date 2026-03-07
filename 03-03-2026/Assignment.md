## Assignment
### Title: Employee Management System using Hibernate (JPA)
Objective

Develop a Java-based backend application using Hibernate (JPA) to manage:

- Employees

- Salary Records

- Performance Reviews

- Proper transaction management is mandatory.

### Question 1: Employee Management

Create an entity class `Employee` mapped to table employee.

Fields:

1. id (Primary Key, Auto-generated)
2. employeeCode (Unique)
3. name
4. email
5. designation
6. department
7. joiningDate
8. active (boolean)

Implement the following:

* Insert a new employee.
* Update employee details using employeeCode.
* Soft delete employee (set active = false).

Fetch employee by:

* id
* employeeCode
* Fetch all active employees using JPQL.

### Question 2: Salary Record Management (25 Marks)

Create an entity class `SalaryRecord` mapped to table salary_record.

Fields:

1. id (Primary Key)
2. employeeCod
3. baseSalary
4. bonus
5. tax
6. netSalary
7. salaryMonth (Format: YYYY-MM)

Implement the following:

* Insert salary record.
* Automatically calculate:
* netSalary = baseSalary + bonus - tax
* Update salary record.
* Delete salary record.

Fetch salary record by:

* employeeCode
* salaryMonth
* Fetch all salary records for a given employee.

Do NOT use foreign key mapping. employeeCode must be treated as a normal column.

### Question 3: Performance Review Management

Create an entity class `PerformanceReview` mapped to table performance_review.

Fields:

1. id (Primary Key)
2. employeeCode
3. rating (1–5)
4. reviewDate
5. comments

Implement the following:

* Insert performance review.
* Update review.
* Delete review.
* Fetch all reviews of a given employee.