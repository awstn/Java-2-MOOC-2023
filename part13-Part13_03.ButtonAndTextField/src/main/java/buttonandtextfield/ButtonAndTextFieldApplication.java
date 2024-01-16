package buttonandtextfield;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;


public class ButtonAndTextFieldApplication extends Application{


    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }
    
    @Override
    public void start(Stage window){
        Button button = new Button("Click me!");
        TextField text = new TextField();
        
        //text.setAlignment(Pos.CENTER);
        
        FlowPane components = new FlowPane();
        components.getChildren().add(button);
        components.getChildren().add(text);
        
        Scene view = new Scene(components);
        
        window.setScene(view);
        window.show();
        
        
    }

}
