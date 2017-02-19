/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.gui;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rishya
 */
public class ListeVoituresController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void gotoprofile(ActionEvent ae) throws IOException {
        Parent login_page = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }

    @FXML
    public void addcar(ActionEvent ae) throws IOException {
        Parent login_page = FXMLLoader.load(getClass().getResource("AjoutVoiture.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }

}