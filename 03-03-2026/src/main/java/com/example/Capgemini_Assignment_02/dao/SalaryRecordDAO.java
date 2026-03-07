package com.example.Capgemini_Assignment_02.dao;

import com.example.Capgemini_Assignment_02.entity.SalaryRecord;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class SalaryRecordDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ems");

    public void insertSalaryRecord(SalaryRecord record) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(record);
        em.getTransaction().commit();
        em.close();
    }

    public void updateSalaryRecord(Long id, double baseSalary, double bonus, double tax) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        SalaryRecord record = em.find(SalaryRecord.class, id);
        if (record == null) {
            System.out.println("Salary record not found for id: " + id);
            em.getTransaction().rollback();
            em.close();
            return;
        }

        record.setBaseSalary(baseSalary);
        record.setBonus(bonus);
        record.setTax(tax);
        // netSalary recalculated inside the setters

        em.getTransaction().commit();
        em.close();
    }

    public void deleteSalaryRecord(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        SalaryRecord record = em.find(SalaryRecord.class, id);
        if (record != null)
            em.remove(record);
        em.getTransaction().commit();
        em.close();
    }

    public List<SalaryRecord> getByEmployeeCode(String empCode) {
        EntityManager em = emf.createEntityManager();
        List<SalaryRecord> list = em.createQuery(
                "SELECT s FROM SalaryRecord s WHERE s.employeeCode = :code", SalaryRecord.class)
                .setParameter("code", empCode)
                .getResultList();
        em.close();
        return list;
    }

    public List<SalaryRecord> getBySalaryMonth(String salaryMonth) {
        EntityManager em = emf.createEntityManager();
        List<SalaryRecord> list = em.createQuery(
                "SELECT s FROM SalaryRecord s WHERE s.salaryMonth = :month", SalaryRecord.class)
                .setParameter("month", salaryMonth)
                .getResultList();
        em.close();
        return list;
    }

    public List<SalaryRecord> getAllByEmployee(String empCode) {
        return getByEmployeeCode(empCode);
    }
}

