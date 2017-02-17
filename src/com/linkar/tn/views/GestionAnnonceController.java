/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.views;

import com.jfoenix.controls.JFXButton;
import com.linkar.tn.entities.Annonce;
import com.linkar.tn.entities.Membre;
import com.linkar.tn.entities.Reclamation;
import com.linkar.tn.services.AnnonceServices;
import com.linkar.tn.services.MembreServices;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import linkar_test.GestureEvents;

/**
 * FXML Controller class
 *
 * @author Oussama Reguez
 */
public class GestionAnnonceController implements Initializable {

    
    TableView<Annonce> generateTable(List<Annonce> annonces){
       
         TableView<Annonce> table = new TableView<Annonce>();
        
        
         
         ObservableList<Annonce> data =FXCollections.observableArrayList(annonces);
          table.setEditable(true);
          /*
         TableColumn firstNameCol = new TableColumn("First Name"); 
         firstNameCol.setCellValueFactory(
                new PropertyValueFactory<GestureEvents.Person, String>("first_name"));

        */
          //firstNameCol.setCellValueFactory(cellData ->{System.out.println("sdfsdf"+cellData.getValue().getLast_name());return new ReadOnlyStringWrapper(cellData.getValue().getFirst_name());});
        TableColumn descriptionCol = new TableColumn("Description"); 
       descriptionCol.setCellValueFactory(
                new PropertyValueFactory<GestureEvents.Person, String>("description"));
           TableColumn dateCol = new TableColumn("type"); 
        dateCol.setCellValueFactory(
   new Callback<TableColumn.CellDataFeatures<Annonce, String>, ObservableValue<String>>() {
      @Override
      public ObservableValue<String> call(TableColumn.CellDataFeatures<Annonce, String> annonce) {
         SimpleStringProperty property = new SimpleStringProperty();
         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         property.setValue(dateFormat.format(annonce.getValue().getDate_annonce()));
         return property;
      }
   });
       
        
      
           ////////////////////////////////////////////////////////
 TableColumn<Annonce, Annonce> CompteCol = new TableColumn<>("Utilisateur");
  
        CompteCol.setMinWidth(150);
        CompteCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Annonce, Annonce>, ObservableValue<Annonce>>() {
          @Override public ObservableValue<Annonce> call(TableColumn.CellDataFeatures<Annonce,Annonce> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
        
       CompteCol.setCellFactory(new Callback<TableColumn<Annonce, Annonce>, TableCell<Annonce, Annonce>>() {
          @Override public TableCell<Annonce ,Annonce> call(TableColumn<Annonce, Annonce> btnCol) {
            return new TableCell<Annonce,Annonce>() {
              
//init label
                
                
            
              @Override public void updateItem(final Annonce annonce, boolean empty) {
                super.updateItem(annonce, empty);
                if (annonce != null) {
        Label l = generateLabel(annonce.getM());
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
       TableColumn<Annonce, Annonce> AnnonceCol = new TableColumn<>("Actions");
       // btnCol.setMinWidth(150);
       AnnonceCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Annonce, Annonce>, ObservableValue<Annonce>>() {
          @Override public ObservableValue<Annonce> call(TableColumn.CellDataFeatures<Annonce, Annonce> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
     
       AnnonceCol.setCellFactory(new Callback<TableColumn<Annonce, Annonce>, TableCell<Annonce, Annonce>>() {
          @Override public TableCell<Annonce, Annonce> call(TableColumn<Annonce, Annonce> btnCol) {
            return new TableCell<Annonce, Annonce>() {
               
               
           
              @Override public void updateItem(final Annonce annonce, boolean empty) {
                super.updateItem(annonce, empty);
                if (annonce != null) {
                    System.out.println(annonce.getId_annonce());
                   // System.out.println("Reclamatioddddddddddddddn "+String.valueOf(annonce.getId_reclamation()));
             Label  l = new Label("Annonce "+String.valueOf(annonce.getId_annonce()));
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
   
 
 
        TableColumn<Annonce, Annonce> btnCol = new TableColumn<>("Actions");
       // btnCol.setMinWidth(150);
        btnCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Annonce, Annonce>, ObservableValue<Annonce>>() {
          @Override public ObservableValue<Annonce> call(TableColumn.CellDataFeatures<Annonce, Annonce> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
     
        btnCol.setCellFactory(new Callback<TableColumn<Annonce, Annonce>, TableCell<Annonce, Annonce>>() {
          @Override public TableCell<Annonce, Annonce> call(TableColumn<Annonce, Annonce> btnCol) {
            return new TableCell<Annonce, Annonce>() {
               
               
              final ImageView buttonGraphic = new ImageView();
              final Button button = new Button(); {
                button.setGraphic(buttonGraphic);
                button.setMinWidth(130);
              }
              @Override public void updateItem(final Annonce annonce, boolean empty) {
                super.updateItem(annonce, empty);
                if (annonce != null) {
                HBox hbox = new HBox();
   

    JFXButton buttonRemove = new JFXButton ();
    
    buttonRemove.setGraphic(new ImageView(new Image("file:images/Close-32.png")));
  //  buttonCurrent.setPrefSize(100, 20);

  
   JFXButton buttonOpen = new JFXButton ();
   buttonOpen.setGraphic(new ImageView(new Image("file:images/Open-32.png")));
    JFXButton buttonBlock = new JFXButton ();
   buttonBlock.setGraphic(new ImageView(new Image("file:images/User-Lock-32.png")));
   
buttonBlock.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent event) {
               //  reclamationService.markReclamation(true, reclamation.getId_reclamation());
                
                 //       refreshTable(reclamationService.getAllReclamation(false));
                        
                    }
                  });
   
    
   

    hbox.getChildren().addAll(buttonOpen,buttonRemove,buttonBlock );
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
        table.getColumns().addAll(AnnonceCol,CompteCol,descriptionCol,dateCol,btnCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
       
        return table;
    }
    MembreServices membreService=new MembreServices() ;
    public void refreshTable(List<Annonce>annonces){
 
         ObservableList<Annonce> data =FXCollections.observableArrayList(annonces);
       table.getItems().clear();
        table.getItems().addAll(data);
    }
     TableView<Annonce> table;
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
    /**
     * Initializes the controller class.
     */
    
      @FXML
    private VBox container;
    AnnonceServices annonceService = new AnnonceServices();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table =generateTable(annonceService.getAllAnnonces());
        container.getChildren().add(table);
        // TODO
    }    
    
}
