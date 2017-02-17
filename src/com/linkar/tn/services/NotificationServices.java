
package com.linkar.tn.services;


import com.linkar.tn.Iservice.MembreIService;


import com.linkar.tn.entities.Membre;
import com.linkar.tn.entities.Notification;
import com.linkar.tn.entities.Reclamation;
import com.linkar.tn.technics.DataSource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rishya
 */
public class NotificationServices {
    private Connection cnx;
    private PreparedStatement ps;
    private MembreServices membreService = new MembreServices();
public NotificationServices()
{
cnx=DataSource.getDataSource().getConnection();
}
public void addNotfication(String type,int id_membre,int id_sender){
     String sql="INSERT INTO `notification`(`id_member`,`type`, `id_sender`) VALUES (?,?,?)";
    try {
            PreparedStatement prepared = cnx.prepareStatement(sql);
            prepared.setInt(1,id_membre);
            prepared.setString(2, type);
             prepared.setInt(3,id_sender);
           
            prepared.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
}
 public List<Notification> getAllNotification(int id_membre){
    String sql="select * from notification WHERE id_member=?";
    List<Notification> list = new ArrayList<Notification>();
    Notification n = null;
         
    try {
            PreparedStatement prepared = cnx.prepareStatement(sql);
           
             prepared.setInt(1,id_membre);
           
           ResultSet rs= prepared.executeQuery();
          while (rs.next()) {
              Membre owner = membreService.getMembre(id_membre);
               Membre sender= membreService.getMembre(rs.getInt(6));
              n=new Notification(rs.getInt(1),owner, sender,rs.getBoolean(4),rs.getString(5));
              list.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return list;
}

public List<Notification> getAllNotificationByType(int id_membre,String type){
    String sql="select * from notification WHERE id_membre=? and type=?";
    List<Notification> list = new ArrayList<Notification>();
    Notification n = null;
         
    try {
            PreparedStatement prepared = cnx.prepareStatement(sql);
           
             prepared.setInt(1,id_membre);
               prepared.setString(2,type);
           
           ResultSet rs= prepared.executeQuery();
          while (rs.next()) {
              Membre owner = membreService.getMembre(id_membre);
               Membre sender= membreService.getMembre(rs.getInt(6));
              n=new Notification(rs.getInt(1),owner, sender,rs.getBoolean(4),rs.getString(5));
              list.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return list;
}

public int countAllNotification(int id_membre){
    
    String req = "select count(id_member) from notification where id_member=?  ";
      
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
            ps.setInt(1, id_membre);
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

public int countRecentNotification(int id_membre,String type,int lastCount){
   
   int count=0;
   if(type.equals("all")){
       count=countAllNotification(id_membre);
   } else{
       count=countNotificatdfdionByType(id_membre, type);
   }
   System.out.println("from db"+count);
   return count-lastCount;
 
}

public List<Notification>getRecentNotificaton(int id_membre,String type,int lastCount){
     List<Notification>notifications=new ArrayList<>();
  String req = "select * from notification a  where a.id_member=? and type=? order by id_notification desc";
     if (type.equals("all")){
       req="select * from notification a  where a.id_member=? order by id_notification desc";
   }
   
          
      
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
            ps.setInt(1, id_membre);
              if (type.equals("all")){
                   ps.setInt(1, id_membre);
                   
              } else{
                  ps.setInt(1, id_membre);
                   ps.setString(2, type);
              }
           
          // ps.setMaxRows(1);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int count = rs.getRow();
            rs.beforeFirst();
            int max=count-lastCount;
            for( int i=1;i<=max;i++){
               rs.next() ;
            Notification n = new Notification();
            n.setId_notification(rs.getInt(1));
                n.setMembre(new Membre(id_membre));
                n.setSender(membreService.getMembre(rs.getInt(6)));
                n.setType(rs.getString(5));
                n.setSeen(rs.getBoolean(3));
               notifications.add(n);
               
            
                
// return rs.getInt(1);
            
            
            }
            //generation de notifications
          
            return notifications;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    
    return null;
}

public List<Notification>MonitorNotification(int id_membre,String type,int lastCount){
    List<Notification>notifications=new ArrayList<>();
    List<Membre>membres=new ArrayList<>();
    if(type.equals("demande")){
          String req = "select p.id_member from place p ,annonce a where a.id_member=?";
      
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
            ps.setInt(1, id_membre);
          // ps.setMaxRows(1);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int count = rs.getRow();
            rs.beforeFirst();
            int max=count-lastCount;
            for( int i=1;i<=max;i++){
               rs.next() ;
            
                membres.add(membreService.getMembre(rs.getInt(1)));
             // return rs.getInt(1);
            
            
            }
            //generation de notifications
            for(Membre e:membres){
                Notification n = new Notification();
                n.setMembre(new Membre(id_membre));
                n.setSender(e);
                n.setType("demande");
               notifications.add(n);
                
            }
            return notifications;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    
       if(type.equals("reclamation")){
          String req = "select id_membre from reclamation ";
      
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
           // ps.setInt(1, id_membre);
          // ps.setMaxRows(1);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int count = rs.getRow();
            rs.beforeFirst();
            int max=count-lastCount;
            for( int i=1;i<=max;i++){
               rs.next() ;
            
                membres.add(membreService.getMembre(rs.getInt(1)));
             // return rs.getInt(1);
            
            
            }
            //generation de notifications
            for(Membre e:membres){
                Notification n = new Notification();
                n.setMembre(new Membre(id_membre));
                n.setSender(e);
                n.setType("reclamation");
               notifications.add(n);
                
            }
            return notifications;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
       
       if(type.equals("message")){
          String req = "select id_sender from message where id_receiver=? ";
      
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
            ps.setInt(1, id_membre);
          // ps.setMaxRows(1);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int count = rs.getRow();
            rs.beforeFirst();
            int max=count-lastCount;
            for( int i=1;i<=max;i++){
               rs.next() ;
            
                membres.add(membreService.getMembre(rs.getInt(1)));
             // return rs.getInt(1);
            
            
            }
            //generation de notifications
            for(Membre e:membres){
                Notification n = new Notification();
                n.setMembre(new Membre(id_membre));
                n.setSender(e);
                n.setType("message");
               notifications.add(n);
                
            }
            return notifications;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    return null;
}





int countNotificatdfdionByType(int id_membre,String type){
    
    String req = "select count(id_member) from notification where id_member=? and type=?  ";
      
         Membre m = null;
        try {
            ps = cnx.prepareStatement(req);
            ps.setInt(1, id_membre);
            ps.setString(2, type);
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


   
}


