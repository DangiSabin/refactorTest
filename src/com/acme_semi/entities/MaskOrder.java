package com.acme_semi.entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class MaskOrder {
    public int onum;
    public Customer cust;
    public String prodtyp;
    public LocalDate recdate;
    public LocalDate shpdate;
    public ArrayList layers;
    public double scl;
    public double shft;
    public String ordertyp = "Mask";

    public boolean haspellicle;
    public String glasssiz;
    public String glasstyp;
}
