package FlightControl;
import java.util.Scanner;
import FlightControl.logic.FlightControl;
import FlightControl.ui.UserInterface;

public class Main {

    public static void main(String[] args) {
        // Write the main program here. It is useful to create some classes of your own.
        Scanner scanner = new Scanner(System.in);
        FlightControl database = new FlightControl();
        UserInterface ui = new UserInterface(database, scanner);
        
        
        ui.start();
    }
}
