
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        List<Integer> inputs = new ArrayList<>();
        System.out.println("Input numbers, type \"end\" to stop.");
        
        while(true){
            String input = scanner.nextLine();
            if (input.equals("end")){
                break;
            }
            
            inputs.add(Integer.valueOf(input));
        }
       
        double averagePositive = inputs.stream()
                .mapToInt(i -> i)
                .filter(i -> i > 0)
                .average()
                .getAsDouble();
        
        double averageNegative = inputs.stream()
                .mapToInt(i -> i)
                .filter(i -> i < 0)
                .average()
                .getAsDouble();
        
        System.out.println("print the average of the negative numbers or the positive numbers? (n/p)");
        String choice = scanner.nextLine();
        
        
        if (choice.equals("n")){
            System.out.println("Average of the positive numbers: " + averageNegative);
        }
        
        if (choice.equals("p")){
            System.out.println("Average of the positive numbers: " + averagePositive);
            
        }
        

    }
}

/*
import java.util.ArrayList;

import java.util.Scanner;

 

public class AverageOfSelectedNumbers {

 

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // toteuta ohjelmasi tänne

 

        System.out.println("Input numbers, type \"end\" to stop.");

        ArrayList<Integer> input = new ArrayList<>();

 

        while (true) {

            String read = scanner.nextLine();

 

            if (read.equals("end")) {

                break;

            }

 

            input.add(Integer.valueOf(read));

        }

 

        System.out.println("");

 

        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");

        String choise = scanner.nextLine();

        if (choise.equals("n")) {

            System.out.println("Average of the negative numbers: " + input.stream().filter(l -> l < 0).mapToInt(i -> i).average().getAsDouble());

        } else {

            System.out.println("Average of the positive numbers: " + input.stream().filter(l -> l > 0).mapToInt(i -> i).average().getAsDouble());

        }

 

    }

}

 


*/