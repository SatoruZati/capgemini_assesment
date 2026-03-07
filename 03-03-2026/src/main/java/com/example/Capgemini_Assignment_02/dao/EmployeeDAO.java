package com.example.Capgemini_Assignment_02.dao;

import com.example.Capgemini_Assignment_02.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import java.util.List;

public class EmployeeDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ems");

    public void insertEmployee(Employee emp) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
        em.close();
    }

    public void updateEmployee(String empCode, String name, String email,
                               String designation, String department) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee emp = getByEmployeeCode(empCode);
        if (emp == null) {
            System.out.println("No employee found with code: " + empCode);
            em.getTransaction().rollback();
            em.close();
            return;
        }

        emp = em.merge(emp);
        emp.setName(name);
        emp.setEmail(email);
        emp.setDesignation(designation);
        emp.setDepartment(department);

        em.getTransaction().commit();
        em.close();
    }

    public void softDelete(String empCode) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee emp = getByEmployeeCode(empCode);
        if (emp != null) {
            emp = em.merge(emp);
            emp.setActive(false);
        }

        em.getTransaction().commit();
        em.close();
    }

    public Employee getById(Long id) {
        EntityManager em = emf.createEntityManager();
        Employee emp = em.find(Employee.class, id);
        em.close();
        return emp;
    }

    public Employee getByEmployeeCode(String empCode) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT e FROM Employee e WHERE e.employeeCode = :code", Employee.class)
                    .setParameter("code", empCode)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public List<Employee> getAllActiveEmployees() {
        EntityManager em = emf.createEntityManager();
        List<Employee> list = em.createQuery("SELECT e FROM Employee e WHERE e.active = true", Employee.class)
                .getResultList();
        em.close();
        return list;
    }
}

