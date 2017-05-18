/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.controllers;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.linkar.tn.entities.Membre;
import com.linkar.tn.entities.Reclamation;
import com.linkar.tn.services.MembreServices;
import com.linkar.tn.services.ReclamationService;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;


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
    @FXML
    private StackPane stackPane;
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
        TableColumn subjectCol = new TableColumn("sujet"); 
        subjectCol.setCellValueFactory(
                new PropertyValueFactory<Reclamation, String>("subject"));
          
          TableColumn typeCol = new TableColumn("type"); 
         typeCol.setCellValueFactory(
                new PropertyValueFactory<Reclamation, String>("type"));
         
         
         
          
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
       TableColumn<Reclamation, Reclamation> ReclamationCol = new TableColumn<>("Reclamation");
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
                
                      reclamation.setMarked(true);
                      table.getItems().remove(reclamation);
                      table.refresh();
                        
                    }
                  });
   
buttonOpen.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent event) {
                        try {
                            showReclamationDialog(reclamation);
                        } catch (IOException ex) {
                            Logger.getLogger(GestionReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
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
    
    
    
     void showReclamationDialog(Reclamation r) throws IOException{
       
         JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Reclamation"));
       ;
       AnchorPane pane =new AnchorPane();
      pane.setMaxHeight(500);
       pane.setMaxWidth(550);
      Text t = new Text("from:");
      
               Label l = new Label(r.getMembre().getFirst_name()+" "+r.getMembre().getLast_name());
               l.setStyle("-fx-padding: 0px 0px 0px 20px ;");
             Image img = new Image(r.getMembre().getUrl_picture());
            // Image img = new Image(m.getUrl_picture());
        ImageView iv= new ImageView(img);
            l.setGraphic(iv);
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String d = formatter.format(r.getDate_Reclamation());
           
       Text date = new Text("date : "+d);
      
       HBox from= new HBox(); 
           from.getChildren().addAll(t,l);
            from.setStyle("-fx-padding: 10px 0px 0px 0px ;");
            
             HBox datee= new HBox(); 
           datee.getChildren().addAll(date);
     
           datee.setStyle("-fx-padding: 10px 0px 10px 0px ;");
       
       TextArea text = new TextArea();
       text.setStyle("-fx-padding: 50px 50px 0px 0px;");
             text.setText(r.getText());
             
            text.setStyle("text-area-background: green;");
              
text.setMaxWidth(350);
text.setMaxHeight(500);

VBox vbox = new VBox();

       
     
       vbox.getChildren().addAll(from,datee,text);
       pane.getChildren().addAll(vbox);
       
       

      
        JFXButton buttonConfirm = new JFXButton ("marker");
        
        JFXButton buttonCancel = new JFXButton ("annuler");
        content.getActions().addAll(buttonConfirm,buttonCancel);
        buttonConfirm.setOnAction(((event) -> {
        reclamationService.markReclamation(true, r.getId_reclamation());
                
                      r.setMarked(true);
                      table.getItems().remove(r);
                      table.refresh();
             dialog.close();
            
        }));
        buttonCancel.setOnAction(((event) -> {
              dialog.close();
        }));
       
        /*
        
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML2.fxml"));
       AnchorPane aa = (AnchorPane) fxmlLoader.load();
      //  GestionCompteController controller=fxmlLoader.<GestionCompteController>getController();
        //controller.initTT();
         content.setBody(aa);
    } catch(Exception e) {
        e.printStackTrace();
    }
        */
        //loader.<FXML2Controller>getController().initTT();
      //  AnchorPane a = (AnchorPane) loader.load();
         
          
       content.setBody(pane);
         dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.TOP);
        dialog.show();
       
    }
     
    JFXDialog dialog;
    public void initTT(){
        
    }
   
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
