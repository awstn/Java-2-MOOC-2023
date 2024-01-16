import java.util.List;
import java.util.ArrayList;

public class Pipe <T>{
    private List<T> pipe;
    
    public Pipe(){
        this.pipe = new ArrayList<>();
    }
    
    public void putIntoPipe(T value){
        this.pipe.add(value);
    }
    
    public T takeFromPipe(){
        if (!isInPipe()){
            return null;
        }
        
        T oldest = this.pipe.get(0);
        this.pipe.remove(oldest);
        return oldest;
        
        
    }
    
    public boolean isInPipe(){
        return !this.pipe.isEmpty();
    }
}
