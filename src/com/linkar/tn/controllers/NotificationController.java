/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.controllers;



import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXToggleButton;
import com.linkar.tn.entities.Membre;
import com.linkar.tn.entities.Notification;
import com.linkar.tn.services.MembreServices;
import com.linkar.tn.services.NotificationServices;
import com.linkar.tn.utils.NotificationUtils;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import static javafx.beans.property.IntegerProperty.integerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Oussama Reguez
 */
public class NotificationController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML
    private Label countNotif;
   public NotificationServices serviceNotif;
    int count=0;
    MembreServices serviceMembre;
    List<Notification>notifications;
    @FXML
    private JFXToggleButton soundToggle;
    @FXML
    private JFXToggleButton messageToggle;
    @FXML
    private JFXToggleButton responseToggle;
    @FXML
    private JFXToggleButton demandeToggle;
    
 
    
    void RefreshUi(List<Notification> notifs){
        ObservableList<Notification> data =FXCollections.observableArrayList(notifs);
        list.getItems().clear();
        list.getItems().addAll(data);
       countNotif.setText("("+String.valueOf(count)+")");
       
        
    }
   
    Notification GetNotification(int id){
        
      Notification s=  notifications.stream().filter((a)->a.getId_notification()==id).findFirst().get();
        return s;
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
    Label generateLabel(Notification n){
        
          Label l=null;
       
        Membre m = n.getSender();
        String url=m.getUrl_picture();
                l = new Label(GenerateTextNotification(n));
             //Image img = new Image("file:images/user.png");
             Image img = new Image(n.getSender().getUrl_picture());
        ImageView iv= new ImageView(img);
            l.setGraphic(iv);
           
          //  list.getItems().add(l);
             
              
        
        
      
       
          
          
        
        return l;
    }
      JFXListView<Notification> generateNotification(List<Notification> notifications){
         JFXListView<Notification> list = new JFXListView<Notification>();
    
    ObservableList<Notification> data = FXCollections.observableArrayList(notifications);
    
     list.setItems(data);
 
        list.setCellFactory(new Callback<ListView<Notification>, 
            ListCell<Notification>>() {
                @Override 
                public JFXListCell<Notification> call(ListView<Notification> list) {
                    return new JFXListCell<Notification>(){
                        @Override
        public void updateItem(Notification item, boolean empty) {
            super.updateItem(item, empty);
           
            if (item != null) {
                
                Label l=generateLabel(item);
               // rect.setFill(Color.web(item));
                setGraphic(l);
            }
        }
                    };
                }
            }
        );
        return list;
    }
    
    
    
      @FXML
    private VBox vBox;

               
               @FXML
    private VBox parametre;
    private JFXListView list;
          @FXML
    private Button b;
          void DisplayNotification(Notification n){
               Image img = new Image(n.getSender().getUrl_picture());
           ImageView iv= new ImageView(img);
        System.out.println("lollolol");
        Notifications.create()
              .title("Notification")
              .text(GenerateTextNotification(n)).graphic(iv)
              .show();
          }
          @FXML
    private void handle(ActionEvent event)
    {
        Image img = new Image("file:images/user.png");
        ImageView iv= new ImageView(img);
        System.out.println("lollolol");
         parametre.setVisible(true);
        Notifications.create()
              .title("Title Text")
              .text("Hello World 0!").graphic(iv)
              .show();
                
        
        
    }
    
    
    void initSettings(){
        messageToggle.selectedProperty().set(NotificationUtils.Messages);
         demandeToggle.selectedProperty().set(NotificationUtils.Demandes);
          responseToggle.selectedProperty().set(NotificationUtils.Response);
          soundToggle.selectedProperty().set(NotificationUtils.Sound);
         //  messageToggle.selectedProperty().set(NotificationUtils.Response);
           
    }
  void   saveSettings(){
      try{
          NotificationUtils.Messages=messageToggle.selectedProperty().get();
         NotificationUtils.Demandes=demandeToggle.selectedProperty().get();
         NotificationUtils.Response= responseToggle.selectedProperty().get();
         NotificationUtils.Sound=soundToggle.selectedProperty().get();
           NotificationUtils.saveAll();
      }
      catch(Exception ex ){
          System.out.println("problem notif settings");
      }
     
  }
    void refreshListView(List<Notification> notifications){
        ObservableList<Notification> data =FXCollections.observableArrayList(notifications);
        list.getItems().clear();
        list.getItems().addAll(data);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        serviceNotif=new NotificationServices();
        notifications=serviceNotif.getAllNotification(1);
        list=generateNotification(notifications);
        list.setExpanded(true);
         list.setOnMouseClicked(event -> {
         System.out.println("yell");
              });
       
         vBox.getChildren().add(1,list);
        
        count=notifications.size();
        countNotif.setText("("+String.valueOf(count)+")");
        
      parametre.managedProperty().bind(parametre.visibleProperty());
      vBox.managedProperty().bind(vBox.visibleProperty());
      parametre.setVisible(false);
      
       
     new Thread(generateTask()).start();
      
     

        // TODO
    }    
    
    
    Task generateTask(){
          Task longTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                
                 while (true) {
         try {
             Thread.sleep(1000);
         } catch (InterruptedException ex) {
            
         }
         // List<Notification> recentNotifications= serviceNotif.getRecentNotificaton(1, "all", 0);
          
          
          int c=serviceNotif.countRecentNotification(1, "all", count);
          System.out.println(c);
          
       if( c>0){
        List<Notification>recentNotifications=serviceNotif.getRecentNotificaton(1, "all", count);
                   
                 
                  notifications.addAll(0,recentNotifications );
                  System.out.println("done adding ");
                count+=recentNotifications.size();
                
                System.out.println("counte"+count);
                Platform.runLater(new Runnable() {
                 @Override public void run() {
                     //RefreshUi(recentNotifications);
                     RefreshUi(notifications);
                     /*
                     for(Notification notif :recentNotifications){
                         //DisplayNotification(notif);
                     }
*/
                     
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
    
     @FXML
    void settingAction(ActionEvent event) {
vBox.setVisible(false);

parametre.setVisible(true);
initSettings();
    }
    @FXML
    void cancelAction(ActionEvent event) {
vBox.setVisible(true);
parametre.setVisible(false);
    }

    @FXML
    private void saveAction(ActionEvent event) {
        saveSettings();
        vBox.setVisible(true);
parametre.setVisible(false);
    }
}


 


