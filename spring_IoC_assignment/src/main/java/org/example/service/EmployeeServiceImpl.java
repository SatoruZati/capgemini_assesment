package org.example.service;

import org.example.model.Address;
import org.example.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    private Employee employee;

    public EmployeeServiceImpl() {
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void addEmployee() {
        System.out.println("Employee added successfully.");
        printEmployeeDetails();
    }

    @Override
    public void updateEmployee() {
        employee.setSalary(employee.getSalary() + 5000);
        System.out.println("Employee updated successfully.");
        printEmployeeDetails();
    }

    @Override
    public void deleteEmployee() {
        System.out.println("Employee deleted successfully: " + employee.getId());
    }

    @Override
    public void getEmployee() {
        System.out.println("Employee fetched successfully.");
        printEmployeeDetails();
    }

    private void printEmployeeDetails() {
        Address address = employee.getAddress();
        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println("City: " + address.getCity());
        System.out.println("State: " + address.getState());
        System.out.println("Country: " + address.getCountry());
        System.out.println("Pincode: " + address.getPincode());
        System.out.println();
    }
}

