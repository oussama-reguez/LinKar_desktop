/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.views;


import com.linkar.tn.utils.NotificationUtils;
import javafx.application.Application;
import javafx.application.Platform;
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
public class testGestionCompte extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("sdf");
       
     
         Parent root = FXMLLoader.load(getClass().getResource("GestionCompte_1.fxml"));
      Thread thread=  new Thread(new NotificationUtils().generateTask());
       thread.start();
      Scene scene = new Scene(root);
        
        stage.setScene(scene);
         
        
         stage.setOnCloseRequest(e ->{thread.stop();});
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
