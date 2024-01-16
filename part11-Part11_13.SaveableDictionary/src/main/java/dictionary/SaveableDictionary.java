       
package dictionary;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.nio.file.Paths;
import java.util.Scanner;

public class SaveableDictionary {
    private Map<String, String> dictionary;
    //private PrintWriter writer;
    private String fileName;
    
    public SaveableDictionary(){
        this.dictionary = new HashMap<>();
    }
    
    public SaveableDictionary(String file) {
        this.dictionary = new HashMap<>();
        this.fileName = file;
    }
    
    public boolean load(){
        try {
            Scanner fileReader = new Scanner(Paths.get(this.fileName));
           
            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                String finnish = parts[0];
                String english = parts[1];
                add(finnish, english);
            }          
            return true;
        } catch (Exception e){
            System.out.println("Error");
            return false;
        }
        
    }
    
    public void add(String words, String translation){
        if (this.dictionary.containsKey(words)){
            return;
        }
        this.dictionary.put(words, translation);
    }
    
    public String translate(String word){
        String search = this.dictionary.get(word);
        if (search == null){
            for (Map.Entry<String, String> entry : this.dictionary.entrySet()){
                if (entry.getValue().equals(word)){
                    return entry.getKey();
                }
            }
        }
        return search;
        
    }
    
    public void delete(String word){        
        if (this.dictionary.containsKey(word)){
            this.dictionary.remove(word);
            return;
        }
        
        for (Map.Entry<String, String> entry : this.dictionary.entrySet()){
            if (entry.getValue().equals(word)){
                this.dictionary.remove(entry.getKey());
                return;
            }
        }
    }
    
    public boolean save(){
        
        try {
            
            PrintWriter writer = new PrintWriter(this.fileName);
            for (Map.Entry<String, String> entry : this.dictionary.entrySet()){
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
            writer.close();
            return true;

        } catch (Exception e){
            System.out.println("Error");
            return false;
        }
        
        
    }
    
    
    
}

/*
package dictionary;

 

import java.io.File;

import java.io.IOException;

import java.io.PrintWriter;

import java.nio.file.Files;

import java.nio.file.Paths;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import java.util.Map;

 

public class SaveableDictionary {

 

    private Map<String, String> words;

    private String file;

 

    public SaveableDictionary() {

        this.words = new HashMap<>();

    }

 

    public SaveableDictionary(String file) {

        this();

        this.file = file;

    }

 

    public boolean load() {

        try {

            Files.lines(Paths.get(this.file))

                    .map(l -> l.split(":"))

                    .forEach(parts -> {

                        this.words.put(parts[0], parts[1]);

                        this.words.put(parts[1], parts[0]);

                    });

            return true;

        } catch (IOException ex) {

            return false;

        }

    }

 

    public boolean save() {

        try {

            PrintWriter writer = new PrintWriter(new File(file));

            saveWords(writer);

            writer.close();

        } catch (Exception e) {

            return false;

        }

        return true;

    }

 

    public void add(String word, String translation) {

        if (words.containsKey(word)) {

            return;

        }

 

        words.put(word, translation);

        words.put(translation, word);

    }

 

    public String translate(String word) {

        return words.get(word);

    }

 

    public void delete(String word) {

        String translation = translate(word);

 

        words.remove(word);

        words.remove(translation);

    }

 

    private void saveWords(PrintWriter writer) throws IOException {

        List<String> allreadySaved = new ArrayList<>();

        words.keySet().stream().forEach(word -> {

            if (allreadySaved.contains(word)) {

                return;

            }

 

            String pari = word + ":" + words.get(word);

            writer.println(pari);

 

            allreadySaved.add(word);

            allreadySaved.add(words.get(word));

        });

    }

}
*/