import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        
        int sum = 0;
        
        while (true){
            int input = Integer.valueOf(scanner.nextLine());
            if (input == 0){
                break;
            }
            
            if (input > 0){
                numbers.add(input);
            }
        }
        
        for (int i : numbers){
            sum += i;
        }
        
        if (numbers.isEmpty()){
            System.out.println("Cannot calculate the average");
        } else {
            System.out.println((1.0 * sum / numbers.size()));
        }
        
        
        
        

    }
    
    
}
