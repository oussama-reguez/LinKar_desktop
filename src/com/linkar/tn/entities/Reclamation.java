package com.linkar.tn.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.linkar.tn.entities.Membre;
import java.sql.Date;


/**
 *
 * @author Oussama Reguez
 */
public class Reclamation {
    
    private int id_reclamation;
    private Membre membre;
    private String text;
    private Date date_Reclamation ;

    @Override
    public String toString() {
        return "Reclamation{" + "id_reclamation=" + id_reclamation + ", membre=" + membre + ", text=" + text + ", date_Reclamation=" + date_Reclamation + '}';
    }

    
    public Reclamation(int id_reclamation, Membre membre, String text, Date date_Reclamation) {
        this.id_reclamation = id_reclamation;
        this.membre = membre;
        this.text = text;
        this.date_Reclamation = date_Reclamation;
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
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the date_Reclamation
     */
    public Date getDate_Reclamation() {
        return date_Reclamation;
    }

    /**
     * @param date_Reclamation the date_Reclamation to set
     */
    public void setDate_Reclamation(Date date_Reclamation) {
        this.date_Reclamation = date_Reclamation;
    }
    
    
    
}
