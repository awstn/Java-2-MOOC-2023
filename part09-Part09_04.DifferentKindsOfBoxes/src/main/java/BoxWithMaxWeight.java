import java.util.ArrayList;

public class BoxWithMaxWeight extends Box{    
    private int capacity;
    private ArrayList<Item> items;
    
    public BoxWithMaxWeight(int capacity){
        this.capacity = capacity;
        this.items = new ArrayList<>();
        
    }
    
    @Override
    public void add(Item item){
        int weight = 0;
        for (Item i : this.items){
            weight += i.getWeight();
        }
        
        if (weight + item.getWeight() <= this.capacity){
            this.items.add(item);
        }
        
    }
    
    @Override
    public boolean isInBox(Item item){
        for (Item i : this.items) {
            if (i.equals(item)){
                return true;
            }
        }
        return false;
    }
}

/*
import java.util.ArrayList;

 

public class BoxWithMaxWeight extends Box {

 

    private ArrayList<Item> items;

    private int maxweight;

 

    public BoxWithMaxWeight(int capacity) {

        this.maxweight = capacity;

        this.items = new ArrayList<>();

    }

 

    @Override

    public void add(Item item) {

        if (this.weightOfItems() + item.getWeight() > this.maxweight) {

            return;

        }

 

        this.items.add(item);

    }

 

    @Override

    public boolean isInBox(Item tavara) {

        return this.items.contains(tavara);

    }

 

    private int weightOfItems() {

        int weight = 0;

        for (Item item : this.items) {

            weight = weight + item.getWeight();

        }

 

        return weight;

    }

}
*/