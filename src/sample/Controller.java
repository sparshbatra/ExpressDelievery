package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private ArrayList<Order> listOfOrders = new ArrayList<Order>();

    @FXML
    private Button btn1,btn2,btn3,btn4;


    public ArrayList<Order> getListOfOrders() {
        return listOfOrders;
    }

    public void setListOfOrders(ArrayList<Order> listOfOrders) {
        this.listOfOrders = listOfOrders;
    }

    public void addInListOfOrders(Order order){
        listOfOrders.add(order);
    }

    public void b1(ActionEvent event) throws IOException {

        try{
            Stage stage;
            Parent root;

            stage = (Stage) btn1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene1.fxml"));
            root = loader.load();


            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void b2(ActionEvent event) throws IOException{

        Stage stage;
        Parent root;

        stage = (Stage) btn2.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

//        HashMap<int,String> details = logic.getdetails();
//        input1, input2;
//        if(!details.containsKey(input1))
//            //error;
//            if(!(input2 == 'P' || input2 == 'D')){
//                //error;
//            }
//            else
//                logic.updateDetails(input1, input2);

    }
    public void b3(ActionEvent event)throws IOException{
        Stage stage;
        Parent root;

        stage = (Stage) btn3.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void b4(ActionEvent event)throws IOException{

        Platform.exit();

    }

}
