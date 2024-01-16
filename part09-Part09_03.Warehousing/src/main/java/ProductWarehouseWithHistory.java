
public class ProductWarehouseWithHistory extends ProductWarehouse {
    //private double initialBalance;
    private ChangeHistory changeHistory;
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance){
        super(productName, capacity);        
        this.changeHistory = new ChangeHistory();
        
        super.addToWarehouse(initialBalance);
        this.changeHistory.add(initialBalance);
    }
    
    
    @Override
    public void addToWarehouse(double amount){
        super.addToWarehouse(amount);
        this.changeHistory.add(super.getBalance());
        
    }
    
    @Override
    public double takeFromWarehouse(double amount){
        double balance = super.takeFromWarehouse(amount);
        this.changeHistory.add(super.getBalance());
        return balance;
    }
    
    
    public String history(){ 
        return this.changeHistory.toString();
    }
    
    public void printAnalysis(){
        System.out.println("Product: " + super.getName() + 
                            "\nHistory: " + this.history() +
                            "\nLargest amount of product: " + this.changeHistory.maxValue() +
                            "\nSmallest amount of product: " + this.changeHistory.minValue() +
                            "\nAverage: " + this.changeHistory.average());
    }
    
}

/*
public class ProductWarehouseWithHistory extends ProductWarehouse {

 

    private ChangeHistory history;

 

    public ProductWarehouseWithHistory(String name, double capacity, double initalBalance) {

        super(name, capacity);

        history = new ChangeHistory();

        addToWarehouse(initalBalance);

    }

 

    public String history() {

        return history.toString();

    }

 

    public void printAnalysis() {

        System.out.println("Product: " + getName());

        System.out.println("History: " + history());

        System.out.println("Largest amount of product: " + history.maxValue());

        System.out.println("Smallest amount of product: " + history.minValue());

        System.out.println("Average: " + history.average());

    }

 

    @Override

    public void addToWarehouse(double amount) {

        super.addToWarehouse(amount);

        history.add(getBalance());

    }

 

    @Override

    public double takeFromWarehouse(double amount) {

        double received = super.takeFromWarehouse(amount);

        history.add(getBalance());

        return received;

    }

}
*/