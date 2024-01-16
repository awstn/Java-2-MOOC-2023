package notifier;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class NotifierApplication  extends Application{


    public static void main(String[] args) {
        launch(NotifierApplication.class);
        System.out.println("Hello world!");
    }
        
    @Override
    public void start(Stage window) {
        TextField topText = new TextField();
        Label notifier = new Label();
        Button updateButton = new Button("Update");
        
        
        topText.textProperty().addListener((change, oldValue, newValue) -> {
            System.out.println(oldValue + " -> " + newValue);
            notifier.setText(newValue);
        });
        /*
        updateButton.setOnAction((event) -> { //written as a lambda expression
            notifier.setText(topText.getText());
        });
        
        /*
        
        updateButton.setOnAction(new EventHandler<ActionEvent>() { // traditional way 
            @Override
            public void handle(ActionEvent event){
                notifier.setText(topText.getText());
            }
        });
        
        */ 
        
        VBox componentGroup = new VBox();
        componentGroup.setSpacing(20);
        componentGroup.getChildren().addAll(topText, updateButton, notifier);

        Scene scene = new Scene(componentGroup);

        window.setScene(scene); 
        window.show();
    }

}
