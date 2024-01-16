import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Collection;

public class Warehouse {
    private Map<String, Integer> productPrices;
    private Map<String, Integer> productStock;
    
    public Warehouse(){
        this.productPrices = new HashMap<>();
        this.productStock = new HashMap<>();
        
    }
    
    public void addProduct(String product, int price, int stock){
        this.productPrices.put(product, price);
        this.productStock.put(product, stock);
    }
    
    public int price(String product){
        if (this.productPrices.get(product) == null){
            return -99;
        }
       

        return this.productPrices.get(product);
        
        
    }
    public boolean inventoryCheck(String product){
        if (this.productStock.get(product) == null){
            return false;
        } 
        return true;
    }
    
    public int stock(String product){
        if (inventoryCheck(product)){            
            return this.productStock.get(product);
        }       
        return 0;         
    }
    
    public boolean take(String product){
        if (inventoryCheck(product)){
            int stock = this.productStock.get(product);
        
            if (stock > 0){
                stock -= 1;
                this.productStock.put(product, stock);
                return true;
            }
            
            if (stock == 0){
                return false;
            }
        }
        
        return false;
        
    }
    
    public Set<String> products(){
        Set<String> products = this.productPrices.keySet();   
        
        return products;
    }
    
/*
    import java.util.HashMap;

import java.util.Map;

import java.util.Set;

 

public class Warehouse {

 

    private Map<String, Integer> prices;

    private Map<String, Integer> quantities;

 

    public Warehouse() {

        this.prices = new HashMap<>();

        this.quantities = new HashMap<>();

    }

 

    public void addProduct(String product, int price, int stock) {

        this.prices.put(product, price);

        this.quantities.put(product, stock);

    }

 

    public int price(String product) {

        return this.prices.getOrDefault(product, -99);

    }

 

    public int stock(String product) {

        return this.quantities.getOrDefault(product, 0);

    }

 

    public boolean take(String product) {

        if (!this.quantities.containsKey(product)) {

            return false;

        }

        

        int stock = this.quantities.get(product);

        if (stock <= 0) {

            return false;

        }

 

        this.quantities.put(product, stock - 1);

        return true;

    }

 

    public Set<String> products() {

        return this.quantities.keySet();

    }

}
    */
    

}
