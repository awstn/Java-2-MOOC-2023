package title;

import java.util.Scanner;
import javafx.application.Application;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the title?");
        String title = scanner.nextLine();
        
        Application.launch(UserTitle.class, "--title=" + title);

    }
    /*
    System.out.println("Hello world!");

    Scanner reader = new Scanner(System.in);
    System.out.println("What title would you like?");
    String title = reader.nextLine();

    Application.launch(UserTitle.class, "--title=" + title);
 
    */

}
