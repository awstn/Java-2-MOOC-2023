import java.util.ArrayList;
import java.util.List;

public class Hideout<T> {
    private List<T> hideout;
    
    public Hideout(){
        this.hideout = new ArrayList<>();

    }
   
    public void putIntoHideout(T toHide){
        if (!this.hideout.isEmpty()){
            this.hideout.remove(0);
        }
        this.hideout.add(toHide);
    }
    
    public T takeFromHideout(){
        T x = this.hideout.get(0);
        
        this.hideout.remove(0);
        
        return x;
        
    }
    
    public boolean isInHideout(){
        if (this.hideout.isEmpty()){
            return false;
        }
        
        return true;
    }
    
}

/*
    private T inHiding;

 

    public void putIntoHideout(T toHide) {

        this.inHiding = toHide;

    }

 

    public boolean isInHiding() {

        return this.inHiding != null;

    }

 

    public T takeFromHideout() {

        T previouslyInHiding = this.inHiding;

        this.inHiding = null;

        return previouslyInHiding;

    }

}
*/