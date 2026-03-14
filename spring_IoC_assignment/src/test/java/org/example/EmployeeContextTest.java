package org.example;

import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmployeeContextTest {

    @Test
    void shouldLoadEmployeeAndServiceBeans() {
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("applicationContext.xml")) {
            EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);
            Employee employee = context.getBean("employee", Employee.class);

            assertNotNull(employeeService);
            assertEquals(101, employee.getId());
            assertEquals("Mike", employee.getName());
            assertNotNull(employee.getAddress());
            assertEquals("Bangalore", employee.getAddress().getCity());
        }
    }
}

