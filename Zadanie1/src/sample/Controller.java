package sample;


import algNum.Zadanie1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private double array[] = new double[200];

    {

        double a = -1;
        for (int i = 0; i < array.length; i++){
            array[i] = Math.round(a * 100.0) /100.0;
            a += 0.01;
        }
    }





    @FXML
    public NumberAxis xaxis;
    @FXML
    public NumberAxis yaxis;
    @FXML
    private LineChart<Double, Double> chart;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    void onClickButton1(ActionEvent event) {
        chart.getData().clear();
        initialize(null, null);
    }

    @FXML
    void onClickButton2(ActionEvent event) {
        chart.getData().clear();
        XYChart.Series<Double, Double> series = new XYChart.Series<>();
        series.getData().add(0, new XYChart.Data<Double, Double>(0.0, 2.0));
        series.getData().add(1, new XYChart.Data<Double, Double>(-1.0, 1.0));
        series.getData().add(2, new XYChart.Data<Double, Double>(-2.0, 2.0));
        series.getData().add(3, new XYChart.Data<Double, Double>(-3.0, 1.0));
        series.setName("Mój super wykres 2");
        chart.getData().add(series);

        XYChart.Series<Double, Double> series2 = new XYChart.Series<>();
        series2.getData().add(0, new XYChart.Data<Double, Double>(0.0, -1.0));
        series2.getData().add(1, new XYChart.Data<Double, Double>(-1.0, -2.0));
        series2.getData().add(2, new XYChart.Data<Double, Double>(-2.0, -1.0));
        series2.getData().add(3, new XYChart.Data<Double, Double>(-3.0, -2.0));
        series2.setName("Mój super wykres 3a");
        chart.getData().add(series2);


    }

    @FXML
    void onClickButton3(ActionEvent event) {
        chart.getData().clear();
        XYChart.Series<Double, Double> series = new XYChart.Series<>();
        series.getData().add(0, new XYChart.Data<Double, Double>(0.0, -1.0));
        series.getData().add(1, new XYChart.Data<Double, Double>(-1.0, -2.0));
        series.getData().add(2, new XYChart.Data<Double, Double>(-2.0, -1.0));
        series.getData().add(3, new XYChart.Data<Double, Double>(-3.0, -2.0));
        series.setName("Mój super wykres 3");
        chart.getData().add(series);

    }


    //interfejs initializable pozwala przygotować pierwszy widok aplikacji i można ją wykorzystać do ładowania
    //statycznych rzeczy
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        double[] results = Zadanie1.countArraySinTaylor(this.array);
        XYChart.Series<Double, Double> series = new XYChart.Series<>();
        for (int i = 0; i < results.length; i++){
            series.getData().add(i, new XYChart.Data<Double, Double>(this.array[i], results[i]));
        }
        series.setName("Mój super wykres");
        chart.getData().add(series);
    }
}
