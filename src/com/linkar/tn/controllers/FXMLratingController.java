/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.controllers;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import Entities.TableData;
import Entities.RecData;
import com.linkar.tn.services.LstData;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author WIKI
 */
public class FXMLratingController implements Initializable {

    @FXML
    AnchorPane view ;
    AnchorPane critere ;
    Label lbl1 ;
    @FXML
    TableView tbmembre;
    @FXML
    TableColumn clnom ;
    @FXML
    TableColumn clnum ;
    @FXML
    TableColumn clemail ;
   
      @FXML
      JFXTextField rechercher ;
       JFXCheckBox parnom ;
        JFXCheckBox paremail ;
     JFXCheckBox parnum ;
      TableView tab ;
    @FXML
    private Label lal1;
    
    
    
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        tbmembre.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                
                
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/com/linkar/tn/views/App.fxml"));
                    Scene scene = new Scene(root);
                    Stage primaryStage = new Stage();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLratingController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        } );
         
     //    parnom.setSelected(true);
        
        
        
        ObservableList<TableData> data = FXCollections.observableArrayList();
        
        LstData dao = new LstData() ;
        
          data=dao.lister();
        tbmembre.getItems().clear();
      //  tbmembre.setItems(data);
        
         clnom.setCellValueFactory(new PropertyValueFactory<TableData, String>("nom"));
          clnum.setCellValueFactory(new PropertyValueFactory<TableData, Double>("num"));
           clemail.setCellValueFactory(new PropertyValueFactory<TableData, String>("email"));
          
           if (rechercher == null){
           
               System.err.println("*******");
           }
           
        rechercher.textProperty().addListener(new ChangeListener<String>(){
       @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    String search =rechercher.getText();
                    LstData cr = new LstData();
                             ObservableList<TableData> data = FXCollections.observableArrayList(cr.findbyname(search));

                    tbmembre.setItems(data);
    }
              });
           
          
        
        
        
        
        
        
        
           
    }    
    
    
    }    
    
            
                   
                    