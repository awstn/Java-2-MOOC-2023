
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here
        
        List<Integer> numbers = new ArrayList<>();
        while(true){
            String input = scanner.nextLine();
            if (input.equals("end")){
                break;
            }
            
            numbers.add(Integer.valueOf(input));
        }
        
        System.out.println(positive(numbers));
        

    }
    
    public static List<Integer> positive(List<Integer> numbers){
        
        List<Integer> values = numbers.stream()
                .filter(value -> value > 0)
                .map(value -> value)
                .collect(Collectors.toCollection(ArrayList::new));
        
        return values;
                
    }

}


/*
import java.util.List;

import java.util.Scanner;

import java.util.stream.Collectors;

 

public class PositiveNumbers {

 

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // test your method here

 

    }

 

    public static List<Integer> positive(List<Integer> numbers) {

        return numbers.stream().filter(number -> number > 0).collect(Collectors.toList());

    }

}
*/