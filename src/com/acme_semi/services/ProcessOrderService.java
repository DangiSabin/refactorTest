package com.acme_semi.services;

import java.util.ArrayList;

import com.acme_semi.entities.ChipOrder;
import com.acme_semi.entities.DataPoint;
import com.acme_semi.entities.Layer;
import com.acme_semi.entities.MaskOrder;

public class ProcessOrderService {

    public int processord(ChipOrder cord, LogService lServ) {
        lServ.loginfoln("Starting Order processing...\n");
        lServ.loginfoln("Order Number: " + cord.onum);
        lServ.loginfoln("Customer Name: " + cord.cust.name);
        lServ.loginfoln("Order Type: " + cord.ordertyp);
        lServ.loginfoln("Product Type: " + cord.prodtyp);
        lServ.loginfoln("Packaged: " + cord.ispackaged);
        lServ.loginfoln("Package Type: " + cord.packagetyp);
        lServ.loginfoln("Received Date: " + cord.recdate);
        lServ.loginfoln("Shipped Date: " + cord.shpdate);
        for (int i=0; i < cord.layers.size(); i++) {
            Layer l = (Layer) cord.layers.get(i);
            lServ.loginfoln("-----------------------");
            lServ.loginfoln("Layer Number: " + l.lnum);
            lServ.loginfoln("Layer Type: " + l.typ);
            lServ.loginfoln("Layer Name: " + l.nam);
            lServ.loginfo("Original Pattern Data: ");
            ArrayList<DataPoint> scalddat = new ArrayList<DataPoint>();
            for (int j = 0; j < l.ptrnDat.size(); j++) {
                lServ.loginfo("{" + l.ptrnDat.get(j).x + "," + l.ptrnDat.get(j).y + "} ");
                DataPoint scaldp = new DataPoint(l.ptrnDat.get(j).x * cord.scl, l.ptrnDat.get(j).y * cord.scl);
                scalddat.add(scaldp);
            }
            lServ.loginfoln("");
            lServ.loginfo("Scaled Pattern Data: ");
            ArrayList<DataPoint> scaldshftdat = new ArrayList<DataPoint>();
            for (int j = 0; j < l.ptrnDat.size(); j++) {
                lServ.loginfo("{" + scalddat.get(j).x + "," + scalddat.get(j).y + "} ");
                DataPoint scalshftdp = new DataPoint(scalddat.get(j).x + cord.shft, scalddat.get(j).y + cord.shft);
                scaldshftdat.add(scalshftdp);
            }
            lServ.loginfoln();
            lServ.loginfo("Shifted Pattern Data: ");
            for (int j = 0; j < l.ptrnDat.size(); j++) {
                lServ.loginfo("{" + scaldshftdat.get(j).x + "," + scaldshftdat.get(j).y + "} ");
            }
            lServ.loginfoln();
        }
        lServ.loginfoln("done processing order " + cord.onum + "\n");
        return 1;
    }

    public int processord(MaskOrder mord, LogService lServ) {
        lServ.loginfoln("Starting Order processing...\n");
        lServ.loginfoln("Order Number: " + mord.onum);
        lServ.loginfoln("Customer Name: " + mord.cust.name);
        lServ.loginfoln("Order Type: " + mord.ordertyp);
        lServ.loginfoln("Product Type: " + mord.prodtyp);
        lServ.loginfoln("Pellicle: " + mord.haspellicle);
        lServ.loginfoln("Received Date: " + mord.recdate);
        lServ.loginfoln("Shipped Date: " + mord.shpdate);
        for (int i=0; i < mord.layers.size(); i++) {
            Layer l = (Layer) mord.layers.get(i);
            lServ.loginfoln("-----------------------");
            lServ.loginfoln("Layer Number: " + l.lnum);
            lServ.loginfoln("Layer Type: " + l.typ);
            lServ.loginfoln("Layer Name: " + l.nam);
            lServ.loginfo("Original Pattern Data: ");
            ArrayList<DataPoint> scalddat = new ArrayList<DataPoint>();
            for (int j = 0; j < l.ptrnDat.size(); j++) {
                lServ.loginfo("{" + l.ptrnDat.get(j).x + "," + l.ptrnDat.get(j).y + "} ");
                DataPoint scaldp = new DataPoint(l.ptrnDat.get(j).x * mord.scl, l.ptrnDat.get(j).y * mord.scl);
                scalddat.add(scaldp);
            }
            lServ.loginfoln();
            lServ.loginfo("Scaled Pattern Data: ");
            ArrayList<DataPoint> scaldshftdat = new ArrayList<DataPoint>();
            for (int j = 0; j < l.ptrnDat.size(); j++) {
                lServ.loginfo("{" + scalddat.get(j).x + "," + scalddat.get(j).y + "} ");
                DataPoint scalshftdp = new DataPoint(scalddat.get(j).x + mord.shft, scalddat.get(j).y + mord.shft);
                scaldshftdat.add(scalshftdp);
            }
            lServ.loginfoln();
            lServ.loginfo("Shifted Pattern Data: ");
            for (int j = 0; j < l.ptrnDat.size(); j++) {
                lServ.loginfo("{" + scaldshftdat.get(j).x + "," + scaldshftdat.get(j).y + "} ");
            }
            lServ.loginfoln();
        }
        lServ.loginfoln("done processing order " + mord.onum + "\n");
        return 1;
    }
}
