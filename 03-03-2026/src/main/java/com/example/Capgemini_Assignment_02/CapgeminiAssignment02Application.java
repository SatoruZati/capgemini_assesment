package com.example.Capgemini_Assignment_02;

import com.example.Capgemini_Assignment_02.dao.EmployeeDAO;
import com.example.Capgemini_Assignment_02.dao.PerformanceReviewDAO;
import com.example.Capgemini_Assignment_02.dao.SalaryRecordDAO;
import com.example.Capgemini_Assignment_02.entity.Employee;
import com.example.Capgemini_Assignment_02.entity.PerformanceReview;
import com.example.Capgemini_Assignment_02.entity.SalaryRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class CapgeminiAssignment02Application {

	public static void main(String[] args) {
		SpringApplication.run(CapgeminiAssignment02Application.class, args);

		EmployeeDAO employeeDAO = new EmployeeDAO();
		SalaryRecordDAO salaryDAO = new SalaryRecordDAO();
		PerformanceReviewDAO reviewDAO = new PerformanceReviewDAO();

		// Q1: Employee

		Employee emp1 = new Employee("EMP001", "Arjun Sharma", "arjun@example.com",
				"Software Engineer", "Development", LocalDate.of(2022, 6, 15));
		employeeDAO.insertEmployee(emp1);

		Employee emp2 = new Employee("EMP002", "Priya Nair", "priya@example.com",
				"QA Engineer", "Testing", LocalDate.of(2021, 3, 1));
		employeeDAO.insertEmployee(emp2);

		// update emp1
		employeeDAO.updateEmployee("EMP001", "Arjun S.", "arjun.s@example.com",
				"Senior Software Engineer", "Development");

		// soft delete emp2
		employeeDAO.softDelete("EMP002");

		// fetch by id
		Employee fetched = employeeDAO.getById(1L);
		System.out.println("Fetched by id: " + fetched);

		// fetch by code
		Employee byCode = employeeDAO.getByEmployeeCode("EMP001");
		System.out.println("Fetched by code: " + byCode);

		// all active employees
		List<Employee> activeList = employeeDAO.getAllActiveEmployees();
		System.out.println("Active employees: " + activeList);

		// Q2: Salary Records

		SalaryRecord sal1 = new SalaryRecord("EMP001", 50000, 5000, 3000, "2025-01");
		salaryDAO.insertSalaryRecord(sal1);

		SalaryRecord sal2 = new SalaryRecord("EMP001", 50000, 6000, 3500, "2025-02");
		salaryDAO.insertSalaryRecord(sal2);

		// update salary record
		salaryDAO.updateSalaryRecord(sal1.getId(), 52000, 5500, 3200);

		// fetch by employee code
		List<SalaryRecord> empSalaries = salaryDAO.getByEmployeeCode("EMP001");
		System.out.println("Salaries for EMP001: " + empSalaries);

		// fetch by salary month
		List<SalaryRecord> monthSalaries = salaryDAO.getBySalaryMonth("2025-02");
		System.out.println("Salaries for 2025-02: " + monthSalaries);

		// delete a salary record
		salaryDAO.deleteSalaryRecord(sal2.getId());

		//Q3: Performance Reviews

		PerformanceReview rev1 = new PerformanceReview("EMP001", 4, LocalDate.of(2025, 12, 31), "Good performance overall");
		reviewDAO.insertReview(rev1);

		PerformanceReview rev2 = new PerformanceReview("EMP001", 3, LocalDate.of(2024, 12, 31), "Needs improvement in communication");
		reviewDAO.insertReview(rev2);

		// update review
		reviewDAO.updateReview(rev1.getId(), 5, "Excellent performance", LocalDate.of(2025, 12, 31));

		// fetch all reviews for employee
		List<PerformanceReview> reviews = reviewDAO.getByEmployeeCode("EMP001");
		System.out.println("Reviews for EMP001: " + reviews);

		// delete a review
		reviewDAO.deleteReview(rev2.getId());
	}
}
