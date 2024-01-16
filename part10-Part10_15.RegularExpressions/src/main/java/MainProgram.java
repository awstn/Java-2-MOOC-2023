import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        Scanner scan = new Scanner(System.in);
        Checker check = new Checker();
        
        System.out.println("Enter a string: ");
        String input = scan.nextLine();
        
        if (check.isDayOfWeek(input) | check.allVowels(input) | check.timeOfDay(input) ){
            System.out.println("The form is correct.");
        } else {            
            System.out.println("The form is incorrect");
        }
        
        
    }
}
