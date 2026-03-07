package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.example.entity.Customer;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private final EntityManager em;

    public CustomerDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public String saveCustomer(Customer c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return "saved: " + c.getCustomerName();
    }

    @Override
    public String updateCustomer(Customer c) {
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
        return "updated: " + c.getCustomerName();
    }

    @Override
    public String deleteCustomerById(int id) {
        Customer found = em.find(Customer.class, id);
        if (found == null) return "customer not found";
        em.getTransaction().begin();
        em.remove(found);
        em.getTransaction().commit();
        return "deleted customer id=" + id;
    }

    @Override
    public Customer getCustomerById(int id) {
        return em.find(Customer.class, id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        // pull everything
        return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        try {
            return em.createQuery("SELECT c FROM Customer c WHERE c.email = :mail", Customer.class)
                    .setParameter("mail", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
