
package com.linkar.tn.services;


import com.linkar.tn.Iservice.MembreIService;
import com.linkar.tn.entities.Annonce;


import com.linkar.tn.entities.Membre;
import com.linkar.tn.technics.DataSource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    
    public List<Membre> searchMembersByFullName(String search){
         String req = "select * from membre where first_name like ? or last_name like ? ";
       List<Membre> membres = new ArrayList<Membre>();
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
            ps.setString(1, search+"%");
            ps.setString(2, search+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                m = new Membre(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getDouble(8),rs.getString(9),rs.getBoolean(10),rs.getBoolean(11),rs.getBoolean(12),rs.getBoolean(13),rs.getString(14),rs.getString(15),rs.getString(7),rs.getBoolean("statut"));
              membres.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return membres;
    }
          
  
  
        public List<String> getFirstNames(String search){
         List<String> results = new ArrayList<String>();
            String req = "select first_name from membre where first_name like ? ";
       
       
        try {
            ps = cnx.prepareStatement(req);
            ps.setString(1, search+"%");
           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
              //  m = new Membre(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getDouble(8),rs.getString(9),rs.getBoolean(10),rs.getBoolean(11),rs.getBoolean(12),rs.getBoolean(13),rs.getString(14),rs.getString(15),rs.getString(7));
             results.add(rs.getString("first_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return results;  
        }
        
        public List<String> getLastNames(String search){
           List<String> results = new ArrayList<String>();
            String req = "select * from membre where last_name like ? ";
       
       
        try {
            ps = cnx.prepareStatement(req);
            ps.setString(1, search+"%");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
              //  m = new Membre(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getDouble(8),rs.getString(9),rs.getBoolean(10),rs.getBoolean(11),rs.getBoolean(12),rs.getBoolean(13),rs.getString(14),rs.getString(15),rs.getString(7));
             results.add(rs.getString("last_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return results;  
        }
        
         public List<String> getFullNames(String search){
           List<String> results = new ArrayList<String>();
            String req = "select first_name , last_name from membre where last_name like ? or first_name like ? ";
            
       
       
        try {
            ps = cnx.prepareStatement(req);
            ps.setString(1, search+"%");
            ps.setString(1, search+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
              //  m = new Membre(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getDouble(8),rs.getString(9),rs.getBoolean(10),rs.getBoolean(11),rs.getBoolean(12),rs.getBoolean(13),rs.getString(14),rs.getString(15),rs.getString(7));
             results.add(rs.getString("first_name")+" "+rs.getString("last_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return results;  
        }
       
        
        
       
        
        
    public List<Membre> searchMembersByFirstName(String search){
         String req = "select * from membre where first_name like ?  ";
       List<Membre> membres = new ArrayList<Membre>();
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
            ps.setString(1, search+"%");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                m = new Membre(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getDouble(8),rs.getString(9),rs.getBoolean(10),rs.getBoolean(11),rs.getBoolean(12),rs.getBoolean(13),rs.getString(14),rs.getString(15),rs.getString(7),rs.getBoolean("statut"));
              membres.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    return membres;
    }
       public List<Membre> searchMembersByLastName(String search){
         String req = "select * from membre where last_name like ?  ";
       List<Membre> membres = new ArrayList<Membre>();
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
            ps.setString(1, search+"%");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                m = new Membre(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getDouble(8),rs.getString(9),rs.getBoolean(10),rs.getBoolean(11),rs.getBoolean(12),rs.getBoolean(13),rs.getString(14),rs.getString(15),rs.getString(7),rs.getBoolean("statut"));
              membres.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    return membres;
    }
       
          public List<Membre> searchMembersByRole(boolean isAdmin){
         String req = "select * from membre where role=?  ";
       List<Membre> membres = new ArrayList<Membre>();
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
            ps.setBoolean(1, isAdmin);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                m = new Membre(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getDouble(8),rs.getString(9),rs.getBoolean(10),rs.getBoolean(11),rs.getBoolean(12),rs.getBoolean(13),rs.getString(14),rs.getString(15),rs.getString(7),rs.getBoolean("statut"));
              membres.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    return membres;
    }
    
     public  LinkedHashMap<Date,Integer> getStatCreatedUsers(){
       String req = "select  DATE(CreatedTime) d ,count(id_member) from membre   GROUP BY YEAR(d), MONTH(d)  order by CreatedTime ";
         LinkedHashMap<Date,Integer>results = new LinkedHashMap<>();
        
        try {
            ps = cnx.prepareStatement(req);
           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                try{
                results.put(rs.getDate(1),rs.getInt(2));
                }
                catch(SQLException e){
                    System.out.println("date problem");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
   
        
        return results;
    }
     
         public  LinkedHashMap<Date,Integer> getStatCreatedUsersbyYear(){
       String req = "select  DATE(CreatedTime) d ,count(id_member) from membre   GROUP BY YEAR(d) order by CreatedTime ";
         LinkedHashMap<Date,Integer>results = new LinkedHashMap<>();
        
        try {
            ps = cnx.prepareStatement(req);
           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                try{
                results.put(rs.getDate(1),rs.getInt(2));
                }
                catch(SQLException e){
                    System.out.println("date problem");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
   
        
        return results;
    }
     
      public  Map<String, Integer>getStatnbrUsersbyGender(){
       String req = "select  gender ,count(id_member) from membre  group by  gender ";
        Map<String, Integer> results = new HashMap<>();
        
        try {
            ps = cnx.prepareStatement(req);
           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                try{
                results.put(rs.getString(1),rs.getInt(2));
                }
                catch(SQLException e){
                    System.out.println("date problem");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
   
        
        return results;
    }
     
      
        public int getNbrUsers(){
        
         String req = "select count(id_member) from membre  ";
      
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
           ps.setMaxRows(1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
              return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return 0;
    }
        
        
         public List<Membre> getActiveUsers(int nbAnnonce){
          
            return null;
      }
         
         public Membre getMembre(int id ){
             
            
         String req = "select *  from membre where id_member=?  ";
      
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
           ps.setMaxRows(1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                rs.getInt(1);
                m = new Membre(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getDouble(8),rs.getString(9),rs.getBoolean(10),rs.getBoolean(11),rs.getBoolean(12),rs.getBoolean(13),rs.getString(14),rs.getString(15),rs.getString(7),rs.getBoolean("statut"));
              return m;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return null;
         }
         
         
          public List<Membre> getAllMembres(){
             
            
         String req = "select *  from membre  ";
      List<Membre>membres = new ArrayList<>();
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
          //  ps.setInt(1, id);
           //ps.setMaxRows(1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                rs.getInt(1);
                
                m = new Membre(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getDouble(8),rs.getString(9),rs.getBoolean(10),rs.getBoolean(11),rs.getBoolean(12),rs.getBoolean(13),rs.getString(14),rs.getString(15),rs.getString(7),rs.getBoolean("statut"));
             
                membres.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return membres;
         }
        public   void changeRole(boolean role,int id_membre){
              
	String req="update membre set role=? where id_member=?";
    try {
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setBoolean(1,role);
        ps.setInt(2,id_membre);
        
       
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(MembreServices.class.getName()).log(Level.SEVERE, null, ex);
    }
	}
        
        public void toggleMember(int id_membre,boolean isBlocked){
            String req="update membre set statut=? where id_member=?";
    try {
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setBoolean(1,isBlocked);
        ps.setInt(2,id_membre);
        
       
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(MembreServices.class.getName()).log(Level.SEVERE, null, ex);
    }
	}
            
        
       
        }

           
          
        
        
 
     
    



