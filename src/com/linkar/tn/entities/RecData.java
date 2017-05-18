/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author WIKI
 */
public class RecData {
    
    public  SimpleStringProperty type ;
    public SimpleStringProperty sujet ;
    public SimpleStringProperty description ;

    public RecData(String type , String sujet , String description) {
        this.type = new SimpleStringProperty(type) ;
        this.sujet = new SimpleStringProperty(sujet) ;
        this.description = new SimpleStringProperty(description) ;
        
        
    }
    
     public String getType() {
        return type.get();
    }

    public String getSujet() {
        return sujet.get();
    }

    

    public String getDescription(){
        return description.get();
    }
    
    
    
}
