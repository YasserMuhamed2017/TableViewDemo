/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableviewdemo;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Yasser Muhamed
 */
public class Accounts {
    public SimpleStringProperty username = new SimpleStringProperty("");
    public SimpleStringProperty password = new SimpleStringProperty("");
    public SimpleStringProperty type = new SimpleStringProperty("");
    
    public Accounts(String username , String password , String type){
       this.username.set(username);
       this.password.set( password);
       this.type.set(type);
                
    }
    public String getUsername(){
        return username.get();
    }
    public String getPassword(){
        return password.get();
    }
    public String getType(){
        return type.get();
    }
    
}
