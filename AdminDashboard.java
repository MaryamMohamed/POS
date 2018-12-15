/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import frames.updateEmployeeFrame;
import frames.addCustomerFrame;
import frames.addEmployeeFrame;
import frames.updateCustomerFrame;
import frames.reportsFrame;
import static java.awt.SystemColor.desktop;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author 1300180
 */
public class AdminDashboard extends LogInFrame {
    
    @Override
    public void start(Stage primaryStage) {
          primaryStage.setTitle("Admin Dashboard");
          GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(20);
            grid.setVgap(20);
            grid.setPadding(new Insets(25, 25, 25, 25));

//            MenuBar menuBar = new MenuBar();
//            Scene scene = new Scene(new VBox(), 700, 700);
//            scene.setFill(Color.OLDLACE);
//            Menu menuFile = new Menu("File");
//            Menu menuEmployee = new Menu("Employee");
//            Menu menuCustome = new Menu("Customer");
//            Menu menuReport = new Menu("Report");
//            menuBar.getMenus().addAll(menuFile, menuEmployee, menuCustome ,menuReport);
//            ((VBox) scene.getRoot()).getChildren().addAll(menuBar);
//            primaryStage.setScene(scene);
//            primaryStage.show();
            
          Label EmployeeLabel = new Label("Employee:");
          grid.add(EmployeeLabel, 0, 0);
          
          final ComboBox EmployeeOptions = new ComboBox();
          EmployeeOptions.getItems().addAll(
            "Add employee",            
//            "Delete employee",
            "Update/Delete employee"
            );
          EmployeeOptions.getSelectionModel().selectFirst();
          grid.add(EmployeeOptions, 1, 0);
          
          Button go1 = new Button("       GO     ");
          GridPane.setHalignment(go1, HPos.RIGHT);
          grid.add(go1, 2, 0);
          
          Label CustomerLabel = new Label("Customer:");
          grid.add(CustomerLabel, 0, 1);
          
          final ComboBox CustomerOptions = new ComboBox();
          CustomerOptions.getItems().addAll(
            "Add customer",            
//            "Delete customer",
            "Update/Delete customer"
            );
          CustomerOptions.getSelectionModel().selectFirst();
          grid.add(CustomerOptions, 1, 1);
          
          Button go2 = new Button("       GO     ");
          GridPane.setHalignment(go2, HPos.RIGHT);
          grid.add(go2, 2, 1);
          
          Button reports = new Button("       My Reports       ");
          grid.add(reports, 1, 2);
          GridPane.setHalignment(reports, HPos.CENTER);
          
          Button SignOut = new Button("          Sign Out          ");
          grid.add(SignOut, 1, 5);
          GridPane.setHalignment(SignOut, HPos.CENTER);
          
          Scene scene = new Scene(grid, 700, 700);
          primaryStage.setScene(scene);
          primaryStage.show();
          
          go1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               String SelectedOption = (String) EmployeeOptions.getValue();

               if (SelectedOption.equals("Add employee")){
                    primaryStage.close();
                    addEmployeeFrame addEmployee = new addEmployeeFrame();
                    Stage s = new Stage();
                    addEmployee.start(s);
               }
//               else if (SelectedOption.equals("Delete employee")){
//                    primaryStage.close();
//                    deleteEmployeeFrame deleteEmployee = new deleteEmployeeFrame();
//                    Stage s = new Stage();
//                    deleteEmployee.start(s);
//               }
               
               else if (SelectedOption.equals("Update/Delete employee")){
                    primaryStage.close();
                    updateEmployeeFrame updateEmployee = new updateEmployeeFrame();
                    Stage s = new Stage();
                    updateEmployee.start(s);
               }
                
            }
        });
          
          go2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               String SelectedOption = (String) CustomerOptions.getValue();

               if (SelectedOption.equals("Add customer")){
                    primaryStage.close();
                    addCustomerFrame addCustomer = new addCustomerFrame();
                    Stage s = new Stage();
                    addCustomer.start(s);
               }
//               else if (SelectedOption.equals("Delete customer")){
//                    primaryStage.close();
//                    deleteCustomerFrame deleteCustomer = new deleteCustomerFrame();
//                    Stage s = new Stage();
//                    deleteCustomer.start(s);
//               }
               
               else if (SelectedOption.equals("Update/Delete customer")){
                    primaryStage.close();
                    updateCustomerFrame updateCustomer = new updateCustomerFrame();
                    Stage s = new Stage();
                    updateCustomer.start(s);
                   }
                
                }
            });
          
          reports.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent t) {
                  primaryStage.close();
                  reportsFrame repoerts = new reportsFrame();
                  Stage s = new Stage();
                  repoerts.start(s);
                }
            });
            
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
          
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
