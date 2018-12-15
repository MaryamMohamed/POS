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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author 1300180
 */
public class addEmployeeFrame extends AdminDashboard {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Add Employee Panel");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Label loginLabel = new Label("ADD EMPLOYEE");
        loginLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        grid.add(loginLabel, 0, 0);

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
        grid.add(EPhone, 0, 5);

        final TextField EP = new TextField();
        grid.add(EP, 1, 5);
////////////////////////////////////        
        Label EAdress = new Label("Employee Adress:");
        grid.add(EAdress, 0, 4);

        final TextField EA = new TextField();
        grid.add(EA,1, 4);
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
              if(!EId.getText().equals("")&&!EF.getText().equals("")&&!EL.getText().equals("")&&!EP.getText().equals("")&&!EA.getText().equals("")){
                  employee E = new employee();
                  E.setID(Integer.parseInt(EId.getText()));
                  E.setFristName(EF.getText());
                  E.setLastName(EL.getText());
                  E.setPhoneNumber(EP.getText());
                  E.setAdress(EA.getText());
                if(E.addemployee())
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
