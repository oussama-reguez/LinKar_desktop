/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rishya
 */
public class MainViewController {

    @FXML
    public void gotoprofile(ActionEvent ae) throws IOException {
        Parent login_page = FXMLLoader.load(getClass().getResource("/com/linkar/tn/gui/Profile.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }

    @FXML
    public void logout(ActionEvent ae) throws IOException {

        Parent login_page = FXMLLoader.load(getClass().getResource("/com/linkar/tn/gui/Login.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }
    static int id_other;

    @FXML
    public void testmembre(ActionEvent ae) throws IOException {

        id_other = 12;
        Parent login_page = FXMLLoader.load(getClass().getResource("/com/linkar/tn/gui/ProfileOther.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }
}
