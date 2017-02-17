
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
public class AnnonceServices {
    private Connection cnx;
    private PreparedStatement ps;
public AnnonceServices()
{
cnx=DataSource.getDataSource().getConnection();
}

double getAvgAnnoncePerDay(){
    return 0;
}
public List<String> getYears(){
       String req = "select  distinct YEAR(date)  from annonce order by date ";
     List<String>years= new ArrayList<>();
        
        try {
            ps = cnx.prepareStatement(req);
         //   ps.setString(1, year);
           
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
            {
                try{
               years.add(rs.getString(1));
                }
                catch(SQLException e){
                    System.out.println("date problem");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
   
        
        return years;
}

  public  LinkedHashMap<Integer,Integer> getStatCreatedAnnoncePerMonth(String year){
       String req = "select  MONTH(date), count(id_annonce) from annonce   where YEAR(date)= ? GROUP BY MONTH(date )  order by date ";
         LinkedHashMap<Integer,Integer>results = new LinkedHashMap<>();
        
        try {
            ps = cnx.prepareStatement(req);
            ps.setString(1, year);
           
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
            {
                try{
                results.put(rs.getInt(1),rs.getInt(2));
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

public int getNbrAnnonce(){
        
         String req = "select count(id_annonce) from annonce  ";
      
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
double getAvgAnnoncePerYear(){
    
    return 0;
}

Map<Date,Integer> getNbrAnnoncePerDate(){
    
    return null;
}
 public  Map<String, Integer>getStatNbrAnnoncebyStatus(){
       String req = "select  status ,count(id_member) from annonce group by  status";
        Map<String, Integer> results = new HashMap<>();
        
        try {
            ps = cnx.prepareStatement(req);
           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                try{
                    int n=rs.getInt(1);
                    String statut="";
                    //encours
                    if(n==0){
                        statut="En cours";
                    }
                    //terminé
                    if(n==1){
                        statut="supprimer";
                    }
                    if(n==2){
                        statut="terminer";
                    }
                    
                results.put(statut,rs.getInt(2));
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
Map<String,Integer>getFavoriteCities(){
    return null;
}

public  Map<String, Integer>getStatnbrAnnoncebyDestination(){
       String req = "select  destination ,count(id_annonce) from annonce  group by  depart ";
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

public  Map<String, Integer>getStatnbrAnnoncebydepart(){
       String req = "select  depart ,count(id_annonce) from annonce  group by  depart ";
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

MembreServices membreService = new MembreServices();
public List<Annonce> getAllAnnonces(){
     
         String req = "select * from annonce  ";
       List<Annonce> annonces = new ArrayList<Annonce>();
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
         //   ps.setBoolean(1, isAdmin);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
              //  m = new Membre(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getDouble(8),rs.getString(9),rs.getBoolean(10),rs.getBoolean(11),rs.getBoolean(12),rs.getBoolean(13),rs.getString(14),rs.getString(15),rs.getString(7),rs.getBoolean("statut"));
              //Annonce(req, req, true, true, true, true, true, date_annonce, true, req, id, id, req, m, v)
              //
  //public Annonce(String depart, String destination, boolean fumeur, boolean bavard, boolean men_only, boolean women_only, boolean animaux, Date date_annonce, boolean regulier, String horaire_depart, int places,
                                                                                                                                                                                                                            //int tarif, String description, Membre m, Voiture v) {               
             Annonce a=  new Annonce(rs.getString("depart"),rs.getString("destination"),rs.getBoolean("smoker"),rs.getBoolean("talkative")
                       ,rs.getBoolean("men_only"),rs.getBoolean("women_only"),rs.getBoolean("pet"),rs.getDate("date"),true,null,rs.getInt("places"),rs.getInt("price"),rs.getString("description"),membreService.getMembre(rs.getInt("id_member")),null);
              a.setId_annonce(rs.getInt("id_annonce")); 
             annonces.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    return annonces;
    

}

 public  void removeAnnonce(int a){
                
         String req = "DELETE from annonce WHERE id_annonce=? ";
      
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
            ps.setInt(1, a);
           //ps.setMaxRows(1);
           ps.executeUpdate();
            
         }
            catch(Exception r){
                r.printStackTrace();

            } 
            
                              }
public List<Annonce> getAnnonceByUser(Membre m){
             String req = "select * from annonce where id_member=?  ";
       List<Annonce> annonces = new ArrayList<Annonce>();
      
        try {
            ps = cnx.prepareStatement(req);
            ps.setInt(1, m.getId_member());
         //   ps.setBoolean(1, isAdmin);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
              //  m = new Membre(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getDouble(8),rs.getString(9),rs.getBoolean(10),rs.getBoolean(11),rs.getBoolean(12),rs.getBoolean(13),rs.getString(14),rs.getString(15),rs.getString(7),rs.getBoolean("statut"));
              //Annonce(req, req, true, true, true, true, true, date_annonce, true, req, id, id, req, m, v)
              //
  //public Annonce(String depart, String destination, boolean fumeur, boolean bavard, boolean men_only, boolean women_only, boolean animaux, Date date_annonce, boolean regulier, String horaire_depart, int places,
             Annonce a=  new Annonce(rs.getString("depart"),rs.getString("destination"),rs.getBoolean("smoker"),rs.getBoolean("talkative")
                       ,rs.getBoolean("men_only"),rs.getBoolean("women_only"),rs.getBoolean("pet"),rs.getDate("date"),true,null,rs.getInt("places"),rs.getInt("price"),rs.getString("description"),membreService.getMembre(rs.getInt("id_member")),null);
             a.setId_annonce(rs.getInt("id_annonce"));
             annonces.add(a);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    return annonces;
   
}
}






