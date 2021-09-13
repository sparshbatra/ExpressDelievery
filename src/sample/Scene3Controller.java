package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene3Controller {
    @FXML
    private Button back3id;

    private TableView<Order> table = new TableView<Order>();
//    private final ObservableList<Order> data =
    //FXCollections.observableArrayList(listOfOrders);
    //dummy value
    private final ObservableList<Order> data =
            FXCollections.observableArrayList(
                    new Order(1111, 10, 20, 34.53, 30.23,"1111" ),
                    new Order(1111, 10, 20, 34.53, 30.23,"1111" )
                    );


    public void initalize(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");


        final Label label = new Label("Address Book");


        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("Shipment ID");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Order, String>("ShipmentID"));

        TableColumn lastNameCol = new TableColumn("Weight");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Order, String>("Weight"));

        TableColumn emailCol = new TableColumn("Distance to destination");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Order, String>("distance"));

        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

    }
    public void back3(ActionEvent event) throws IOException {

        try{
            Stage stage;
            Parent root;

            stage = (Stage) back3id.getScene().getWindow();
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
