/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.entities;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author WIKI
 */
public class Ratings {
    
   // public SimpleIntegerProperty id_rater ;
   public SimpleDoubleProperty rating ;
    public SimpleStringProperty feedback ;

    public Ratings(double rating, String feedback) {
      //  this.id_rater =  new SimpleIntegerProperty(id_rater);
        this.rating =  new SimpleDoubleProperty(rating);
        this.feedback = new SimpleStringProperty(feedback);
    }

//    public Integer getId_rater() {
//        return id_rater.get();
//    }

  

    public Double getRating() {
        return rating.get();
    }

    public String getFeedback() {
        return feedback.get();
    }
    
    
    
    
    
    
}
