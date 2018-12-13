/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import core.item;
import java.util.Date;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 1300180
 */
public class InvoiveFrame extends Application {
    Stage window;
    TableView<item> table;
    TextField nameInput, IDInput, PriceInput, ExpiredDateInput, QuantityInput;
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        
        //Name column
        TableColumn<item, String> nameColumn = new TableColumn<>("Item Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        
        //ID column
        TableColumn<item, String> idColumn = new TableColumn<>("ID");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("itemID"));   
        
        //Price column
        TableColumn<item, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        
        //ItemExpiredDate column
        TableColumn<item, Date> expireddateColumn = new TableColumn<>("Expired Date");
        expireddateColumn.setMinWidth(200);
        expireddateColumn.setCellValueFactory(new PropertyValueFactory<>("itemExpiredDate"));

        //Quantity column
        TableColumn<item, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        
        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);
        
        //ID input
        IDInput = new TextField();
        IDInput.setPromptText("ID");
        IDInput.setMinWidth(100);
        
        //Price input
        PriceInput = new TextField();
        PriceInput.setPromptText("Price");
        PriceInput.setMinWidth(100);
        
        //Expired date input
        ExpiredDateInput = new TextField();
        ExpiredDateInput.setPromptText("ExpiredDate");
        ExpiredDateInput.setMinWidth(100);
        //Quantity input
        QuantityInput = new TextField();
        QuantityInput.setPromptText("Quantity");
        QuantityInput.setMinWidth(100);        

        //Buttons
        Button addButton = new Button ("Add");
        Button deleteButton = new Button ("Delete");
        
        
        HBox hBox = new HBox();
        hBox.setPadding (new Insets (10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput,IDInput, PriceInput, ExpiredDateInput, QuantityInput, addButton, deleteButton);
        table = new TableView<>();
        table.setItems(getItem());
        table.getColumns().addAll(nameColumn, idColumn, priceColumn, expireddateColumn, quantityColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public ObservableList<item> getItem(){
        ObservableList<item> items = FXCollections.observableArrayList();
        
        return items;
        
    }
}
