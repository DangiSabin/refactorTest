package com.uberchip.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Refactored to encapsulate fields and provide getter and setter methods.
 */
public class Layer{
	private int layerNumber;
    private String type;
    private String name;
    private List<DataPoint> patternData = new ArrayList<>();
    
    // Getters and Setters
    
	public int getLayerNumber() {
		return layerNumber;
	}
	public void setLayerNumber(int layerNumber) {
		this.layerNumber = layerNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DataPoint> getPatternData() {
		return patternData;
	}
	public void setPatternData(List<DataPoint> patternData) {
		this.patternData = patternData;
	}
}
