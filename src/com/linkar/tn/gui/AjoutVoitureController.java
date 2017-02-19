/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.gui;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.linkar.tn.Iservices.VoitureIService;
import com.linkar.tn.entities.Voiture;
import static com.linkar.tn.gui.LoginController.IDSession;
import com.linkar.tn.services.VoitureServices;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Rishya
 */
public class AjoutVoitureController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ImageView picturecar;
    @FXML
    private JFXTextField carmodel;
    @FXML
    private JFXTextField carcolor;
    @FXML
    private JFXComboBox carbrand;
    @FXML
    private JFXRadioButton place1;
    @FXML
    private JFXRadioButton place8;
    @FXML
    private JFXRadioButton place2;
    @FXML
    private JFXRadioButton place3;
    @FXML
    private JFXRadioButton place4;
    @FXML
    private JFXRadioButton place5;
    @FXML
    private JFXRadioButton place6;
    @FXML
    private JFXRadioButton place7;
    @FXML
    private JFXRadioButton confort1;
    @FXML
    private JFXRadioButton confort2;
    @FXML
    private JFXRadioButton confort3;
    @FXML
    private JFXRadioButton confort4;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Champs obligatoire!");
        carmodel.getValidators().add(validator);
        carmodel.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                carmodel.validate();
            }
        });
        RequiredFieldValidator validator1 = new RequiredFieldValidator();
        validator1.setMessage("Champs obligatoire!");
        carcolor.getValidators().add(validator1);
        carcolor.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                carcolor.validate();
            }
        });
        carbrand.getItems().addAll("Autre", "BMW", "Hyundai", "Kia", "Mercdes Benz", "Nissan", "Peugeot", "Porshe", "Renault", "Toyota", "Volswagen");

    }

    @FXML
    public void backtoprofile(ActionEvent ae) throws IOException {
        Parent login_page = FXMLLoader.load(getClass().getResource("ListeVoitures.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }

    @FXML
    public void uploadcarpicture(ActionEvent ae) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Ajouter une voiture");
        Window stage = null;
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("GIF", "*.gif"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        File selectedFile = fileChooser.showOpenDialog(stage);
        System.out.println("Le chemin image est: " + selectedFile);
        Path selectedFile_path = selectedFile.toPath();
        String selectedFile_string = selectedFile_path.toString();

        picturecar.setImage(new Image(selectedFile_string));
        //    Uploader.uploadFile(IDSession,selectedFile_string);
    }

    @FXML
    public void doaddcar(ActionEvent ae) throws IOException {
        String model = carmodel.getText();
        String brand = (String) carbrand.getValue();
        String color = carcolor.getText();
        String confort = "";
        int nombre_places = 4;

        if (confort1.isSelected()) {
            confort = "Peu confortable";

        }
        if (confort2.isSelected()) {
            confort = ("Confort moyen");

        }
        if (confort3.isSelected()) {
            confort = ("Confortable");

        }
        if (confort4.isSelected()) {
            confort = ("Très confortable");

        }
        if (place1.isSelected()) {
            nombre_places = 1;

        }
        if (place1.isSelected()) {
            nombre_places = 1;

        }
        if (place2.isSelected()) {
            nombre_places = 2;

        }
        if (place3.isSelected()) {
            nombre_places = 3;

        }
        if (place4.isSelected()) {
            nombre_places = 4;

        }
        if (place5.isSelected()) {
            nombre_places = 5;

        }
        if (place6.isSelected()) {
            nombre_places = 6;

        }
        if (place7.isSelected()) {
            nombre_places = 7;

        }
        if (place8.isSelected()) {
            nombre_places = 8;

        }
        String url_car_selfie = "aaa";
        Voiture v = new Voiture(brand, model, IDSession, confort, nombre_places, url_car_selfie, color);
        VoitureIService vs = new VoitureServices();
        vs.addvoiture(v);

    }
}
