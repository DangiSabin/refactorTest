package com.uberchip.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.uberchip.entities.ChipOrder;
import com.uberchip.entities.Customer;
import com.uberchip.entities.DataPoint;
import com.uberchip.entities.Layer;
import com.uberchip.entities.MaskOrder;
import com.uberchip.entities.Order;
import com.uberchip.repository.OrderRepository;
import com.uberchip.services.LogService;
import com.uberchip.services.ProcessOrderService;

/**
 * Refactored to match the output format of Acme_Semi system test.
 */
public class UberChipSystemTest {
	private static final OrderRepository orderRepository = new OrderRepository();
    private static final ProcessOrderService processOrderService = new ProcessOrderService();
    private static final LogService logService = new LogService();

    public static void main(String[] args) {
        UberChipSystemTest.systemTest();
    }

    public static String systemTest() {
        logService.logInfoLn("UberChip order system test commencing...");

        // Setup customers and orders
        setupCustomersAndOrders();

        // Process all orders in the repository
        processAllOrders();

        logService.logInfoLn("UberChip order system test concluded");
        return logService.getLogOutput();
    }
    
    /**
     * Sets up customers and their associated orders.
     */
    private static void setupCustomersAndOrders() {
        Customer customer1 = createCustomer(1, "Generic Motors", "Detroit");
        Customer customer2 = createCustomer(2, "Electric Electronics", "San Jose");

        ChipOrder chipOrder1 = createChipOrder(1, customer1, "controller", true, "20 pin", LocalDate.parse("2024-06-11"), LocalDate.parse("2024-06-11"), 10, 100, createLayersForOrder1());
        MaskOrder maskOrder2 = createMaskOrder(2, customer1, "1X Master", true, LocalDate.parse("2024-06-11"), LocalDate.parse("2024-06-11"), 20, 200, createLayersForOrder2());

        ChipOrder chipOrder3 = createChipOrder(3, customer2, "microprocessor", true, "100 pin", LocalDate.parse("2024-06-11"), LocalDate.parse("2024-06-11"), 30, 300, createLayersForOrder3());
        MaskOrder maskOrder4 = createMaskOrder(4, customer2, "5X Master", false, LocalDate.parse("2024-06-11"), LocalDate.parse("2024-06-11"), 40, 400, createLayersForOrder4());

        customer1.getChipOrders().add(chipOrder1);
        customer1.getMaskOrders().add(maskOrder2);
        customer2.getChipOrders().add(chipOrder3);
        customer2.getMaskOrders().add(maskOrder4);

        orderRepository.getChipOrders().add(chipOrder1);
        orderRepository.getChipOrders().add(chipOrder3);
        orderRepository.getMaskOrders().add(maskOrder2);
        orderRepository.getMaskOrders().add(maskOrder4);
    }

    /**
     * Processes all orders in the order repository.
     */
    private static void processAllOrders() {
        HashMap<Integer, Order> allOrders = new HashMap<>();
        for (ChipOrder chipOrder : orderRepository.getChipOrders()) {
            allOrders.put(chipOrder.getOrderNumber(), chipOrder);
        }
        for (MaskOrder maskOrder : orderRepository.getMaskOrders()) {
            allOrders.put(maskOrder.getOrderNumber(), maskOrder);
        }

        List<Integer> sortedKeys = new ArrayList<>(allOrders.keySet());
        Collections.sort(sortedKeys);

        for (int key : sortedKeys) {
            Order order = allOrders.get(key);
            processOrderService.processOrder(order, logService);
        }
    }

