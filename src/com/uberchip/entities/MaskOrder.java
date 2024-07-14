package com.uberchip.entities;

/**
 * Refactored to encapsulate fields and provide getter and setter methods.
 */
public class MaskOrder extends Order {
	private boolean hasPellicle;
	
	// Getters and Setters
	public boolean isHasPellicle() {
		return hasPellicle;
	}

	public void setHasPellicle(boolean hasPellicle) {
		this.hasPellicle = hasPellicle;
	}

	@Override
	public String getOrderType() {
		return "Mask";
	}
}
