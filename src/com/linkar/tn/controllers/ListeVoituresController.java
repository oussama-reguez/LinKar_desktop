/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.controllers;


import com.linkar.tn.Iservices.VoitureIService;
import com.linkar.tn.entities.Voiture;
import com.linkar.tn.services.VoitureServices;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML
    private TableView tableCars;
    @FXML
    private TableColumn clbrand;
    @FXML
    private TableColumn clcouleur;
    @FXML
    private TableColumn clmarque;
    @FXML
    private TableColumn clconfort;
    @FXML
    private TableColumn clplaces;
    
    VoitureIService s = new VoitureServices();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Voiture> cars = FXCollections.observableArrayList(s.getAllCars(LoginController.IDSession));
        tableCars.setItems(cars);
        
        
        
         clbrand.setCellValueFactory(new PropertyValueFactory<Voiture, String>("brand"));
         clmarque.setCellValueFactory(new PropertyValueFactory<Voiture, String>("model"));
         clcouleur.setCellValueFactory(new PropertyValueFactory<Voiture, String>("color"));
         clconfort.setCellValueFactory(new PropertyValueFactory<Voiture, String>("confort"));
         clplaces.setCellValueFactory(new PropertyValueFactory<Voiture, String>("number_places"));
         
          //tableCars.getColumns().addAll(CompteCol,GenderCol,EmailCol,telCol,statutCol,comboCol,btnCol);
          
    }

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
    public void addcar(ActionEvent ae) throws IOException {
        Parent login_page = FXMLLoader.load(getClass().getResource("/com/linkar/tn/gui/AjoutVoiture.fxml"));
        Scene login_scene = new Scene(login_page);
        Stage app_stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(login_scene);
        app_stage.show();
    }

}
