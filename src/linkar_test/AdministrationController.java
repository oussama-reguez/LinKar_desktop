package linkar_test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Oussama Reguez
 */
public class AdministrationController implements Initializable {

    /**
     * Initializes the controller class.
     */
   
    
    
        private ObservableList<Person> list=null; ;
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
list=FXCollections.observableArrayList(
            new Person("Jacob", "Smith", "jacob.smith@example.com","Coffee"),
            new Person("Isabella", "Johnson", "isabella.johnson@example.com","Fruit"),
            new Person("Ethan", "Williams", "ethan.williams@example.com","Fruit"),
            new Person("Emma", "Jones", "emma.jones@example.com","Coffee"),
            new Person("Michael", "Brown", "michael.brown@example.com","Fruit")

        );
    
    }    
    
    
}
