/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.services;
import com.linkar.tn.entities.Avis;
import com.linkar.tn.Iservice.AddAvis ;
import com.linkar.tn.technics.DataSource;
import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author WIKI
 */
public class Ajouter_Avis implements AddAvis{
public Connection cnx ;

    public Ajouter_Avis() {
        
        cnx = DataSource. getDataSource().getConnection();
    }



    @Override
    public void AjouterAvis(Avis A) {
          try {
        String requete = "insert into feedback (rating,feedback,id_member,id_rater) values (?,?,?,?)";
  
        java.sql.PreparedStatement ps = cnx.prepareStatement(requete) ;
        ps.setDouble(1,A.getRating());
        ps.setString(2,A.getFeed_back());
        ps.setInt(3,A.getM().getId_member());
        ps.setInt(4,A.getId_rater());
        ps.executeUpdate();
        
         System.err.println("rate");
        
        
        
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(Ajouter_Avis.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
    }
    
    
    
    
    
    
}
