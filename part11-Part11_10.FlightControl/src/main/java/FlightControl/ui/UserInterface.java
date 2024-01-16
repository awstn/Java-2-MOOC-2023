
package FlightControl.ui;
import FlightControl.logic.FlightControl;
import FlightControl.domain.Airplane;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private FlightControl flightControl;
    
    public UserInterface(FlightControl flightControl, Scanner scanner){
        this.flightControl = flightControl;
        this.scanner = scanner;
    }

    
    public void assetControlCommands(){
        System.out.println("[1] Add an airplane");
        System.out.println("[2] Add a flight");       
        System.out.println("[x] Exit Airport Asset Control");   
        System.out.println(">");
     
    }
    
    public void flightControlCommands(){
        System.out.println("[1] Print airplanes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print airplane details");
        System.out.println("[x] Quit");
        System.out.println(">");
 
    }
    
    public void start(){
        System.out.println("Airport Asset Control");
        assetControl();
        System.out.println("Flight Control");
        flightControl();
        
    }
    
    public void assetControl(){
        while (true){
            assetControlCommands();
            String input = this.scanner.nextLine().toLowerCase();
            
            if (input.equals("x")){
                break;
            }
            
            //int action = Integer.parseInt(input);
            
            if (input.equals("1")){
                addAirplane();
            }
            
            if (input.equals("2")){
                addFlight();
            }
            
            else {
                continue;
            }
        }
    }
    
    public void flightControl(){
        while (true){
            flightControlCommands();
            String input = this.scanner.nextLine().toLowerCase();
            
            if (input.equals("x")){
                break;
            }
            
            //int action = Integer.parseInt(input);
            
            if (input.equals("1")){
                this.flightControl.printAirplanes();
            }
            
            if (input.equals("2")){
                this.flightControl.printFlights();
            }
            
            if (input.equals("3")){
                System.out.println("Give the airplane id:");
                String search = this.scanner.nextLine();
                System.out.println(this.flightControl.getAirplane(search));
            }
            
            else {
                continue;
            }
        }
    }
    
    public void addAirplane(){
        System.out.println("Give the airplane id:");
        String airplaneID = this.scanner.nextLine();
        System.out.println("Give the airplane capacity:");
        int airplaneCapacity = Integer.valueOf(this.scanner.nextLine());
        
        this.flightControl.addAirplane(airplaneID, airplaneCapacity);
    }
    
    public void addFlight(){
        Airplane airplane = findAirplane();
        
        System.out.println("Give the departure airport id: ");
        String departure = this.scanner.nextLine();
        System.out.println("Give the target airport id: ");
        String arrival = this.scanner.nextLine();       
        
        this.flightControl.addFlight(airplane, departure, arrival);
             
    }
    
    private Airplane findAirplane(){
        Airplane airplane = null;
        
        while (airplane == null){
            System.out.println("Give the airplane id:");
            String id = this.scanner.nextLine();
            airplane = this.flightControl.getAirplane(id);
                        
            if (this.flightControl.getAirplane(id) == null){
                System.out.println(id + " could not be found.");
            }
        }
    
        return airplane;
     
    }
    

}

/*
Choose an action:
[1] Print airplanes
[2] Print flights
[3] Print airplane details
[x] Quit
> 1
G-OWAC (101 capacity)
HA-LOL (42 capacity)
Choose an action:
[1] Print airplanes
[2] Print flights
[3] Print airplane details
[x] Quit
> 2
HA-LOL (42 capacity) (HEL-BAL)
HA-LOL (42 capacity) (BAL-HEL)
G-OWAC (101 capacity) (JFK-BAL)

Choose an action:
[1] Print airplanes
[2] Print flights
[3] Print airplane details
[x] Quit
> 3
Give the airplane id: G-OWAC
G-OWAC (101 capacity)

*/
