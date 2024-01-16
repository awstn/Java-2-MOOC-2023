
package FlightControl.domain;


public class Flight {
    private Airplane airplane;
    private Airport departureAirport;
    private Airport arrivalAirport;
    
    public Flight(Airplane airplane, Airport departureAirport, Airport arrivalAirport){
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }
    
    public Airplane getAirplane(){
        return this.airplane;
    }
    
    public Airport getDepartureAirport(){
        return this.departureAirport;
    }
    
    public Airport getArrivalAirport(){
        return this.arrivalAirport;
    }
    
    @Override
    public String toString(){
        return this.getAirplane() + " (" + this.getDepartureAirport() + "-" + this.getArrivalAirport() + ")";
    }
}
