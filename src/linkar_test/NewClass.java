/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkar_test;

import com.linkar.tn.entities.Annonce;
import com.linkar.tn.entities.Membre;
import com.linkar.tn.entities.Notification;
import com.linkar.tn.entities.Reclamation;
import com.linkar.tn.services.AnnonceServices;
import com.linkar.tn.services.MembreServices;
import com.linkar.tn.services.NotificationServices;
import com.linkar.tn.services.ReclamationService;
import com.linkar.tn.utils.NotificationUtils;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.DatePicker;
import javafx.scene.media.AudioClip;
import sun.audio.AudioPlayer;

/**
 *
 * @author Oussama Reguez
 */
public class NewClass {
     public static void main(String[] args) throws IOException, InterruptedException {
    
      /*
      MembreServices service = new MembreServices();
     Map<Date,Integer>map= service.getStatCreatedUsers();
     map.forEach((key, value) -> {
    System.out.println("Key : " + key + " Value : " + value);
});
     
     Map<String,Integer> map2= service.getStatnbrUsersbyGender();
     map2.forEach((key, value) -> {
    System.out.println("Key : " + key + " Value : " + value);
});
*/
      /*
      NotificationServices service = new NotificationServices();
      Notification n = new Notification();
      n.setId_notification(4);
      List<Notification>d =new ArrayList<>();
      d.add(n);
      List<Notification> notifications= service.getRecentNotificaton(1, "all", 0);
      System.out.println("sddff");
      if(notifications==null){
           System.out.println("sddffd");
      }
      for(Notification e : notifications){
          System.out.println(e);
      }
      System.out.println("sddddddddddddddddddd");
      notifications.addAll(0,d );
      for(Notification e : notifications){
          System.out.println(e);
      }
      
      */
      while(true){
          NotificationUtils.playSound();
 

 Thread.sleep(8000);
      }
   
    
       
        
       
}    
}