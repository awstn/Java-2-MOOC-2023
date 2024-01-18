
package application;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.chart.XYChart;


public class SavingsChart {
    
    private XYChart.Series savingsChart;
    private Map<Integer,Double> savingsHashMap;
    
    public SavingsChart(){
        this.savingsChart = new XYChart.Series<>();
        this.savingsHashMap = new HashMap<>();
        this.savingsChart.setName("Savings");
    }
    
    public void calculateSavings(double monthlyAmount){
        double savings = 0.0;
        for (int i = 0; i <= 30; i++){   
            savings += monthlyAmount * 12;
            this.savingsChart.getData().add(new XYChart.Data(i, savings));           
        }
    }
    
    public XYChart.Series getChart(){
        return this.savingsChart;
    }
    
    public Map getData(){
        return this.savingsHashMap;
    }
    
    public void clear(){
        this.savingsChart.getData().clear();
    }
    
}
