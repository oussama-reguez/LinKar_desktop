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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import Entities.RecData ;
import Entities.TableData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.jfoenix.controls.JFXButton;
import com.linkar.tn.services.ReclamationData;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyProperty;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author WIKI
 */
public class InterRecuperationController implements Initializable {

    @FXML
    AnchorPane view1 ;
    @FXML
    Label lal2 ;
    @FXML
    TableView tbrec ;
    @FXML
    TableColumn cltype ;
     @FXML
    TableColumn clsujet ;
     @FXML
    TableColumn cldescription ;
    @FXML
    Pane pane1 ;
    @FXML
    private JFXButton delete;
    @FXML
    private TableColumn cldelete;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ObservableList<RecData> data = FXCollections.observableArrayList();
        
        ReclamationData dao = new ReclamationData() ;
        data = dao.lister() ;
        
        tbrec.getItems().clear();
        tbrec.setItems(data);
        
        
        cltype.setCellValueFactory(new PropertyValueFactory<RecData, String>("type"));
        
        
         clsujet.setCellValueFactory(new PropertyValueFactory<RecData, String>("sujet"));
          
         cldescription.setCellValueFactory(new PropertyValueFactory<RecData, String>("description"));
         
         
  

                delete.setOnAction(e-> {
         
         RecData selectItems = (RecData) tbrec.getSelectionModel().getSelectedItem();
         tbrec.getItems().remove(selectItems) ;
         
         
         
         
         }
         
         
         
         
         
         
         
         );
         
         
         
         
         
         
    }    
    
}
