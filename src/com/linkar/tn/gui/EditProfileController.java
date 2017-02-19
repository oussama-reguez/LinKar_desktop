/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.gui;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.linkar.tn.entities.Membre;
import static com.linkar.tn.gui.LoginController.IDSession;
import com.linkar.tn.services.MembreServices;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
public class EditProfileController implements Initializable {

    @FXML
    private JFXTextField editnom;
    @FXML
    private JFXTextField editprenom;
    @FXML
    private JFXTextField editphone;
    @FXML
    private JFXTextArea editaddress;
    @FXML
    private JFXTextField editemail;
    @FXML
    private JFXDatePicker editbirth;
    @FXML
    private ImageView editpicturepreview;
    /**
     * Initializes the controller class.
     */
    MembreServices s = new MembreServices();
    Membre m = s.getById(IDSession);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        editnom.setText(m.getLast_name());
        editprenom.setText(m.getFirst_name());
        editemail.setText(m.getEmail());
        editaddress.setText(m.getAddress());
        editphone.setText(String.valueOf(m.getPhone_number()));
        editbirth.setValue(m.getBirth().toLocalDate());
        editpicturepreview.setImage(new Image(m.getUrl_picture()));

    }

    @FXML
    public void doedit(ActionEvent ae) throws IOException {
        Membre n = new Membre();
        LocalDate date = editbirth.getValue();

        Date birth = Date.valueOf(date);
        System.out.println(n.getLast_name());
        s.edit(IDSession,
                editnom.getText(),
                editprenom.getText(),
                birth,
                editphone.getText(),
                editaddress.getText(),
                editemail.getText()
        );
        Parent login_page = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }

    @FXML
    public void editimage(ActionEvent ae) throws IOException {
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

        editpicturepreview.setImage(new Image(selectedFile_string));
        //    Uploader.uploadFile(IDSession,selectedFile_string);
    }

}
