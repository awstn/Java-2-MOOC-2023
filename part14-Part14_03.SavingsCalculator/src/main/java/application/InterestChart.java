
package application;

import java.util.Map;
import javafx.scene.chart.XYChart;


public class InterestChart {
    
    public XYChart.Series interestChart;
    
    public InterestChart(){
        this.interestChart = new XYChart.Series<>();
        this.interestChart.setName("Savings with Interest");
    }
    
    public XYChart.Series getData(){
        return this.interestChart;
    }
    
    public void calculateInterest(double monthlyAmount, double interest){
        double val = 0.0;
        
        for (int i = 0; i <= 30; i++){              
            val = (val + monthlyAmount * 12) * ((1 + interest/100));          
            this.interestChart.getData().add(new XYChart.Data(i,val));

        }
    }
    
    public XYChart.Series getChart(){
        return this.interestChart;
    }
    
    public void clear(){
        this.interestChart.getData().clear();
    }
    
    
    
    
    
    
}
