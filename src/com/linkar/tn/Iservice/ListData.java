/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecService;
import Entities.TableData ;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author WIKI
 */
public interface ListData {
    
     ObservableList<TableData> lister();
     
    ObservableList<TableData> findbyname (String name) ;
    
}
