/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import frames.addCustomerFrame;
import frames.customerFrame;
import frames.updateCustomerFrame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import frames.itemFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 1300180
 */
public class EmployeeDashboard extends LogInFrame {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Employee Dashboard");
        GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(20);
            grid.setVgap(20);
            grid.setPadding(new Insets(25, 25, 25, 25));
            
        Button CustomerB = new Button("   Customer   ");
          grid.add(CustomerB, 0, 0);
          
        Button ItemB = new Button("     Item     ");
          grid.add(ItemB, 2, 0);
          
        Button SignOut = new Button("          Sign Out          ");
          grid.add(SignOut, 1, 5);
          GridPane.setHalignment(SignOut, HPos.CENTER);
        
        Scene scene = new Scene(grid, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        SignOut.setOnAction(new EventHandler<ActionEvent>() {
                @Override
              public void handle(ActionEvent t) {
                  primaryStage.close();
                  LogInFrame LF = new LogInFrame();
                  try {
                        Stage s = new Stage();
                        LF.start(s);

                    } catch (Exception ex) {
                        Logger.getLogger(LogInFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        
        ItemB.setOnAction(new EventHandler<ActionEvent>() {
                @Override
              public void handle(ActionEvent t) {
                  primaryStage.close();
                    itemFrame item = new itemFrame();
                    Stage s = new Stage();
                    item.start(s);
                }
            });
        
        CustomerB.setOnAction(new EventHandler<ActionEvent>() {
                @Override
              public void handle(ActionEvent t) {
                  primaryStage.close();
                    customerFrame customer = new customerFrame();
                    Stage s = new Stage();
                    customer.start(s);
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
