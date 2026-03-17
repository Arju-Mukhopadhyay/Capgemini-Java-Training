package com.proj1.proj1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CustomerDAOImpl {
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
    
    public void saveCustomer(Customer2 customer) {
        openConnection();
        em.persist(customer);
        closeConnection();
    }
    
    public Customer2 findById(int id) {
        openConnection();
        Customer2 customer = em.find(Customer2.class, id);
        closeConnection();
        return customer;
    }
    
    public List<Customer2> findAll() {
        openConnection();
        TypedQuery<Customer2> query = em.createQuery("SELECT c FROM Customer2 c", Customer2.class);
        List<Customer2> customers = query.getResultList();
        closeConnection();
        return customers;
    }
    
    public void updateCustomer(Customer2 customer) {
        openConnection();
        em.merge(customer);
        closeConnection();
    }
    
    public void deleteCustomer(int id) {
        openConnection();
        Customer2 customer = em.find(Customer2.class, id);
        if (customer != null) {
            em.remove(customer);
        }
        closeConnection();
    }
    
    public Customer2 findByEmail(String email) {
        openConnection();
        TypedQuery<Customer2> query = em.createQuery("SELECT c FROM Customer2 c WHERE c.email = :email", Customer2.class);
        query.setParameter("email", email);
        Customer2 customer = query.getSingleResult();
        closeConnection();
        return customer;
    }
}