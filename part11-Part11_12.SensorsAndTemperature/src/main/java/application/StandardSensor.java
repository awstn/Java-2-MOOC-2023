
package application;


public class StandardSensor implements Sensor{
    private int temperature;
    //private boolean powerOn;
    
    public StandardSensor(int temperature){
        this.temperature = temperature;
        //this.powerOn = true;
    }
    
    public boolean isOn(){
        return true;
    }
    
    public void setOn(){
        //this.powerOn = true;
    }
    
    public void setOff(){
        //this.powerOn = false;
    }
    
    public int read(){
        if (isOn() == false){
            throw new IllegalStateException();
        }
        
        return this.temperature;
    }
}
