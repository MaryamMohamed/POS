/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import GUI.AdminDashboard;
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

/**
 *
 * @author 1300180
 */
public class updateCustomerFrame extends AdminDashboard {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Update Customer Panel");
          GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(20);
            grid.setVgap(20);
            grid.setPadding(new Insets(25, 25, 25, 25));

        Label IdL = new Label("Customer ID:");
        grid.add(IdL, 0, 0);

        final TextField search = new TextField();
        grid.add(search, 1, 0);
        
        Button searchButton = new Button("search");
        grid.add(searchButton, 2, 0);
//////////////////////////////////
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1,1);
///////////////////////////////////        
        Label Id = new Label("Customer ID:");
        grid.add(Id, 0, 2);

        final TextField CId = new TextField();
        grid.add(CId, 1, 2);
///////////////////////////////////
        Label CFname = new Label("Customer First Name:");
        grid.add(CFname, 0, 3);

        final TextField CF = new TextField();
        grid.add(CF, 1, 3);
// ///////////////////////////////       
        Label CLname = new Label("Customer Last Name:");
        grid.add(CLname, 0, 4);

        final TextField CL = new TextField();
        grid.add(CL, 1, 4);
//////////////////////////////////        
        Label CPhone = new Label("Customer Phone:");
        grid.add(CPhone, 0, 5);

        final TextField CP = new TextField();
        grid.add(CP, 1, 5);
////////////////////////////////////        
        Label CAdress = new Label("Customer Adress:");
        grid.add(CAdress, 0, 6);

        final TextField CA = new TextField();
        grid.add(CA, 1, 6);
///////////////////////////////////   
        Button updateButton = new Button("UPDATE");
        
        grid.add(updateButton, 1, 7);
        
///////////////////////////////////   
        Button deleteButton = new Button("DELETE");
        
        grid.add(deleteButton, 2, 7);
///////////////////////////////////
        Button back = new Button("Back");
       
        grid.add(back, 0, 7);
///////////////////////////////////
        Scene scene = new Scene(grid, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
///////////////////////////////////        
        
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               primaryStage.close();
               AdminDashboard admin = new AdminDashboard();
               Stage s = new Stage();
               admin.start(s);
            }
        });
//////////////////////////////////////        
        
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            Customer C = new Customer();
            @Override
            public void handle(ActionEvent e) {
              if(!search.getText().equals("")){
                  
                  Customer returned = C.searchCustomerById(Integer.parseInt(search.getText()));
                  if (returned.getID() > 0) {
                      setPanelData(returned);
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
            private void setPanelData(Customer c) {
                      CId.setText(""+C.getID());
                      CF.setText(""+C.getFristName());
                      CL.setText(""+C.getLastName());
                      CP.setText(""+C.getAdress());
                      CA.setText(""+C.getPhoneNumber());
            }
        });
        
        updateButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
              if(!CId.getText().equals("")&&!CF.getText().equals("")&&!CL.getText().equals("")&&!CP.getText().equals("")&&!CA.getText().equals("")){
                  Customer C = new Customer();
                  C.setID(Integer.parseInt(CId.getText()));
                  C.setFristName(CF.getText());
                  C.setLastName(CL.getText());
                  C.setPhoneNumber(CP.getText());
                  C.setAdress(CA.getText());
                  
                if(C.updateCustomer())
                {
                    actiontarget.setFill(Color.GREEN);
                    actiontarget.setText("Updated Successfully ... !");
                }
                else
                {
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("Failed to Update ... !");
                }
              }
              else{
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("Missing required Fields!\nPlease, complete them before submit!");
              }               
            }
        });
        
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
              if(!search.getText().equals("")){
                  Customer C = new Customer();
                if(C.deleteCustomer(Integer.parseInt(CId.getText())))
                {
                    actiontarget.setFill(Color.GREEN);
                    actiontarget.setText("Deleted Successfully ... !");
                }
                else
                {
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("Failed to Deleted ... !");
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
