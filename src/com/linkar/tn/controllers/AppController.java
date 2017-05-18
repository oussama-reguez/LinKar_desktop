/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.controllers;




import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.linkar.tn.Iservice.AddAvis;
import com.linkar.tn.entities.Avis;
import com.linkar.tn.entities.Membre;
import com.linkar.tn.services.Ajouter_Avis;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.TableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author WIKI
 */
public class AppController implements Initializable {

    @FXML
    private AnchorPane an1;
    @FXML
    private Pane pa1;
    @FXML
    private JFXTextArea commentaire;
    @FXML
    private Pane pane2;
    @FXML
    private JFXButton rate;
org.controlsfx.control.Rating rating  ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       rating = new org.controlsfx.control.Rating();
        rating.setOrientation(Orientation.HORIZONTAL);
        rating.setUpdateOnHover(false);
        rating.setPartialRating(false);
        rating.setRating(1);
        pane2.getChildren().add(rating) ;
  
  
       
    }    

    @FXML
    private void Rate(ActionEvent event) {
        
        String comm = commentaire.getText();
        Double rate = rating.getRating();
        System.out.println(rate);
        Membre M1 = new Membre(1) ;
        
        Avis a1 = new Avis(1, rate, comm, new Membre(1), 3) ;    
        AddAvis avis = new Ajouter_Avis();
        avis.AjouterAvis(a1);
        
    }
    
     
    
    
}
