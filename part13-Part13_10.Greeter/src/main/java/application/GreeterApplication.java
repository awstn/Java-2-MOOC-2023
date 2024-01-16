package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application{


    public static void main(String[] args) {
        System.out.println("Hellow world! :3");
        launch(GreeterApplication.class);
    }
    
    @Override
    public void start(Stage window){
        GridPane inputLayout = new GridPane();
        
        Label inputInstructions = new Label("Enter your name and start.");
        TextField userInput = new TextField();
        Button start = new Button("Start");
        
        inputLayout.add(inputInstructions, 0, 0);
        inputLayout.add(userInput, 0, 1);
        inputLayout.add(start, 0 , 2);
        
        inputLayout.setPrefSize(300,180);
        inputLayout.setAlignment(Pos.CENTER);
        inputLayout.setVgap(10);
        inputLayout.setHgap(10);
        inputLayout.setPadding(new Insets(20,20,20,20));
        
        GridPane welcomeLayout = new GridPane();
        Label welcomeText = new Label();
        welcomeLayout.setPrefSize(300,180);
        welcomeLayout.add(welcomeText, 0, 0);
        welcomeLayout.setAlignment(Pos.CENTER);
        
        Scene welcomeView = new Scene(welcomeLayout);
        
        start.setOnAction((event) -> {
            welcomeText.setText("Welcome " + userInput.getText() +"!");
            window.setScene(welcomeView);
        });
        
        
        
        
        
        Scene userView = new Scene(inputLayout);
        window.setScene(userView);
        window.show();
        
        
        
        
        
    }
    
    
    
    
    
}


/*
    @Override

    public void start(Stage stage) throws Exception {

 

        Label instructionText = new Label("Enter your name and start.");

        TextField nameField = new TextField();

        Button startButton = new Button("Start");

 

        GridPane layout = new GridPane();

        layout.setPrefSize(300, 180);

        layout.setAlignment(Pos.CENTER);

 

        layout.add(instructionText, 0, 0);

        layout.add(nameField, 0, 1);

        layout.add(startButton, 0, 2);

 

        layout.setVgap(10);

        layout.setHgap(10);

        layout.setPadding(new Insets(20, 20, 20, 20));

        Scene passwordView = new Scene(layout);

 

        // Beginning screen

        Label greetingText = new Label("");

 

        StackPane greetingLayout = new StackPane();

        greetingLayout.setPrefSize(300, 180);

        greetingLayout.getChildren().add(greetingText);

        greetingLayout.setAlignment(Pos.CENTER);

 

        Scene greetingVIew = new Scene(greetingLayout);

 

        startButton.setOnAction((event) -> {

            greetingText.setText("Welcome " + nameField.getText() + "!");

            stage.setScene(greetingVIew);

        });

 

        stage.setScene(passwordView);

        stage.show();

    }
*/