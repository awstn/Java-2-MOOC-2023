
package application;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;



public class AverageSensor implements Sensor{
    private List<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor(){
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    
    public boolean isOn(){
        for (Sensor sensor : this.sensors){
            if (sensor.isOn() == false){
                return false;
            }
        }
        return true;
    }
    
    public void setOn(){
        this.sensors.forEach(sensor -> sensor.setOn());
              
    }
    
    public void setOff(){
        this.sensors.forEach(sensor -> sensor.setOff());
        
    }
    
    public int read(){
        if (this.isOn() == false || this.sensors.isEmpty()){
            throw new IllegalStateException();
        }
        
        int sum = 0;
        for (Sensor sensor : this.sensors){
            int temp = sensor.read();
            sum += temp;
        }
        
        int average = sum / this.sensors.size();
        this.readings.add(average);
        return average;
        
        /*

        if (!isOn()) {

            throw new IllegalStateException();

        }

 

        int sum = 0;

        for (Sensor sensori : sensors) {

            sum += sensori.read();

        }

        int reading = sum / sensors.size();

 

        readings.add(reading);

 

        return reading;

    }
        */
        
    }
    
    public void addSensor(Sensor toAdd){
        this.sensors.add(toAdd);
        
    }
    
    public List<Integer> readings(){
        return this.readings;
    }
    

}
