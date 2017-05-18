/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.controllers;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.linkar.tn.entities.Membre;
import com.linkar.tn.entities.Notification;
import com.linkar.tn.entities.Reclamation;
import com.linkar.tn.services.MembreServices;

import java.io.IOException;
import java.lang.reflect.Member;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
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

import org.controlsfx.control.action.Action;

/**
 * FXML Controller class
 *
 * @author Oussama Reguez
 */
public class GestionCompteController implements Initializable {

    @FXML
    private TableView<Membre> mTable;
   
    @FXML
    private StackPane stackPane;
 
   /**
     * Initializes the controller class.
     */
    void  generateTable(List<Membre> membres,int af){
       
       
    
         membres.forEach((a)->System.out.println("dd"+a));
         
         ObservableList<Membre> data =FXCollections.observableArrayList(membres);
          //table.setEditable(true);
          /*
         TableColumn firstNameCol = new TableColumn("First Name"); 
         firstNameCol.setCellValueFactory(
                new PropertyValueFactory<GestureEvents.Person, String>("first_name"));

        */
          //firstNameCol.setCellValueFactory(cellData ->{System.out.println("sdfsdf"+cellData.getValue().getLast_name());return new ReadOnlyStringWrapper(cellData.getValue().getFirst_name());});
      
          
          TableColumn firstNameCol = new TableColumn("First Name"); 
         firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Membre, String>("first_name"));
          
          TableColumn EmailCol = new TableColumn("Email"); 
         EmailCol.setCellValueFactory(
                new PropertyValueFactory<Membre, String>("email"));
         
          TableColumn GenderCol = new TableColumn("Genre"); 
        
        GenderCol.setStyle("-fx-alignment: CENTER;");
         GenderCol.setCellValueFactory(
                new PropertyValueFactory<Membre, String>("gender"));
         
          
         
         ////////////////////////////////////////////////////////
 TableColumn<Membre, Membre> telCol = new TableColumn<>("Telephone");
  
