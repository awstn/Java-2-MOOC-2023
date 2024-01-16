
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class InputView {
    
    private Dictionary dictionary;
    
    public InputView(Dictionary dictionary){
        this.dictionary = dictionary;
    }
    
    public Parent getView(){
        GridPane layout = new GridPane(); //set layout
           
        Label wordInstruction = new Label("Word"); //set objects in layout
        TextField wordField = new TextField();
        Label translationInstruction = new Label("Translation");
        TextField translationField = new TextField();
        Button addWordPair = new Button("Add the word pair");

        layout.setAlignment(Pos.CENTER); //set styling of the objects
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10,10,10,10));
                
        layout.add(wordInstruction,0,0); //place the objects
        layout.add(wordField,0,1);
        layout.add(translationInstruction,0,2);
        layout.add(translationField,0,3);
        layout.add(addWordPair,0,4);
       
        addWordPair.setOnMouseClicked((event) -> {
            String word = wordField.getText();
            String translation = translationField.getText();
            
            this.dictionary.add(word, translation);
            
            wordField.clear();
            translationField.clear();
        });
        
        return layout;
        
        
    }
}


