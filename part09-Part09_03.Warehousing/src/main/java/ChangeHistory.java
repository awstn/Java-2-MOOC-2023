import java.util.ArrayList;

public class ChangeHistory {
    
    private ArrayList<Double> history;
    
    public ChangeHistory(){
        this.history = new ArrayList<>();
    }
    
    public void add(double status){
        this.history.add(status);
    }
    
    public void clear(){
        this.history.clear();
    }
    
    public double maxValue(){
        double max = 0;
        for (double status : this.history){
            if (status > max){
                max = status;
            }
        }
        
        return max;
    }
    
    public double minValue(){
        double min = this.history.get(0);
        for (int i = 0; i < this.history.size(); i++){
            if (this.history.get(i) < min){
                min = this.history.get(i);
            }
        }
        return min;
    }
    
    public double average(){
        if (this.history.isEmpty()){
            return 0;
        }
        
        double sum = 0;
        for (double status : this.history){
            sum += status;
        }
        
        return sum / this.history.size();
        
    }
    
    @Override
    public String toString(){
        return this.history.toString();
    }
    
}


/*
import java.util.ArrayList;

 

public class ChangeHistory {

 

    private ArrayList<Double> states;

 

    public ChangeHistory() {

        this.states = new ArrayList<>();

    }

 

    public void add(double status) {

        this.states.add(status);

    }

 

    public void clear() {

        this.states.clear();

    }

 

    public double minValue() {

        double min = this.states.get(0);

        for (Double d : this.states) {

            if (min > d) {

                min = d;

            }

        }

        return min;

    }

 

    public double maxValue() {

        double max = this.states.get(0);

        for (Double d : this.states) {

            if (max < d) {

                max = d;

            }

        }

        return max;

    }

 

    public double average() {

        if (this.states.isEmpty()) {

            return 0;

        }

 

        double sum = 0;

        for (Double change : this.states) {

            sum = sum + change;

        }

 

        return sum / this.states.size();

    }

 

    @Override

    public String toString() {

        return states.toString();

    }

}
*/