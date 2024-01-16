
package application;
import static java.lang.Math.abs;
import java.util.Random;

public class TemperatureSensor implements Sensor{
    private boolean powerOn;
    private int temp;
    
    public TemperatureSensor(){       
        this.powerOn = false;
      
    }
    
    public boolean isOn(){
        return this.powerOn;
    }
    
    public void setOn(){
        this.powerOn = true;
    }
    
    public void setOff(){
        this.powerOn = false;
    }
    
    public int getTemp(){
        return this.temp;
    }
    
    public int read(){
        this.powerOn = true;
        
        if (this.powerOn == false){
            throw new IllegalStateException();
        }
              
        while(true){
            int tempValue = new Random().nextInt(61) - new Random().nextInt(61);
            if (tempValue < -30 || tempValue > 30){
                continue;
            }
            this.temp = tempValue;
            break;

        }    
        
        return this.temp;
        
        /*
            public int read() {

        if (!isOn()) {

            throw new IllegalStateException();

        }

 

        Random rnd = new Random();

        return rnd.nextInt(61) - 30;

    }

}
        */

        
        
    }
}
