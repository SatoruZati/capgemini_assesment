package com.example.Capgemini_Assignment_02.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "salary_record")
public class SalaryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeCode;
    private double baseSalary;
    private double bonus;
    private double tax;
    private double netSalary;

    // format: YYYY-MM
    private String salaryMonth;

    public SalaryRecord() {}

    public SalaryRecord(String employeeCode, double baseSalary, double bonus, double tax, String salaryMonth) {
        this.employeeCode = employeeCode;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.tax = tax;
        this.salaryMonth = salaryMonth;
        this.netSalary = baseSalary + bonus - tax;
    }

    public void calculateNetSalary() {
        this.netSalary = this.baseSalary + this.bonus - this.tax;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmployeeCode() { return employeeCode; }
    public void setEmployeeCode(String employeeCode) { this.employeeCode = employeeCode; }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
        calculateNetSalary();
    }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) {
        this.bonus = bonus;
        calculateNetSalary();
    }

    public double getTax() { return tax; }
    public void setTax(double tax) {
        this.tax = tax;
        calculateNetSalary();
    }

    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }

    public String getSalaryMonth() { return salaryMonth; }
    public void setSalaryMonth(String salaryMonth) { this.salaryMonth = salaryMonth; }

    @Override
    public String toString() {
        return "SalaryRecord{id=" + id + ", employeeCode='" + employeeCode + "', month='" + salaryMonth + "', net=" + netSalary + "}";
    }
}
