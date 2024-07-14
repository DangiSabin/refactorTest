package com.uberchip.services;

import java.util.List;

import com.uberchip.entities.ChipOrder;
import com.uberchip.entities.DataPoint;
import com.uberchip.entities.Layer;
import com.uberchip.entities.MaskOrder;
import com.uberchip.entities.Order;

/**
 * Refactored to handle both ChipOrder and MaskOrder types in a unified manner.
 */
public class ProcessOrderService {

	/**
     * Processes an Order (either ChipOrder or MaskOrder) and logs the information.
     * 
     * @param order the Order to process
     * @param logService the LogService to use for logging
     */
    public void processOrder(Order order, LogService logService) {
    	logService.logInfoLn("Starting Order processing...\n");
        logService.logInfoLn("Order Number: " + order.getOrderNumber());
        logService.logInfoLn("Customer Name: " + order.getCustomer().getName());
        logService.logInfoLn("Order Type: " + order.getOrderType());
        logService.logInfoLn("Product Type: " + order.getProductType());

        if (order instanceof ChipOrder) {
            ChipOrder chipOrder = (ChipOrder) order;
            logService.logInfoLn("Packaged: " + chipOrder.isPackaged());
            logService.logInfoLn("Package Type: " + chipOrder.getPackageType());
        } else if (order instanceof MaskOrder) {
            MaskOrder maskOrder = (MaskOrder) order;
            logService.logInfoLn("Pellicle: " + maskOrder.isHasPellicle());
        }
        
        logService.logInfoLn("Received Date: " + order.getReceivedDate());
        logService.logInfoLn("Shipped Date: " + order.getShippedDate());

        processLayers(order.getLayers(), order.getScale(), order.getShift(), logService);

        logService.logInfoLn("done processing order " + order.getOrderNumber() + "\n");
    }
    
    /**
     * Processes the layers of an order, applying scaling and shifting to the pattern data.
     * 
     * @param layers the list of layers to process
     * @param scale the scale factor to apply
     * @param shift the shift value to apply
     * @param logService the LogService to use for logging
     */
    private void processLayers(List<Layer> layers, double scale, double shift, LogService logService) {
        for (Layer layer : layers) {
            logService.logInfoLn("-----------------------");
            logService.logInfoLn("Layer Number: " + layer.getLayerNumber());
            logService.logInfoLn("Layer Type: " + layer.getType());
            logService.logInfoLn("Layer Name: " + layer.getName());

            // Log the original pattern data
            logService.logInfo("Original Pattern Data: ");
            for (DataPoint dataPoint : layer.getPatternData()) {
                logService.logInfo("{" + dataPoint.getX() + "," + dataPoint.getY() + "} ");
            }
            logService.logInfoLn();

            // Log the scaled pattern data
            logService.logInfo("Scaled Pattern Data: ");
            for (DataPoint dataPoint : layer.getPatternData()) {
                DataPoint scaledDataPoint = new DataPoint(dataPoint.getX() * scale, dataPoint.getY() * scale);
                logService.logInfo("{" + scaledDataPoint.getX() + "," + scaledDataPoint.getY() + "} ");
            }
            logService.logInfoLn();

            // Log the shifted pattern data
            logService.logInfo("Shifted Pattern Data: ");
            for (DataPoint dataPoint : layer.getPatternData()) {
                DataPoint shiftedDataPoint = new DataPoint(dataPoint.getX() * scale + shift, dataPoint.getY() * scale + shift);
                logService.logInfo("{" + shiftedDataPoint.getX() + "," + shiftedDataPoint.getY() + "} ");
            }
            logService.logInfoLn();
        }
    }
}
