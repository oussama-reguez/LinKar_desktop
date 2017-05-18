
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
    public void edit(Membre m) {
	String req="update membre set last_name=?,first_name=?,birth=?,phone_number=?,url_picture=?,address=? where id=?";
    try {
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setString(1,m.getLast_name());
        ps.setString(2,m.getFirst_name());
        ps.setDate(3,m.getBirth());
        ps.setString(4,m.getPhone_number());
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
	String req="update membre set email=? where id=?" ;
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
	String req="update membre set password=? where id=?" ;
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
	String req="delete from membre where id=?" ;
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
        String req = "select * from membre where id =?";
        Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                m = new Membre(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getBoolean(9),rs.getBoolean(10),rs.getBoolean(11),rs.getBoolean(12),rs.getString(13),rs.getString(14),rs.getString(15));
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
       String req = "select  DATE(CreatedTime) d ,count(id) from membre   GROUP BY YEAR(d), MONTH(d)  order by CreatedTime ";
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
       String req = "select  DATE(CreatedTime) d ,count(id) from membre   GROUP BY YEAR(d) order by CreatedTime ";
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
       String req = "select  gender ,count(id) from membre  group by  gender ";
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
     
      
      
      public int getBlockedUsers(){
         String req = "select count(id) from membre  where statut=0 ";
      
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
      
        public int getNbrUsers(){
        
         String req = "select count(id) from membre  ";
      
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
          
              String req = "select  m.id , m.last_name , m.first_name ,m.url_picture , m.gender , count(a.id_annonce) b from annonce a , membre m where a.id_membre=m.id group by id order by b desc ";
     
     List<Membre> results = new ArrayList<>();
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
          //  ps.setInt(1, id);
            ps.setMaxRows(20);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                rs.getInt(1);             
                m = new Membre();
                m.setId_member(rs.getInt(1));
                m.setUrl_picture(rs.getString(4));
                m.setFirst_name(rs.getString(3));
System.out.println(rs.getString(2));
                m.setLast_name(rs.getString(2));  
                m.setGender(rs.getString(5));
                m.setNbrAnnonce(rs.getInt(6));
                results.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return results;
      }
         
         public Membre getMembre(int id ){
             
            
         String req = "select *  from membre where id=?  ";
      
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
         
        public List<Membre> getRequestedMembers(){
             
            
         String req = "select *  from membre where verif_cin=0 and url_cin!=''  ";
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
              
	String req="update membre set role=? where id=?";
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
            String req="update membre set statut=? where id=?";
    try {
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setBoolean(1,isBlocked);
        ps.setInt(2,id_membre);
        
       
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(MembreServices.class.getName()).log(Level.SEVERE, null, ex);
    }
	}
            
       public void verifyAccount(int id_membre,boolean action) {
                String req="update membre set verif_cin=? where id=?";
           if(!action){
                      req="update membre set verif_cin=? ,url_cin='' where id=?";
                  }
	
    try {
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setBoolean(1,action);
        ps.setInt(2,id_membre);
        
       
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(MembreServices.class.getName()).log(Level.SEVERE, null, ex);
    }
	}
       
       
       
           @Override
    public void add(Membre m) {
        System.out.println("Done");
        String req = "insert into membre (last_name,first_name,birth,email,password,phone_number,gender,verif_number,verif_cin,verif_email,role,address,sms_code) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            ps.setString(12, m.getAddress());
            ps.setInt(13, m.getSms_code());
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
    public void editImage(int id, String url) {
        String req = "UPDATE membre SET url_picture=? WHERE id_member=?";
        System.out.println(req);
        try {
            cnx.setAutoCommit(false);
            PreparedStatement p = cnx.prepareStatement(req);
            p.setString(1, url);
            p.setInt(2, id);
            p.executeUpdate();
            cnx.commit();
            cnx.setAutoCommit(true);
            System.out.println("La nouvelle URL de l'image de profil est: " + url);

        } catch (SQLException ex) {
            Logger.getLogger(MembreServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  

       
        }

           
          
        
        
 
     
    



