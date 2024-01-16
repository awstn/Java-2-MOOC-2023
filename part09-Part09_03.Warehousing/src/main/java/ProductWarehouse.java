
public class ProductWarehouse extends Warehouse{
    
    private String productName;
    
    
    public ProductWarehouse(String productName, double capacity){
        super(capacity);
        this.productName = productName;
        
    }
    
    public String getName(){
        return this.productName;
    }
    
    public void setName(String newName){
        this.productName = newName;
    }
    
    @Override
    public String toString(){
        return this.productName + ": " + super.toString();
    }
}

/*
 

public class ProductWarehouse extends Warehouse {

 

    private String name;

 

    public ProductWarehouse(String name, double capacity) {

        super(capacity);

        this.name = name;

    }

 

    public String getName() {

        return this.name;

    }

 

    public void setName(String name) {

        this.name = name;

    }

 

    @Override

    public String toString() {

        return this.name + ": " + super.toString();

    }

 

}
*/