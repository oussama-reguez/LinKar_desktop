/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.utils;

import com.linkar.tn.entities.Notification;
import com.linkar.tn.services.NotificationServices;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import org.controlsfx.control.Notifications;
import org.controlsfx.control.action.Action;

/**
 *
 * @author Oussama Reguez
 */
public class NotificationUtils {
    public static  boolean Messages;
  public static boolean Demandes;
   public static  boolean Avis ;
   public static  boolean Reclamation;
  public static  int notifications;
   public static  boolean Response;
     public static  boolean Sound=false;
    
    
   public static Properties properties ;
     public static AudioClip notificationSound;
    
     NotificationServices serviceNotif = new NotificationServices();
     public static void playSound(){
         if(Sound){
              if (notificationSound==null){
              notificationSound = new AudioClip("file:sound/sound.wav");
                                     }
         
         if(!notificationSound.isPlaying()){
               notificationSound.play();
     }
         }
        
         
     }
         
        
    public NotificationUtils(){
        notificationSound = new AudioClip("file:sound/sound.wav");
        
        properties= new Properties();
         System.out.println("constr"+count);
        FileInputStream is=null;
        try {
       
          properties.load(new FileInputStream("notifications.properties"));
         
        loadData();
        System.out.println("notifications"+notifications);
        
        count=notifications;
    
        
        }
    catch ( Exception e ) { e.printStackTrace();}
 
    
 
  
}
    
    
  public   void loadData(){
//    lastMessages=Integer.parseInt(properties.getProperty("messages"));
  //  lastDemandes=Integer.parseInt(properties.getProperty("demandes"));;
   //  lastAvis=Integer.parseInt(properties.getProperty("avis")); ;
   //  lastReclamation=Integer.parseInt(properties.getProperty("reclamation"));
  //   lastResponse=Integer.parseInt(properties.getProperty("reponses"));
    notifications=Integer.parseInt(properties.getProperty("notifications"));
   Messages = Boolean.parseBoolean(properties.getProperty("Messages"));
  Avis = Boolean.parseBoolean(properties.getProperty("Avis"));
   Reclamation = Boolean.parseBoolean(properties.getProperty("Reclamations"));
   Response=Boolean.parseBoolean(properties.getProperty("Responses"));
   Demandes=Boolean.parseBoolean(properties.getProperty("Demandes"));
   Sound=Boolean.parseBoolean(properties.getProperty("Sound"));
        
    }
    
   
  public static  void saveAll() throws FileNotFoundException, IOException{
   
     properties.setProperty("Messages", String.valueOf(Messages));
     properties.setProperty("Demandes", String.valueOf(Demandes));
     properties.setProperty("Avis", String.valueOf(Avis));
     properties.setProperty("Reponses", String.valueOf(Response));
     properties.setProperty("Sound", String.valueOf(Sound));
      File f = new File("notifications.properties");
        OutputStream out = new FileOutputStream( f );
       // properties.store(out, "This is an optional header comment string");
     properties.store(out, "d");
     
    
    }
   
     public static  int count ;
    
    public Task generateTask(){
          Task longTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
              int f=  serviceNotif.countRecentNotification(1, "all", count);
              System.out.println("f"+f);
                if(f>0){
                    System.out.println("show me");
                  
                    Platform.runLater(new Runnable() {
                 @Override public void run() {
                     //RefreshUi(recentNotifications);
                    
                     Notifications.create()
              .title("Notification")
              .text("vous avez "+f+ " nouvelle notifications")
              .show();
                        playSound();
                     
                 }
             });
                     count+=f;
                      
                
            }
                
                 while (true) {
         try {
             Thread.sleep(1000);
         } catch (InterruptedException ex) {
            
         }
         // List<Notification> recentNotifications= serviceNotif.getRecentNotificaton(1, "all", 0);
          
          System.out.println("first it  is "+count);
          int c=serviceNotif.countRecentNotification(1, "all", count);
          System.out.println("ccccc"+c);
          
       if( c>0){
        List<Notification>recentNotifications=serviceNotif.getRecentNotificaton(1, "all", count);
                   
                 
                 // notifications.addAll(0,recentNotifications );
                  System.out.println("done adding ");
                count+=recentNotifications.size();
                
                System.out.println("counte"+count);
                Platform.runLater(new Runnable() {
                 @Override public void run() {
                     //RefreshUi(recentNotifications);
                    
                     for(Notification notif :recentNotifications){
                       if(notif.getType().equals("demande")){
                          if(Demandes){
                               DisplayNotification(notif);
                                playSound();
                          }
                          
                       }
                       if(notif.getType().equals("message")){
                          if(Messages){
                               DisplayNotification(notif);
                                playSound();
                          }
                          
                       }
                       if(notif.getType().equals("reclamation")){
                          if(Reclamation){
                               DisplayNotification(notif);
                                playSound();
                          }
                          
                       }
                       if(notif.getType().equals("response")){
                          if(Response){
                               DisplayNotification(notif);
                                playSound();
                          }
                          
                       }
                        
                        
                     }
                     
                 }
             });
               
       }
      
}
           
                
               
            }
        };
 
        longTask.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t) {
              //
            }
        });
        return longTask;
    }
    
      void DisplayNotification(Notification n){
               Image img = new Image(n.getSender().getUrl_picture());
           ImageView iv= new ImageView(img);
        System.out.println("lollolol");
        Notifications.create()
              .title("Notification")
              .text(GenerateTextNotification(n)).graphic(iv)
                
              .show();
          }
      
       String GenerateTextNotification(Notification n){
          String msgMessage="vous a envoyé un message ";
         String msgDemande="a envoyé une demande";
         String msgReclamation="a deposé une reclamation ";
         String msgReponse="a accepté votre demande";
          String fullName= n.getSender().getFirst_name()+" "+n.getSender().getLast_name();
         if(n.getType().equals("demande")){
             return fullName+" "+msgDemande;
         }
         if(n.getType().equals("message")){
             return fullName+" "+msgMessage;
         }
         if(n.getType().equals("reponse")){
             return fullName+" "+msgReponse;
         }
         if(n.getType().equals("reclamation")){
             return fullName+" "+msgReclamation;
         }
        
         
        return null;
    }
    
    }

