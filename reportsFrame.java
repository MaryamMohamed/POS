///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package frames;
//
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//

package frames;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
/**
 *
 * @author 1300180
 */
public class reportsFrame extends Application {
    @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Pie Chart Report");
        stage.setWidth(500);
        stage.setHeight(500);
 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("laptops", 110),
                new PieChart.Data("Mobile phones", 250),
                new PieChart.Data("Mobile Cover", 50),
                new PieChart.Data("Laptop Cover", 270),
                new PieChart.Data("Headphones", 320));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Pie Chart Report");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}