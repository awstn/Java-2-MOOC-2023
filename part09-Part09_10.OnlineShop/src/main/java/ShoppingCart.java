import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class ShoppingCart {
    private Map<String, Item> cart;
    
    public ShoppingCart(){
        this.cart = new HashMap<>();
    }
    
    public void add(String product, int price){
        if (this.cart.containsKey(product)){
            Item item = this.cart.get(product);
            item.increaseQuantity();
            return;
        }   
        
        Item newItem = new Item(product, 1, price);
        this.cart.put(product, newItem);
    }
    
    public int price(){
        int price = 0;
        Collection<Item> product = this.cart.values();
        
        for (Item i : product){
            price += i.price();
        }
        
        return price;
    }
    
    public void print(){
        Collection<Item> product = this.cart.values();
        
        for (Item i : product){
            System.out.println(i);
        }
    }
}

/*
 

import java.util.HashMap;

import java.util.Map;

 

public class ShoppingCart {

 

    private Map<String, Item> items;

 

    public ShoppingCart() {

        this.items = new HashMap<>();

    }

 

    public int price() {

        int sum = 0;

        for (Item item : this.items.values()) {

            sum = sum + item.price();

        }

        return sum;

    }

 

    public void add(String product, int price) {

        this.items.putIfAbsent(product, new Item(product, 0, price));

        this.items.get(product).increaseQuantity();

    }

 

    public void print() {

        for (Item item : this.items.values()) {

            System.out.println(item);

        }

    }

}
*/