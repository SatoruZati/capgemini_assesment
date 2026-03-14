package org.example;

import org.example.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);

        employeeService.addEmployee();
        employeeService.getEmployee();
        employeeService.updateEmployee();
        employeeService.deleteEmployee();

        ((ClassPathXmlApplicationContext) context).close();
    }
}

