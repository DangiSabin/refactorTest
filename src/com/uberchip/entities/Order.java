package com.uberchip.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for orders, encapsulating common fields and methods.
 */
public abstract class Order {
	private int orderNumber;
    private Customer customer;
    private String productType;
    private LocalDate receivedDate;
    private LocalDate shippedDate;
    private List<Layer> layers = new ArrayList<>();
    private double scale;
    private double shift;
    
    // Getters and Setters
    
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public LocalDate getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(LocalDate receivedDate) {
		this.receivedDate = receivedDate;
	}
	public LocalDate getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(LocalDate shippedDate) {
		this.shippedDate = shippedDate;
	}
	public List<Layer> getLayers() {
		return layers;
	}
	public void setLayers(List<Layer> layers) {
		this.layers = layers;
	}
	public double getScale() {
		return scale;
	}
	public void setScale(double scale) {
		this.scale = scale;
	}
	public double getShift() {
		return shift;
	}
	public void setShift(double shift) {
		this.shift = shift;
	}
    
	public abstract String getOrderType();
}
