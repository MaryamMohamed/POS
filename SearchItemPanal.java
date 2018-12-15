/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import GUI.AdminDashboard;
import core.item;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author 1300180
 */
public class SearchItemPanal extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Search Item Panal");
          GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(20);
            grid.setVgap(20);
            grid.setPadding(new Insets(25, 25, 25, 25));

        Label IdL = new Label("Item ID:");
        grid.add(IdL, 0, 0);

        final TextField search = new TextField();
        grid.add(search, 1, 0);
        
        Button searchButton = new Button("search");
        grid.add(searchButton, 2, 0);
//////////////////////////////////
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1,1);
///////////////////////////////////        
        Label Id = new Label("ItemID:");
        grid.add(Id, 0, 2);

        final Label EId = new Label();
        grid.add(EId, 1, 2);
///////////////////////////////////
        Label EFname = new Label("Item Name:");
        grid.add(EFname, 0, 3);

        final Label EF = new Label();
        grid.add(EF, 1, 3);
// ///////////////////////////////       
        Label CLname = new Label("Item Price:");
        grid.add(CLname, 0, 4);

        final Label EL = new Label();
        grid.add(EL, 1, 4);
//////////////////////////////////        
        Label CPhone = new Label("Item Quantity:");
        grid.add(CPhone, 0, 6);

        final Label EP = new Label();
        grid.add(EP, 1, 6);
////////////////////////////////////        
        Label CAdress = new Label("Item expired date:");
        grid.add(CAdress, 0, 5);

        final Label EA = new Label();
        grid.add(EA, 1, 5);
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
               itemFrame admin = new itemFrame();
               Stage s = new Stage();
               admin.start(s);
            }
        });
//////////////////////////////////////        

searchButton.setOnAction(new EventHandler<ActionEvent>() {
            item E = new item();
            @Override
            public void handle(ActionEvent e) {
                
              if(!search.getText().equals("")){
                 
                  item returned = E.searchItemById(search.getText());
                  if (returned.getItemID() != null) {
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

            private void setPanelData(item e) {
                      EId.setText(""+E.getItemID());
                      EF.setText(""+E.getItemName());
                      EL.setText(""+E.getItemPrice());
                      EP.setText(""+E.getQuantity());
                      EA.setText(""+E.getItemExpiredDate());
                
            }
        });
        
    }
    
}
