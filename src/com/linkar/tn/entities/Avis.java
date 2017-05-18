/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.entities;

/**
 *
 * @author WIKI
 */
public class Avis {
    
    int id_feedback ;
    Double rating ;
    String feed_back ;
    Membre M ;
    int id_rater ;

    public Avis(int id_feedback, Double rating, String feed_back, Membre M, int id_rater) {
        this.id_feedback = id_feedback;
        this.rating = rating;
        this.feed_back = feed_back;
        this.M = M;
        this.id_rater = id_rater;
    }

    public int getId_feedback() {
        return id_feedback;
    }

    public Double getRating() {
        return rating;
    }

    public String getFeed_back() {
        return feed_back;
    }

    public Membre getM() {
        return M;
    }

    public int getId_rater() {
        return id_rater;
    }
    
    
    
    
    
    
}
