/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.services;
import Entities.TableData;
import RecService.ListData ;
import com.linkar.tn.technics.DataSource;
import java.sql.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WIKI
 */
public class LstData implements ListData {
private Connection cnx ;
    public LstData() {
        cnx = DataSource.getDataSource().getConnection();
 
        
        
    }
    
    

    @Override
    public ObservableList<TableData> lister() {
        
        ObservableList<TableData> data = FXCollections.observableArrayList();
        TableData tb;
        
        try {
           String requete2 = "Select * from membre";
           
            java.sql.Statement st = cnx.createStatement();
            
            ResultSet rs ;
    
        rs= st.executeQuery(requete2);
    while(rs.next()) {
            
            data.add(new TableData(rs.getString("first_name"),  rs.getString("phone_number"),rs.getString("email")) ) ;
        
    }
        
    }
        catch (SQLException ex) {
        Logger.getLogger(LstData.class.getName()).log(Level.SEVERE, null, ex);
    }
            
        return data ;
    



}

//    @Override
//    public List<TableData> findbyname(String first_name) {
//        
//         try {
//        String req = "select * from membre where first_name like ?";
//        List<TableData> list = new ArrayList<TableData>();
//        
//   
//        PreparedStatement ps = cnx.prepareStatement(req);
//        ps.setString(1,"%"+first_name+"%");
//        ResultSet rs = ps.executeQuery();
//        
//        while (rs.next()) {
//        
//            TableData tabledata = new TableData(rs.getString("first_name"), (int) rs.getDouble("phone_number"),rs.getString("email"));
//        
//        list.add(tabledata) ;
//        }
//        
//        return list ;
//        
//        
//    } catch (SQLException ex) {
//        Logger.getLogger(LstData.class.getName()).log(Level.SEVERE, null, ex);
//        
//        
//        
//    }
//         return null ;
//                }

    @Override
    public ObservableList<TableData> findbyname(String name) {
        
        ObservableList<TableData> data1 = FXCollections.observableArrayList();
        try {
        
           String requete3 = "SELECT * FROM  membre  where first_name like '"+name+"%'";
                 
    
        PreparedStatement ps1 = cnx.prepareStatement(requete3) ;
     
        ResultSet rs ;
        rs = ps1.executeQuery(requete3);
        
        while(rs.next()){
        
        data1.add(new TableData(rs.getString("first_name"),  rs.getString("phone_number"),rs.getString("email")));
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(LstData.class.getName()).log(Level.SEVERE, null, ex);
    }
           
           return data1 ;
        
    }
        
        
    }

