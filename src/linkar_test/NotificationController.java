/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkar_test;

import com.jfoenix.controls.JFXListView;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Oussama Reguez
 */
public class NotificationController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML
    private JFXListView<Label> list;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            Label l = new Label("tessst tessst tessst tessst");
            l.setGraphic(new ImageView(new Image(new FileInputStream("/images/use.png"))));
            list.getItems().add(l);
        }
        catch (Exception ex){
            
        }
        // TODO
    }    
    
}
