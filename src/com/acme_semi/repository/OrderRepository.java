package com.acme_semi.repository;

import java.util.List;

import com.acme_semi.entities.ChipOrder;
import com.acme_semi.entities.MaskOrder;

public class OrderRepository {
    // all orders store here in the repository
    public List<MaskOrder> maskords;
    public List<ChipOrder> chipords;
}
