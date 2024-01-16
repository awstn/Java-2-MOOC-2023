package textstatistics;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(TextStatisticsApplication.class);
    }
    
    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        TextArea textArea = new TextArea();
        
        HBox statsText = new HBox();
      
        Label letterCount = new Label("Letters: 0" );
        Label wordCount = new Label("Words: 0");
        Label longestWord = new Label("The longest word is:");
           
        
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1,s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            
            letterCount.setText("Letters: " + characters);
            wordCount.setText("Words: " + words);
            longestWord.setText("The longest word is: " + longest);
 
        
        });
        
        /*
        textArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> change, 
                    String oldValue, String newValue){
                
                int characters = newValue.length();
                String[] parts = newValue.split(" ");
                int words = parts.length;
                String longest = Arrays.stream(parts)
                        .sorted((s1,s2) -> s2.length() - s1.length())
                        .findFirst()
                        .get();

                letterCount.setText("Letters: " + characters);
                wordCount.setText("Words: " + words);
                longestWord.setText("The longest word is: " + longest);
                
            }
            
        });
        */

        statsText.getChildren().add(letterCount);
        statsText.getChildren().add(wordCount);
        statsText.getChildren().add(longestWord);
        statsText.setSpacing(10);
        
        
        layout.setCenter(textArea);
        layout.setBottom(statsText);
        
        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
      
        
    }
    
    

}
