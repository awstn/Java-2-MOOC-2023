package application;

import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application{
    

    public static void main(String[] args) {
        launch (ShanghaiApplication.class);
        System.out.println("Hello world!");
    }

    @Override
    public void start(Stage stage) {
        
        
        NumberAxis xAxis = new NumberAxis(2006,2018, 1);
        NumberAxis yAxis = new NumberAxis(0, 100, 5);
        
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Univeresity of Helsinki, Shanghai ranking");
        lineChart.setLegendVisible(false);
            
        XYChart.Series uhData = new XYChart.Series();
        
        uhData.getData().add(new XYChart.Data(2007,73));
        uhData.getData().add(new XYChart.Data(2008,68));
        uhData.getData().add(new XYChart.Data(2009,72));
        uhData.getData().add(new XYChart.Data(2010,72));
        uhData.getData().add(new XYChart.Data(2011,74));
        uhData.getData().add(new XYChart.Data(2012,73));
        uhData.getData().add(new XYChart.Data(2013,76));
        uhData.getData().add(new XYChart.Data(2014,73));
        uhData.getData().add(new XYChart.Data(2015,67));
        uhData.getData().add(new XYChart.Data(2016,56));
        uhData.getData().add(new XYChart.Data(2017,56));
        
        lineChart.getData().add(uhData);
        
        Scene view = new Scene(lineChart, 400, 300);
        stage.setScene(view);
        stage.show();

    }

}

/*
    @Override

    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(2006, 2018, 1);
        NumberAxis yAxis = new NumberAxis(0, 100, 5);
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");


        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("University of Helsinki, Shanghai ranking");

        lineChart.setLegendVisible(false);

 

        XYChart.Series position = new XYChart.Series();

        position.getData().add(new XYChart.Data(2007, 73));

        position.getData().add(new XYChart.Data(2008, 68));

        position.getData().add(new XYChart.Data(2009, 72));

        position.getData().add(new XYChart.Data(2010, 72));

        position.getData().add(new XYChart.Data(2011, 74));

        position.getData().add(new XYChart.Data(2012, 73));

        position.getData().add(new XYChart.Data(2013, 76));

        position.getData().add(new XYChart.Data(2014, 73));

        position.getData().add(new XYChart.Data(2015, 67));

        position.getData().add(new XYChart.Data(2016, 56));

        position.getData().add(new XYChart.Data(2017, 56));

 

        lineChart.getData().add(position);

 

        Scene view = new Scene(lineChart, 400, 300);

        stage.setScene(view);

        stage.show();

    }
*/