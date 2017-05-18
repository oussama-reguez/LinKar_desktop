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
    private String text;
    private Date date_Reclamation ;
    private String type;
    private String subject;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate_Reclamation() {
        return date_Reclamation;
    }

    public void setDate_Reclamation(Date date_Reclamation) {
        this.date_Reclamation = date_Reclamation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

  

    
  

    
  
    
    

    

    
    public Reclamation(int id_reclamation, Membre membre, String text, Date date_Reclamation) {
        this.id_reclamation = id_reclamation;
        this.membre = membre;
        this.text =  text;
        this.date_Reclamation =  date_Reclamation;
    }
    
    public Reclamation(int id_reclamation, Membre membre, String text, Date date_Reclamation,String type,String subject) {
        this.id_reclamation = id_reclamation;
        this.membre = membre;
         this.text = text;
         this.date_Reclamation = date_Reclamation;
        this.type=type;
        this.subject= subject;
    }
    
     public Reclamation(int id_reclamation, Date date_reclamation, Membre M, String text,String subject,String type) {
        this.id_reclamation = id_reclamation;
        this.date_Reclamation= date_reclamation;
       this.membre=M;
        this.text = text;
        this.subject = subject ;
        this.type = type ;
       // this.calend = Calendar.getInstance();
       
    }
    
     public Reclamation(int id_reclamation, Membre membre, String text, Date date_Reclamation,String type,String subject,boolean marked) {
        this.id_reclamation = id_reclamation;
        this.membre = membre;
         this.text =  text;
         this.date_Reclamation =  date_Reclamation;
        this.type=type;
        this.subject= subject;
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
 

    /**
     * @return the date_Reclamation
     */
  
}
