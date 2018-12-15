/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import GUI.AdminDashboard;
import GUI.EmployeeDashboard;
import core.Customer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import core.item; 
/**
 *
 * @author 1300180
 */
public class itemFrame extends Application {
    
    @Override
    public void start(Stage primaryStage) {
            primaryStage.setTitle("Item Panel");
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(20);
            grid.setVgap(20);
            grid.setPadding(new Insets(25, 25, 25, 25));
        
        Button searchButton = new Button("Search for Item");
        grid.add(searchButton, 0, 0);
//////////////////////////////////
        Button ListButton = new Button("  List Items   ");
        grid.add(ListButton, 2, 0);
/////////////////////////////////////        
        Button back = new Button("     Back     ");
        grid.add(back, 1, 5);
///////////////////////////////////
        Scene scene = new Scene(grid, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
///////////////////////////////////        
        
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               primaryStage.close();
               EmployeeDashboard admin = new EmployeeDashboard();
               Stage s = new Stage();
               admin.start(s);
            }
        });
//////////////////////////////////////        
        searchButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               primaryStage.close();
               SearchItemPanal admin = new SearchItemPanal();
               Stage s = new Stage();
               admin.start(s);
            }
        });
//////////////////////////////////////        
        ListButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               ListItemPanal admin = new ListItemPanal();
               Stage s = new Stage();
               admin.start(s);
            }
        });
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
