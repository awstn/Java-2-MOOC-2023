package smiley;

import java.awt.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SmileyApplication extends Application{


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(SmileyApplication.class);
    }
    
    @Override
    public void start(Stage window){
        BorderPane paintingLayout  = new BorderPane();
     
        Canvas paintCanvas = new Canvas(640,480);
        GraphicsContext painter = paintCanvas.getGraphicsContext2D();
        
        paintingLayout.setCenter(paintCanvas);
        
        //set eyes
        painter.fillRect(150, 75, 80, 80);
        painter.fillRect(400, 75, 80, 80);
        
        painter.fillRect(80, 300, 80, 80);
        
        int x = 160;
        for (int i = 0; i < 4; i++){
            painter.fillRect(x, 380, 80, 80);
            x+= 80;
        }
        
        painter.fillRect(480,300,80,80);
        

        Scene view = new Scene(paintingLayout);
        
        window.setScene(view);
        window.show();
        
        
    }

}

/*
    @Override

    public void start(Stage stage) throws Exception {

        Canvas drawingCanvas = new Canvas(400, 400);

        GraphicsContext drawer = drawingCanvas.getGraphicsContext2D();

 

        drawer.setFill(Color.WHITE);

        drawer.clearRect(0, 0, 640, 480);

 

        drawer.setFill(Color.BLACK);

        drawer.fillRect(100, 50, 50, 50);

        drawer.fillRect(250, 50, 50, 50);

 

        drawer.fillRect(100, 250, 200, 50);

        drawer.fillRect(50, 200, 50, 50);

        drawer.fillRect(300, 200, 50, 50);

 

        BorderPane layout = new BorderPane();

        layout.setCenter(drawingCanvas);

        Scene view = new Scene(layout);

 

        stage.setScene(view);

        stage.show();

    }
*/