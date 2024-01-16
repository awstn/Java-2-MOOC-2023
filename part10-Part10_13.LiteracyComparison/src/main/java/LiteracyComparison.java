
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.List;


public class LiteracyComparison {
    
    public static void main(String[] args) {
        List<CountryLiteracyData> database = readFile("literacy.csv");
        
        database.stream().sorted((c1, c2) -> Double.compare(c1.getPercentage(), c2.getPercentage()))
                 .forEach(c -> System.out.println(c));

        
        

    }
    
    public static List<CountryLiteracyData> readFile (String fileName){
        List<CountryLiteracyData> database = new ArrayList<>();
        
        try {
            Files.lines(Paths.get(fileName))
                    .map(line -> line.split(","))
                    .map(parts -> new CountryLiteracyData(parts[3],
                            Integer.valueOf(parts[4]),
                            parts[2].replaceAll("\\(%\\)", "").trim(),
                            Double.valueOf(parts[5])))
                    .forEach(country -> database.add(country));
                                     
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            
        }
        
        return database;
    }
    

    
    
}

/*
public class LiteracyComparison {

    

    public static void main(String[] args) {

 

        ArrayList<Result> results = new ArrayList<>();

        try {

            Files.lines(Paths.get("literacy.csv"))

                    .map(l -> l.split(","))

                    .map(a -> new Result(a[2].replace("(%)", "").trim(), a[3], Integer.valueOf(a[4]), Double.parseDouble(a[5])))

                    .forEach(t -> results.add(t));

        } catch (IOException ex) {

            System.out.println("Error reading file.");

        }

        

        results.stream().sorted((t1, t2) -> {

            if (t1.getLiteracyPercent() > t2.getLiteracyPercent()) {

                return 1;

            }

            if (t1.getLiteracyPercent() < t2.getLiteracyPercent()) {

                return -1;

            }

            return 0;

        }).forEach(t -> System.out.println(t));

    }

}
*/