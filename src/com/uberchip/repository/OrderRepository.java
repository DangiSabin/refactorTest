package com.uberchip.repository;

import java.util.ArrayList;
import java.util.List;

import com.uberchip.entities.ChipOrder;
import com.uberchip.entities.MaskOrder;

/**
 * Refactored to use appropriate data structures and encapsulation.
 */
public class OrderRepository {
	private List<MaskOrder> maskOrders = new ArrayList<>();
    private List<ChipOrder> chipOrders = new ArrayList<>();
    
    // Getters and Setters
    
	public List<MaskOrder> getMaskOrders() {
		return maskOrders;
	}
	public void setMaskOrders(List<MaskOrder> maskOrders) {
		this.maskOrders = maskOrders;
	}
	public List<ChipOrder> getChipOrders() {
		return chipOrders;
	}
	public void setChipOrders(List<ChipOrder> chipOrders) {
		this.chipOrders = chipOrders;
	}
}
