/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.views;

import com.linkar.tn.services.MembreServices;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Oussama Reguez
 */
public class StatUtilisateurController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private LineChart<String,Number> totalUsersByDate;

    @FXML
    private Label countUsers;

    @FXML
    private StackedBarChart<String,Number> totalUsersByYear;

    @FXML
    private HBox topUsers; 
      @FXML
    private PieChart pieChart;
    MembreServices serviceMembre = new MembreServices();
    
    void generatePieChar(){
         ObservableList<PieChart.Data> pieChartData =  FXCollections.observableArrayList();    
                
               // new PieChart.Data("Apples", 30));
      //  final PieChart chart = new PieChart(pieChartData);
           Map<String,Integer>map = serviceMembre.getStatnbrUsersbyGender();
           pieChartData.addAll(new PieChart.Data("female",map.get("female")),
            new PieChart.Data("male",map.get("male"))
            
            );
         
        pieChart.setTitle("nombre totale par genre");
        pieChart.getData().addAll(pieChartData);
        
    }
    void generateBarChart(){
        
        totalUsersByYear.setTitle("nombre totale par date");
       // xAxis.setLabel("Country");       
        //yAxis.setLabel("Value");
   
        
       // series1.getData().add(new XYChart.Data(austria, 25601.34));
       
         DateFormat df = new SimpleDateFormat("yyyy");
        Map<Date,Integer>map = serviceMembre.getStatCreatedUsersbyYear();
        int nbr=0;
        for(Entry<Date,Integer> s :map.entrySet()){
             XYChart.Series series1 = new XYChart.Series();
             
        series1.setName(df.format(s.getKey()));      
            series1.getData().add(new XYChart.Data(df.format(s.getKey()), s.getValue()));
             totalUsersByYear.getData().add(series1);
        }
        
      
       
       
      
    }
    void generateChart(){
       //final NumberAxis yAxis = new NumberAxis();
        //final CategoryAxis xAxis = new CategoryAxis();
        //xAxis.setLabel("Number of Month");
        //creating the chart
      
                
       
         totalUsersByDate.setTitle("nombre d'utilisateur par Mois");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        DateFormat df = new SimpleDateFormat("MM/yyyy");
        Map<Date,Integer>map = serviceMembre.getStatCreatedUsers();
        int nbr=0;
        for(Entry<Date,Integer> s :map.entrySet()){
            series.getData().add(new XYChart.Data(df.format(s.getKey()), nbr+=s.getValue()));
        }
        System.out.println(nbr);
        
        
        
         totalUsersByDate.getData().add(series);
    }
    MembreServices t = new MembreServices();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        countUsers.setText(String.valueOf(t.getNbrUsers()));
       generateChart();
       generateBarChart();
       generatePieChar();
    }    
    
}
