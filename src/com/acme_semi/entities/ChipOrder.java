package com.acme_semi.entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class ChipOrder {
    public int onum;
    public Customer cust;
    public String prodtyp;
    public LocalDate recdate;
    public LocalDate shpdate;
    public ArrayList layers;
    public double scl;
    public double shft;
    public String ordertyp = "Chip";

    public boolean ispackaged;
    public String packagetyp;

}
