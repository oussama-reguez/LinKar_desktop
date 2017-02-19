/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.gui;

import javafx.scene.image.Image;
import java.io.File;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.nio.file.Path;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Rishya
 */
public class Register2Controller implements Initializable {

    @FXML
    private ImageView picture;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void gotomain(ActionEvent ae) throws Exception {
        Parent login_page = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }

    @FXML
    public void upload_picture(ActionEvent ae) throws Exception {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Ajouter une image de profile");
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

        picture.setImage(new Image(selectedFile_string));
        //    Uploader.uploadFile(IDSession,selectedFile_string);
    }

    @FXML
    public void upload_cin(ActionEvent ae) throws Exception {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Ajouter un scan CIN/Passeport");
        Window stage = null;
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("GIF", "*.gif"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        File selectedFile = fileChooser.showOpenDialog(stage);
        System.out.println("Le chemin est CIN/Passeport: " + selectedFile);
        Path selectedFile_path = selectedFile.toPath();
        String selectedFile_string = selectedFile_path.toString();

        picture.setImage(new Image(selectedFile_string));
        //    Uploader.uploadFile(IDSession,selectedFile_string);
    }
}
