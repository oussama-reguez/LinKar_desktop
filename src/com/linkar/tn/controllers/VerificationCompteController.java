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
import com.linkar.tn.entities.Membre;
import com.linkar.tn.entities.Reclamation;
import com.linkar.tn.services.MembreServices;
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
import javafx.scene.control.Dialog;
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
public class VerificationCompteController implements Initializable {

    @FXML
    private VBox vBox;
    @FXML
    private TableView<Membre> mTable;
    @FXML
    private Button btn;
 MembreServices membreService=new MembreServices() ;
    @FXML
    private StackPane stackPane;
    /**
     * Initializes the controller class.
     */
 
  void VerificationDialog(Membre m) throws IOException{
       
         JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Verification"));
       ;
       AnchorPane pane =new AnchorPane();
      pane.setMaxHeight(500);
       pane.setMaxWidth(550);
      Text t = new Text("Utilisateur:");
      
               Label l = new Label(m.getFirst_name()+" "+m.getLast_name());
               l.setStyle("-fx-padding: 0px 0px 0px 20px ;");
             Image img = new Image(m.getUrl_picture());
            // Image img = new Image(m.getUrl_picture());
        ImageView iv= new ImageView(img);
            l.setGraphic(iv);
           
     
       HBox from= new HBox(); 
           from.getChildren().addAll(t,l);
            from.setStyle("-fx-padding: 10px 0px 10px 0px ;");
            
           
         
       
      

VBox vbox = new VBox();
      Image img2 = new Image(m.getUrl_cin());
        ImageView cinImage= new ImageView(img2);
        
     
       vbox.getChildren().addAll(from,cinImage);
       pane.getChildren().addAll(vbox);
       
       

      
        JFXButton buttonConfirm = new JFXButton ("approuver");
         Label k = new Label("");
          k.setStyle("-fx-padding: 0px 10px 0px 0px ;");
           Label dd = new Label("");
          dd.setStyle("-fx-padding: 0px 10px 0px 0px ;");
        buttonConfirm.setStyle("-fx-background-color:#2ecc71;");
     
          JFXButton buttonDeny = new JFXButton ("desapprouver");
            buttonDeny.setStyle("-fx-background-color:#e74c3c");
        JFXButton buttonCancel = new JFXButton ("annuler");
        
       buttonCancel.setStyle("-fx-background-color:#ecf0f1");
        content.getActions().addAll(buttonConfirm,k, buttonDeny,dd,buttonCancel);
        buttonConfirm.setOnAction(((event) -> {
         membreService.verifyAccount(m.getId_member(), true);
         m.setVerif_cin(true);
         mTable.getItems().remove(m);
         dialog.close();
         mTable.refresh();
           
        }));
        
         buttonDeny.setOnAction(((event) -> {
            membreService.verifyAccount(m.getId_member(), false);
             
         m.setVerif_cin(false);
         mTable.getItems().remove(m);
         dialog.close();
         mTable.refresh();
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
                                       Label l = new Label();
                    

                    
                if(person.isRole()){
                    l.setText("Administrateur");
                    
                }
                else{
                    l.setText("Utilisateur");
                }
                       // comboBox.setValue(table);
                  setGraphic(l);
   
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
   

    JFXButton buttonVerify = new JFXButton ();
    buttonVerify.setText("verifier Compte");
    
     buttonVerify.setGraphic(new ImageView(new Image("file:images/id-card2.png")));
  //  buttonCurrent.setPrefSize(100, 20);

  
                   buttonVerify.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent event) {
                        try {
                            VerificationDialog(person);
                        } catch (IOException ex) {
                            Logger.getLogger(VerificationCompteController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                  });
   
                    setGraphic(buttonVerify);
   
   

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       generateTable(membreService.getRequestedMembers(), 0);
    }    


    @FXML
    private void click(ActionEvent event) {
    }
    
}