     //   telCol.setMinWidth(80);
        telCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Membre, Membre>, ObservableValue<Membre>>() {
          @Override public ObservableValue<Membre> call(TableColumn.CellDataFeatures<Membre, Membre> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
        
        telCol.setCellFactory(new Callback<TableColumn<Membre, Membre>, TableCell<Membre, Membre>>() {
          @Override public TableCell<Membre, Membre> call(TableColumn<Membre, Membre> btnCol) {
            return new TableCell<Membre, Membre>() {
                
                
            
              @Override public void updateItem(final Membre person, boolean empty) {
                super.updateItem(person, empty);
                if (person != null) {
                    String k=person.getPhone_number();
              Label l = new Label(k);
                    setGraphic(l);
                } else {
                  setGraphic(null);
                }
              }
            };
          }
        });
 
 
 
 ///////////////////////////////////////////////////////////
         
         
                 ////////////////////////////////////////////////////////
 TableColumn<Membre, Membre> comboCol = new TableColumn<>("Role");
  
        
        comboCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Membre, Membre>, ObservableValue<Membre>>() {
          @Override public ObservableValue<Membre> call(TableColumn.CellDataFeatures<Membre, Membre> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
        
       comboCol.setCellFactory(new Callback<TableColumn<Membre, Membre>, TableCell<Membre, Membre>>() {
          @Override public TableCell<Membre, Membre> call(TableColumn<Membre, Membre> btnCol) {
            return new TableCell<Membre, Membre>() {
                
                
                
            
              @Override public void updateItem(final Membre person, boolean empty) {
                super.updateItem(person, empty);
                if (person != null) {
                    ObservableList<String> options = 
    FXCollections.observableArrayList(
        "Administrateur",
        "Utilisateur"
      
    );
 ComboBox comboBox = new ComboBox(options);
                               comboBox.setOnAction((event) -> {
   
   
    
 
               if(comboBox.getValue().equals("Administrateur")){
                   person.setRole(true);
                   
                  // membreService.changeRole(true, person.getId_member());
               }
               else{
                   person.setRole(false);
                    
               }
               membreService.changeRole(person.isRole(), person.getId_member());
               mTable.refresh();
                //System.out.println(person.isRole());
               
});
                    
                if(person.isRole()){
                    comboBox.setValue("Administrateur");
                    
                }
                else{
                    comboBox.setValue("Utilisateur");
                }
                       // comboBox.setValue(table);
                  setGraphic(comboBox);
   
                }
                else {
                  setGraphic(null);
                }
              }
            };
          }
        });
 
 
 
 ///////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////
 TableColumn<Membre, Membre> CompteCol = new TableColumn<>("Utilisateur");
  
       // CompteCol.setMinWidth(150);
        CompteCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Membre, Membre>, ObservableValue<Membre>>() {
          @Override public ObservableValue<Membre> call(TableColumn.CellDataFeatures<Membre, Membre> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
        
       CompteCol.setCellFactory(new Callback<TableColumn<Membre, Membre>, TableCell<Membre, Membre>>() {
          @Override public TableCell<Membre, Membre> call(TableColumn<Membre, Membre> btnCol) {
            return new TableCell<Membre, Membre>() {
              
//init label
                
                
            
              @Override public void updateItem(final Membre person, boolean empty) {
                super.updateItem(person, empty);
                if (person != null) {
        Label l = generateLabel(person);
                    //set here
                     setGraphic(l);
                } else {
                  setGraphic(null);
                }
              }
            };
          }
        });
 
 
 
 ///////////////////////////////////////////////////////////
 
         ////////////////////////////////////////////////////////
 TableColumn<Membre, Membre> statutCol = new TableColumn<>("Statut");
  
       // CompteCol.setMinWidth(150);
        statutCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Membre, Membre>, ObservableValue<Membre>>() {
          @Override public ObservableValue<Membre> call(TableColumn.CellDataFeatures<Membre, Membre> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
        
       statutCol.setCellFactory(new Callback<TableColumn<Membre, Membre>, TableCell<Membre, Membre>>() {
          @Override public TableCell<Membre, Membre> call(TableColumn<Membre, Membre> btnCol) {
            return new TableCell<Membre, Membre>() {
              
//init label
                
                
            
              @Override public void updateItem(final Membre person, boolean empty) {
                super.updateItem(person, empty);
                if (person != null) {
                    Label l = new Label();
                    if(person.isStatut()){
                        l.setText("activer");
                        l.setTextFill(Color.web("#2ecc71"));
                    } else {
                         l.setText("bloqué");
                        l.setTextFill(Color.web("#e74c3c"));
                    }
                    
        
                    //set here
                     setGraphic(l);
                } else {
                  setGraphic(null);
                }
              }
            };
          }
        });
 
 
 
 ///////////////////////////////////////////////////////////
        TableColumn<Membre, Membre> btnCol = new TableColumn<>("Actions");
       // btnCol.setMinWidth(150);
        btnCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Membre, Membre>, ObservableValue<Membre>>() {
          @Override public ObservableValue<Membre> call(TableColumn.CellDataFeatures<Membre, Membre> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
     
        btnCol.setCellFactory(new Callback<TableColumn<Membre, Membre>, TableCell<Membre, Membre>>() {
          @Override public TableCell<Membre, Membre> call(TableColumn<Membre, Membre> btnCol) {
            return new TableCell<Membre, Membre>() {
               
               
              final ImageView buttonGraphic = new ImageView();
              final Button button = new Button(); {
                button.setGraphic(buttonGraphic);
                button.setMinWidth(130);
              }
              @Override public void updateItem(final Membre person, boolean empty) {
                super.updateItem(person, empty);
                if (person != null) {
                HBox hbox = new HBox();
   

    JFXButton buttonProfil = new JFXButton ();
    
    buttonProfil.setGraphic(new ImageView(new Image("file:images/User-32.png")));
  //  buttonCurrent.setPrefSize(100, 20);

  
   JFXButton buttonBlock = new JFXButton ();
    buttonBlock.setGraphic(new ImageView(new Image("file:images/User-Lock-32.png")));
    JFXButton buttonUnBlock = new JFXButton ();
   buttonUnBlock.setGraphic(new ImageView(new Image("file:images/User-Refresh-32.png")));
   
   JFXButton buttonDelete = new JFXButton ();
    buttonDelete.setGraphic(new ImageView(new Image("file:images/User-Delete-32.png")));
   
    if(person.isStatut()){
      hbox.getChildren().addAll(buttonProfil, buttonBlock,buttonDelete );
  } else {
      hbox.getChildren().addAll(buttonProfil, buttonUnBlock,buttonDelete );
  }
   

                  setGraphic(hbox);
                  person.getFirst_name();
                  button.setText(person.getFirst_name());
                  
                  buttonUnBlock.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent event) {
                  //    actionTaken.setText("Bought " + person.getLikes().toLowerCase() + " for: " + person.getFirstName() + " " + person.getLastName());
                  System.out.println(person.getId_member());
                  person.setStatut(true);
                  membreService.toggleMember(person.getId_member(), true);
                  
                mTable.refresh();
                       //refreshTable(membreService.getAllMembres());
                    }
                  });
                  
                  buttonBlock.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent event) {
                  //    actionTaken.setText("Bought " + person.getLikes().toLowerCase() + " for: " + person.getFirstName() + " " + person.getLastName());
                  System.out.println(person.getId_member());
                  person.setStatut(false);
                  membreService.toggleMember(person.getId_member(), false);
                
                       mTable.refresh();
                    }
                  });
                  
                  buttonDelete.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent event) {
                  //    actionTaken.setText("Bought " + person.getLikes().toLowerCase() + " for: " + person.getFirstName() + " " + person.getLastName());
                  System.out.println(person.getId_member());
                  membreService.delete(person);
                  mTable.getItems().remove(person);
                
                       mTable.refresh();
                    }
                  });
                } else {
                  setGraphic(null);
                }
              }
            };
          }
        });

        mTable.setItems(data);
       // table.getColumns().clear();
       mTable.getColumns().addAll(CompteCol,GenderCol,EmailCol,telCol,statutCol,comboCol,btnCol);
      mTable.setColumnResizePolicy((param) -> true );
      mTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
      
        
    }
    
    
    void ReclamationDialog(Reclamation r) throws IOException{
       
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
       
       

      
        JFXButton buttonConfirm = new JFXButton ("supprimer");
        
        JFXButton buttonCancel = new JFXButton ("annuler");
        content.getActions().addAll(buttonConfirm,buttonCancel);
        buttonConfirm.setOnAction(((event) -> {
            System.out.println("sdfs");
        }));
        buttonCancel.setOnAction(((event) -> {
            System.out.println("sdf");
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
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.TOP);
        dialog.show();
       
    }
    
    public void initTT(){
        
    }
    void confirmDialog(Button action,String txt,String header){
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text(header));
        content.setBody(new Text(txt));
        
        JFXButton buttonCancel = new JFXButton ("annuler");
        content.getActions().addAll(action,buttonCancel);
        
        buttonCancel.setOnAction(((event) -> {
            System.out.println("sdf");
        }));
        JFXDialog d = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.TOP);
        d.show();
    }
    
    
    

