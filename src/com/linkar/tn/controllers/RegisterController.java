/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.controllers;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import com.linkar.tn.Iservice.MembreIService;
import com.linkar.tn.entities.Membre;
import com.linkar.tn.services.MembreServices;
import java.io.IOException;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.validator.EmailValidator;

/**
 *
 * @author Rishya
 */
public class RegisterController implements Initializable {

    @FXML
    private Label emaillabel, datelabel, sexelabel;
    @FXML
    private JFXTextField nomfield;
    @FXML
    private JFXTextField prenomfield;
    @FXML
    private JFXTextField numberfield;
    @FXML
    private JFXTextField emailfield;
    @FXML
    private JFXPasswordField passwordfield;
    @FXML
    private JFXTextArea addressfield;
    @FXML
    private JFXRadioButton genderhomme;
    @FXML
    private JFXRadioButton genderfemme;
    @FXML
    private JFXDatePicker datefield;
    public int email_valid = 0;
    public int date_valid = 0;
    public int gender_valid = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage("Champs obligatoire!");
        nomfield.getValidators().add(validator);
        nomfield.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                nomfield.validate();
            }
        });
        RequiredFieldValidator validator2 = new RequiredFieldValidator();
        prenomfield.getValidators().add(validator2);
        validator2.setMessage("Champs obligatoire!");
        prenomfield.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                prenomfield.validate();
            }
        });
        NumberValidator validator3 = new NumberValidator();
        numberfield.getValidators().add(validator3);
        validator3.setMessage("Numéro invalide!");
        numberfield.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                numberfield.validate();
            }
        });
        RequiredFieldValidator validator4 = new RequiredFieldValidator();
        addressfield.getValidators().add(validator4);
        validator4.setMessage("Champs obligatoire!");
        addressfield.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                addressfield.validate();
            }
        });
        datefield.focusedProperty().addListener((observable, oldValue, newValue)
                -> {
            if (datefield.isFocused() == false) {
                if (datefield.getValue() != null) {
                    date_valid = 1;
                    datelabel.setText("");
                } else {
                    datelabel.setText("Champs obligatoire!");
                    date_valid = 0;
                }
            }
        });

        RequiredFieldValidator validator6 = new RequiredFieldValidator();
        passwordfield.getValidators().add(validator6);
        validator6.setMessage("Champs obligatoire!");
        passwordfield.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                passwordfield.validate();
            }
        });

        emailfield.focusedProperty().addListener((observable, oldValue, newValue)
                -> {
            if (emailfield.isFocused() == false) {
                EmailValidator validator10 = EmailValidator.getInstance();
                if (!validator10.isValid(emailfield.getText())) {
                    emaillabel.setText("Email invalide!");
                    email_valid = 0;
                } else {
                    email_valid = 1;
                    emaillabel.setText("");
                }
            }
        });
    }

    @FXML
    public void register(ActionEvent ae) throws Exception {
        String last_name = nomfield.getText();
        String first_name = prenomfield.getText();
        String email = emailfield.getText();
        String password = passwordfield.getText();
        String address = addressfield.getText();
        String phone_number = numberfield.getText();
        String gender = null;
        LocalDate date = datefield.getValue();

        Date date_naiss = Date.valueOf(date); //Convert from LocalDate to sqlDate

        if (genderfemme.isSelected()) {
            gender = ("Femme");
            sexelabel.setText("");
            gender_valid = 1;
        }
        if (genderhomme.isSelected()) {
            gender = ("Homme");
            sexelabel.setText("");
            gender_valid = 1;
        }
        if (!genderhomme.isSelected() && !genderfemme.isSelected()) {
            gender_valid = 0;
            sexelabel.setText("Champs obligatoire!");
        } else {
            gender_valid = 1;
            sexelabel.setText("");
        }
        if (email_valid == 1 && date_valid == 1 && gender_valid == 1) {
            int sms_code = ThreadLocalRandom.current().nextInt(1000, 999999);
            Membre m = new Membre(last_name, first_name, date_naiss, email, password, phone_number, gender, false, false, false, false, address, sms_code);
            MembreIService s = new MembreServices();
            s.add(m);
            //Email
            sendMail(email, first_name, last_name);
            // + Notification
            //
            Parent register2_page = FXMLLoader.load(getClass().getResource("/com/linkar/tn/gui/Register2.fxml"));
            Scene register2_scene = new Scene(register2_page);
            Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(register2_scene);
            app_stage.show();

            if (email_valid == 1 && date_valid == 0 && gender_valid == 1) {
                System.out.println("test");
                datelabel.setText("Champs obligatoire!");
            }
        }
    }

    @FXML
    public void exit(ActionEvent ae) {
        ((Node) (ae.getSource())).getScene().getWindow().hide();
    }

    @FXML
    public void gotologin(ActionEvent ae) throws IOException {
        Parent login_page = FXMLLoader.load(getClass().getResource("/com/linkar/tn/gui/Login.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }

    public void sendMail(String email,String first_name,String last_name) throws MessagingException, SQLException {
        final String username = "linkar.contact@gmail.com";
        final String pass = "Nana0511";
        Properties props = new Properties();
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "25");
        props.put("mail.debug", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.EnableSSL.enable", "true");

        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, pass);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        message.setSubject("Bienvenu(e) "+first_name+" "+last_name+" à LinKar!");
        message.setContent("Votre inscription à été effectuée!", "text/html;charset=utf-8");
        Transport.send(message);
        System.out.println("Email sent.");

    }
}
