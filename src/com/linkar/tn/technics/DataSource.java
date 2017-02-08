/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tn.technique;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oussama Reguez
 */
public class DataSource {
    
    private static DataSource data ;

     private Connection cnx;
     private Properties configuration;
    
    private DataSource(){
        configuration= new Properties();
        try{
            configuration.load(new FileInputStream("configuration.properties"));
            cnx=DriverManager.getConnection(configuration.getProperty("url"),configuration.getProperty("login"),configuration.getProperty("pwd"));
            System.out.println("connexion etabli !");
        }
        catch (SQLException sql){
            Logger.getLogger(DataSource.class.getName(), sql.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static DataSource getDataSource(){
        if(data==null){
            data= new DataSource();
        }
        
        
        return data;
    }
    public Connection getConnection(){
        return cnx;
    }
    
}
