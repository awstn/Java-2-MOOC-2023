import java.util.ArrayList;

public class Box implements Packable {
    private double maxCapacity;
    private ArrayList<Packable> box;
    
    public Box(double maxCapacity){
        this.maxCapacity = maxCapacity;
        this.box = new ArrayList<>();
    }
    
    public void add(Packable item){
        if (item.weight() + this.weight() <= this.maxCapacity){
            this.box.add(item);
            
        }
    }
    
    @Override
    public double weight(){
        double weight = 0;
        for (Packable item : box){
            weight += item.weight();
        }
        
        
        return weight;
    }
    
    @Override
    public String toString(){
        return "Box: " + this.box.size() + " items, total weight " + this.weight() + " kg";
    }
}
