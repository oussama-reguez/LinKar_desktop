/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.services;
import com.linkar.tn.entities.Message;
import com.linkar.tn.Iservice.Msg_Serv ;
import com.linkar.tn.technics.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author WIKI
 */
public class SendMsg implements Msg_Serv{

    private Connection cnx ;

    public SendMsg() {
        cnx = DataSource.getDataSource().getConnection();
        
    }
    
    @Override
    public void AddMsg(Message M) {
         try {
        String requete="insert into message (id_sender,id_receiver,seen,text,date) values(?,?,?,?,?)";
       
            PreparedStatement ps= cnx.prepareStatement(requete);
            ps.setInt(1,M.getId_sender());
            ps.setInt(2,M.getId_receiver());
            ps.setInt(3,M.getSeen());
            ps.setString(4,M.getText());
        //    ps.setInt(5,M.getA().getId_annonce());
            ps.setDate(5,M.getDate());
            ps.executeUpdate();
            
             System.err.println("Send");
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SendMsg.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
