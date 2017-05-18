/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.views;


import com.linkar.tn.utils.NotificationUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Oussama Reguez
 */
public class testNotification extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("sdf");
        
       Parent root = FXMLLoader.load(getClass().getResource("notification.fxml"));
        
       new Thread(new NotificationUtils().generateTask()).start();
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
