/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.services;

import com.linkar.tn.entities.Reclamation;
import com.linkar.tn.Iservice.Reclama_Serv;
import com.linkar.tn.technics.DataSource;
import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author WIKI
 */
public class AddReclamation implements Reclama_Serv{
    
    private Connection cnx ;

    public AddReclamation() {
        cnx = DataSource.getDataSource().getConnection();
    }
    
    
    

    @Override
    public void addRec(Reclamation R) {
        
        
        try {
        String requete="insert into reclamation (id_membre,date_reclamation,text,subject,type) values (?,?,?,?,?)";
        
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1,R.getMembre().getId_member());
            ps.setDate(2, R.getDate_Reclamation());
            ps.setString(3,R.getText());
            ps.setString(4,R.getSubject());
            ps.setString(5,R.getType());
            
            ps.executeUpdate() ;
            
            System.err.println("Inserer");
       
            
        } catch (SQLException ex) {
            Logger.getLogger(AddReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   

    @Override
    public void affichRec(Reclamation R) {
        try {
        
        String requete2 = "Select * from reclamation";
        
            java.sql.Statement st = cnx.createStatement();
            
            ResultSet rs = st.executeQuery(requete2) ;
            while(rs.next()) {
            
            System.out.println("id_reclamation : "+rs.getInt(1));
                   System.out.println("id_membre : "+rs.getInt(2));
                 
                   System.out.println("Date : "+rs.getDate(3));
                   
                     System.out.println("Text : "+rs.getString(4));
                   
            
            
            
            
            
            
            
            }
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AddReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
