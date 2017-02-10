/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkar_test;

import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
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
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
for(int i = 0 ; i < 4 ; i++) list.getItems().add(new Label("Item " + i));
list.getStyleClass().add("mylistview");
        // TODO
    }    
    @FXML
    JFXListView<Label> list;
    
}
