
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Dictionary {
    private Map<String,String> translations;
    private List<String> words;
    
    public Dictionary(){
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();
        
        add("sanna", "word");
        
    }
    
    public void add(String finnish, String translation){
        if (!this.translations.containsKey(finnish)){
            this.words.add(finnish);
        }
        
        this.translations.put(finnish, translation);
                
    }
    
    public String get(String word){
        return this.translations.get(word);
    }
    
    public String getRandomWord(){
        Random random = new Random();
        return this.words.get(random.nextInt(this.words.size()));
    }
}
