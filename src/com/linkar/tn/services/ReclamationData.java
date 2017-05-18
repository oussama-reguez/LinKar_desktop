/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.services;
import Entities.RecData;
import Entities.TableData;
import RecService.Rec_Data;
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
public class ReclamationData implements Rec_Data {

    private Connection cnx ;
    public ReclamationData() {
        cnx = DataSource.getDataSource().getConnection();

    }
    
    
    
    @Override
    public ObservableList<RecData> lister() {
         ObservableList<RecData> data = FXCollections.observableArrayList();
        TableData tb;
        
        try {
           String requete2 = "Select * from reclamation";
           
            java.sql.Statement st = cnx.createStatement();
            
            ResultSet rs ;
    
        rs= st.executeQuery(requete2);
    while(rs.next()) {
            
            data.add(new RecData(rs.getString("type"),rs.getString("subject"),rs.getString("text"))) ;
        
    }
        
    }
        catch (SQLException ex) {
        Logger.getLogger(LstData.class.getName()).log(Level.SEVERE, null, ex);
    }
            
        return data ;
    
        
        
    }
    
}
