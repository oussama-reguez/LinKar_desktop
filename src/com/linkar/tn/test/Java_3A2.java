/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





import com.linkar.tn.entities.Reclamation;
import com.linkar.tn.services.ReclamationService;
import com.esprit.tn.technique.DataSource;
import com.linkar.tn.entities.Membre;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Oussama Reguez
 */
public class Java_3A2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     //   DataSource data = DataSource.getDataSource();
      //  DepotIService service = new DepotService();
     //   service.add(new Depot(0, "adresse 1"));
    java.util.Date utilDate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
   Reclamation r = new Reclamation(1, new Membre(1), "df",sqlDate );
   Reclamation r2 = new Reclamation(2, new Membre(1), "df",sqlDate );
     Reclamation r3 = new Reclamation(3, new Membre(1), "df",sqlDate);
   
        ReclamationService s = new ReclamationService();
     // s.addReclamation(r);
       //s.addReclamation(r2);
         // s.addReclamation(r3);
     r.setText("oussama");
     
     List<Reclamation> reclamations=s.getAllReclamation();
     for(Reclamation rec:reclamations){
         System.out.println(rec);
     }
   //  s.modifyReclamation(r);
        
     
    // stock.add();
        
        
        // TODO code application logic here
    }
    
}
