/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.controllers;


import com.linkar.tn.entities.Membre;
import com.linkar.tn.entities.Reclamation;
import com.linkar.tn.services.AnnonceServices;
import com.linkar.tn.services.MembreServices;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;


/**
 * FXML Controller class
 *
 * @author Oussama Reguez
 */
public class StatController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     AnnonceServices annonceService = new AnnonceServices();
    @FXML
    private Label countUsers;
    
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
    
    
    @FXML
    private LineChart<String,Number> totalUsersByDate;

     int nbrAnnonce;

    @FXML
    private StackedBarChart<String,Number> totalUsersByYear;

    @FXML
    private HBox topUsers; 
      @FXML
      
    private PieChart pieChart;
    MembreServices serviceMembre = new MembreServices();
    @FXML
    private Label blockedUsers;
    @FXML
    private TableView<Membre> table;
    @FXML
    private TableColumn<Membre, Membre> compteCol;
    @FXML
    private TableColumn<Membre, String> nbrAnnonceCol;
    
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
             stackedAreaChart.setTitle("Evolution mensuel des nombres d'annonces groupé par année");
            stackedAreaChart.setVisible(true);
           
stackedAreaChart.setLegendSide(Side.LEFT);
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
       categoriePieChart.setTitle("Nombre des annonces selon leurs etats ");
        categoriePieChart.getData().addAll(pieChartData);
        // applyCustomColorSequence(pieChartData, "#ffd700","#ffa500");
        categoriePieChart.setLabelLineLength(10);
categoriePieChart.setLegendSide(Side.RIGHT);
    
        
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
      
          
        pieDepart.setTitle("les villes de depart les plus populaires");
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
      
          
        pieDestination.setTitle("les villes de destination les plus populaires");
         pieDestination.getData().addAll(pieChartData);
        
    }
    
    void generateMembrePieChar(){
         ObservableList<PieChart.Data> pieChartData =  FXCollections.observableArrayList();    
                
               // new PieChart.Data("Apples", 30));
      //  final PieChart chart = new PieChart(pieChartData);
           Map<String,Integer>map = serviceMembre.getStatnbrUsersbyGender();
           pieChartData.addAll(new PieChart.Data("Femme",map.get("Femme")),
            new PieChart.Data("Homme",map.get("Homme"))
            
            );
         
        pieChart.setTitle("nombre total des utilisateurs par sexe");
        pieChart.getData().addAll(pieChartData);
        
    }
    void generateBarChart(){
        
        totalUsersByYear.setTitle("nombre total des utilisateurs groupé par année");
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
    
    void initTAble(List<Membre> membres){
           
         nbrAnnonceCol.setCellValueFactory(
                new PropertyValueFactory<Membre, String>("nbrAnnonce"));
         
         
      
        compteCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Membre, Membre>, ObservableValue<Membre>>() {
          @Override public ObservableValue<Membre> call(TableColumn.CellDataFeatures<Membre,Membre> features) {
              return new ReadOnlyObjectWrapper(features.getValue());
          }
        });
    
         
      
  
        
        
       compteCol.setCellFactory(new Callback<TableColumn<Membre, Membre>, TableCell<Membre, Membre>>() {
          @Override public TableCell<Membre ,Membre> call(TableColumn<Membre, Membre> btnCol) {
            return new TableCell<Membre,Membre>() {
              
//init label
                
                
            
              @Override public void updateItem(final Membre membre, boolean empty) {
                super.updateItem(membre, empty);
                if (membre != null) {
       HBox l = generateHbox(membre);
                    //set here
                    setGraphic(l);
                } else {
                  setGraphic(null);
                }
              }
            };
          }
        });
   ObservableList<Membre> data =FXCollections.observableArrayList(membres);
       table.getItems().clear();
       table.setItems(data);
    //  table.getColumns().addAll(compteCol,nbrAnnonceCol);
       // table.getItems().addAll(data);
    
    
    
    
    }
    
     HBox generateHbox(Membre m){
        
          Label l=null;
       
        HBox h =null;
        String url=m.getUrl_picture();
                l = new Label(m.getFirst_name()+" "+m.getLast_name());
             //Image img = new Image("file:images/user.png");
             Image img = new Image(m.getUrl_picture());
        ImageView iv= new ImageView(img);
        
          Label a = new Label();
          ImageView df= new ImageView(new Image("file:images/User-Male-32.png"));
       if(m.getGender().equals("female")){
          df= new ImageView(new Image("file:images/User-Female-32.png"));
       } 
            
            a.setGraphic(df);
        
       h = new HBox();
       
       l.setGraphic(iv);
       
        h.getChildren().addAll(l,a);
           
           
          //  list.getItems().add(l);
             
              
        
        
      
       
          
          
        return h;
        
    }
    void generateLineChart(){
       //final NumberAxis yAxis = new NumberAxis();
        //final CategoryAxis xAxis = new CategoryAxis();
        //xAxis.setLabel("Number of Month");
        //creating the chart
      
                
       
         totalUsersByDate.setTitle("Evolution mensuelle du nombre des utilisateurs inscrits ");
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
        System.err.println("blocked"+t.getBlockedUsers());
        blockedUsers.setText(String.valueOf(t.getBlockedUsers()));
        countAnnonces.setText(String.valueOf(annonceService.getNbrAnnonce()));
       generateLineChart();
       generateBarChart();
       generateMembrePieChar();
       initTAble(t.getActiveUsers(0));
   
       generatePieChar();
        generateStackedAreaChart();
        generateDepartPieChar();
        generateDestinationPieChar();
    }    
    
}
