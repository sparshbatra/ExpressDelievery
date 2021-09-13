package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1Controller {

    @FXML
    private Label cost;
    @FXML
    private TextField weightId;
    @FXML
    private TextField distanceId;
    @FXML
    private TextField voucherCodeId;
    @FXML
    private Button back1id;

    double amount;
    public Order order = new Order();


    public void submit(ActionEvent event) throws IOException{
        double weight = Double.parseDouble( weightId.getText());
        double distance = Double.parseDouble( distanceId.getText());
        String voucherCode = voucherCodeId.getText();
        if(ifInvalidOrder(weight, distance) == true){
            cost.setText("Invalid order");
            return;
        }

        order.setWeight(weight);
        order.setDistance(distance);
        order.setVoucherCode(voucherCode);
        double shippingCost;
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
        order.setShipmentId(order.getShipmentId()+1);
        order.setShippingCost(shippingCost);


        amount = shippingCost;

        cost.setText(String.valueOf(amount));


        Stage stage;
        Parent root;

        stage = (Stage) back1id.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        root = loader.load();

        Controller controller = loader.getController();
        System.out.println(controller.getListOfOrders());
        controller.addInListOfOrders(order);
        System.out.println(controller.getListOfOrders());



    }
    private boolean ifInvalidOrder(double weight, double distance){
        if(weight > 30.00 || weight < 1.0){
            return true;
        }
        if(distance < 5.0 || distance >3000.0){
            return true;
        }
        return false;
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


    public void back1(ActionEvent event) throws IOException {

        try{
            Stage stage;
            Parent root;

            stage = (Stage) back1id.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }



}
