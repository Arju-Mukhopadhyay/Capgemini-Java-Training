package com.proj1.proj1;
import jakarta.persistence.*;
import java.util.*;
import java.time.LocalDate;
@Entity
@Table(name="orders")
public class Order {
	@Id
	@Column
	private int id;
	@Column
	private String orderNo;
	@Column
	private String productName;
	@Column
	private int quantity;
	@Column
	private double price;
	@Column
	private LocalDate orderDate;
	@OneToOne(mappedBy="order")
	private Customer2 customer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public Customer2 getCustomer() {
		return customer;
	}
	public void setCustomer(Customer2 customer) {
		this.customer = customer;
	}
	public Order() {
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNo=" + orderNo + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + ", orderDate=" + orderDate + "]";
	}
	public Order(int id, String orderNo, String productName, int quantity, double price, LocalDate orderDate) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
	}
	
	
}