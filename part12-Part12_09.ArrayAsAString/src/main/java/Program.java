
import java.util.ArrayList;


public class Program {

    public static void main(String[] args) {
        // Test your method here\
        int rows = 2;
        int columns = 2;
        int[][] matrix = new int[rows][columns];
        matrix[0][1] = 5;
        matrix[1][0] = 3;
        matrix[1][1] = 7;
        System.out.println(arrayAsString(matrix));
        
        
        int[][] matrix2 = {
            {3, 2, 7},
            {2, 4, 1},
            {3, 2, 1}
        };

        System.out.println(arrayAsString(matrix2));
        //System.out.println(sumsOfRows(matrix));
        System.out.println(sumsOfDiagonals(matrix));
        System.out.println(sumsOfDiagonals(matrix2));
    }
    
    public static String arrayAsString(int[][] array){
        StringBuilder matrix = new StringBuilder();
        
        for (int row = 0; row < array.length; row++){           
            for (int column = 0; column < array[row].length; column++){
                matrix.append(array[row][column]) ;
            }
            matrix.append("\n");
        }
        
        return matrix.toString();
    }
    
    public static ArrayList<Integer> sumsOfRows(int[][]square) {
    ArrayList<Integer> sumList = new ArrayList<>();

    int sum = 0;
    for (int row = 0; row < square.length; row++){
        for (int column = 0; column < square[row].length; column++){
            sum += square[column][row];
        }
        sumList.add(sum);
        sum = 0;
    }


    return sumList;
    }
    
    public static ArrayList<Integer> sumsOfColumns(int[][] square) {
        ArrayList<Integer> sumList = new ArrayList<>();
        
        int sum = 0;
        for (int row = 0; row < square.length; row++){            
            for (int column = 0; column < square[row].length; column++){
                sum += square[column][row];
            }
        }
        
        
        return sumList;
    }
    
    public static ArrayList<Integer> sumsOfDiagonals(int[][] square) {
    ArrayList<Integer> sumList = new ArrayList<>();

    int sumLeftDiagonal = 0;
    int sumRightDiagonal = 0;
    int countRight = 0;
    for (int row = 0; row < square.length; row++){
        for (int column = 0; column < square[row].length; column++){
            if (row == column){
                sumLeftDiagonal += square[row][column]; 
            }
            
            if (row + column == square.length - 1){
                countRight += 1;
                System.out.println(square[row][column]);
                sumRightDiagonal += square[row][column];
            }
        }
    }
    sumList.add(sumLeftDiagonal);
    sumList.add(sumRightDiagonal);

    return sumList;
    
    }
}
