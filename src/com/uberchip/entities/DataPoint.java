package com.uberchip.entities;

/**
 * Refactored to encapsulate fields and provide getter methods.
 */
public class DataPoint{
	private double x;
	private double y;

    public DataPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters and Setters
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}  
}
