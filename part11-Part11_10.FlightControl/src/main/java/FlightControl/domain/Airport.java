
package FlightControl.domain;

public class Airport {
    private String id;
    
    public Airport(String id){
        this.id = id;
    }
    

    @Override
    public String toString(){
        return this.id;
    }
    
    
}
