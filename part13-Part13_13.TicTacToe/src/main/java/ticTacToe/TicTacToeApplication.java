package ticTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class TicTacToeApplication extends Application{

    private String player = "X";
    private String[][] board;
    
    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    
    @Override
    public void start(Stage window) {
        this.board = new String[3][3];
        BorderPane layout = new BorderPane();
        GridPane gameBoard = new GridPane();
        Label whoseTurn = new Label("Turn: " + this.player);
        
        
        
        for (int row = 0; row < 3; row ++){
            final int row_ = row;
            for (int column = 0; column < 3; column++){
                
                final int column_ = column;                
                Button rowColumn = new Button(" ");             
                rowColumn.setFont(Font.font("Monospaced", 40));
  
                gameBoard.add(rowColumn, column, row);
                  
                rowColumn.setOnMouseClicked((event) -> {
                    if (rowColumn.getText().equals(" ")){
                        rowColumn.setText(this.player);                        
                        if (this.player.equals(" ")){
                            this.player = " ";
                        }     
                        
                        if (this.player.equals("X")){
                            this.player = "O";
                        } else {
                            this.player = "X";   
                        };
                    
                    whoseTurn.setText("Turn: " + this.player);   
                    this.board[row_][column_] = rowColumn.getText();
                    System.out.println(Arrays.deepToString(this.board));
                    
                    }
                    if (checkVertical(column_)){
                        whoseTurn.setText("The end!");
                        this.player = " ";
                    } 
                    
                    if (checkDiagonal()){
                        whoseTurn.setText("The end!");
                        this.player = " ";
                    }
                    
                    if (checkHorizontal(row_)){
                        whoseTurn.setText("The end!");
                        this.player = " ";
                    }
                    
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
        
        
        
        Scene view = new Scene(layout, 300 , 350);
        window.setScene(view);
        window.show();

    }
    
    public boolean checkHorizontal(int currentRow){
        
        if (this.board[currentRow][0] == null || this.board[currentRow][1] == null || this.board[currentRow][2] == null){
            return false;
        }
        return (this.board[currentRow][0].equals(this.board[currentRow][1]) && this.board[currentRow][1].equals(this.board[currentRow][2]));
        
    }
    
    public boolean checkVertical(int currentColumn){        

        if (this.board[0][currentColumn] == null || this.board[1][currentColumn] == null || this.board[2][currentColumn] == null){
            return false;
        }
        return (this.board[0][currentColumn].equals(this.board[1][currentColumn]) && this.board[1][currentColumn].equals(this.board[2][currentColumn]));
        
    }
    
    public boolean checkDiagonal(){   

        if (this.board[0][0] == null || this.board[1][1] == null || this.board[2][1] == null || this.board[1][2] == null || this.board[0][2] == null){
            return false;
        }
        return ((this.board[0][0].equals(this.board[1][1]) && this.board[0][0].equals(this.board[2][2]))
                || (this.board[0][2].equals(this.board[1][1]) && this.board[0][2].equals(this.board[2][0])));
        
    }
    
    
      

}
