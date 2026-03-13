package com.proj1.proj1;

import java.time.LocalDate;
import java.util.List;

public class App4 {
    public static void main(String[] args) {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        
        Customer2 customer = new Customer2(1, "Jack", "jack12@gmail.com", "Male",9874563214L, LocalDate.now());
        Order order = new Order(1, "ORD1", "Pizza", 1, 20.00, LocalDate.now());
        
        customer.setOrder(order);
        order.setCustomer(customer);
        
        customerDAO.saveCustomer(customer);
        System.out.println("Customer saved with order");
        
        Customer2 retrievedCustomer = customerDAO.findById(1);
        retrievedCustomer.setCustomerName("Jack Updated");
        customerDAO.updateCustomer(retrievedCustomer);
        System.out.println("Customer updated");
        
        Customer2 fetchedCustomer = customerDAO.findById(1);
        System.out.println("Fetched customer: " + fetchedCustomer);
        
        List<Customer2> allCustomers = customerDAO.findAll();
        System.out.println("All customers: " + allCustomers);
        
        Order fetchedOrder = orderDAO.findById(1);
        fetchedOrder.setQuantity(2);
        fetchedOrder.setPrice(15.00);
        orderDAO.updateOrder(fetchedOrder);
        
        Order updatedOrder = orderDAO.findById(1);
        System.out.println("Updated order: " + updatedOrder);
        
        Customer2 customerByEmail = customerDAO.findByEmail("jack12@email.com");
        System.out.println("Customer found by email: " + customerByEmail);
        
        customerDAO.deleteCustomer(1);
        System.out.println("Customer deleted");
    }
}