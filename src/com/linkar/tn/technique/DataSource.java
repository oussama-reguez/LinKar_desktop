/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.technique;

import java.io.File;
import java.io.FileInputStream;
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
 * @author Rishya
 */
public class DataSource {
  private static DataSource myinstance;
   private String url;//="jdbc:mysql://http://127.0.0.1:3306/linkar";
   private String login;//="root";
   private String pwd;//="";
   private Properties properties;
   private Connection cnx;
  private DataSource()
  {
  properties=new Properties();
      try {
          
 properties.load(new FileInputStream(new File("configuration.properties")));
 url=properties.getProperty("url");
 login=properties.getProperty("login");
 pwd=properties.getProperty("pwd");
 cnx=DriverManager.getConnection(url, login, pwd);
          System.out.println("Connexion établie (Datasource) ☻");
      } catch (SQLException ex) {
          Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
          Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
      }
  
  
  
  }
  public static DataSource getInstance()
  {if(myinstance==null)
      myinstance=new DataSource();
      return myinstance;
  }
  
  public Connection getMyConnection()
  {return cnx;}
  
}
