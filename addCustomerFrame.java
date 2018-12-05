/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import core.customer;
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
public class addCustomerFrame extends Application{
    
    @Override

    public void start(final Stage stage) {
        stage.setTitle("Add Customer Panel");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));
//////////////////////////////////        
        Label Id = new Label("Customer ID:");
        grid.add(Id, 0, 1);

        final TextField CId = new TextField();
        grid.add(CId, 1, 1);
//////////////////////////////////
        Label CFname = new Label("Customer First Name:");
        grid.add(CFname, 0, 2);

        final TextField CF = new TextField();
        grid.add(CF, 1, 2);
// ///////////////////////////////       
        Label CLname = new Label("Customer Last Name:");
        grid.add(CLname, 0, 3);

        final TextField CL = new TextField();
        grid.add(CL, 1, 3);
//////////////////////////////////        
        Label CPhone = new Label("Customer Phone:");
        grid.add(CPhone, 0, 4);

        final TextField CP = new TextField();
        grid.add(CP, 1, 4);
////////////////////////////////////        
        Label CAdress = new Label("Customer Adress:");
        grid.add(CAdress, 0, 5);

        final TextField CA = new TextField();
        grid.add(CA, 1, 5);
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
    /*    addButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               customer C = new customer(Integer.valueOf(CId.getText()), CF.getText(), CL.getText(), Integer.valueOf(CP.getText()), CA.getText());
               C.write(C);
               
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
