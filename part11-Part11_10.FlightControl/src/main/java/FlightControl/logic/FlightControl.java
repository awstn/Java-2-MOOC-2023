
package FlightControl.logic;

import FlightControl.domain.Airport;
import FlightControl.domain.Flight;
import FlightControl.domain.Airplane;
import java.util.HashMap;
import java.util.Map;

public class FlightControl {
    
    private Map<String,Airplane> airplanes;
    private Map<String, Flight> flights;
    private Map<String, Airport> airports;
    
    
    public FlightControl(){
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
        this.airports = new HashMap<>();
    }
    
    public void addAirplane(String id, int capacity){
        this.airplanes.put(id, new Airplane(id,capacity));
    }
    
    public void addFlight(Airplane airplane, String departure, String arrival ){
        this.airports.putIfAbsent(departure, new Airport(departure));
        this.airports.putIfAbsent(arrival, new Airport(arrival));
        
        Flight flight = new Flight(airplane, this.airports.get(departure), this.airports.get(arrival));
        this.flights.put(flight.toString(), flight);
    }
    
    public Airplane getAirplane(String id){
        return this.airplanes.get(id);
    }
    
    public void printAirplanes(){
        for (Airplane airplane : this.airplanes.values()){
            System.out.println(airplane);
        }
    }
    
    public void printFlights(){
        for (Flight flight : this.flights.values()){
            System.out.println(flight);
        }
    }
    
    
    
}
