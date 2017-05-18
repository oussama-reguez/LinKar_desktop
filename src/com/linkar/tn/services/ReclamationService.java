package com.linkar.tn.services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.linkar.tn.entities.Reclamation;

import com.linkar.tn.Iservice.ReclamationIService;
import com.linkar.tn.technics.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oussama Reguez
 */
public class ReclamationService implements ReclamationIService {
 private Connection cnx;
    public ReclamationService(){
         cnx=DataSource.getDataSource().getConnection();
    }
    @Override
    public void addReclamation(Reclamation r) {
    String sql="INSERT INTO `reclamation`(`id_membre`, `date_reclamation`, `text`) VALUES (?,?,?)";
    try {
            PreparedStatement prepared = cnx.prepareStatement(sql);
            prepared.setInt(1,r.getMembre().getId_member());
            prepared.setDate(2, r.getDate_Reclamation());
            prepared.setString(3, r.getText());
           
            prepared.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeReclamation(Reclamation r) {
       String req = "delete from reclamation where id = ?";
        try {
          PreparedStatement  ps = cnx.prepareStatement(req);
            ps.setInt(1, r.getId_reclamation());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyReclamation(Reclamation r) {
       String sql="UPDATE `reclamation` SET `id_membre`=?,`date_reclamation`=?,`text`=? WHERE id_reclamation=?";
    try {
            PreparedStatement prepared = cnx.prepareStatement(sql);
            prepared.setInt(1,r.getMembre().getId_member());
            prepared.setDate(2, r.getDate_Reclamation());
            prepared.setString(3, r.getText());
             prepared.setInt(4,r.getId_reclamation());
           
            prepared.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Reclamation getReclamationById(int id) {
         String sql="select * from reclamation WHERE id_reclamation=?";
         Reclamation r= null;
    try {
            PreparedStatement prepared = cnx.prepareStatement(sql);
           
             prepared.setInt(1,id);
           
           ResultSet rs= prepared.executeQuery();
          while (rs.next()) {
                r = new Reclamation(rs.getInt(1),null,rs.getString(4),rs.getDate(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return r;
    }

    public void markReclamation(boolean mark,int id_reclamation){
        String sql="UPDATE `reclamation` SET marked=? WHERE id_reclamation=?";
    try {
            PreparedStatement prepared = cnx.prepareStatement(sql);
           prepared.setBoolean(1,mark);
            prepared.setInt(2,id_reclamation);
           
           
           
            prepared.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    MembreServices membreService = new MembreServices();
    @Override
    public List<Reclamation> getAllReclamation() {
        String sql="select * from reclamation ";
         Reclamation r= null;
         List<Reclamation> reclamations=new ArrayList<>();
    try {
            PreparedStatement prepared = cnx.prepareStatement(sql);
           
             
           
           ResultSet rs= prepared.executeQuery();
          while (rs.next()) {
                r = new Reclamation(rs.getInt(1),membreService.getMembre(rs.getInt(2)),rs.getString(4),rs.getDate(3),rs.getString("type"),rs.getString("subject"),rs.getBoolean("marked"));
                reclamations.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return reclamations;
    }
    
      public List<Reclamation> getAllReclamation(boolean marked) {
        String sql="select * from reclamation where marked = ? ";
         Reclamation r= null;
         List<Reclamation> reclamations=new ArrayList<>();
    try {
            PreparedStatement prepared = cnx.prepareStatement(sql);
           
             prepared.setBoolean(1, marked);
           
           ResultSet rs= prepared.executeQuery();
          while (rs.next()) {
                r = new Reclamation(rs.getInt(1),membreService.getMembre(rs.getInt(2)),rs.getString(4),rs.getDate(3),rs.getString("type"),rs.getString("subject"),rs.getBoolean("marked"));
                reclamations.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return reclamations;
    }
    
}
