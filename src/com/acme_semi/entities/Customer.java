package com.acme_semi.entities;

import java.util.ArrayList;

public class Customer {
    public int id;
    public String name;
    public String loc;
    public ArrayList<ChipOrder> chipOrds;
    public ArrayList<MaskOrder> maskOrds;
}
