package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entity.Order;

public class OrderDAOImpl implements OrderDAO {

    private final EntityManager em;

    public OrderDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public String saveOrder(Order o) {
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        return "saved order: " + o.getOrderNumber();
    }

    @Override
    public String updateOrder(Order o) {
        em.getTransaction().begin();
        em.merge(o);
        em.getTransaction().commit();
        return "updated order: " + o.getOrderNumber();
    }

    @Override
    public String deleteOrderById(int id) {
        Order found = em.find(Order.class, id);
        if (found == null) return "order not found";
        em.getTransaction().begin();
        em.remove(found);
        em.getTransaction().commit();
        return "deleted order id=" + id;
    }

    @Override
    public Order getOrderById(int id) {
        return em.find(Order.class, id);
    }
}