    // Helper methods for creating customers, orders, and layers
    private static Customer createCustomer(int id, String name, String location) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setLocation(location);
        return customer;
    }

    private static ChipOrder createChipOrder(int orderNumber, Customer customer, String productType, boolean isPackaged, String packageType, LocalDate receivedDate, LocalDate shippedDate, double scale, double shift, List<Layer> layers) {
        ChipOrder chipOrder = new ChipOrder();
        chipOrder.setOrderNumber(orderNumber);
        chipOrder.setCustomer(customer);
        chipOrder.setProductType(productType);
        chipOrder.setPackaged(isPackaged);
        chipOrder.setPackageType(packageType);
        chipOrder.setReceivedDate(receivedDate);
        chipOrder.setShippedDate(shippedDate);
        chipOrder.setScale(scale);
        chipOrder.setShift(shift);
        chipOrder.setLayers(layers);
        return chipOrder;
    }
    
    private static MaskOrder createMaskOrder(int orderNumber, Customer customer, String productType, boolean hasPellicle, LocalDate receivedDate, LocalDate shippedDate, double scale, double shift, List<Layer> layers) {
        MaskOrder maskOrder = new MaskOrder();
        maskOrder.setOrderNumber(orderNumber);
        maskOrder.setCustomer(customer);
        maskOrder.setProductType(productType);
        maskOrder.setHasPellicle(hasPellicle);
        maskOrder.setReceivedDate(receivedDate);
        maskOrder.setShippedDate(shippedDate);
        maskOrder.setScale(scale);
        maskOrder.setShift(shift);
        maskOrder.setLayers(layers);
        return maskOrder;
    }

    private static List<Layer> createLayersForOrder1() {
        List<Layer> layers = new ArrayList<>();

        Layer layer1 = new Layer();
        layer1.setLayerNumber(1);
        layer1.setType("metal");
        layer1.setName("metal1");
        layer1.setPatternData(new ArrayList<DataPoint>() {{
            add(new DataPoint(-100, 100));
            add(new DataPoint(100, 100));
            add(new DataPoint(-100, -100));
            add(new DataPoint(100, -100));
        }});
        layers.add(layer1);

        Layer layer2 = new Layer();
        layer2.setLayerNumber(2);
        layer2.setType("via");
        layer2.setName("via1");
        layer2.setPatternData(new ArrayList<DataPoint>() {{
            add(new DataPoint(-10, 10));
            add(new DataPoint(10, 10));
            add(new DataPoint(-10, -10));
            add(new DataPoint(10, -10));
        }});
        layers.add(layer2);

        Layer layer3 = new Layer();
        layer3.setLayerNumber(3);
        layer3.setType("metal");
        layer3.setName("metal2");
        layer3.setPatternData(new ArrayList<DataPoint>() {{
            add(new DataPoint(-1, 1));
            add(new DataPoint(1, 1));
            add(new DataPoint(-1, -1));
            add(new DataPoint(1, -1));
        }});
        layers.add(layer3);

        return layers;
    }
    
    private static List<Layer> createLayersForOrder2() {
        List<Layer> layers = new ArrayList<>();

        Layer layer1 = new Layer();
        layer1.setLayerNumber(1);
        layer1.setType("pattern");
        layer1.setName("layer1");
        layer1.setPatternData(new ArrayList<DataPoint>() {{
            add(new DataPoint(-200, 200));
            add(new DataPoint(200, 200));
            add(new DataPoint(-200, -200));
            add(new DataPoint(200, -200));
        }});
        layers.add(layer1);

        Layer layer2 = new Layer();
        layer2.setLayerNumber(2);
        layer2.setType("pattern");
        layer2.setName("layer2");
        layer2.setPatternData(new ArrayList<DataPoint>() {{
            add(new DataPoint(-20, 20));
            add(new DataPoint(20, 20));
            add(new DataPoint(-20, -20));
            add(new DataPoint(20, -20));
        }});
        layers.add(layer2);

        Layer layer3 = new Layer();
        layer3.setLayerNumber(3);
        layer3.setType("pattern");
        layer3.setName("layer3");
        layer3.setPatternData(new ArrayList<DataPoint>() {{
            add(new DataPoint(-2, 2));
            add(new DataPoint(2, 2));
            add(new DataPoint(-2, -2));
            add(new DataPoint(2, -2));
        }});
        layers.add(layer3);

        return layers;
    }

    private static List<Layer> createLayersForOrder3() {
        List<Layer> layers = new ArrayList<>();

        Layer layer1 = new Layer();
        layer1.setLayerNumber(1);
        layer1.setType("metal");
        layer1.setName("metal1");
        layer1.setPatternData(new ArrayList<DataPoint>() {{
            add(new DataPoint(-300, 300));
            add(new DataPoint(300, 300));
            add(new DataPoint(-300, -300));
            add(new DataPoint(300, -300));
        }});
        layers.add(layer1);

        Layer layer2 = new Layer();
        layer2.setLayerNumber(2);
        layer2.setType("via");
        layer2.setName("via1");
        layer2.setPatternData(new ArrayList<DataPoint>() {{
            add(new DataPoint(-30, 30));
            add(new DataPoint(30, 30));
            add(new DataPoint(-30, -30));
            add(new DataPoint(30, -30));
        }});
        layers.add(layer2);

        Layer layer3 = new Layer();
        layer3.setLayerNumber(3);
        layer3.setType("metal");
        layer3.setName("metal2");
        layer3.setPatternData(new ArrayList<DataPoint>() {{
            add(new DataPoint(-3, 3));
            add(new DataPoint(3, 3));
            add(new DataPoint(-3, -3));
            add(new DataPoint(3, -3));
        }});
        layers.add(layer3);

        return layers;
    }

    private static List<Layer> createLayersForOrder4() {
        List<Layer> layers = new ArrayList<>();

        Layer layer1 = new Layer();
        layer1.setLayerNumber(1);
        layer1.setType("pattern");
        layer1.setName("layer1");
        layer1.setPatternData(new ArrayList<DataPoint>() {{
            add(new DataPoint(-400, 400));
            add(new DataPoint(400, 400));
            add(new DataPoint(-400, -400));
            add(new DataPoint(400, -400));
        }});
        layers.add(layer1);

        Layer layer2 = new Layer();
        layer2.setLayerNumber(2);
        layer2.setType("pattern");
        layer2.setName("layer2");
        layer2.setPatternData(new ArrayList<DataPoint>() {{
            add(new DataPoint(-40, 40));
            add(new DataPoint(40, 40));
            add(new DataPoint(-40, -40));
            add(new DataPoint(40, -40));
        }});
        layers.add(layer2);

        Layer layer3 = new Layer();
        layer3.setLayerNumber(3);
        layer3.setType("pattern");
        layer3.setName("layer3");
        layer3.setPatternData(new ArrayList<DataPoint>() {{
            add(new DataPoint(-4, 4));
            add(new DataPoint(4, 4));
            add(new DataPoint(-4, -4));
            add(new DataPoint(4, -4));
        }});
        layers.add(layer3);

        return layers;
    }
}
