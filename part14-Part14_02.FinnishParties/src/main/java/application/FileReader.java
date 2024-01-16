
package application;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileReader {    
       
    public List<String> load(String fileName){
        List<String> rows = new ArrayList<>();      
        try {
            Files.lines(Paths.get(fileName))
                .forEach(line -> rows.add(line));
        } catch (Exception e){
            System.out.println("Error reading file");
        }
        
        
        return rows;
    }
    
}
