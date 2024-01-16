import java.util.List;
import java.util.ArrayList;

public class Herd implements Movable{
    private List<Movable> herd;
    
    public Herd(){
        this.herd = new ArrayList<>();
    }
    
    @Override
    public String toString(){
        String printOut = "";
        for (Movable organism : this.herd){
            printOut += organism + "\n";
        }
        return printOut;
    
    }
    
    public void addToHerd(Movable movable){
        this.herd.add(movable);
    }
    
    public void move(int dx, int dy){
        for (Movable i : this.herd){
            i.move(dx, dy);
        }
    }
    
    
    
}
