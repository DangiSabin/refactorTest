package com.uberchip.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Refactored to encapsulate fields and provide getter and setter methods.
 */
public class Customer{
	private int id;
    private String name;
    private String location;
    private List<ChipOrder> chipOrders = new ArrayList<>();
    private List<MaskOrder> maskOrders = new ArrayList<>();
    
    // Getters and Setters
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<ChipOrder> getChipOrders() {
		return chipOrders;
	}
	public void setChipOrders(List<ChipOrder> chipOrders) {
		this.chipOrders = chipOrders;
	}
	public List<MaskOrder> getMaskOrders() {
		return maskOrders;
	}
	public void setMaskOrders(List<MaskOrder> maskOrders) {
		this.maskOrders = maskOrders;
	}
}
