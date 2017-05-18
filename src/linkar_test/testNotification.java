/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkar_test;



import com.linkar.tn.utils.NotificationUtils;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Oussama Reguez
 */
public class testNotification extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("sdf");
        
       Parent root = FXMLLoader.load(getClass().getResource("/com/linkar/tn/views/notification.fxml"));
        
      Thread d=  new Thread(new NotificationUtils().generateTask());
        d.start();
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              System.out.println("Stage is closing");
              d.stop();
          }
      });   
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
