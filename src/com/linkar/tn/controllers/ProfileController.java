/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.controllers;

import com.jfoenix.controls.JFXButton;
import com.linkar.tn.Iservice.MembreIService;
import com.linkar.tn.entities.Membre;
import static com.linkar.tn.controllers.LoginController.IDSession;
import com.linkar.tn.services.MembreServices;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rishya
 */
public class ProfileController implements Initializable {

    @FXML
    private ImageView profile_picture;
    @FXML
    private Label name;
    @FXML
    private Label verified;
    @FXML
    private Label birth_date;
    @FXML
    private Label phone_number;
    @FXML
    private Label average_rating;
    @FXML
    private JFXButton validatenumberbutton;
    @FXML
    private JFXButton validatecinbutton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Mon profil est affiché");
        name.setText(m.getLast_name() + " " + m.getFirst_name());
        if (true == m.isVerif_cin()) {
            verified.setText("✓");
        }
        birth_date.setText("Date de naissance: " + m.getBirth());
        phone_number.setText("Numéro de téléphone: " + m.getPhone_number());
        LocalDate date = LocalDate.now();
        profile_picture.setImage(new Image(m.getUrl_picture()));
        System.out.println(m.isVerif_number());
        if (m.isVerif_number() == true) {
            validatenumberbutton.setVisible(false);
        }
        if (m.isVerif_cin() == true) {
            validatecinbutton.setVisible(false);
        }
    }

    @FXML
    public void gotomain(ActionEvent ae) throws IOException {
        Parent login_page = FXMLLoader.load(getClass().getResource("/com/linkar/tn/gui/MainView.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }
    MembreIService s = new MembreServices();
    Membre m = s.getById(IDSession);

    @FXML
    public void gotocars(ActionEvent ae) throws IOException {
        Parent login_page = FXMLLoader.load(getClass().getResource("/com/linkar/tn/gui/ListeVoitures.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }

    @FXML
    public void editpassword(ActionEvent ae) throws IOException {
        Parent login_page = FXMLLoader.load(getClass().getResource("/com/linkar/tn/gui/EditPassword.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }

    @FXML
    public void editprofile(ActionEvent ae) throws IOException {
        Parent login_page = FXMLLoader.load(getClass().getResource("/com/linkar/tn/gui/EditProfile.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }

    @FXML
    public void validatenumber(ActionEvent ae) throws IOException {
        Parent login_page = FXMLLoader.load(getClass().getResource("/com/linkar/tn/gui/ValidateNumber.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }

    @FXML
    public void validatecin(ActionEvent ae) throws IOException {
        Parent login_page = FXMLLoader.load(getClass().getResource("/com/linkar/tn/gui/ValidateCIN.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }
}
