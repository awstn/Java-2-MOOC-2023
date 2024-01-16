
public class List<Type> {
    private Type[] values;
    private int firstFreeSpace;
    
    public List(){
        this.values = (Type[]) new Object[10];
        this.firstFreeSpace = 0;
    }
    
    public void add(Type value){
        if (this.values.length == this.firstFreeSpace){
            grow();
        }
        
        this.values[this.firstFreeSpace] = value;
        this.firstFreeSpace++;
    }
    
    private void grow(){
        int newSize = this.values.length + this.values.length / 2;
        Type[] newValues = (Type[]) new Object[newSize];
        
        for (int i = 0; i < this.values.length; i++){
            newValues[i] = this.values[i];
        }
        
        this.values = newValues;
    } 
    
    public boolean contains(Type value){
        return this.indexOfValue(value) >= 0;
    }
    
    public void remove(Type value){
        int indexOfValue = indexOfValue(value);
        
        if (indexOfValue(value) < 0){
            return; //not found
        }
        
        moveToTheLeft(indexOfValue);
        this.firstFreeSpace--;
        
    }
    
    public int indexOfValue(Type value){
        for (int i = 0; i < this.firstFreeSpace; i++){
            if (this.values[i] == value || this.values[i].equals(value)){
                return i;
            }
        }
        return -1;
    }
    
    private void moveToTheLeft(int index){
        for (int i = index; i < this.firstFreeSpace; i++){
            this.values[i] = this.values[i + 1];

        }

    }
    
    public Type value(int index){
        if (index < 0 || index > this.values.length){
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.firstFreeSpace + "]");
        }
        
        return this.values[index];
        
    }
    
    public int size(){
        return this.firstFreeSpace;
    }
    
    
}
