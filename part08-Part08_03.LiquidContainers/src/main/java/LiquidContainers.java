
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int first = 0;
        int second = 0;


        while (true) {
            
            System.out.println("first: " + first + "/100");
            System.out.println("second: " + second + "/100");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] parts = input.split(" ");           
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            
            if (command.equals("add")){
                System.out.println("");
                if (first + amount > 100){
                    first = 100;
                    continue;
                }
                
                if (amount < 0){
                    continue;
                }
                
                first += amount;
            }
            
            if (command.equals("move")) {
                System.out.println("");
                if (amount < 0 || first == 0) {
                    continue;
                }
                
                if (amount > first) {
                    amount = first;
                }
                
                second += amount;
                first -= amount;
                
                if (second > 100) {
                    second = 100;
                }
                
                if (first < 0){
                    first = 0;
                }
                
            }
            
            if (command.equals("remove")) {
                System.out.println("");
                if (amount < 0 || second == 0){
                    continue;
                }
                
                if (amount > second) {
                    amount = second;
                }
                
                second -= amount;
                
                if (second < 0){
                    second = 0;
                }
            }
            
            
            
            

        }
    }

}

/*
import java.util.Scanner;

 

public class LiquidContainers {

 

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

 

        int first = 0;

        int second = 0;

 

        while (true) {

            System.out.println("First: " + first + "/100");

            System.out.println("Second: " + second + "/100");

            System.out.print("> ");

 

            String input = scan.nextLine();

            if (input.equals("quit")) {

                break;

            }

 

            String[] partsOfInput = input.split(" ");

            input = partsOfInput[0];

            int amount = Integer.valueOf(partsOfInput[1]);

 

            if (input.equals("add") && amount > 0) {

                first = first + amount;

                if (first > 100) {

                    first = 100;

                }

            }

 

            if (input.equals("move") && amount > 0) {

                if (amount > first) {

                    amount = first;

                }

 

                first = first - amount;

                second = second + amount;

 

                if (second > 100) {

                    second = 100;

                }

            }

 

            if (input.equals("remove") && amount > 0) {

                second = second - amount;

                if (second < 0) {

                    second = 0;

                }

            }

 

            System.out.println("");

        }

    }

 

}
*/