package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Logic {
    private ArrayList<Order> listOfOrders;
    HashMap<int, String> shipmentDetail = new HashMap<int, String>();


    public double getCost(double input1, double input2, String input3) {
        Order order = new Order();
        order.setWeight(input1);
        order.setDistance(input2);
        order.setVoucherCode(input3);

        double cost = order.getShippingCost();
        return cost;

    }
    public HashMap<int, String> getShipmentDetail(){

        return shipmentDetail;

    }

    public void updateDetails(int input1, int input2) {
        int id = input1;
        String status = input2;
        shipmentDetail[id] = input2;


    }
}
