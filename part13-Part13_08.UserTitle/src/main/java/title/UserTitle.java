package title;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.stage.Stage;
import java.util.Scanner;


public class UserTitle extends Application{

    @Override
    public void start(Stage window){       
        Parameters param = getParameters();        
        String getTitle = param.getNamed().get("title");
        
        window.setTitle(getTitle);
        window.show();
        
    }
    /*
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle(getParameters().getNamed().get("title"));
        stage.show();

    }
    */

}