     TableView<Membre> generateTable(List<Membre> membres){
       
         TableView<Membre> table = new TableView<Membre>();
        
         membres.forEach((a)->System.out.println("dd"+a));
         
         ObservableList<Membre> data =FXCollections.observableArrayList(membres);
          table.setEditable(true);
          /*
         TableColumn firstNameCol = new TableColumn("First Name"); 
         firstNameCol.setCellValueFactory(
                new PropertyValueFactory<GestureEvents.Person, String>("first_name"));

        */
          //firstNameCol.setCellValueFactory(cellData ->{System.out.println("sdfsdf"+cellData.getValue().getLast_name());return new ReadOnlyStringWrapper(cellData.getValue().getFirst_name());});
        TableColumn firstNameCol = new TableColumn("First Name"); 
         firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Membre, String>("first_name"));
          
          TableColumn EmailCol = new TableColumn("Email"); 
         EmailCol.setCellValueFactory(
                new PropertyValueFactory<Membre, String>("email"));
         
          TableColumn GenderCol = new TableColumn("Genre"); 
         GenderCol.setCellValueFactory(
                new PropertyValueFactory<Membre, String>("gender"));
         
          
         
         ////////////////////////////////////////////////////////
 TableColumn<Membre, Membre> telCol = new TableColumn<>("Telephone");
  
