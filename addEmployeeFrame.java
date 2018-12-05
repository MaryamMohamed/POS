/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

//import core.Employee;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;

/**
 *
 * @author 1300180
 */
public class addEmployeeFrame extends Application{
    
    @Override
    public void start(final Stage stage) {
        stage.setTitle("Add Employee Panel");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));
//////////////////////////////////        
        Label Id = new Label("Employee ID:");
        grid.add(Id, 0, 1);

        final TextField EId = new TextField();
        grid.add(EId, 1, 1);
//////////////////////////////////
        Label EFname = new Label("Employee First Name:");
        grid.add(EFname, 0, 2);

        final TextField EF = new TextField();
        grid.add(EF, 1, 2);
// ///////////////////////////////       
        Label ELname = new Label("Employee Last Name:");
        grid.add(ELname, 0, 3);

        final TextField EL = new TextField();
        grid.add(EL, 1, 3);
//////////////////////////////////        
        Label EPhone = new Label("Employee Phone:");
        grid.add(EPhone, 0, 4);

        final TextField EP = new TextField();
        grid.add(EP, 1, 4);
////////////////////////////////////        
        Label EAdress = new Label("Employee Adress:");
        grid.add(EAdress, 0, 5);

        final TextField EA = new TextField();
        grid.add(EA, 1, 5);
///////////////////////////////////        
        Button addButton = new Button("Add");
        
        grid.add(addButton, 1, 7);
///////////////////////////////////
        Button back = new Button("Back");
       
        grid.add(back, 0, 7);
//////////////////////////////////        
        Scene scene = new Scene(grid, 500, 400);
        stage.setScene(scene);
        stage.show();   
/////////////////////////////////
        /*addButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               Employee E = new Employee(Integer.valueOf(EId.getText()), EF.getText(), EL.getText(), Integer.valueOf(EP.getText()), EA.getText());
               E.write(E);
               
               stage.close();
               AdminPanel admin = new AdminPanel();
               Stage s = new Stage();
               admin.start(s);                
            }
        });
        
       */ 
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               stage.close();
               AdminPanel admin = new AdminPanel();
               Stage s = new Stage();
               admin.start(s);
            }
        });    
    }
    
}
