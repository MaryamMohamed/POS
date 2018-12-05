/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.application.Application;
import javafx.stage.Stage;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


/**
 *
 * @author 1300180
 */
public class AdminPanel extends Application{
    
    @Override
    public void start(final Stage stage) {
        stage.setTitle("Admin page");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Choose your operation");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0);
        
        final ComboBox SAOptions = new ComboBox();
        SAOptions.getItems().addAll(
            "Add customer",
            "Delete customer",
            "Update customer",
            "Add employee",            
            "Delete employee",
            "Update employee"
        );
        SAOptions.getSelectionModel().selectFirst();
        grid.add(SAOptions, 0, 1);
        
        Button btn = new Button("     Ok     ");
        GridPane.setHalignment(btn, HPos.RIGHT);
        grid.add(btn, 2, 1);
        
        Button reports = new Button("My Reports");
        grid.add(reports, 0, 2);
        
        Button SignOut = new Button("Sign Out");
        grid.add(SignOut, 2, 3);
        
        
        Scene scene = new Scene(grid, 500, 400);
        stage.setScene(scene);
        stage.show();
        
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               String SelectedOption = (String) SAOptions.getValue();
               if (SelectedOption.equals("Add customer")){
                    stage.close();
                    addCustomerFrame addC = new addCustomerFrame();
                    Stage s = new Stage();
                    addC.start(s);
               }
               else if (SelectedOption.equals("Delete customer")){
                    stage.close();
                    deleteCustomerFrame deleteC = new deleteCustomerFrame();
                    Stage s = new Stage();
                    deleteC.start(s);
               }
               
               else if (SelectedOption.equals("Update customer")){
                    stage.close();
                    updateCustomerFrame updateC = new updateCustomerFrame();
                    Stage s = new Stage();
                    updateC.start(s);
               }
               
               else if (SelectedOption.equals("Add employee")){
                    stage.close();
                    addEmployeeFrame addE = new addEmployeeFrame();
                    Stage s = new Stage();
                    addE.start(s);
               }
               
               else if (SelectedOption.equals("Delete employee")){
                    stage.close();
                    deleteEmployeeFrame deleteE = new deleteEmployeeFrame();
                    Stage s = new Stage();
                    deleteE.start(s);
               }
               
               else if (SelectedOption.equals("Update employee")){
                    stage.close();
                    updateEmployeeFrame updateE = new updateEmployeeFrame();
                    Stage s = new Stage();
                    updateE.start(s);
               }
                
            }
        });
        
        reports.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent c) {
               stage.close();
                    reportsFrame RF = new reportsFrame();
                    try {
                        Stage s = new Stage();
                        RF.start(s);

                    } catch (Exception ex) {
                        Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        });
        
        SignOut.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               stage.close();
            }
        });

    }
    
}
