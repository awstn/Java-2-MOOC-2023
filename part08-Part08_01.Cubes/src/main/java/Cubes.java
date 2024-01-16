
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true){
            String input = scanner.nextLine();
            if (input.equals("end")){
                break;
            }
            int numInput = Integer.valueOf(input);
            int cube = numInput * numInput * numInput;
            System.out.println(cube);
        }

    }
}
