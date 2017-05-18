/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import com.jfoenix.controls.JFXButton;
import com.linkar.tn.entities.Ratings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * FXML Controller class
 *
 * @author WIKI
 */
public class TableAvisController implements Initializable {

    @FXML
    private TableColumn clrate;
    @FXML
    private TableColumn clcommentaire;
    @FXML
    private TableView  rates;
    @FXML
    private TableColumn  clid;
    @FXML
    private JFXButton delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ObservableList<Ratings> ratings = FXCollections.observableArrayList();
        
        recupererRatings dao = new recupererRatings();
        
        ratings = dao.lister() ;
        
        rates.getItems().clear();
        rates.setItems(ratings);
        
        
//        clid.setCellValueFactory(new PropertyValueFactory<Ratings, Integer>("id_rater"));
        
        
         clrate.setCellValueFactory(new PropertyValueFactory<Ratings, Double>("rating"));
          
         clcommentaire.setCellValueFactory(new PropertyValueFactory<Ratings, String>("feedback"));
        
        
         

        
       
        
        
        
        
    }    
    
}
