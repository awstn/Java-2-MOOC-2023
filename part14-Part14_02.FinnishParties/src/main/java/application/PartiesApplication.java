package application;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.Scene;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PartiesApplication extends Application {
    
    private FileReader fileReader;

    public static void main(String[] args) {
        launch(PartiesApplication.class);

    }
    

        
    @Override 
    public void start(Stage window){ 
        this.fileReader = new FileReader();

        Map<String, Map<Integer,Double>> dataConverted = convertToMap(this.fileReader.load("partiesdata.tsv"));
        
        NumberAxis xAxis = new NumberAxis(1968,2008,4);
        NumberAxis yAxis = new NumberAxis(0,30,5);
        
        LineChart<Number,Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");
        
        dataConverted.keySet().stream().forEach(party -> {
           XYChart.Series data = new XYChart.Series();
           data.setName(party);
           
           dataConverted.get(party).entrySet().stream()
                   .filter(pair -> pair.getValue() > 0)
                   .forEach(pair -> {data.getData().add(new XYChart.Data(pair.getKey(),pair.getValue()));
                         
            });
           
           lineChart.getData().add(data);
        }); 
        
        Scene view = new Scene(lineChart, 640, 480);
        window.setScene(view);
        window.show();
        
    }
    
    public Map<String, Map<Integer, Double>> convertToMap(List data){
        Map<String, Map<Integer, Double>> partiesData = new HashMap<>();
        Map<Integer, Double> yearsPercentages = new HashMap<>();
        
        List<Integer> years = new ArrayList<>();                
        List<String> rawData = data;        
        
        String[] yearsRow = rawData.get(0).split("\t"); //get the first row and add it to a list. 
        for (int i = 1; i < yearsRow.length; i++){
            years.add(Integer.valueOf(yearsRow[i]));           
        }
        rawData.remove(0);
        
        for (int i = 0; i < rawData.size(); i++){
            String[] split = rawData.get(i).split("\t");
            
            for (int j = 1; j < split.length; j++){ //After adding party, iterate through to add years and percentages              
                if (split[j].equals("-")){
                    split[j] = "0";
                }
               
                yearsPercentages.put(years.get(j-1), Double.valueOf(split[j]));
                
            }
            
            Map<Integer, Double> hmTemp = new HashMap<>(yearsPercentages); //make a temp copy 
            
            partiesData.putIfAbsent(split[0], hmTemp);
            yearsPercentages.clear();        
            
        }
             
        
        return partiesData;
    }
    
   

        
        
        
        
        
        
    

}


/* 

public class PartiesApplication extends Application {

    @Override

    public void start(Stage stage) {

        List<String[]> rows = new ArrayList<>();

        try {

            Files.lines(Paths.get("partiesdata.tsv")).map(line -> line.split("\t")).forEach(rivi -> rows.add(rivi));

        } catch (IOException ex) {

            System.out.println("Failed to read the file \"partiesdata.tsv\".");

            return;

        }

        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        for (int i = 1; i < rows.size(); i++) {
            String[] row = rows.get(i);
            XYChart.Series data = new XYChart.Series();
            data.setName(row[0]);

 

            for (int column = 1; column < row.length; column++) {

                String value = row[column];

                if (value.equals("-")) {

                    continue;
                }

                int year = Integer.parseInt(rows.get(0)[column]);

                data.getData().add(new XYChart.Data(year, Double.parseDouble(value)));

            }

            lineChart.getData().add(data);

 

        }

 

        Scene view = new Scene(lineChart, 400, 300);

        stage.setScene(view);

        stage.show();

    }

 

    public static void main(String[] args) {

        launch(PartiesApplication.class);

        System.out.println("Hello world!");

    }

 

}
*/