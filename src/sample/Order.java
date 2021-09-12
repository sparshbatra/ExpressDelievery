package sample;

import java.util.ArrayList;

public class Order {
    private double weight;
    private double distance;
    private String voucherCode;
    private String orderId;
    private double shippingCost;
    private double payableAmount;
    private int shipmentId = 00000;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    private String shipmentStatus;


    private boolean ifValidOrder(double weight){
        if(weight > 30.00 || weight < 1.0){
            return true;
        }
        if(distance < 5.0 || distance >3000.0){
            return true;
        }
        return false;
    }

    public double getShippingCost(float weight, double distance, String voucherCode){
        if(ifValidOrder(weight) == true){
            return -1;
        }

        double p = Math.ceil(distance/5);
        if(weight <= 2){
            shippingCost = 8.10*p;
        }
        else if(weight > 2 && weight <= 6){
            shippingCost = 9.20*p;
        }
        else if(weight > 6 && weight <= 10){
            shippingCost = 12.70*p;
        }
        else {
            shippingCost = 16.80*p;
        }

        double validVoucher = ifValidVoucherCode(voucherCode);

        if(validVoucher!=-1){
            shippingCost -= validVoucher;
        }
        shipmentId++;
        return shippingCost;
    }

    private double ifValidVoucherCode(String voucherCode){
        if(voucherCode == "1111")
            return 10;
        if(voucherCode == "2222")
            return 20;
        if(voucherCode == "3333")
            return 30;
        if(voucherCode == "4444")
            return 40;
        return -1;
    }



}
