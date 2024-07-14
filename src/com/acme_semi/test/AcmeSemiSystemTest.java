package com.acme_semi.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import com.acme_semi.entities.ChipOrder;
import com.acme_semi.entities.Customer;
import com.acme_semi.entities.DataPoint;
import com.acme_semi.entities.Layer;
import com.acme_semi.entities.MaskOrder;
import com.acme_semi.repository.OrderRepository;
import com.acme_semi.services.ProcessOrderService;
import com.acme_semi.services.LogService;

public class AcmeSemiSystemTest {

    static OrderRepository oRep = new OrderRepository();
    static ProcessOrderService pServ = new ProcessOrderService();
    static LogService lServ = new LogService();

    public static void main(String[] args) {
        AcmeSemiSystemTest.systemTest();
    }

    public static String systemTest() {
        lServ.loginfoln("Acme_Semi order system test commencing...");
        // setup up customer, order, layer, pattern data

        // custs (2)
        int cNum1 = 1;
        Customer c1 = new Customer();
        c1.id = cNum1;
        c1.name = "Generic Motors";
        c1.loc = "Detroit";
        int cNum2 = 2;
        Customer c2 = new Customer();
        c2.id = cNum2;
        c2.name = "Electric Electronics";
        c2.loc = "San Jose";

        // order 1
        int oNum = 1;
        ChipOrder cOrd1 = new ChipOrder();
        cOrd1.onum = oNum;
        cOrd1.cust = c1;
        cOrd1.prodtyp = "controller";
        cOrd1.ispackaged = true;
        cOrd1.packagetyp = "20 pin";
        cOrd1.recdate = LocalDate.parse("2024-06-11");
        cOrd1.shpdate = LocalDate.parse("2024-06-11");
        ArrayList cOrd1layers = new ArrayList();
        cOrd1.layers = cOrd1layers;
        cOrd1.scl = 10;
        cOrd1.shft = 100;

        Layer o1l1 = new Layer();
        int o1lnum1 = 1;
        o1l1.lnum = o1lnum1;
        o1l1.typ = "metal";
        o1l1.nam = "metal1";
        o1l1.ptrnDat = new ArrayList<DataPoint>() {{ add(new DataPoint(-100, 100)); add(new DataPoint(100, 100)); add(new DataPoint(-100, -100)); add(new DataPoint(100, -100)); }};
        cOrd1layers.add(o1l1);

        Layer o1l2 = new Layer();
        int o1lnum2 = 2;
        o1l2.lnum = o1lnum2;
        o1l2.typ = "via";
        o1l2.nam = "via1";
        o1l2.ptrnDat = new ArrayList<DataPoint>() {{ add(new DataPoint(-10, 10)); add(new DataPoint(10, 10)); add(new DataPoint(-10, -10)); add(new DataPoint(10, -10)); }};
        cOrd1layers.add(o1l2);

        Layer o1l3 = new Layer();
        int o1lnum3 = 3;
        o1l3.lnum = o1lnum3;
        o1l3.typ = "metal";
        o1l3.nam = "metal2";
        o1l3.ptrnDat = new ArrayList<DataPoint>() {{ add(new DataPoint(-1, 1)); add(new DataPoint(1, 1)); add(new DataPoint(-1, -1)); add(new DataPoint(1, -1)); }};
        cOrd1layers.add(o1l3);

        // order 2
        oNum = 2;
        MaskOrder mOrd2 = new MaskOrder();
        mOrd2.onum = oNum;
        mOrd2.cust = c1;
        mOrd2.prodtyp = "1X Master";
        mOrd2.recdate = LocalDate.parse("2024-06-11");
        mOrd2.shpdate = LocalDate.parse("2024-06-11");
        mOrd2.haspellicle = true;
        ArrayList mOrd2layers = new ArrayList();
        mOrd2.layers = mOrd2layers;
        mOrd2.scl = 20;
        mOrd2.shft = 200;

        Layer o2l1 = new Layer();
        int o2lnum1 = 1;
        o2l1.lnum = o2lnum1;
        o2l1.typ = "pattern";
        o2l1.nam = "layer1";
        o2l1.ptrnDat = new ArrayList<DataPoint>() {{ add(new DataPoint(-200, 200)); add(new DataPoint(200, 200)); add(new DataPoint(-200, -200)); add(new DataPoint(200, -200)); }};
        mOrd2layers.add(o2l1);

        Layer o2l2 = new Layer();
        int o2lnum2 = 2;
        o2l2.lnum = o2lnum2;
        o2l2.typ = "pattern";
        o2l2.nam = "layer2";
        o2l2.ptrnDat = new ArrayList<DataPoint>() {{ add(new DataPoint(-20, 20)); add(new DataPoint(20, 20)); add(new DataPoint(-20, -20)); add(new DataPoint(20, -20)); }};
        mOrd2layers.add(o2l2);

        Layer o2l3 = new Layer();
        int o2lnum3 = 3;
        o2l3.lnum = o2lnum3;
        o2l3.typ = "pattern";
        o2l3.nam = "layer3";
        o2l3.ptrnDat = new ArrayList<DataPoint>() {{ add(new DataPoint(-2, 2)); add(new DataPoint(2, 2)); add(new DataPoint(-2, -2)); add(new DataPoint(2, -2)); }};
        mOrd2layers.add(o2l3);

        // order 3
        oNum = 3;
        ChipOrder cOrd3 = new ChipOrder();
        cOrd3.onum = oNum;
        cOrd3.cust = c2;
        cOrd3.prodtyp = "microprocessor";
        cOrd3.ispackaged = true;
        cOrd3.packagetyp = "100 pin";
        cOrd3.recdate = LocalDate.parse("2024-06-11");
        cOrd3.shpdate = LocalDate.parse("2024-06-11");
        ArrayList cOrd3layers = new ArrayList();
        cOrd3.layers = cOrd3layers;
        cOrd3.scl = 30;
        cOrd3.shft = 300;

        Layer o3l1 = new Layer();
        int o3lnum1 = 1;
        o3l1.lnum = o3lnum1;
        o3l1.typ = "metal";
        o3l1.nam = "metal1";
        o3l1.ptrnDat = new ArrayList<DataPoint>() {{ add(new DataPoint(-300, 300)); add(new DataPoint(300, 300)); add(new DataPoint(-300, -300)); add(new DataPoint(300, -300)); }};
        cOrd3layers.add(o3l1);

        Layer o3l2 = new Layer();
        int o3lnum2 = 2;
        o3l2.lnum = o3lnum2;
        o3l2.typ = "via";
        o3l2.nam = "via1";
        o3l2.ptrnDat = new ArrayList<DataPoint>() {{ add(new DataPoint(-30, 30)); add(new DataPoint(30, 30)); add(new DataPoint(-30, -30)); add(new DataPoint(30, -30)); }};
        cOrd3layers.add(o3l2);

        Layer o3l3 = new Layer();
        int o3lnum3 = 3;
        o3l3.lnum = o3lnum3;
        o3l3.typ = "metal";
        o3l3.nam = "metal2";
        o3l3.ptrnDat = new ArrayList<DataPoint>() {{ add(new DataPoint(-3, 3)); add(new DataPoint(3, 3)); add(new DataPoint(-3, -3)); add(new DataPoint(3, -3)); }};
        cOrd3layers.add(o3l3);

        // order 4
        oNum = 4;
        MaskOrder mOrd4 = new MaskOrder();
        mOrd4.onum = oNum;
        mOrd4.cust = c2;
        mOrd4.prodtyp = "5X Master";
        mOrd4.haspellicle = false;
        mOrd4.recdate = LocalDate.parse("2024-06-11");
        mOrd4.shpdate = LocalDate.parse("2024-06-11");
        ArrayList mOrd4layers = new ArrayList();
        mOrd4.layers = mOrd4layers;
        mOrd4.scl = 40;
        mOrd4.shft = 400;

        Layer o4l1 = new Layer();
        int o4lnum1 = 1;
        o4l1.lnum = o4lnum1;
        o4l1.typ = "pattern";
        o4l1.nam = "layer1";
        o4l1.ptrnDat = new ArrayList<DataPoint>() {{ add(new DataPoint(-400, 400)); add(new DataPoint(400, 400)); add(new DataPoint(-400, -400)); add(new DataPoint(400, -400)); }};
        mOrd4layers.add(o4l1);

        Layer o4l2 = new Layer();
        int o4lnum2 = 2;
        o4l2.lnum = o4lnum2;
        o4l2.typ = "pattern";
        o4l2.nam = "layer2";
        o4l2.ptrnDat = new ArrayList<DataPoint>() {{ add(new DataPoint(-40, 40)); add(new DataPoint(40, 40)); add(new DataPoint(-40, -40)); add(new DataPoint(40, -40)); }};
        mOrd4layers.add(o4l2);

        Layer o4l3 = new Layer();
        int o4lnum3 = 3;
        o4l3.lnum = o4lnum3;
        o4l3.typ = "pattern";
        o4l3.nam = "layer3";
        o4l3.ptrnDat = new ArrayList<DataPoint>() {{ add(new DataPoint(-4, 4)); add(new DataPoint(4, 4)); add(new DataPoint(-4, -4)); add(new DataPoint(4, -4)); }};
        mOrd4layers.add(o4l3);

        // ords to custs
        c1.chipOrds = new ArrayList<ChipOrder>();
        c1.maskOrds = new ArrayList<MaskOrder>();
        c2.chipOrds = new ArrayList<ChipOrder>();
        c2.maskOrds = new ArrayList<MaskOrder>();
        c1.chipOrds.add(cOrd1);
        c1.maskOrds.add(mOrd2);
        c2.chipOrds.add(cOrd3);
        c2.maskOrds.add(mOrd4);

        // update rep
        oRep.chipords = new ArrayList<ChipOrder>();
        oRep.maskords = new ArrayList<MaskOrder>();
        oRep.chipords.add(cOrd1);
        oRep.chipords.add(cOrd3);
        oRep.maskords.add(mOrd2);
        oRep.maskords.add(mOrd4);

        // process all orders in repo in order of order number
        HashMap<Integer, Object> allordrs = new HashMap<Integer, Object>();
        for (int i=0; i<oRep.chipords.size(); i++) {
            Object ord = oRep.chipords.get(i);
            int onum = ((ChipOrder)ord).onum;
            allordrs.put(onum, ord);
        }
        for (int i=0; i<oRep.maskords.size(); i++) {
            Object ord = oRep.maskords.get(i);
            int onum = ((MaskOrder)ord).onum;
            allordrs.put(onum, ord);
        }
        ArrayList srtdkeys = new ArrayList();
        srtdkeys.addAll(allordrs.keySet());
        Collections.sort(srtdkeys);
        for (int i=0; i<srtdkeys.size(); i++) {
            int key = (int)srtdkeys.get(i);
            Object order = allordrs.get(key);
            if (order instanceof ChipOrder) {
                pServ.processord((ChipOrder)allordrs.get(key), lServ);
            } else if (order instanceof MaskOrder) {
                pServ.processord((MaskOrder)allordrs.get(key), lServ);
            }
        }

        lServ.loginfoln("Acme_Semi order system test concluded");
        return lServ.logoutput;
    }
}
