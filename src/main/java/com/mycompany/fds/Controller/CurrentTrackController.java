package com.mycompany.fds.Controller;

//import com.mycompany.fds.Helper;
import com.mycompany.fds.View.FoodCard;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CurrentTrackController implements Initializable {
    public Label chaleurLabel;
    public Label metreLabel;
    static String st ="";
    public AnchorPane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources)  {
        File file = new File("src/main/resources/iotFiles/chaleurSensor");
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(file));
//defining the axes
            final CategoryAxis xAxis = new CategoryAxis(); // we are gonna plot against time
            final NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Time/s");
            xAxis.setAnimated(true); // axis animations are removed
            yAxis.setLabel("Value");
            yAxis.setAnimated(true); // axis animations are removed

            //creating the line chart with two axis created above
            final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
            lineChart.setTitle("Realtime JavaFX Charts");
            lineChart.setAnimated(true); // disable animations
            //defining a series to display data
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Temperature en Celcius");

            // add series to chart
            lineChart.getData().add(series);
            pane.getChildren().add(lineChart);


            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();


            BufferedReader finalBr = br;
            scheduledExecutorService.scheduleAtFixedRate(() -> {
            // get a random integer between 0-10

            // Update the chart
            Platform.runLater(() -> {
                try {
                    st = finalBr.readLine();
                    if (st == null) {
                        scheduledExecutorService.shutdown();
                    }else {
                        chaleurLabel.setText(st);
                        System.out.println(st);
                        Date now = new Date();
                        // put random number with current time
                        series.getData().add(new XYChart.Data<>(simpleDateFormat.format(now), Integer.parseInt(st)));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }, 0, 1, TimeUnit.SECONDS);

           /* while ((st = br.readLine()) != null) {
                System.out.println(st);
            }
*/

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