        telCol.setMinWidth(80);
        telCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Membre, Membre>, ObservableValue<Membre>>() {
          @Override public ObservableValue<Membre> call(TableColumn.CellDataFeatures<Membre, Membre> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
        
        telCol.setCellFactory(new Callback<TableColumn<Membre, Membre>, TableCell<Membre, Membre>>() {
          @Override public TableCell<Membre, Membre> call(TableColumn<Membre, Membre> btnCol) {
            return new TableCell<Membre, Membre>() {
                
                
            
              @Override public void updateItem(final Membre person, boolean empty) {
                super.updateItem(person, empty);
                if (person != null) {                  
              Label l = new Label(person.getPhone_number());
                    setGraphic(l);
                } else {
                  setGraphic(null);
                }
              }
            };
          }
        });
 
 
 
 ///////////////////////////////////////////////////////////
         
         
                 ////////////////////////////////////////////////////////
 TableColumn<Membre, Membre> comboCol = new TableColumn<>("Role");
  
        
        comboCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Membre, Membre>, ObservableValue<Membre>>() {
          @Override public ObservableValue<Membre> call(TableColumn.CellDataFeatures<Membre, Membre> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
        
       comboCol.setCellFactory(new Callback<TableColumn<Membre, Membre>, TableCell<Membre, Membre>>() {
          @Override public TableCell<Membre, Membre> call(TableColumn<Membre, Membre> btnCol) {
            return new TableCell<Membre, Membre>() {
                
                
                
            
              @Override public void updateItem(final Membre person, boolean empty) {
                super.updateItem(person, empty);
                if (person != null) {
                    ObservableList<String> options = 
    FXCollections.observableArrayList(
        "Administrateur",
        "Utilisateur"
      
    );
 ComboBox comboBox = new ComboBox(options);
                               comboBox.setOnAction((event) -> {
   
   
    
 
               if(comboBox.getValue().equals("Administrateur")){
                   person.setRole(true);
                   
                  // membreService.changeRole(true, person.getId_member());
               }
               else{
                   person.setRole(false);
                    
               }
               membreService.changeRole(person.isRole(), person.getId_member());
                //System.out.println(person.isRole());
               
});
                    
                if(person.isRole()){
                    comboBox.setValue("Administrateur");
                    
                }
                else{
                    comboBox.setValue("Utilisateur");
                }
                       // comboBox.setValue(table);
                  setGraphic(comboBox);
   
                }
                else {
                  setGraphic(null);
                }
              }
            };
          }
        });
 
 
 
 ///////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////
 TableColumn<Membre, Membre> CompteCol = new TableColumn<>("Utilisateur");
  
        CompteCol.setMinWidth(150);
        CompteCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Membre, Membre>, ObservableValue<Membre>>() {
          @Override public ObservableValue<Membre> call(TableColumn.CellDataFeatures<Membre, Membre> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
        
       CompteCol.setCellFactory(new Callback<TableColumn<Membre, Membre>, TableCell<Membre, Membre>>() {
          @Override public TableCell<Membre, Membre> call(TableColumn<Membre, Membre> btnCol) {
            return new TableCell<Membre, Membre>() {
              
//init label
                
                
            
              @Override public void updateItem(final Membre person, boolean empty) {
                super.updateItem(person, empty);
                if (person != null) {
        Label l = generateLabel(person);
                    //set here
                     setGraphic(l);
                } else {
                  setGraphic(null);
                }
              }
            };
          }
        });
 
 
 
 ///////////////////////////////////////////////////////////
 
         ////////////////////////////////////////////////////////
 TableColumn<Membre, Membre> statutCol = new TableColumn<>("Statut");
  
       // CompteCol.setMinWidth(150);
        statutCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Membre, Membre>, ObservableValue<Membre>>() {
          @Override public ObservableValue<Membre> call(TableColumn.CellDataFeatures<Membre, Membre> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
        
       statutCol.setCellFactory(new Callback<TableColumn<Membre, Membre>, TableCell<Membre, Membre>>() {
          @Override public TableCell<Membre, Membre> call(TableColumn<Membre, Membre> btnCol) {
            return new TableCell<Membre, Membre>() {
              
//init label
                
                
            
              @Override public void updateItem(final Membre person, boolean empty) {
                super.updateItem(person, empty);
                if (person != null) {
                    Label l = new Label();
                    if(person.isStatut()){
                        l.setText("activer");
                        l.setTextFill(Color.web("#2ecc71"));
                    } else {
                         l.setText("bloqué");
                        l.setTextFill(Color.web("#e74c3c"));
                    }
                    
        
                    //set here
                     setGraphic(l);
                } else {
                  setGraphic(null);
                }
              }
            };
          }
        });
 
 
 
 ///////////////////////////////////////////////////////////
        TableColumn<Membre, Membre> btnCol = new TableColumn<>("Actions");
       // btnCol.setMinWidth(150);
        btnCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Membre, Membre>, ObservableValue<Membre>>() {
          @Override public ObservableValue<Membre> call(TableColumn.CellDataFeatures<Membre, Membre> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
     
        btnCol.setCellFactory(new Callback<TableColumn<Membre, Membre>, TableCell<Membre, Membre>>() {
          @Override public TableCell<Membre, Membre> call(TableColumn<Membre, Membre> btnCol) {
            return new TableCell<Membre, Membre>() {
               
               
              final ImageView buttonGraphic = new ImageView();
              final Button button = new Button(); {
                button.setGraphic(buttonGraphic);
                button.setMinWidth(130);
              }
              @Override public void updateItem(final Membre person, boolean empty) {
                super.updateItem(person, empty);
                if (person != null) {
                HBox hbox = new HBox();
   

    JFXButton buttonProfil = new JFXButton ();
    
    buttonProfil.setGraphic(new ImageView(new Image("file:images/User-32.png")));
  //  buttonCurrent.setPrefSize(100, 20);

  
   JFXButton buttonBlock = new JFXButton ();
    buttonBlock.setGraphic(new ImageView(new Image("file:images/User-Lock-32.png")));
    JFXButton buttonUnBlock = new JFXButton ();
   buttonUnBlock.setGraphic(new ImageView(new Image("file:images/User-Refresh-32.png")));
   
   JFXButton buttonDelete = new JFXButton ();
    buttonDelete.setGraphic(new ImageView(new Image("file:images/User-Delete-32.png")));
   
    if(person.isStatut()){
      hbox.getChildren().addAll(buttonProfil, buttonBlock,buttonDelete );
  } else {
      hbox.getChildren().addAll(buttonProfil, buttonUnBlock,buttonDelete );
  }
   

                  setGraphic(hbox);
                  person.getFirst_name();
                  button.setText(person.getFirst_name());
                  
                  buttonUnBlock.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent event) {
                  //    actionTaken.setText("Bought " + person.getLikes().toLowerCase() + " for: " + person.getFirstName() + " " + person.getLastName());
                  System.out.println(person.getId_member());
                  membreService.toggleMember(person.getId_member(), true);
                
                       refreshTable(membreService.getAllMembres());
                    }
                  });
                  
                  buttonBlock.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent event) {
                  //    actionTaken.setText("Bought " + person.getLikes().toLowerCase() + " for: " + person.getFirstName() + " " + person.getLastName());
                  System.out.println(person.getId_member());
                  membreService.toggleMember(person.getId_member(), false);
                
                       refreshTable(membreService.getAllMembres());
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
        table.getColumns().addAll(CompteCol,GenderCol,EmailCol,telCol,statutCol,comboCol,btnCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
       
        return table;
    }
     
     
     
    MembreServices membreService=new MembreServices() ;
    public void refreshTable(List<Membre>membres){
        
 
         ObservableList<Membre> data =FXCollections.observableArrayList(membres);
        table.getItems().clear();
        table.getItems().addAll(data);
    }
    
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
    public void initCombobox(){
         List<String> list = new ArrayList<String>();
        list.add("Nom complet");
        list.add("Nom");
        list.add("Prenom");
        
        ObservableList obList = FXCollections.observableList(list);
        type.getItems().clear();
        type.setItems(obList);
        type.getSelectionModel().selectFirst();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       System.out.println("i've been called ") ;
      //  table=generateTable(membreService.getAllMembres());
       
      //  vBox.getChildren().add(table);
        
      if(mTable.getItems()!=null){
           generateTable(membreService.getAllMembres(), 0);
        initCombobox();
      }
       
    
    }    
    
    
    @FXML
    private VBox vBox;
      @FXML
    private Button btn;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private JFXComboBox<?> type;

  
    @FXML
    private JFXButton btnRechercher;
    @FXML
    void click(ActionEvent event) {
        
System.out.println("clickme");

mTable.getItems().get(1).setStatut(false);
mTable.getItems().get(1).setRole(true);
mTable.refresh();
       
  //    confirmDialog();
       try{
      //    ReclamationDialog();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       
//   refreshTable(membreService.searchMembersByLastName("a"));
    }

  
      @FXML
    void searchAction(ActionEvent event) {
        /*
         
           JFXDialog dialog = new JFXDialog();
          System.out.println("sdf");
          VBox v = new VBox();
          v.setPrefWidth(200);
           v.setPrefHeight(50);
          Label l =new Label("Voulez vous vraiment changer le role ");
          JFXButton buttonProfil = new JFXButton ("dfdfdf");
          v.getChildren().add(l);
           v.getChildren().add(buttonProfil);
          
          
dialog.setContent(v);
                     dialog.show(stack);;
                 


       
           
//container.getChildren().add(dialog);

//dialog.show();
        */

  String value =type.getSelectionModel().getSelectedItem().toString();
    mTable.getItems().clear();
  if(   type.getSelectionModel().getSelectedIndex()==0)
     {
     
       mTable.getItems().addAll(membreService.searchMembersByFullName(txtSearch.getText()));
       

    }
      if(   type.getSelectionModel().getSelectedIndex()==1)
     {
       
       mTable.getItems().addAll(membreService.searchMembersByFirstName(txtSearch.getText()));
       

        
    }
       if(   type.getSelectionModel().getSelectedIndex()==2)
     {
         
       mTable.getItems().addAll(membreService.searchMembersByLastName(txtSearch.getText()));
       

        
    }
     
          System.out.println(value);
          mTable.refresh();//
          
    }
    private TableView<Membre> table;
}
