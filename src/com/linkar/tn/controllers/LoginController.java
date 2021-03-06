/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.controllers;

import com.chilkatsoft.CkCrypt2;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.linkar.tn.technics.DataSource;
import com.linkar.tn.utils.BCrypt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
public class LoginController {

    @FXML
    private Label invalid_label;
    @FXML
    private JFXTextField email_box;
    @FXML
    private JFXPasswordField password_box;

    @FXML
    public void login(ActionEvent ae) throws IOException {

        if (VerifLogin() != 0) {
            Parent login_page = FXMLLoader.load(getClass().getResource("/com/linkar/tn/gui/MainView.fxml"));
            Scene login_scene = new Scene(login_page);
            Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(login_scene);
            app_stage.show();
        } else {
            invalid_label.setText("Email et/ou mot de passe érroné(s)");
            email_box.clear();
            password_box.clear();
        }

    }

    @FXML
    public void exit(ActionEvent ae) {
        ((Node) (ae.getSource())).getScene().getWindow().hide();
    }

    @FXML
    public void gotoregister(ActionEvent ae) throws IOException {
        Parent login_page = FXMLLoader.load(getClass().getResource("/com/linkar/tn/gui/Register.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }
    static int IDSession;

    private int VerifLogin() {
        Connection c;
        IDSession = 0;
        c = DataSource.getDataSource().getConnection();
        Statement stmt = null;
        Statement stmt2 = null;
        try {
            c.setAutoCommit(false);
            System.out.println("Accès à la base de données réussi (LoginController) ♫");
            
            stmt = c.createStatement();
            stmt2 = c.createStatement();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM membre WHERE email= " + "'" + email_box.getText() + "'"
                    )) {
                while (rs.next()) 
                {
                    
                    if (rs.getString("email") != null && rs.getString("password") != null) {
                        String username = rs.getString("email");
                        System.out.println("email = " + username);
                        String password = rs.getString("password");
                       password=password.replace("y", "a");
                       
                        if (BCrypt.checkpw(password_box.getText(), password)){
                            System.out.println("It matches");
                           IDSession=  rs.getInt("id");
                        }
	
                        
                        
else
	System.out.println("It does not match");
                        System.out.println("password = " + password);
                        
                        System.out.println("ID Session est: " + IDSession);
                    }
                }
            }
            stmt.close();
            stmt2.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Success (LoginController: vérification réussie) ☻");
        return IDSession;
    }
}
