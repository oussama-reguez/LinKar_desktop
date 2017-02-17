package linkar_test;

import com.linkar.tn.Iservice.MembreIService;
import com.linkar.tn.entities.Membre;
import com.linkar.tn.services.MembreServices;
import java.lang.reflect.Member;
import java.util.Comparator;
import java.util.List;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class gestionCompte extends Application {
    
    TableView<Membre> generateTable(List<Membre> membres){
       
         TableView<Membre> table = new TableView<Membre>();
         ListView<Membre> v= new ListView<>();
         
        
         membres.forEach((a)->System.out.println("dd"+a));
         
         ObservableList<Membre> data =FXCollections.observableArrayList(membres);
          table.setEditable(true);
          
         TableColumn firstNameCol = new TableColumn("First Name"); 
         firstNameCol.setCellValueFactory(
                new PropertyValueFactory<GestureEvents.Person, String>("first_name"));
//firstNameCol.setCellValueFactory(cellData ->{System.out.println("sdfsdf"+cellData.getValue().getLast_name());return new ReadOnlyStringWrapper(cellData.getValue().getFirst_name());});
        
        TableColumn lastNameCol = new TableColumn("Last Name"); 
         firstNameCol.setCellValueFactory(
                new PropertyValueFactory<GestureEvents.Person, String>("last_name"));
        
 TableColumn<Membre, Membre> comboCol = new TableColumn<>("Role");
  
        comboCol.setMinWidth(150);
        comboCol.setCellValueFactory(new Callback<CellDataFeatures<Membre, Membre>, ObservableValue<Membre>>() {
          @Override public ObservableValue<Membre> call(CellDataFeatures<Membre, Membre> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
        
       comboCol.setCellFactory(new Callback<TableColumn<Membre, Membre>, TableCell<Membre, Membre>>() {
          @Override public TableCell<Membre, Membre> call(TableColumn<Membre, Membre> btnCol) {
            return new TableCell<Membre, Membre>() {
                ObservableList<String> options = 
    FXCollections.observableArrayList(
        "Administrateur",
        "Utilisateur"
      
    );
 ComboBox comboBox = new ComboBox(options);
                
                
            
              @Override public void updateItem(final Membre person, boolean empty) {
                super.updateItem(person, empty);
                if (person != null) {
                if(person.isRole()){
                    comboBox.setValue("Administrateur");
                }
                else{
                    comboBox.setValue("Utilisateur");
                }
                       // comboBox.setValue(table);
                  setGraphic(comboBox);
              comboBox.setOnAction((event) -> {
    
    System.out.println("ComboBox Action (selected: " + comboBox.getValue());
               if(comboBox.getValue().equals("Administrateur")){
                   person.setRole(true);
               }
               else{
                   person.setRole(false);
               }
});
                } else {
                  setGraphic(null);
                }
              }
            };
          }
        });
 
 
 
 ///////////////////////////////////////////////////////////
        TableColumn<Membre, Membre> btnCol = new TableColumn<>("Actions");
        btnCol.setMinWidth(150);
        btnCol.setCellValueFactory(new Callback<CellDataFeatures<Membre, Membre>, ObservableValue<Membre>>() {
          @Override public ObservableValue<Membre> call(CellDataFeatures<Membre, Membre> features) {
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
    hbox.setPadding(new Insets(15, 12, 15, 12));
    hbox.setSpacing(10);
    hbox.setStyle("-fx-background-color: #336699;");

    Button buttonCurrent = new Button("Current");
    buttonCurrent.setPrefSize(100, 20);

    Button buttonProjected = new Button("Projected");
    buttonProjected.setPrefSize(100, 20);
    hbox.getChildren().addAll(buttonCurrent, buttonProjected);

                  setGraphic(button);
                  person.getFirst_name();
                  button.setText(person.getFirst_name());
                  button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent event) {
                  //    actionTaken.setText("Bought " + person.getLikes().toLowerCase() + " for: " + person.getFirstName() + " " + person.getLastName());
                     System.out.println("hello"+person.isRole());
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
        table.getColumns().addAll(firstNameCol, lastNameCol,comboCol,btnCol);
        return table;
    }
    private TableView<Membre> table = new TableView<Membre>();
    
    
    MembreServices service = new MembreServices();
     private  List<Membre>  membres=service.searchMembersByFullName("ou");
    private  ObservableList<Membre> data =FXCollections.observableArrayList(membres);
       

    public static void main(String[] args) {
       
        launch(args);
    }

    @Override
    public void start(Stage stage) {
         
        stage.setTitle("Table View Sample");

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        final Label actionTaken = new Label();
        table=generateTable(service.getAllMembres());
/*
        table.setEditable(true);
        

    
         TableColumn firstNameCol = new TableColumn("First Name"); 
         firstNameCol.setCellValueFactory(
                new PropertyValueFactory<GestureEvents.Person, String>("first_name"));
//firstNameCol.setCellValueFactory(cellData ->{System.out.println("sdfsdf"+cellData.getValue().getLast_name());return new ReadOnlyStringWrapper(cellData.getValue().getFirst_name());});
        
        TableColumn lastNameCol = new TableColumn("Last Name"); 
         firstNameCol.setCellValueFactory(
                new PropertyValueFactory<GestureEvents.Person, String>("last_name"));
        
 TableColumn<Membre, Membre> comboCol = new TableColumn<>("Role");
  
        comboCol.setMinWidth(150);
        comboCol.setCellValueFactory(new Callback<CellDataFeatures<Membre, Membre>, ObservableValue<Membre>>() {
          @Override public ObservableValue<Membre> call(CellDataFeatures<Membre, Membre> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
        
       comboCol.setCellFactory(new Callback<TableColumn<Membre, Membre>, TableCell<Membre, Membre>>() {
          @Override public TableCell<Membre, Membre> call(TableColumn<Membre, Membre> btnCol) {
            return new TableCell<Membre, Membre>() {
                ObservableList<String> options = 
    FXCollections.observableArrayList(
        "Administrateur",
        "Utilisateur"
      
    );
 ComboBox comboBox = new ComboBox(options);
                
                
            
              @Override public void updateItem(final Membre person, boolean empty) {
                super.updateItem(person, empty);
                if (person != null) {
                if(person.isRole()){
                    comboBox.setValue("Administrateur");
                }
                else{
                    comboBox.setValue("Utilisateur");
                }
                       // comboBox.setValue(table);
                  setGraphic(comboBox);
              comboBox.setOnAction((event) -> {
    
    System.out.println("ComboBox Action (selected: " + comboBox.getValue());
               if(comboBox.getValue().equals("Administrateur")){
                   person.setRole(true);
               }
               else{
                   person.setRole(false);
               }
});
                } else {
                  setGraphic(null);
                }
              }
            };
          }
        });
 
 
 
 ///////////////////////////////////////////////////////////
        TableColumn<Membre, Membre> btnCol = new TableColumn<>("Actions");
        btnCol.setMinWidth(150);
        btnCol.setCellValueFactory(new Callback<CellDataFeatures<Membre, Membre>, ObservableValue<Membre>>() {
          @Override public ObservableValue<Membre> call(CellDataFeatures<Membre, Membre> features) {
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
    hbox.setPadding(new Insets(15, 12, 15, 12));
    hbox.setSpacing(10);
    hbox.setStyle("-fx-background-color: #336699;");

    Button buttonCurrent = new Button("Current");
    buttonCurrent.setPrefSize(100, 20);

    Button buttonProjected = new Button("Projected");
    buttonProjected.setPrefSize(100, 20);
    hbox.getChildren().addAll(buttonCurrent, buttonProjected);

                  setGraphic(button);
                  person.getFirst_name();
                  button.setText(person.getFirst_name());
                  button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent event) {
                  //    actionTaken.setText("Bought " + person.getLikes().toLowerCase() + " for: " + person.getFirstName() + " " + person.getLastName());
                     System.out.println("hello"+person.isRole());
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
        table.getColumns().addAll(firstNameCol, lastNameCol,comboCol,btnCol);
*/
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, table, actionTaken);
        VBox.setVgrow(table, Priority.ALWAYS);

        stage.setScene(new Scene(vbox));
      
        
        stage.show();
    }

    public static class Person {

        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty likes;

        private Person(String fName, String lName, String email, String likes) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
            this.likes = new SimpleStringProperty(likes);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String fName) {
            firstName.set(fName);
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String fName) {
            lastName.set(fName);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String fName) {
            email.set(fName);
        }

        public String getLikes() {
            return likes.get();
        }

        public void setLikes(String likes) {
            this.likes.set(likes);
        }
    }

    // icons for non-commercial use with attribution from: http://www.iconarchive.com/show/veggies-icons-by-iconicon/bananas-icon.html and http://www.iconarchive.com/show/collection-icons-by-archigraphs.html
    private final Image coffeeImage = new Image(
      "http://icons.iconarchive.com/icons/archigraphs/collection/48/Coffee-icon.png"
    );
    private final Image fruitImage = new Image(
      "http://icons.iconarchive.com/icons/iconicon/veggies/48/bananas-icon.png"
    );
}
