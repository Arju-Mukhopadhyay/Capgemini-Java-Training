package com.proj1.proj1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OrderDAOImpl {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private EntityManager em;
    
    private void openConnection() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    private void closeConnection() {
        em.getTransaction().commit();
        em.close();
    }
    
    public void saveOrder(Order order) {
        openConnection();
        em.persist(order);
        closeConnection();
    }
    
    public Order findById(int id) {
        openConnection();
        Order order = em.find(Order.class, id);
        closeConnection();
        return order;
    }
    
    public void updateOrder(Order order) {
        openConnection();
        em.merge(order);
        closeConnection();
    }
}