import java.util.ArrayList;

public class OneItemBox extends Box {
    private ArrayList<Item> box;
    
    public OneItemBox(){
        this.box = new ArrayList<>();
    }
    
    @Override
    public void add(Item item){
        if (this.box.isEmpty()){
            this.box.add(item);
        }
        
        return;
    }
    
    @Override
    public boolean isInBox(Item item){
        if (this.box.isEmpty()){
            return false;
        }
        return (item.equals(this.box.get(0)));
    }
    
}

/*
public class OneItemBox extends Box {

 

    private Item item;

 

    public OneItemBox() {

    }

 

    @Override

    public void add(Item item) {

        if (this.item != null) {

            return;

        }

 

        this.item = item;

    }

 

    @Override

    public boolean isInBox(Item item) {

        return this.item != null && this.item.equals(item);

    }

}
*/