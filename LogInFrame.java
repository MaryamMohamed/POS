/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
public class LogInFrame extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label loginLabel = new Label("Login");
        loginLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        grid.add(loginLabel, 0, 0);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        Label passwordLable = new Label("Password:");
        grid.add(passwordLable, 0, 2);

        TextField userNameTF = new TextField();
        grid.add(userNameTF, 1, 1);

        PasswordField passwordPF = new PasswordField();
        grid.add(passwordPF, 1, 2);
        Button loginButton = new Button("Sign in");
        GridPane.setHalignment(loginButton, HPos.RIGHT);
        grid.add(loginButton, 1, 5);        
        
        
        Scene scene = new Scene(grid, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();  
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        loginButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
              
                if(userNameTF.getText().equals("Admin")&&passwordPF.getText().equals("Admin1234"))
                {
                    primaryStage.close();
                    AdminDashboard adminDB = new AdminDashboard();
                    try {
                        Stage s = new Stage();
                        adminDB.start(s);

                    } catch (Exception ex) {
                        Logger.getLogger(LogInFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(userNameTF.getText().equals("Employee")&&passwordPF.getText().equals("Employee1234"))
                {
                    primaryStage.close();
                    EmployeeDashboard adminDB = new EmployeeDashboard();
                    try {
                        Stage s = new Stage();
                        adminDB.start(s);

                    } catch (Exception ex) {
                        Logger.getLogger(LogInFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("Invalid Username and Password!");
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
