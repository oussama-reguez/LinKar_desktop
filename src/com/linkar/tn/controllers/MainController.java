/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.controllers;

import linkar_test.*;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRippler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;

/**
 * FXML Controller class
 *
 * @author Oussama Reguez
 */
public class MainController implements Initializable {

    private Button menu;
    @FXML
    private AnchorPane navList;
    @FXML
    private JFXRippler menuButton;
    @FXML
    private StackPane mainContent;
    @FXML
    private JFXListView<String> listView;
    @FXML
    private StackPane titleBurgerContainer;
    @FXML
    private JFXHamburger burger;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //navList.setItems(FXCollections.observableArrayList("Red","Yellow","Blue"));
        prepareSlideMenuAnimation();
        
        ObservableList<String> items =FXCollections.observableArrayList (
    "Gestion Compte ",  "verification des comptes", "Reclamation","verification des annonces","visualiser les statestiques");
 

Label  g = new Label("gestion Compte");
        Image img = new Image("file:/images/group.png");
        ImageView iv= new ImageView(img);
            g.setGraphic(iv);
        
        listView.setItems(items);

listView.setOnMouseClicked(new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {
            try {
                StackPane  main=null;
                int n= listView.getSelectionModel().getSelectedIndex();
               System.out.println("nnnnnnnnnnnnnnnnn"+n);
                switch(n){
                    case 0:     main = FXMLLoader.load(getClass().getResource("/com/linkar/tn/views/GestionCompte.fxml"));
                            break;
                    case 1 : main = FXMLLoader.load(getClass().getResource("/com/linkar/tn/views/verificationCompte.fxml")); ;break;
                    case 2: main = FXMLLoader.load(getClass().getResource("/com/linkar/tn/views/gestionReclamation.fxml"));;;
                      break;
                   case 3: main = FXMLLoader.load(getClass().getResource("/com/linkar/tn/views/gestionAnnonce.fxml"));break;
                case 4: main = FXMLLoader.load(getClass().getResource("/com/linkar/tn/views/statView.fxml"));break;
                }
                
                mainContent.getChildren().clear();
                 mainContent.getChildren().add(main);
                  Platform.runLater(new Runnable() {
                 @Override public void run() {
                     
                    toggleMenu();
                     
                 }
             });
                
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });

        try {
           
            
          
            StackPane  main = FXMLLoader.load(getClass().getResource("/com/linkar/tn/views/GestionCompte.fxml"));
            
            mainContent.getChildren().add(main);
//listView.setExpanded(true);
//listView.depthProperty().set(5);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }    
    
    
  TranslateTransition openNav;
  TranslateTransition closeNav;
    private void prepareSlideMenuAnimation() {
        
       openNav=new TranslateTransition(new Duration(350), navList);
        openNav.setToX(0);
        closeNav=new TranslateTransition(new Duration(350), navList);
         menuButton.setOnMouseClicked((e)->{
             
           toggleMenu();
           
			
         
         });      
         
         
        
    }
    
    void toggleMenu(){
        	if(navList.getTranslateX()!=0){
                openNav.play();
                
                burger.getAnimation().setRate(1);
			
            }else{
                closeNav.setToX(-(navList.getWidth()));
                closeNav.play();
                  burger.getAnimation().setRate(-1);
            }
                burger.getAnimation().play();
        
    }
}
