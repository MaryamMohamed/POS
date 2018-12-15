/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import GUI.AdminDashboard;
import core.employee;
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
public class updateEmployeeFrame extends AdminDashboard {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Update Employee Panel");
          GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(20);
            grid.setVgap(20);
            grid.setPadding(new Insets(25, 25, 25, 25));

        Label IdL = new Label("Employee ID:");
        grid.add(IdL, 0, 0);

        final TextField search = new TextField();
        grid.add(search, 1, 0);
        
        Button searchButton = new Button("search");
        grid.add(searchButton, 2, 0);
//////////////////////////////////
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1,1);
///////////////////////////////////        
        Label Id = new Label("Employee ID:");
        grid.add(Id, 0, 2);

        final TextField EId = new TextField();
        grid.add(EId, 1, 2);
///////////////////////////////////
        Label EFname = new Label("Employee First Name:");
        grid.add(EFname, 0, 3);

        final TextField EF = new TextField();
        grid.add(EF, 1, 3);
// ///////////////////////////////       
        Label CLname = new Label("Employee Last Name:");
        grid.add(CLname, 0, 4);

        final TextField EL = new TextField();
        grid.add(EL, 1, 4);
//////////////////////////////////        
        Label CPhone = new Label("Employee Phone:");
        grid.add(CPhone, 0, 6);

        final TextField EP = new TextField();
        grid.add(EP, 1, 6);
////////////////////////////////////        
        Label CAdress = new Label("Employee Adress:");
        grid.add(CAdress, 0, 5);

        final TextField EA = new TextField();
        grid.add(EA, 1, 5);
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
            employee E = new employee();
            @Override
            public void handle(ActionEvent e) {
                
              if(!search.getText().equals("")){
                 
                  employee returned = E.searchemployeeById(Integer.parseInt(search.getText()));
                  if (returned.getID() != 0) {
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

            private void setPanelData(employee e) {
                      EId.setText(""+E.getID());
                      EF.setText(""+E.getFristName());
                      EL.setText(""+E.getLastName());
                      EP.setText(""+E.getAdress());
                      EA.setText(""+E.getPhoneNumber());
                
            }
        });
        

    
        updateButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
              if(!EId.getText().equals("")&&!EF.getText().equals("")&&!EL.getText().equals("")&&!EP.getText().equals("")&&!EA.getText().equals("")){
                  employee E = new employee();
                  E.setID(Integer.parseInt(EId.getText()));
                  E.setFristName(EF.getText());
                  E.setLastName(EL.getText());
                  E.setPhoneNumber(EP.getText());
                  E.setAdress(EA.getText());
                if(E.updateEmployee())
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
                  employee E = new employee();
                if(E.deleteEmployee(Integer.parseInt(EId.getText())))
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
