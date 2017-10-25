/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableviewdemo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Yasser Muhamed
 */
public class TableViewDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        // define table view
        ObservableList<Accounts> accountList = FXCollections.observableArrayList(
        
        new Accounts("YASSER" , " 646456 " , "Admin"),
        new Accounts("jena" , " 49874156 " , "user"),
        new Accounts("salem" , " 214dskj " , "developer"),
        new Accounts("Asmaa" , " fdkhdl " , "designer"),
        new Accounts("Ahmed" , " ewygwfj " , "QA"),
        new Accounts("Omnia" , " dsgdsjhds " , "tester")
         );
        // define tableView
        
        TableView<Accounts> tableViewAccounts = new TableView<>(accountList);
   
        
        TableColumn<Accounts , String > fUsername = new TableColumn<>("User Name");
        fUsername.setCellValueFactory( new PropertyValueFactory<> ("username") );
        tableViewAccounts.getColumns().add(fUsername);
        
         
        TableColumn<Accounts , String > fPassword = new TableColumn<>("Password");
        fPassword.setCellValueFactory( new PropertyValueFactory<> ("password") );
        tableViewAccounts.getColumns().add(fPassword);
        
         TableColumn<Accounts , String > fType = new TableColumn<>("Account Type ");// title
        fType.setCellValueFactory( new PropertyValueFactory<> ("type") );
        tableViewAccounts.getColumns().add(fType);
        
        tableViewAccounts.setPrefSize(300, 300);
        
        
        // Access Events
        
        TableView.TableViewSelectionModel<Accounts> tableViewSelectionModel = tableViewAccounts.getSelectionModel();
        tableViewSelectionModel.selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
               int index = (int) newValue ;
                System.out.println("Nmae : "  + accountList.get(index).getUsername());
            }
        }
          );
        
        
        FlowPane root = new FlowPane();
        root.getChildren().add(tableViewAccounts);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
