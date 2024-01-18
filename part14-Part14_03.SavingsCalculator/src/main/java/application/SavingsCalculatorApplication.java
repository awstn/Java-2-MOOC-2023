package application;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application{
    
    
    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
        System.out.println("Hello world!");
    }
    
    @Override
    public void start(Stage window){
        BorderPane layout = new BorderPane();
        
        VBox topHeading = new VBox();
        topHeading.setPadding(new Insets(25));
                
        BorderPane monthlySavings = new BorderPane(); 
        Slider monthlySlider = new Slider(25, 250 ,4);
        monthlySlider.setShowTickMarks(true);
        monthlySlider.setShowTickLabels(true); 
        Label sliderValue = new Label(String.valueOf(monthlySlider.getValue()));
        
        BorderPane interestRate = new BorderPane();
        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setShowTickMarks(false);
        interestSlider.setShowTickLabels(true);
        Label interestValue = new Label(String.valueOf(interestSlider.getValue()));
          
        monthlySavings.setLeft(new Label("Monthly savings"));
        monthlySavings.setCenter(monthlySlider);
        monthlySavings.setRight(sliderValue);
        interestRate.setLeft(new Label("Yearly interest rate"));
        interestRate.setCenter(interestSlider);
        interestRate.setRight(interestValue);
        
        
        topHeading.getChildren().addAll(monthlySavings, interestRate);       
        
        
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();

        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        XYChart.Series savingsChart = new XYChart.Series();
        XYChart.Series interestChart = new XYChart.Series();

        
        
        lineChart.setTitle("Savings Counter");
        
        lineChart.getData().addAll(savingsChart, interestChart);

        
        DecimalFormat df = new DecimalFormat("#.00");       

        monthlySlider.valueProperty().addListener((observable, oldValue, newValue) -> {         
            sliderValue.setText(String.format("%.2f", newValue.doubleValue()));            
            
            updateChart(monthlySlider.getValue(), interestSlider.getValue(), savingsChart, interestChart);            
           
        });
        
        interestSlider.valueProperty().addListener((observable, oldValue, newValue) -> {            
            interestValue.setText(String.format("%.2f", newValue.doubleValue()));           
            
            updateChart(monthlySlider.getValue(),interestSlider.getValue(), savingsChart, interestChart);            
           
        });
        
        updateChart(monthlySlider.getValue(),interestSlider.getValue(), savingsChart, interestChart);            

              
        layout.setCenter(lineChart);
        layout.setTop(topHeading);
        
        Scene view = new Scene(layout, 720, 720);
        window.setScene(view);
        window.show();
    }
    
    public void updateChart(double savings, double interest, XYChart.Series savingsSeries, XYChart.Series withInterestSeries){
        savingsSeries.getData().clear();
        withInterestSeries.getData().clear();
        
        savingsSeries.getData().add(new XYChart.Data(0, 0));
        withInterestSeries.getData().add(new XYChart.Data(0, 0));   
        
        double savingsAmount = 0;
        double val = 0;
        
        for (int i = 1; i <= 30; i++){   
            savingsAmount += savings * 12;
            val = (val + savings * 12) * (1 + interest/100); 
         
            savingsSeries.getData().add(new XYChart.Data(i, savingsAmount));   
            withInterestSeries.getData().add(new XYChart.Data(i,val));

        }
 
        
    }

}   
