package textstatistics;

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


public class TextStatisticsApplication extends Application{


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(TextStatisticsApplication.class);
    }
    
    public void start(Stage window){
        BorderPane layout = new BorderPane();
        
        HBox statsText = new HBox();
        statsText.getChildren().add(new Label("Letters: 0"));
        statsText.getChildren().add(new Label("Words: 0"));
        statsText.getChildren().add(new Label("The longest word is:"));
        statsText.setSpacing(10);
     
        layout.setCenter(new TextArea());
        layout.setBottom(statsText);
        
        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
        
        
        
        
    }

}
