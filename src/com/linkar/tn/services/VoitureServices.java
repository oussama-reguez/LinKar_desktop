/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.services;

import com.linkar.tn.Iservices.VoitureIService;
import com.linkar.tn.entities.Voiture;
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
 * @author Rishya
 */
public class VoitureServices implements VoitureIService {

    private Connection cnx;

    public VoitureServices() {
        cnx = DataSource.getDataSource().getConnection();
    }

    @Override
    public void addvoiture(Voiture v) {
        System.out.println("Done");
        String req = "insert into linkar.voiture (brand,model,id_member,confort,number_places,url_car_selfie,color) values (?,?,?,?,?,?,?)";
        try {
            cnx.setAutoCommit(false);
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, v.getBrand());
            ps.setString(2, v.getModel());
            ps.setInt(3, v.getId_member());
            ps.setString(4, v.getConfort());
            ps.setInt(5, v.getNumber_places());
            ps.setString(6, v.getUrl_car_selfie());
            ps.setString(7, v.getColor());
            System.out.println("Voiture ajoutée");
            ps.executeUpdate();
            cnx.commit();
            cnx.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(MembreServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Voiture v) {
        String req = "delete from voiture where id_voiture=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, v.getId_voiture());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MembreServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Voiture> getAllCars(Integer id) {
        String req = "select * from voiture where id_member =?";
        List<Voiture>voitures=new ArrayList<>();
        Voiture v = null;
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                v = new Voiture(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8));
                voitures.add(v);
            }
        } catch (Exception e) {
        }
        return voitures;
    }
}
