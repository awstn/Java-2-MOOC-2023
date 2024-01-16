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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class JokeApplication extends Application{

    
    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(JokeApplication.class);
    }
    
    @Override
    public void start(Stage window){
        
        //1. Create Joke Layout
        BorderPane layout = new BorderPane();
        
        //1.1 Create menu for joke layout
        HBox menu = new HBox();
        menu.setPadding(new Insets(20,20,20,20));
        menu.setSpacing(10);
        menu.setAlignment(Pos.CENTER);
        
        //1.2 Create buttons for joke layout
        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");
        
        //1.3 Add buttons to menu
        menu.getChildren().addAll(jokeButton, answerButton, explanationButton);
        
        layout.setPrefSize(300,180);  
        layout.setTop(menu);
        
        
        //2 Add subviews and add them to the menu buttons
        //2.1 create subview layout
        StackPane jokeLayout = createView("What do you call a bear with no teeth?");
        StackPane answerLayout = createView("A gummy bear.");
        StackPane explanationLayout = createView("Because without teeth you only have gums!");
        
        
        //2.2 Setup subviews to each button
        jokeButton.setOnAction((event) -> {
            layout.setCenter(jokeLayout);
        });
        
        answerButton.setOnAction((event) -> {
            layout.setCenter(answerLayout);
        });
        
        explanationButton.setOnAction((event) -> {
            layout.setCenter(explanationLayout);
        });
        
        //2.3 Set initial view
        layout.setCenter(jokeLayout);
        
        //3. Create main scene with layout
        Scene scene = new Scene(layout);
        
        
        //4. Show the main scene
        window.setScene(scene);
        window.show();
        
        
    }
    
    private StackPane createView(String text){
        
        StackPane layout = new StackPane();
        layout.setPrefSize(300,180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);
        
        return layout;
    }
}

/*
    @Override

    public void start(Stage stage) throws Exception {

 

        BorderPane layout = new BorderPane();
        HBox menu = new HBox();
        menu.setPadding(new Insets(10, 10, 10, 10));
        menu.setSpacing(10);

        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        menu.getChildren().addAll(jokeButton, answerButton, explanationButton);

        layout.setTop(menu); 

        // 2. Create the layouts to match the buttons

        StackPane joke = createView("What do you call a bear with no teeth?");
        StackPane answer = createView("A gummy bear.");
        StackPane explanation = createView("...");

        layout.setCenter(joke);

        jokeButton.setOnAction((event) -> layout.setCenter(joke));
        answerButton.setOnAction((event) -> layout.setCenter(answer));
        explanationButton.setOnAction((event) -> layout.setCenter(explanation));
        Scene nakyma = new Scene(layout);

        stage.setScene(nakyma);
        stage.show();
    }

    private StackPane createView(String text) {

        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);
        return layout;

    }
*/