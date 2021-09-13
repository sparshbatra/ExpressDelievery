package sample;

import java.util.ArrayList;

public class Order {
    private double weight;
    private double distance;
    private String voucherCode;
    private double shippingCost;
    private double payableAmount;
    private int shipmentId = 00000;

    public Order() {
    }

    public Order(int shipmentId, double weight, double distance, double shippingCost, double payableAmount, String voucherCode) {
        shipmentId=shipmentId;
        weight = weight;
        distance=distance;
        shippingCost=shippingCost;
        payableAmount=payableAmount;
        voucherCode=voucherCode;

    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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







}
