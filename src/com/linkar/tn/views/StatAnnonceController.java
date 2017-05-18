/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.views;

import com.linkar.tn.services.AnnonceServices;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Oussama Reguez
 */
public class StatAnnonceController implements Initializable {

    /**
     * Initializes the controller class.
     */
    AnnonceServices annonceService = new AnnonceServices();
    @FXML
    private Label countUsers;

    @FXML
    private ScatterChart<String, Number> scatterChart;

    @FXML
    private PieChart pieChart;

    @FXML
    private StackedAreaChart<Number, Number> stackedAreaChart;
    void generateStackedAreaChart(){
        
       
        List<String>years= annonceService.getYears();
        
         DateFormat df = new SimpleDateFormat("MM/yyyy");
        for(String year : years){
              XYChart.Series<Number,Number> series = new XYChart.Series();  
      
      series.setName(year); 
             Map<Integer,Integer> map=annonceService.getStatCreatedAnnoncePerMonth(year);
             int count=0;
             for(Map.Entry<Integer,Integer> s :map.entrySet()){
                 
              series.getData().add(new XYChart.Data(s.getKey(), count+=s.getValue())); 
              //System.out.println(s.getKey()+" "+s.getValue());
        }
             stackedAreaChart.setTitle("Annonce par ans");
             stackedAreaChart.getData().add(series);
             System.out.println("added");
        }

       
    }
 void generatePieChar(){
         ObservableList<PieChart.Data> pieChartData =  FXCollections.observableArrayList();    
                
               // new PieChart.Data("Apples", 30));
      //  final PieChart chart = new PieChart(pieChartData);
          Map<String,Integer>map = annonceService.getStatNbrAnnoncebyStatus();
           pieChartData.addAll(new PieChart.Data("Terminé",map.get("terminer")),
            new PieChart.Data("supprimer",map.get("supprimer"))    
            );
        pieChart.setTitle("Nombre des annonce par categorie");
        pieChart.getData().addAll(pieChartData);
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        countUsers.setText(String.valueOf(annonceService.getNbrAnnonce()));
        generatePieChar();
        generateStackedAreaChart();
    }    
    
}
