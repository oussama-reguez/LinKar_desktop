/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.controllers;


import com.linkar.tn.services.AnnonceServices;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

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
    private Label countAnnonces;


    @FXML
    private PieChart categoriePieChart;

    @FXML
    private StackedAreaChart<Number, Number> stackedAreaChart;
    @FXML
    private HBox stacked;
    @FXML
    private PieChart pieDepart;
    @FXML
    private PieChart pieDestination;
    
     
    void generateStackedAreaChart(){
        final NumberAxis xAxis = new NumberAxis(1, 12, 1);
         
        final NumberAxis yAxis = new NumberAxis();
        
         xAxis.setLabel("Month");
        yAxis.setLabel("Value");
       
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
           //  stackedAreaChart= new StackedAreaChart<Number,Number>(xAxis,yAxis);
             stackedAreaChart.setTitle("Annonce par ans");
            
             stackedAreaChart.getData().add(series);
             System.out.println("added");
            // stacked.getChildren().add(stackedAreaChart);
        }

       
    }
 void generatePieChar(){
         ObservableList<PieChart.Data> pieChartData =  FXCollections.observableArrayList();    
                
               // new PieChart.Data("Apples", 30));
      //  final PieChart chart = new PieChart(pieChartData);
          Map<String,Integer>map = annonceService.getStatNbrAnnoncebyStatus();
        
           for(Map.Entry<String,Integer> entry :map.entrySet()){
            
               System.out.println(entry.getKey()+" "+entry.getValue());
            pieChartData.add(new PieChart.Data(entry.getKey(),entry.getValue()));
            
        }
          
     categoriePieChart.setLabelsVisible(true);
       categoriePieChart.setTitle("Nombre des annonce ");
        categoriePieChart.getData().addAll(pieChartData);
        // applyCustomColorSequence(pieChartData, "#ffd700","#ffa500");
        categoriePieChart.setLabelLineLength(10);
categoriePieChart.setLegendSide(Side.RIGHT);
    
        
    }
 private void applyCustomColorSequence(
    ObservableList<PieChart.Data> pieChartData, 
    String... pieColors) {
  int i = 0;
  for (PieChart.Data data : pieChartData) {
    data.getNode().setStyle(
      "-fx-pie-color: " + pieColors[i % pieColors.length] + ";"
    );
    i++;
  }
}
 
  void generateDepartPieChar(){
         ObservableList<PieChart.Data> pieChartData =  FXCollections.observableArrayList();    
                int count =0;
               // new PieChart.Data("Apples", 30));
      //  final PieChart chart = new PieChart(pieChartData);
          Map<String,Integer>map = annonceService.getStatnbrAnnoncebydepart();
        for(Map.Entry<String,Integer> entry :map.entrySet()){
            
            pieChartData.add(new PieChart.Data(entry.getKey(),entry.getValue()));
            count+=entry.getValue();
        }
        
         pieChartData.add(new PieChart.Data("autre",nbrAnnonce-count));
      
          
        pieDepart.setTitle("Nombre des annonces par categorie");
        pieDepart.getData().addAll(pieChartData);
        
    }
  
   void generateDestinationPieChar(){
         ObservableList<PieChart.Data> pieChartData =  FXCollections.observableArrayList();    
                int count =0;
               // new PieChart.Data("Apples", 30));
      //  final PieChart chart = new PieChart(pieChartData);
          Map<String,Integer>map = annonceService.getStatnbrAnnoncebyDestination();
        for(Map.Entry<String,Integer> entry :map.entrySet()){
            
            pieChartData.add(new PieChart.Data(entry.getKey(),entry.getValue()));
            count+=entry.getValue();
        }
        
         pieChartData.add(new PieChart.Data("autre",nbrAnnonce-count));
      
          
        pieDestination.setTitle("Nombre des annonces par categorie");
         pieDestination.getData().addAll(pieChartData);
        
    }
    
    int nbrAnnonce;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nbrAnnonce=annonceService.getNbrAnnonce();
        // TODO
        countAnnonces.setText(String.valueOf(nbrAnnonce));
        generatePieChar();
        generateStackedAreaChart();
        generateDepartPieChar();
        generateDestinationPieChar();
    }    
    
}
