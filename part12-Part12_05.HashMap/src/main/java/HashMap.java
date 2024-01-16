import java.util.ArrayList;
import java.util.List;

public class HashMap <K,V>{
    
    private ArrayList<Pair<K,V>>[] values; //stating that this is a an ARRAY of ARRAYLISTS
    private int firstFreeIndex; 
    
    public HashMap(){
        this.values = new ArrayList[2];
        this.firstFreeIndex = 0;
    }   
    
    public V get(K key){
        int hashValue = getHashValue(key); // hashValue is the key used to store the arraylist pair.  
        
        if (this.values[hashValue] == null){
            return null; // If there is no arraylist, returns null. No arrayList to look through. 
        }
        
        // looking through arraylist. 
        ArrayList<Pair<K,V>> valuesAtIndex = this.values[hashValue];
        
        for (int i = 0; i < valuesAtIndex.size(); i++){
            if (valuesAtIndex.get(i).getKey().equals(key)){
                return valuesAtIndex.get(i).getValue();
            }
        }
        
        return null;
        
    }
    
    public void add(K key, V value){
        ArrayList<Pair<K,V>> valuesAtIndex = getListBasedOnKey(key); // returns the Pair which is stored as an arraylist.         
        int index = getIndexOfKey(valuesAtIndex, key); //finds the index of the key.
               
        if (index < 0){  //if index is less than 0, then it will add a new Pair object. 
            valuesAtIndex.add(new Pair<>(key, value));
            this.firstFreeIndex++;
        } else {
            valuesAtIndex.get(index).setValue(value);
        }
        
        if (1.0 * this.firstFreeIndex / this.values.length > 0.75){ // if the size of the firstFreeIndex is greater than .75 than we will grow the array. 
            grow(); 
        }
    }
    
    
    public void grow(){
        ArrayList<Pair<K,V>>[] newValues = new ArrayList[this.values.length * 2];
        
        for (int i = 0; i < this.values.length; i++){ // this is iterating over the array
            copy(newValues, i);
        }
        
        this.values = newValues;
        
    }
    
    public void copy(ArrayList<Pair<K,V>>[] newArray, int startIndex){
        for (int i = 0; i < this.values[startIndex].size(); i++){ //this is iterating over the arraylist
            Pair<K,V> value = this.values[startIndex].get(i);
            
            int hashValue = (value.getKey().hashCode() % newArray.length);
            if (newArray[hashValue] == null){
                newArray[hashValue] = new ArrayList<>();
            }
            
            newArray[hashValue].add(value);
        }
    }
    
    public V remove(K key){
        ArrayList<Pair<K,V>> valuesAtIndex = getListBasedOnKey(key); //get the ArrayList 
        
        if(valuesAtIndex.size() == 0){
            return null;
        }
        
        int index = getIndexOfKey(valuesAtIndex, key);
        if (index < 0){
            return null;
        }
        
        Pair<K,V> pair = valuesAtIndex.get(index);
        valuesAtIndex.remove(pair);
        
        return pair.getValue();
                
    }
    
    
    private ArrayList getListBasedOnKey(K key){ // returns the Pair object which is stored as an arraylist.  
        int hashValue = getHashValue(key);
        
        if (this.values[hashValue] == null){
            this.values[hashValue] = new ArrayList<>();
        }
       
        return this.values[hashValue];
    }
    
    private int getIndexOfKey(ArrayList<Pair<K,V>> myList, K key){ //looks through the arraylist to see if any of the keys matches.  
        int index = -1; // if the index is -1, then the key does not exist. 
        for(int i = 0; i < myList.size(); i++){
            if (myList.get(i).getKey().equals(key)){
                index = i;
                break;
            }
        }
        
        return index;
    }
    
    private int getHashValue(K key){
        return Math.abs(key.hashCode() % this.values.length);
    }
}
