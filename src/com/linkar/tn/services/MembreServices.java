
package com.linkar.tn.services;

import com.esprit.tn.technique.DataSource;
import com.linkar.tn.Iservices.MembreIService;

import com.linkar.tn.entities.Membre;

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
public class MembreServices implements MembreIService{
    private Connection cnx;
    private PreparedStatement ps;
public MembreServices()
{
cnx=DataSource.getDataSource().getConnection();
}
    @Override
    public void add(Membre m) {
          System.out.println("Done");
	String req="insert into membre (last_name,first_name,birth,email,password,phone_number,gender,verif_number,verif_cin,verif_email,role,url_cin,url_picture,address) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
    try {
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setString(1,m.getLast_name());
        ps.setString(2,m.getFirst_name());
        ps.setDate(3,m.getBirth());
        ps.setString(4,m.getEmail());
		ps.setString(5,m.getPassword());
		ps.setDouble(6,m.getPhone_number());
		ps.setString(7,m.getGender());
		ps.setBoolean(8,m.isVerif_number());
		ps.setBoolean(9,m.isVerif_cin());
		ps.setBoolean(10,m.isVerif_email());
		ps.setBoolean(11,m.isRole());
		ps.setString(12,m.getUrl_cin());
		ps.setString(13,m.getUrl_picture());
		ps.setString(14,m.getAddress());
        ps.executeUpdate();
        System.out.println("Done");
    } catch (SQLException ex) {
        Logger.getLogger(MembreServices.class.getName()).log(Level.SEVERE, null, ex);
    }
	}
    @Override
    public void edit(Membre m) {
	String req="update membre set last_name=?,first_name=?,birth=?,phone_number=?,url_picture=?,address=? where id_member=?";
    try {
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setString(1,m.getLast_name());
        ps.setString(2,m.getFirst_name());
        ps.setDate(3,m.getBirth());
        ps.setDouble(4,m.getPhone_number());
        ps.setString(5,m.getUrl_picture());
        ps.setString(6,m.getAddress());
        ps.setInt(7,m.getId_member());
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(MembreServices.class.getName()).log(Level.SEVERE, null, ex);
    }
	}
        @Override
    public void editEmail(Membre m) {
	String req="update membre set email=? where id_member=?" ;
    try {
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setString(1,m.getEmail());
        ps.setInt(2,m.getId_member());
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(MembreServices.class.getName()).log(Level.SEVERE, null, ex);
    }
	}
        @Override
    public void editPass(Membre m) {
	String req="update membre set password=? where id_member=?" ;
    try {
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setString(1,m.getPassword());
        ps.setInt(2,m.getId_member());
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(MembreServices.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
	    @Override
    public void delete(Membre m) {
	String req="delete from membre where id_member=?" ;
    try {
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setInt(1,m.getId_member());
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
            ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                m = new Membre(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getBoolean(9),rs.getBoolean(10),rs.getBoolean(11),rs.getBoolean(12),rs.getString(13),rs.getString(14),rs.getString(15));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }
    public List<Membre> getMembersNyName(String search){
         String req = "select * from membre where first_name like '%?' ";
       List<Membre> membres = new ArrayList<Membre>();
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
            ps.setString(0, search);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                m = new Membre(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getBoolean(9),rs.getBoolean(10),rs.getBoolean(11),rs.getBoolean(12),rs.getString(13),rs.getString(14),rs.getString(15));
              membres.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        
    return membres;
    }
            
    
    
    
}
