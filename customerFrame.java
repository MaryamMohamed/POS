/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import GUI.EmployeeDashboard;
import core.Customer;
import core.item;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
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

/**
 *
 * @author 1300180
 */
public class customerFrame extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Search Customer Panel");
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(20);
            grid.setVgap(20);
            grid.setPadding(new Insets(25, 25, 25, 25));

        Label IdL = new Label("Customer ID:");
        grid.add(IdL, 0, 0);
///////////////////////////////////
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1,1);
///////////////////////////////////        
        final TextField search = new TextField();
        grid.add(search, 1, 0);
//////////////////////////////////        
        Button searchButton = new Button("search");
        grid.add(searchButton, 2, 0);
//////////////////////////////////
        Button back = new Button("     Back    ");
        grid.add(back, 0, 7);
        GridPane.setHalignment(back, HPos.CENTER);
//////////////////////////////////
        Button ADD = new Button("     ADD     ");
        grid.add(ADD, 1, 7);   
        GridPane.setHalignment(ADD, HPos.CENTER);
//////////////////////////////////
        Button Invo = new Button("Go To Invoice");
        grid.add(Invo, 2, 7);
        GridPane.setHalignment(Invo, HPos.CENTER);
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
        
        ADD.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               addCustomerFrame admin = new addCustomerFrame();
               Stage s = new Stage();
               admin.start(s);
            }
        });
/////////////////////////////////////////
        searchButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
              if(!search.getText().equals("")){
                  Customer I = new Customer();
                  Customer returned = I.searchCustomerById(Integer.parseInt(search.getText()));
                  if (returned.getID() > 0) {
                      actiontarget.setFill(Color.GREEN);
                      actiontarget.setText("Customer Found ...!");
                  } else {
                      actiontarget.setFill(Color.RED);
                      actiontarget.setText("Not Found ...!");
                  }
              }
              else{
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("Missing required Fields!\nPlease, complete them before submit!");
              }               
            }
        });
//////////////////////////////////////
    
        Invo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               InvoiveFrame admin = new InvoiveFrame();
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
