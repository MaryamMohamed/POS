/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import GUI.AdminDashboard;
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
import javafx.stage.Stage;
import core.FileManger;
import core.Customer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
/**
 *
 * @author 1300180
 */
public class addCustomerFrame extends AdminDashboard {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Add Customer Panel");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));


        Label loginLabel = new Label("ADD CUSTOMER");
        loginLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        grid.add(loginLabel, 0, 0);

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
        grid.add(CPhone, 0, 5);

        final TextField CP = new TextField();
        grid.add(CP, 1, 5);
////////////////////////////////////        
        Label CAdress = new Label("Customer Adress:");
        grid.add(CAdress, 0, 4);

        final TextField CA = new TextField();
        grid.add(CA, 1, 4);
///////////////////////////////////        
        Button addButton = new Button("Add");
        
        grid.add(addButton, 1, 7);
///////////////////////////////////
        Button back = new Button("Back");
       
        grid.add(back, 0, 7);
///////////////////////////////////
        final Text actiontarget = new Text();
        
        grid.add(actiontarget, 1, 9);
//////////////////////////////////
        Scene scene = new Scene(grid, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
/////////////////////////////////        
        
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               primaryStage.close();
               AdminDashboard admin = new AdminDashboard();
               Stage s = new Stage();
               admin.start(s);
            }
        });
////////////////////////////////////        
        
        addButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
              if(!CId.getText().equals("")&&!CF.getText().equals("")&&!CL.getText().equals("")&&!CP.getText().equals("")&&!CA.getText().equals("")){
                  Customer C = new Customer();
                  C.setID(Integer.parseInt(CId.getText()));
                  C.setFristName(CF.getText());
                  C.setLastName(CL.getText());
                  C.setPhoneNumber(CP.getText());
                  C.setAdress(CA.getText());
                if(C.addCustomer())
                {
                    actiontarget.setFill(Color.GREEN);
                    actiontarget.setText("Added Successfully ... !");
                }
                else
                {
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("Failed to insert ... !");
                }
              }
              else{
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("Missing required Fields!\nPlease, complete them before submit!");
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
