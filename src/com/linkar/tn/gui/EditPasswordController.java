/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.gui;

import com.jfoenix.controls.JFXPasswordField;
import com.linkar.tn.Iservices.MembreIService;
import com.linkar.tn.entities.Membre;
import static com.linkar.tn.gui.LoginController.IDSession;
import com.linkar.tn.services.MembreServices;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rishya
 */
public class EditPasswordController implements Initializable {

    @FXML
    private JFXPasswordField newpass;
    @FXML
    private JFXPasswordField oldpass;
    @FXML
    private Label invalid_password;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void backtoprofile(ActionEvent ae) throws IOException {
    Parent login_page = FXMLLoader.load(getClass().getResource("Profile.fxml"));
    Scene login_scene = new Scene(login_page);
    Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
    app_stage.hide();
    app_stage.setScene(login_scene);
    app_stage.show();
  }  
    
    @FXML
    public void doeditpassword(ActionEvent ae) throws IOException {
    String oldpassword = oldpass.getText();   
    String newpassword = newpass.getText(); 
    MembreIService s = new MembreServices();
    Membre m = s.getById(IDSession);
    if (m.getPassword().equals(oldpassword))
    {
    s.editPass(IDSession,newpassword);

    Parent login_page = FXMLLoader.load(getClass().getResource("Profile.fxml"));
    Scene login_scene = new Scene(login_page);
    Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
    app_stage.hide();
    app_stage.setScene(login_scene);
    app_stage.show();
    // + Notification
    }
    else
    {
        invalid_password.setText("Mot de passe invalide");
        oldpass.clear();
    }
    
  } 
}
