/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author WIKI
 */
public class TableData {
    public SimpleStringProperty nom ;
   public SimpleStringProperty num ;
   
     public SimpleStringProperty email ;

    public TableData(String nom , String num , String email) {
        this.nom = new SimpleStringProperty(nom) ;
        this.email = new SimpleStringProperty(email);
        this.num = new SimpleStringProperty(num);
        
    }

    public String getNom() {
        return nom.get();
    }

    public String getNum() {
        return num.get();
    }

    

    public String getEmail() {
        return email.get();
    }

}
