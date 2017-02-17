package com.linkar.tn.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.linkar.tn.entities.Membre;
import java.sql.Date;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author Oussama Reguez
 */
public class Reclamation {
    
    private int id_reclamation;
    private Membre membre;
    private SimpleStringProperty text;
    private SimpleObjectProperty date_Reclamation ;
    private SimpleStringProperty type;
    private SimpleStringProperty subject;
    private boolean marked ;

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    
    
    @Override
    public String toString() {
        return "Reclamation{" + "id_reclamation=" + id_reclamation + ", membre=" + membre + ", text=" + text + ", date_Reclamation=" + date_Reclamation + ", type=" + type + ", subject=" + subject + '}';
    }

  

    
    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getSubject() {
        return subject.get();
    }

    public void setSubject(String subject) {
        this.subject.set( subject);
    }
  
    
    

    

    
    public Reclamation(int id_reclamation, Membre membre, String text, Date date_Reclamation) {
        this.id_reclamation = id_reclamation;
        this.membre = membre;
        this.text =  new SimpleStringProperty(text);
        this.date_Reclamation =  new SimpleObjectProperty(date_Reclamation);
    }
    
    public Reclamation(int id_reclamation, Membre membre, String text, Date date_Reclamation,String type,String subject) {
        this.id_reclamation = id_reclamation;
        this.membre = membre;
         this.text =  new SimpleStringProperty(text);
         this.date_Reclamation =  new SimpleObjectProperty(date_Reclamation);
        this.type=new  SimpleStringProperty( type);
        this.subject= new  SimpleStringProperty(subject);
    }
    
     public Reclamation(int id_reclamation, Membre membre, String text, Date date_Reclamation,String type,String subject,boolean marked) {
        this.id_reclamation = id_reclamation;
        this.membre = membre;
         this.text =  new SimpleStringProperty(text);
         this.date_Reclamation =  new SimpleObjectProperty(date_Reclamation);
        this.type=new  SimpleStringProperty( type);
        this.subject= new  SimpleStringProperty(subject);
         this.marked=marked;
    }
     
    

   
    

    /**
     * @return the id_reclamation
     */
    public int getId_reclamation() {
        return id_reclamation;
    }

    /**
     * @param id_reclamation the id_reclamation to set
     */
    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    /**
     * @return the membre
     */
    public Membre getMembre() {
        return membre;
    }

    /**
     * @param membre the membre to set
     */
    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text.get();
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text.set(text);
    }

    /**
     * @return the date_Reclamation
     */
    public Date getDate_Reclamation() {
        return (java.sql.Date)date_Reclamation.get();
    }

    /**
     * @param date_Reclamation the date_Reclamation to set
     */
    public void setDate_Reclamation(Date date_Reclamation) {
        this.date_Reclamation .set( date_Reclamation);
    }
    
    
    
}
