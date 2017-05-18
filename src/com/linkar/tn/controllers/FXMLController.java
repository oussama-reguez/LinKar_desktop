/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.controllers;

import com.linkar.tn.entities.Membre;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
//import Mail.Mail;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import com.linkar.tn.entities.Reclamation;

import com.jfoenix.controls.JFXComboBox;
import com.linkar.tn.Iservice.Reclama_Serv;
import com.linkar.tn.services.AddReclamation;
import java.lang.reflect.Member;
import java.sql.Date;

/**
 * FXML Controller class
 *
 * @author WIKI
 */
public class FXMLController implements Initializable {
    
    @FXML
    JFXComboBox TypeBox ;

    @FXML
    JFXButton send;
    @FXML
    private JFXTextField shortdesc;
    @FXML
    private JFXTextArea longdesc;
    @FXML
    private AnchorPane AnchorPane;

    public void submit(ActionEvent ae) throws Exception {
        String type=String.valueOf(TypeBox.getValue());
        String sub =shortdesc.getText();
        String content = longdesc.getText();
        
        java.util.Date d = new java.util.Date();
        
        Reclamation R = new Reclamation(2,new Date(d.getTime()),new Membre(1), content , sub,type) ;
        
        Reclama_Serv Rec = new AddReclamation();
        Rec.addRec(R);



    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TypeBox.getItems().addAll("Personne","Annonce");

    }

}
