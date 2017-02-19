/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.gui;

import com.linkar.tn.Iservices.MembreIService;
import com.linkar.tn.entities.Membre;
import static com.linkar.tn.gui.MainViewController.id_other;
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
public class ProfileOtherController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MembreIService k = new MembreServices();
        Membre n = k.getById(id_other);
        System.out.println(id_other);
        name.setText(n.getLast_name() + " " + n.getFirst_name());
        if (true == n.isVerif_cin()) {
            verified.setText("✓");
        }
        birth_date.setText("Date de naissance: " + n.getBirth());
        LocalDate date = LocalDate.now();
        profile_picture.setImage(new Image(n.getUrl_picture()));
    }

    @FXML
    public void gotomain(ActionEvent ae) throws IOException {
        Parent login_page = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }

    @FXML
    public void gotocars(ActionEvent ae) throws IOException {
        Parent login_page = FXMLLoader.load(getClass().getResource("ListeVoituresOther.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }

    @FXML
    public void shownumber(ActionEvent ae) throws IOException {
        MembreIService k = new MembreServices();
        Membre n = k.getById(id_other);
        phone_number.setText("Numéro de téléphone: " + n.getPhone_number());

    }

}
