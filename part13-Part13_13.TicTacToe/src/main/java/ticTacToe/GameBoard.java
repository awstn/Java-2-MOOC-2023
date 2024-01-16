/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 *
 * @author austin
 */
public class GameBoard {
    
    private String player = "X";
    
    public GameBoard(){
        
    }
    
    public Parent getview(){
        BorderPane layout = new BorderPane();
        GridPane gameBoard = new GridPane();
        Label whoseTurn = new Label("Turn: " + this.player);
        Label theEnd = new Label("The end!");
        
        for (int x = 0; x < 3; x ++){
            final int x_ = x;
            for (int y = 0; y < 3; y++){
                final int y_ = y;                
                Button xy = new Button(" ");             
                xy.setFont(Font.font("Monospaced", 40));
  
                gameBoard.add(xy, y, x);
                  
                xy.setOnMouseClicked((event) -> {
                    if (xy.getText().equals(" ")){
                        xy.setText(this.player);
                        
                        if (this.player.equals("X")){
                        this.player = "O";

                        } else {
                            this.player = "X";
                        }
                    }
              
                    whoseTurn.setText("Turn: " + this.player);   
                });                                
            }
        }                            
                          
        gameBoard.setAlignment(Pos.BASELINE_CENTER);
        gameBoard.setVgap(10);
        gameBoard.setHgap(10);
        gameBoard.setPadding(new Insets(10, 10, 10, 10));
                      
        
        whoseTurn.setFont(Font.font("Monospace", 40));
        layout.setTop(whoseTurn);
        layout.setCenter(gameBoard);
        
        
        
        
        return layout;
    }
    
}
