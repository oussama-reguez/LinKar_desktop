package com.linkar.tn.services;

import com.linkar.tn.Iservices.MembreIService;
import com.linkar.tn.entities.Membre;
import com.linkar.tn.technique.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rishya
 */
public class MembreServices implements MembreIService {

    private Connection cnx;

    public MembreServices() {
        cnx = DataSource.getInstance().getMyConnection();
    }

    @Override
    public void add(Membre m) {
        System.out.println("Done");
        String req = "insert into membre (last_name,first_name,birth,email,password,phone_number,gender,verif_number,verif_cin,verif_email,role,url_cin,url_picture,address,sms_code) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, m.getLast_name());
            ps.setString(2, m.getFirst_name());
            ps.setDate(3, m.getBirth());
            ps.setString(4, m.getEmail());
            ps.setString(5, m.getPassword());
            ps.setString(6, m.getPhone_number());
            ps.setString(7, m.getGender());
            ps.setBoolean(8, m.isVerif_number());
            ps.setBoolean(9, m.isVerif_cin());
            ps.setBoolean(10, m.isVerif_email());
            ps.setBoolean(11, m.isRole());
            ps.setString(12, m.getUrl_cin());
            ps.setString(13, m.getUrl_picture());
            ps.setString(14, m.getAddress());
            ps.setInt(15, m.getSms_code());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MembreServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Done");
    }

    @Override
    public void edit(int id, String last_name, String first_name, Date birth, String phone_number, String address, String email) {
        String req = "update membre set last_name=?,"
                + "first_name=?,"
                + "birth=?,"
                + "phone_number=?,"
                + "address=?,"
                + "email=? where id_member=?";
        System.out.println(req);
        try {
            cnx.setAutoCommit(false);
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, last_name);
            ps.setString(2, first_name);
            ps.setDate(3, birth);
            ps.setString(4, phone_number);
            ps.setString(5, address);
            ps.setString(6, email);
            ps.setInt(7, id);
            ps.executeUpdate();
            cnx.commit();
            cnx.setAutoCommit(true);
            System.out.println("Modification effectuée!");
        } catch (SQLException ex) {
            Logger.getLogger(MembreServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editPass(int id, String pass) {
        String reqpass = "UPDATE `linkar`.`membre` SET `password` = '" + pass + "' WHERE `membre`.`id_member` = " + id;
        System.out.println(reqpass);
        try {
            cnx.setAutoCommit(false);
            PreparedStatement p = cnx.prepareStatement(reqpass);
            p.executeUpdate();
            cnx.commit();
            cnx.setAutoCommit(true);

        } catch (SQLException ex) {
            Logger.getLogger(MembreServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editVerif_number(int id) {
        int state = 1;
        String req = "UPDATE `linkar`.`membre` SET `verif_number` = '" + state + "' WHERE `membre`.`id_member` = " + id;
        System.out.println(req);
        try {
            cnx.setAutoCommit(false);
            PreparedStatement p = cnx.prepareStatement(req);
            p.executeUpdate();
            cnx.commit();
            cnx.setAutoCommit(true);

        } catch (SQLException ex) {
            Logger.getLogger(MembreServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Membre m) {
        String req = "delete from membre where id_member=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, m.getId_member());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MembreServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Membre getById(Integer id) {
        String req = "select * from membre where id_member =?";
        Membre m = null;
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new Membre(rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(8), rs.getString(9), rs.getBoolean(10), rs.getBoolean(11), rs.getBoolean(12), rs.getBoolean(13), rs.getString(15), rs.getString(14), rs.getString(7), rs.getInt(18));
            }
        } catch (Exception e) {
        }
        return m;
    }

}
