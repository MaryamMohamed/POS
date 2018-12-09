/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
public class LogIn extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(final Stage primaryStage) {
        
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
/*
        //ToggleGroup TG = new ToggleGroup();
        RadioButton r1 = new RadioButton("Admin");
        grid.add(r1, 0, 4);
        RadioButton r2 = new RadioButton("Employee");
        grid.add(r2, 1, 4);
       // TG.getToggles().addAll(r1,r2);
 */       
        Button loginButton = new Button("Sign in");
        GridPane.setHalignment(loginButton, HPos.RIGHT);
        grid.add(loginButton, 1, 5);        
        
        
        Scene scene = new Scene(grid, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();  
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
      
        loginButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
              
                if(userNameTF.getText().equals("Admin")&&passwordPF.getText().equals("Admin1234")) // مش عارفة اخليه يختار واحد بس
                {
                    primaryStage.close();
                    AdminPanel adminP = new AdminPanel();
                    try {
                        Stage s = new Stage();
                        adminP.start(s);

                    } catch (Exception ex) {
                        Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(userNameTF.getText().equals("Employee")&&passwordPF.getText().equals("Employee1234"))
                {
                    primaryStage.close();
                    EmployeePanel adminP = new EmployeePanel();
                    try {
                        Stage s = new Stage();
                        adminP.start(s);

                    } catch (Exception ex) {
                        Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("Invalid Username and Password!");
                }
            }
        });
    }
}

        /**/
    

