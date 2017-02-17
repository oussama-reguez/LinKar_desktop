/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkar_test;

/**
 *
 * @author Oussama Reguez
 */
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import com.linkar.tn.entities.Membre;
import com.linkar.tn.entities.Notification;
import com.linkar.tn.services.NotificationServices;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;
 
public class ListViewSample extends Application {
    
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
            Rectangle rect = new Rectangle(100, 20);
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
    
    
      Label generateLabel(Notification n){
          Label l=null;
        String msgDemande="a envoye une demande";
        Membre m = n.getSender();
        String fullName= m.getFirst_name()+" "+m.getLast_name();
        String url=m.getUrl_picture();
     
          if(n.getType().equals("demande")){
              
                l = new Label(fullName+" "+msgDemande);
          l.setOnMousePressed((event) -> {
         System.out.println("kkk");
          });
             Image img = new Image("file:images/user.png");
        ImageView iv= new ImageView(img);
        l.setId(String.valueOf(n.getId_notification()));
            l.setGraphic(iv);
           
          //  list.getItems().add(l);
             
              
        
        }
      
       
          
          
        
        return l;
    }
 
    
    
    
    ObservableList<String> data = FXCollections.observableArrayList(
            "chocolate", "salmon", "gold", "coral", "darkorchid",
            "darkgoldenrod", "lightsalmon", "black", "rosybrown", "blue",
            "blueviolet", "brown");
 
     JFXListView<Notification> list;
    @Override
    public void start(Stage stage) {
         NotificationServices not=new NotificationServices();
        VBox box = new VBox();
        Button b = new Button();
        b.setOnMouseClicked((e)->refreshListView(not.getRecentNotificaton(1,"demande", 2)));
        Scene scene = new Scene(box, 200, 200);
        stage.setScene(scene);
       
   list =generateNotification(not.getAllNotification(1));
      
         box.getChildren().addAll(list,b);
        VBox.setVgrow(list, Priority.ALWAYS);
        
        
             
 
        
  
list.getStyleClass().add("jfx-list-view");
 



list.setOnMouseClicked(new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {
            System.out.println("clicked on " + list.getSelectionModel().getSelectedItem());
        }
    });
        stage.show();
    }
    
  
    void refreshListView(List<Notification> notifications){
        ObservableList<Notification> data =FXCollections.observableArrayList(notifications);
        list.getItems().clear();
        list.getItems().addAll(data);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}