import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> storageUnit;
    
    public StorageFacility(){
        this.storageUnit = new HashMap<>();
    }
    
    public void add(String unit, String item){
        this.storageUnit.putIfAbsent(unit, new ArrayList<>());
        
        ArrayList<String> items = this.storageUnit.get(unit);
        items.add(item);
        
        /// this.storageUnit.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String storageUnit){
        return this.storageUnit.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    public void remove(String storageUnit, String item){
        ArrayList<String> items = this.storageUnit.get(storageUnit);
        items.remove(item);
        
        if (items.size() == 0){
            this.storageUnit.remove(storageUnit);
        }
    }
    
    public ArrayList<String> storageUnits(){
        ArrayList<String> unitNames = new ArrayList<>();
        for (String name : this.storageUnit.keySet()){
            unitNames.add(name);
        }
        
        return unitNames;
    }
    
}

/*
import java.util.ArrayList;

import java.util.HashMap;

 

public class StorageFacility {

 

    private HashMap<String, ArrayList<String>> unitsAndContents;

 

    public StorageFacility() {

        this.unitsAndContents = new HashMap();

    }

 

    public void add(String unit, String item) {

        this.unitsAndContents.putIfAbsent(unit, new ArrayList<>());

        this.unitsAndContents.get(unit).add(item);

    }

 

    public ArrayList<String> contents(String storageUnit) {

        return this.unitsAndContents.getOrDefault(storageUnit, new ArrayList<>());

    }

 

    public void remove(String storageUnit, String item) {

        if (!this.unitsAndContents.containsKey(storageUnit)) {

            return;

        }

 

        this.unitsAndContents.get(storageUnit).remove(item);

 

        if (this.unitsAndContents.get(storageUnit).isEmpty()) {

            this.unitsAndContents.remove(storageUnit);

        }

    }

 

    public ArrayList<String> storageUnits() {

        ArrayList<String> units = new ArrayList<>();

        for (String unit : this.unitsAndContents.keySet()) {

            units.add(unit);

        }

 

        return units;

    }

}
*/