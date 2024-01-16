import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> registry;
    
    public VehicleRegistry(){
        this.registry = new HashMap();
    }
    
    public boolean add(LicensePlate licensePlate, String owner){
        if (!(this.registry.containsKey(licensePlate))){
            this.registry.put(licensePlate, owner);
            return true;
        }
        return false;
      
    }
    
    public String get(LicensePlate licensePlate){
        return this.registry.get(licensePlate);
    }
    
    public boolean remove(LicensePlate licensePlate){
        if (!(this.registry.containsKey(licensePlate))){
            return false;
        }
        this.registry.remove(licensePlate);
        return true;
    }
    
    public void printLicensePlates(){
        for (LicensePlate i : this.registry.keySet()){
            System.out.println(i);
        }
    }
    
    public void printOwners(){
        ArrayList owners = new ArrayList();
        
        for (LicensePlate i : this.registry.keySet()){
            String owner = this.registry.get(i);
            
            if (owners.contains(owner)){
                continue;
            }
            
            System.out.println(owner);
            owners.add(owner);
                
        }
                    
    }
    
}
