package com.example.Capgemini_Assignment_02.dao;

import com.example.Capgemini_Assignment_02.entity.PerformanceReview;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class PerformanceReviewDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ems");

    public void insertReview(PerformanceReview review) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(review);
        em.getTransaction().commit();
        em.close();
    }

    public void updateReview(Long id, int rating, String comments, LocalDate reviewDate) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        PerformanceReview review = em.find(PerformanceReview.class, id);
        if (review == null) {
            System.out.println("Review not found for id: " + id);
            em.getTransaction().rollback();
            em.close();
            return;
        }

        review.setRating(rating);
        review.setComments(comments);
        review.setReviewDate(reviewDate);

        em.getTransaction().commit();
        em.close();
    }

    public void deleteReview(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        PerformanceReview review = em.find(PerformanceReview.class, id);
        if (review != null)
            em.remove(review);
        em.getTransaction().commit();
        em.close();
    }

    public List<PerformanceReview> getByEmployeeCode(String empCode) {
        EntityManager em = emf.createEntityManager();
        List<PerformanceReview> list = em.createQuery(
                "SELECT p FROM PerformanceReview p WHERE p.employeeCode = :code", PerformanceReview.class)
                .setParameter("code", empCode)
                .getResultList();
        em.close();
        return list;
    }
}

