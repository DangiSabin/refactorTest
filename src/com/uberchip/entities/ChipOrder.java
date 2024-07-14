package com.uberchip.entities;

/**
 * Refactored to encapsulate fields and provide getter and setter methods.
 */
public class ChipOrder extends Order {
	private boolean isPackaged;
    private String packageType;
    
    // Getters and Setters
	
	public boolean isPackaged() {
		return isPackaged;
	}

	public void setPackaged(boolean isPackaged) {
		this.isPackaged = isPackaged;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	@Override
	public String getOrderType() {
		return "Chip";
	}
}
