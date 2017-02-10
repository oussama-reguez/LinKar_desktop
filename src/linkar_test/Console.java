/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkar_test;

import com.linkar.tn.entities.Membre;
import com.linkar.tn.services.MembreServices;
import java.util.List;
import static javafx.application.Application.launch;

/**
 *
 * @author Oussama Reguez
 */
public class Console {
     public static void main(String[] args) {
      //  launch(args);
      MembreServices m = new MembreServices();
      List<Membre> membres = m.searchMembersByRole(false);
      for(Membre e : membres){
          System.err.println(e);
      }
      System.err.println("sdf");
    }
}
