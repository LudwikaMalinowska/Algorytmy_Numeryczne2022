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
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private double array[] = new double[1_000];

    {
        double start = - Math.PI ;
        double end = Math.PI;
        double len = Math.PI;
        array[0] = start;
        double df = (end - start) / array.length;
        System.out.println(array[0]);
        double a = -3.14;
        for (int i = 1; i < array.length; i++){
            array[i] = start + i * df;
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
        double[] results = Zadanie1.countMistakeSinTAtanT(this.array);
        XYChart.Series<Double, Double> series = countSeriesFromData(results);
        series.setName("Błąd sinT * atanT");

        chart.getData().add(series);
    }

    @FXML
    void onClickButton3(ActionEvent event) {
        chart.getData().clear();
        double[] results = Zadanie1.countMistakeSinTAtanTBackwards(this.array);
        XYChart.Series<Double, Double> series = countSeriesFromData(results);

        series.setName("Błąd sinT * atanT liczone od końca");
        chart.getData().add(series);
    }

    @FXML
    void onClickButton4(ActionEvent event) {
        chart.getData().clear();
        double[] results = Zadanie1.countMistakeSinTAtanTFromPrev(this.array);
        XYChart.Series<Double, Double> series = countSeriesFromData(results);

        series.setName("Błąd sinT * atanT liczone z poprzedniego elementu");
        chart.getData().add(series);
    }

    @FXML
    void onClickButton5(ActionEvent event) {
        chart.getData().clear();
        double[] results = Zadanie1.countMistakeSinTAtanTFromPrevBackwards(this.array);
        XYChart.Series<Double, Double> series = countSeriesFromData(results);

        series.setName("Błąd sinT * atanT z poprzedniego elementu od końca");
        chart.getData().add(series);
    }

    @FXML
    void onClickButton6(ActionEvent event) {
        chart.getData().clear();

        double[] results1 = Zadanie1.countMistakeSinTAtanT(this.array);
        XYChart.Series<Double, Double> series1 = countSeriesFromData(results1);
        series1.setName("Błąd sinT * atanT");
        chart.getData().add(series1);

        double[] results2 = Zadanie1.countMistakeSinTAtanTFromPrevBackwards(this.array);
        XYChart.Series<Double, Double> series2 = countSeriesFromData(results2);
        series2.setName("Błąd sinT * atanT z poprzedniego elementu od końca");
        chart.getData().add(series2);
    }

    @FXML
    void onClickButton7(ActionEvent event) {
        chart.getData().clear();

        double[] results1 = Zadanie1.countMistakeSinTAtanT(this.array);
        XYChart.Series<Double, Double> series1 = countSeriesFromData(results1);
        series1.setName("Błąd sinT * atanT");
        chart.getData().add(series1);

        double[] results2 = Zadanie1.countMistakeSinTAtanTBackwards(this.array);
        XYChart.Series<Double, Double> series2 = countSeriesFromData(results2);
        series2.setName("Błąd sinT * atanT od końca");
        chart.getData().add(series2);

        double[] results3 = Zadanie1.countMistakeSinTAtanTFromPrev(this.array);
        XYChart.Series<Double, Double> series3 = countSeriesFromData(results3);
        series3.setName("Błąd sinT * atanT z poprzedniego elementu");
        chart.getData().add(series3);

        double[] results4 = Zadanie1.countMistakeSinTAtanTFromPrevBackwards(this.array);
        XYChart.Series<Double, Double> series4 = countSeriesFromData(results4);
        series4.setName("Błąd sinT * atanT z poprzedniego elementu od końca");
        chart.getData().add(series4);
    }

    private XYChart.Series<Double, Double> countSeriesFromData(double[] results){
        XYChart.Series<Double, Double> series = new XYChart.Series<>();
        for (int i = 0; i < results.length; i++){
//            if (Double.isNaN(results[i])) continue;
            series.getData().add(new XYChart.Data<Double, Double>(this.array[i], results[i]));
        }


        return series;
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
        chart.setCreateSymbols(false);
    }
}
