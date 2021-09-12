package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.stage.WindowEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
        Group root = new Group();
//        Scene.scene = new Scene(root, Color.BLACK);

        stage.setTitle("Express Deleivery");

        Button b1 = new Button("1.\tAdd Shipping Order");
        Button b2 = new Button("2.\tUpdate Shipping Status");
        Button b3 = new Button("3.\tDisplay all Orders");
        Button b4 = new Button("4.\tExit the system");

        Logic logic = new Logic();

        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                input1,input2,input3;
                logic.getCost(input1, input2, input3);
            }
        };
        b1.setOnAction(event1);

        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {

                HashMap<int,String> details = logic.getdetails();
                input1, input2;
                if(!details.containsKey(input1))
                    //error;
                if(!(input2 == 'P' || input2 == 'D')){
                    //error;
                }
                else
                    logic.updateDetails(input1, input2);



            }
        };
        b2.setOnAction(event2);

        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {

            }
        };
        b3.setOnAction(event3);

        b4.setText("Quit");

        b4.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });

        // create a stack pane
        TilePane r = new TilePane();

        // add button
        r.getChildren().add(b1);
        r.getChildren().add(b2);
        r.getChildren().add(b3);
        r.getChildren().add(b4);

        // create a scene
        Scene sc = new Scene(r, 200, 200);
        stage.setScene(sc);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
