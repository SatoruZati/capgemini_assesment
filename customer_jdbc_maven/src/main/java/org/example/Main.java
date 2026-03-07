package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.CustomerDAO;
import org.example.dao.CustomerDAOImpl;
import org.example.dao.OrderDAO;
import org.example.dao.OrderDAOImpl;
import org.example.entity.Customer;
import org.example.entity.Order;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customerJDBC");
        EntityManager em = emf.createEntityManager();

        CustomerDAO customerDAO = new CustomerDAOImpl(em);
        OrderDAO orderDAO = new OrderDAOImpl(em);

        Customer messi = new Customer("Lionel Messi", "leo.messi10@mail.com", "Male", 9876501234L, LocalDate.of(2024, 1, 15));
        Customer ronaldo = new Customer("Cristiano Ronaldo", "cr7.ronaldo@mail.com", "Male", 9123400007L, LocalDate.of(2024, 2, 20));
        Customer neymar = new Customer("Neymar Jr", "neymar.jr11@mail.com", "Male", 9988776655L, LocalDate.of(2024, 3, 5));
        Customer zidane = new Customer("Zinedine Zidane", "zizou.zidane@mail.com", "Male", 9871234560L, LocalDate.of(2024, 4, 18));
        Customer ronaldinho = new Customer("Ronaldinho Gaucho", "ronaldinho10@mail.com", "Male", 9765432100L, LocalDate.of(2024, 5, 22));
        Customer ramos = new Customer("Sergio Ramos", "sergio.ramos4@mail.com", "Male", 9654321089L, LocalDate.of(2024, 6, 30));

        customerDAO.saveCustomer(messi);
        customerDAO.saveCustomer(ronaldo);
        customerDAO.saveCustomer(neymar);
        customerDAO.saveCustomer(zidane);
        customerDAO.saveCustomer(ronaldinho);
        System.out.println(customerDAO.saveCustomer(ramos));

        // update phone
        neymar.setPhone(9111222333L);
        System.out.println(customerDAO.updateCustomer(neymar));

        // fetch by id
        Customer fetched = customerDAO.getCustomerById(messi.getId());
        System.out.println("fetched: " + fetched);

        // fetch customer by email
        Customer byEmail = customerDAO.getCustomerByEmail("zizou.zidane@mail.com");
        System.out.println("by email: " + byEmail);

        // list everyone
        List<Customer> everyone = customerDAO.getAllCustomers();
        System.out.println("all customers:");
        everyone.forEach(System.out::println);

        //  Order CRUD

        Order o1 = new Order("ORD-001", "iPhone 17 Pro Max", 1, 134670.0, LocalDate.of(2024, 2, 1));
        Order o2 = new Order("ORD-002", "Samsung Galaxy S26 Ultra", 2, 107899.0, LocalDate.of(2024, 3, 10));
        Order o3 = new Order("ORD-003", "Dell ALienware 15 Laptop", 1, 189785.0, LocalDate.of(2024, 4, 15));
        Order o4 = new Order("ORD-004", "Sony Alpha A7 Camera", 1, 242290.0, LocalDate.of(2024, 5, 20));
        Order o5 = new Order("ORD-005", "MacBook Pro 14 M5", 1, 219659.0, LocalDate.of(2024, 6, 1));

        // link orders to customers
        o1.setCustomer(messi);
        messi.setOrder(o1);
        o2.setCustomer(ronaldo);
        ronaldo.setOrder(o2);
        o3.setCustomer(neymar);
        neymar.setOrder(o3);
        o4.setCustomer(zidane);
        zidane.setOrder(o4);
        o5.setCustomer(ronaldinho);
        ronaldinho.setOrder(o5);

        orderDAO.saveOrder(o1);
        orderDAO.saveOrder(o2);
        orderDAO.saveOrder(o3);
        orderDAO.saveOrder(o4);
        System.out.println(orderDAO.saveOrder(o5));

        // customer bought one more phone
        o2.setQuantity(3);
        System.out.println(orderDAO.updateOrder(o2));

        // fetch o1 by id
        Order gotOrder = orderDAO.getOrderById(o1.getId());
        System.out.println("fetched order: " + gotOrder);

        // customer has no order        // safe to delete
        System.out.println(customerDAO.deleteCustomerById(ramos.getId()));

        // delete o3
        System.out.println(orderDAO.deleteOrderById(o3.getId()));

        em.close();
        emf.close();
    }
}
