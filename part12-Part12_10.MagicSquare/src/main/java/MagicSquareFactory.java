
public class MagicSquareFactory {


    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);
        
        // implement the creation of a magic square with the Siamese method algorithm here
             
        int count = 1;
        int row = 0;
        int column = square.getHeight() / 2;
        
        while (true){                      
            int valueAtLocation = square.readValue(column, row);
           
            if (count > size * size){
                break;
            }

            if (valueAtLocation == 0){                                    
                square.placeValue(column, row, count);
                count += 1;
            }
            
            if (row < 0 && column > square.getHeight() - 1){
                row += 2;
                column = square.getHeight() - 1;
                valueAtLocation = square.readValue(column,row);
                if (valueAtLocation == 0){
                    square.placeValue(column,row,count);
                    count += 1;
                } else if (valueAtLocation > 0){
                    row -= 1;
                    column += 1;
                }
                
            }
            
            if (valueAtLocation > 0){
                row += 2;
                column -= 1;
                valueAtLocation = square.readValue(column, row);
                if (valueAtLocation == 0){
                    square.placeValue(column,row,count);
                    count += 1;
                } else if (valueAtLocation > 0){
                    row -= 1;
                    column += 1;
                }
            }

            if (row < 0){
                row = square.getWidth() - 1;
                valueAtLocation = square.readValue(column,row);
                
                if (valueAtLocation == 0){
                    square.placeValue(column, row, count);
                    count += 1;
                }
            }

            if (column > square.getHeight() - 1){
                column = 0;
                valueAtLocation = square.readValue(column,row);
                if (valueAtLocation == 0){
                    square.placeValue(column, row, count);
                    count += 1;
                }
            }
            
            if (valueAtLocation > 0){
                row += 1;
                valueAtLocation = square.readValue(column,row);                
                if (valueAtLocation == 0){
                    square.placeValue(column,row,count);
                    count += 1;
                } 
                
            }
            
            row -= 1;
            column += 1;
            
        }


 
        return square;
    }

}

/*
public class MagicSquareFactory {

 

    public MagicSquare createMagicSquare(int size) {

 

        MagicSquare square = new MagicSquare(size);

 

        // implement the creation of a magic square with the Siamese method algorithm here

        int x = size / 2;

        int y = 0;

 

        int number = 1;

        int numbers = size * size;

 

        while (number <= numbers) {

            square.placeValue(x, y, number);

 

            // is the position to the top right free

            // get the position

            int candidateY = y - 1;

            int candidateX = x + 1;

 

            if (candidateY < 0) {

                candidateY += size;

            }

 

            if (candidateX >= size) {

                candidateX %= size;

            }

 

            // if the position is free, we'll place the number there

            if (square.readValue(candidateX, candidateY) == 0) {

                x = candidateX;

                y = candidateY;

            } else {

                // the position is not free, so we move "down"

                y++;

                if (y >= size) {

                    y = 0;

                }

            }

 

            number++;

 

        }

 

        return square;

    }

 

}
*/