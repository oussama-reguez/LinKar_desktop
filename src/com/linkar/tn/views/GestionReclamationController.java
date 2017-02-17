/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.views;

import com.jfoenix.controls.JFXButton;
import com.linkar.tn.entities.Membre;
import com.linkar.tn.entities.Reclamation;
import com.linkar.tn.services.MembreServices;
import com.linkar.tn.services.ReclamationService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import linkar_test.GestureEvents;

/**
 * FXML Controller class
 *
 * @author Oussama Reguez
 */

public class GestionReclamationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    ReclamationService reclamationService = new ReclamationService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table =generateTable(reclamationService.getAllReclamation(false));
        container.getChildren().add(1,table);
        // TODO
    }    
    
     TableView<Reclamation> generateTable(List<Reclamation> reclamations){
       
         TableView<Reclamation> table = new TableView<Reclamation>();
        
        
         
         ObservableList<Reclamation> data =FXCollections.observableArrayList(reclamations);
          table.setEditable(true);
          /*
         TableColumn firstNameCol = new TableColumn("First Name"); 
         firstNameCol.setCellValueFactory(
                new PropertyValueFactory<GestureEvents.Person, String>("first_name"));

        */
          //firstNameCol.setCellValueFactory(cellData ->{System.out.println("sdfsdf"+cellData.getValue().getLast_name());return new ReadOnlyStringWrapper(cellData.getValue().getFirst_name());});
        TableColumn subjectCol = new TableColumn("subject"); 
        subjectCol.setCellValueFactory(
                new PropertyValueFactory<GestureEvents.Person, String>("subject"));
          
          TableColumn typeCol = new TableColumn("type"); 
         typeCol.setCellValueFactory(
                new PropertyValueFactory<GestureEvents.Person, String>("type"));
         
         
         
          
           ////////////////////////////////////////////////////////
 TableColumn<Reclamation, Reclamation> CompteCol = new TableColumn<>("Utilisateur");
  
        CompteCol.setMinWidth(150);
        CompteCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reclamation, Reclamation>, ObservableValue<Reclamation>>() {
          @Override public ObservableValue<Reclamation> call(TableColumn.CellDataFeatures<Reclamation,Reclamation> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
        
       CompteCol.setCellFactory(new Callback<TableColumn<Reclamation, Reclamation>, TableCell<Reclamation, Reclamation>>() {
          @Override public TableCell<Reclamation ,Reclamation> call(TableColumn<Reclamation, Reclamation> btnCol) {
            return new TableCell<Reclamation,Reclamation>() {
              
//init label
                
                
            
              @Override public void updateItem(final Reclamation reclamation, boolean empty) {
                super.updateItem(reclamation, empty);
                if (reclamation != null) {
        Label l = generateLabel(reclamation.getMembre());
                    //set here
                     setGraphic(l);
                } else {
                  setGraphic(null);
                }
              }
            };
          }
        });
 
 
       
       /////////////
       TableColumn<Reclamation, Reclamation> ReclamationCol = new TableColumn<>("Actions");
       // btnCol.setMinWidth(150);
        ReclamationCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reclamation, Reclamation>, ObservableValue<Reclamation>>() {
          @Override public ObservableValue<Reclamation> call(TableColumn.CellDataFeatures<Reclamation, Reclamation> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
     
        ReclamationCol.setCellFactory(new Callback<TableColumn<Reclamation, Reclamation>, TableCell<Reclamation, Reclamation>>() {
          @Override public TableCell<Reclamation, Reclamation> call(TableColumn<Reclamation, Reclamation> btnCol) {
            return new TableCell<Reclamation, Reclamation>() {
               
               
           
              @Override public void updateItem(final Reclamation reclamation, boolean empty) {
                super.updateItem(reclamation, empty);
                if (reclamation != null) {
                    System.out.println("Reclamatioddddddddddddddn "+String.valueOf(reclamation.getId_reclamation()));
              Label  l = new Label("Reclamation "+String.valueOf(reclamation.getId_reclamation()));
             //Image img = new Image("file:images/user.png");
             Image img = new Image("file:images/Document-01-32.png");
        ImageView iv= new ImageView(img);
        l.setGraphic(iv);
            setGraphic(l);
                    
                } else {
                  setGraphic(null);
                }
              }
            };
          }
        });
       
       ///////////
 
 ///////////////////////////////////////////////////////////
   
 
 
        TableColumn<Reclamation, Reclamation> btnCol = new TableColumn<>("Actions");
       // btnCol.setMinWidth(150);
        btnCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Reclamation, Reclamation>, ObservableValue<Reclamation>>() {
          @Override public ObservableValue<Reclamation> call(TableColumn.CellDataFeatures<Reclamation, Reclamation> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
     
        btnCol.setCellFactory(new Callback<TableColumn<Reclamation, Reclamation>, TableCell<Reclamation, Reclamation>>() {
          @Override public TableCell<Reclamation, Reclamation> call(TableColumn<Reclamation, Reclamation> btnCol) {
            return new TableCell<Reclamation, Reclamation>() {
               
               
              final ImageView buttonGraphic = new ImageView();
              final Button button = new Button(); {
                button.setGraphic(buttonGraphic);
                button.setMinWidth(130);
              }
              @Override public void updateItem(final Reclamation reclamation, boolean empty) {
                super.updateItem(reclamation, empty);
                if (reclamation != null) {
                HBox hbox = new HBox();
   

    JFXButton buttonProfil = new JFXButton ();
    
    buttonProfil.setGraphic(new ImageView(new Image("file:images/User-32.png")));
  //  buttonCurrent.setPrefSize(100, 20);

  
   JFXButton buttonOpen = new JFXButton ();
   buttonOpen.setGraphic(new ImageView(new Image("file:images/Open-32.png")));
    JFXButton buttonMark = new JFXButton ();
   buttonMark.setGraphic(new ImageView(new Image("file:images/Document-Check-32.png")));
   
buttonMark.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent event) {
                 reclamationService.markReclamation(true, reclamation.getId_reclamation());
                
                        refreshTable(reclamationService.getAllReclamation(false));
                        
                    }
                  });
   
    
   

    hbox.getChildren().addAll(buttonOpen,buttonMark );
                  setGraphic(hbox);
                //  person.getFirst_name();
                  //button.setText(person.getFirst_name());
                  
                  button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent event) {
                  //    actionTaken.setText("Bought " + person.getLikes().toLowerCase() + " for: " + person.getFirstName() + " " + person.getLastName());
                  //   System.out.println("hello"+person.isRole());
                    }
                  });
                } else {
                  setGraphic(null);
                }
              }
            };
          }
        });

        table.setItems(data);
        table.getColumns().clear();
        table.getColumns().addAll(ReclamationCol,CompteCol,typeCol,subjectCol,btnCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
       
        return table;
    }
    MembreServices membreService=new MembreServices() ;
    public void refreshTable(List<Reclamation>reclamations){
 
         ObservableList<Reclamation> data =FXCollections.observableArrayList(reclamations);
       table.getItems().clear();
        table.getItems().addAll(data);
    }
     TableView<Reclamation> table;
    Label generateLabel(Membre m){
        
          Label l=null;
       
       
        String url=m.getUrl_picture();
                l = new Label(m.getFirst_name()+" "+m.getLast_name());
             //Image img = new Image("file:images/user.png");
             Image img = new Image(m.getUrl_picture());
        ImageView iv= new ImageView(img);
            l.setGraphic(iv);
           
          //  list.getItems().add(l);
             
              
        
        
      
       
          
          
        
        return l;
    }
    
     @FXML
    private VBox container;
    
}
