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
                
        //monthly sum slider
        Slider monthlySlider = new Slider(25, 250 ,4);
        monthlySlider.setShowTickMarks(true);
        monthlySlider.setShowTickLabels(true); 
        monthlySlider.setSnapToTicks(true);
        
        //interest slider
        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setShowTickMarks(false);
        interestSlider.setShowTickLabels(true);
        interestSlider.setSnapToTicks(true);
        
        //slider labels
        Label sliderValue = new Label(String.valueOf(monthlySlider.getValue()));
        Label interestValue = new Label(String.valueOf(interestSlider.getValue()));
        
        //setting borderPane object for monthly sum slider
        BorderPane monthlySavings = new BorderPane();
        monthlySavings.setLeft(new Label("Monthly savings"));
        monthlySavings.setCenter(monthlySlider);
        monthlySavings.setRight(sliderValue);
        
        //setting borderPane object for interest slider
        BorderPane interestRate = new BorderPane();
        interestRate.setLeft(new Label("Yearly interest rate"));
        interestRate.setCenter(interestSlider);
        interestRate.setRight(interestValue);
        
        //creating VBox object and adding the borderPane objects (interestRate and monthlySavings) to it
        VBox topHeading = new VBox();
        topHeading.setPadding(new Insets(25));
        topHeading.getChildren().addAll(monthlySavings, interestRate);       
             
        //setting numberAxis objects for LineChart
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();

        //setting up LineChart and two XYCharts.Series objects that will display the savings and interest on the LineChart.
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setAnimated(false);
        lineChart.setLegendVisible(false);
        XYChart.Series savingsChart = new XYChart.Series();
        XYChart.Series interestChart = new XYChart.Series();

        //setting up title of LineChart and adding the XYCharts to the lineChart
        lineChart.setTitle("Savings Counter");
        lineChart.getData().addAll(savingsChart, interestChart);
        
        
        //Adding a event listener to the monthly slider where it will update savingsChart according to the new value
        monthlySlider.valueProperty().addListener((observable, oldValue, newValue) -> {         
            sliderValue.setText(String.format("%.2f", newValue.doubleValue()));                        
            updateChart(monthlySlider.getValue(), interestSlider.getValue(), savingsChart, interestChart);            
           
        });
        
        //Adding a event listener to the interest slider where it will update savingsChart according to the new value
        interestSlider.valueProperty().addListener((observable, oldValue, newValue) -> {            
            interestValue.setText(String.format("%.2f", newValue.doubleValue()));           
            updateChart(monthlySlider.getValue(),interestSlider.getValue(), savingsChart, interestChart);            
           
        });
        
        //adding this so the graph will display the values on start of the program
        updateChart(monthlySlider.getValue(),interestSlider.getValue(), savingsChart, interestChart);            

        
        layout.setCenter(lineChart);
        layout.setTop(topHeading);
        
        Scene view = new Scene(layout, 720, 720);
        window.setScene(view);
        window.show();
    }
    
    public void updateChart(double savings, double interest, XYChart.Series savingsSeries, XYChart.Series withInterestSeries){
        
        //clears the chart 
        savingsSeries.getData().clear();
        withInterestSeries.getData().clear();
        
        //updates it with new values
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

/*
    public void start(Stage ikkuna) {

        BorderPane display = new BorderPane();

 
        Slider monthlySum = new Slider();
        monthlySum.setMin(25);
        monthlySum.setMax(250);
        monthlySum.setSnapToTicks(true);
        monthlySum.setBlockIncrement(500);
        monthlySum.setShowTickLabels(true);
        monthlySum.setShowTickMarks(true);

 
        Slider interestRate = new Slider();
        interestRate.setMin(0);
        interestRate.setMax(10);
        interestRate.setMinorTickCount(10);
        interestRate.setShowTickLabels(true);
        interestRate.setShowTickMarks(true);

        Label savingsText = new Label("25");
        Label interestRateText = new Label("0");

        BorderPane monthlySumDisplay = new BorderPane();
        monthlySumDisplay.setLeft(new Label("Monthly savings"));
        monthlySumDisplay.setCenter(monthlySum);
        monthlySumDisplay.setRight(savingsText);
        monthlySumDisplay.setPadding(new Insets(10));

        BorderPane interestRateDisplay = new BorderPane();
        interestRateDisplay.setLeft(new Label("Yearly interest rate"));
        interestRateDisplay.setCenter(interestRate);
        interestRateDisplay.setRight(interestRateText);
        interestRateDisplay.setPadding(new Insets(10));


        VBox sliderDisplay = new VBox();
        sliderDisplay.getChildren().add(monthlySumDisplay);
        sliderDisplay.getChildren().add(interestRateDisplay);

        sliderDisplay.setPadding(new Insets(10));
        sliderDisplay.setSpacing(10);

        display.setTop(sliderDisplay);


        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> savingsLineChart = new LineChart<>(xAxis, yAxis);
        savingsLineChart.setAnimated(false);
        savingsLineChart.setLegendVisible(false);
        savingsLineChart.setTitle("Savings calculator");

        display.setCenter(savingsLineChart);


        XYChart.Series savings = new XYChart.Series();
        XYChart.Series savingsWithInterest = new XYChart.Series();

        savingsLineChart.getData().add(savings);
        savingsLineChart.getData().add(savingsWithInterest);
 
        monthlySum.setOnMouseReleased(e -> {
            savingsText.setText("" + monthlySum.getValue());
            updateChart(monthlySum.getValue(), interestRate.getValue(), savings, savingsWithInterest);

        });

        interestRate.setOnMouseReleased(e -> {
            String interestString = "" + interestRate.getValue();
            if (interestString.length() > 4) {
                interestString = interestString.substring(0, 4);
            }
            interestRateText.setText(interestString);
            updateChart(monthlySum.getValue(), interestRate.getValue(), savings, savingsWithInterest);
        });


        Scene view = new Scene(display, 640, 480);
        ikkuna.setScene(view);
        ikkuna.show();

    }

 

    private void updateChart(double monthlySavings, double interestRate, XYChart.Series savings, XYChart.Series savingsWithInterest) {

        savings.getData().clear();
        savingsWithInterest.getData().clear();

        savings.getData().add(new XYChart.Data(0, 0));
        savingsWithInterest.getData().add(new XYChart.Data(0, 0));

        double previous = 0;

        for (int i = 1; i <= 30; i++) {
            savings.getData().add(new XYChart.Data(i, i * monthlySavings * 12));
            previous += monthlySavings * 12;
            previous *= (1 + interestRate / 100.0);

            savingsWithInterest.getData().add(new XYChart.Data(i, previous));

        }

    }

 
*/