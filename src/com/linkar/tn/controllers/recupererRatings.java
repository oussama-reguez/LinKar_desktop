/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.controllers;

import com.linkar.tn.Iservice.RecAvis;
import com.linkar.tn.entities.Ratings;
import com.linkar.tn.technics.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author WIKI
 */
public class recupererRatings implements RecAvis{
public Connection cnx ;
    public recupererRatings() {
        
        cnx = DataSource.getDataSource().getConnection();
        
    }

    @Override
    public ObservableList<Ratings> lister() {
        
        ObservableList<Ratings> ratings = FXCollections.observableArrayList();
         try {
        String requete = "select * from feedback";
   
        java.sql.Statement st = cnx.createStatement();
        ResultSet rs ;
        
        rs=st.executeQuery(requete) ;
        
        while (rs.next()) {
        
      ratings.add(new Ratings(rs.getDouble("rating"),rs.getString("feedback"))) ;
      
      
      
        }
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(recupererRatings.class.getName()).log(Level.SEVERE, null, ex);
    }
            
            return ratings;
    
        
        
    }
   
    
    
    
}
