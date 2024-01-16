package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MultipleViews extends Application{

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(MultipleViews.class);
    }
    
    @Override
    public void start(Stage window){
        BorderPane firstLayout = new BorderPane();
        VBox secondLayout = new VBox();
        GridPane thirdLayout = new GridPane();
        
        Scene first = new Scene(firstLayout);
        Scene second = new Scene(secondLayout);
        Scene third = new Scene(thirdLayout);
        
        
        Label firstViewText = new Label("First view!");
        Label secondViewText = new Label("Second view!");
        Label thirdViewText = new Label("Third view!");
        
        Button toSecondView = new Button("To the second view!");
        Button toThirdView = new Button ("To the third view!");
        Button toFirstView = new Button("To the first view!");
        
        firstLayout.setTop(firstViewText);
        firstLayout.setCenter(toSecondView);
        
        secondLayout.setSpacing(10);
        secondLayout.getChildren().addAll(toThirdView, secondViewText);
        
        thirdLayout.add(thirdViewText, 0, 0);
        thirdLayout.add(toFirstView, 1, 1);
        
        toSecondView.setOnAction((event) -> {
            window.setScene(second);
        });
        
        toThirdView.setOnAction((event) -> {
            window.setScene(third);
        });
        
        toFirstView.setOnAction((event) -> {
            window.setScene(first);
        });
        
        
        window.setScene(first);
        window.show();
        
        
    }

}

/*
package application;

 

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;

import javafx.scene.layout.VBox;

import javafx.stage.Stage;

 

public class MultipleViews extends Application {

 

    @Override

    public void start(Stage stage) throws Exception {

 

        Button firstButton = new Button("To the first view!");

        Button secondButton = new Button("To the second view!");

        Button thirdButton = new Button("To the third view!");

 

        BorderPane firstLayout = new BorderPane();

        firstLayout.setTop(new Label("First view!"));

        firstLayout.setCenter(secondButton);

 

        VBox secondLayout = new VBox();

        secondLayout.getChildren().addAll(thirdButton, new Label("Second view!"));

 

        GridPane thirdLayout = new GridPane();

        thirdLayout.add(new Label("Third view!"), 0, 0);

        thirdLayout.add(firstButton, 1, 1);

 

        Scene first = new Scene(firstLayout);

        Scene second = new Scene(secondLayout);

        Scene third = new Scene(thirdLayout);

 

        firstButton.setOnAction((event) -> {

            stage.setScene(first);

        });

 

        secondButton.setOnAction((event) -> {

            stage.setScene(second);

        });

 

        thirdButton.setOnAction((event) -> {

            stage.setScene(third);

        });

 

        stage.setScene(first);

        stage.show();

    }

 

    public static void main(String[] args) {

        launch(MultipleViews.class);

        System.out.println("Hello world!");

    }

 

}
*/