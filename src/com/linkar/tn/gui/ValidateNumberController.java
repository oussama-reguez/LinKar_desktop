/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.gui;

import com.jfoenix.controls.JFXTextField;
import com.linkar.tn.Iservices.MembreIService;
import com.linkar.tn.entities.Membre;
import static com.linkar.tn.gui.LoginController.IDSession;
import com.linkar.tn.services.MembreServices;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
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
public class ValidateNumberController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label false_code;
    @FXML
    private JFXTextField code;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            MembreIService s = new MembreServices() ; 
    Membre m = s.getById(IDSession);
    int code_verif = m.getSms_code();
                Twilio.init("ACf71dbdf4db9d2bafa9cd3323ee9f77b0", "9d22d49cf36c917b9c87719b530cd52b");
        Message message = Message.creator(new PhoneNumber("+21621443151"),
                                          new PhoneNumber("+15618551080"), 
                                          "Merci pour votre inscription sur LinKar. Saisir ce code pour vérifier votre numéro: "+code_verif)
                                 .create();
    }    
        @FXML
    public void validatenumber(ActionEvent ae) throws IOException {
    MembreIService s = new MembreServices() ; 
    Membre m = s.getById(IDSession);
    int code_verif = m.getSms_code();
    System.out.println(m.getSms_code());
    int input = Integer.parseInt(code.getText());
    if (input==code_verif)
    {
    System.out.println("Code vérifié");
    s.editVerif_number(IDSession);
    Parent login_page = FXMLLoader.load(getClass().getResource("Profile.fxml"));
    Scene login_scene = new Scene(login_page);
    Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
    app_stage.hide();
    app_stage.setScene(login_scene);
    app_stage.show(); 
    }
    else
    {
        false_code.setText("Code érroné!");
    }
 
    }
}
