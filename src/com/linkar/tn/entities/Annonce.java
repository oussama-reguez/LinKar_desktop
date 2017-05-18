/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.entities;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Beya Idhiba
 */
public class Annonce {
    
    private int id_annonce;
    private String depart;
    private String approdep;
    private String destination;
    private String approdest;
    private boolean fumeur;
    private boolean bavard;
    private boolean men_only;
    private boolean women_only;
    private boolean animaux;
    private LocalDate date_annonce;
    private String horaire_depart;
    private boolean regulier;
    private int places;
    private int tarif;
    private String description;
    private int id_membre;
    private int id_voiture;
    private int place1;
    private int place2;
    private int place3;
    private int place4;
    //private boolean etat=false;

    public Annonce() {
        //this.etat=false;
    }

    public Annonce(int id_annonce, String depart, String approdep, String destination, String approdest, boolean fumeur, boolean bavard, boolean men_only, boolean women_only, boolean animaux, LocalDate date_annonce, String horaire_depart, boolean regulier, int places, int tarif, String description, int id_membre, int id_voiture, int place1, int place2, int place3, int place4) {
        this.id_annonce = id_annonce;
        this.depart = depart;
        this.approdep = approdep;
        this.destination = destination;
        this.approdest = approdest;
        this.fumeur = fumeur;
        this.bavard = bavard;
        this.men_only = men_only;
        this.women_only = women_only;
        this.animaux = animaux;
        this.date_annonce = date_annonce;
        this.horaire_depart = horaire_depart;
        this.regulier = regulier;
        this.places = places;
        this.tarif = tarif;
        this.description = description;
        this.id_membre = id_membre;
        this.id_voiture = id_voiture;
        this.place1 = place1;
        this.place2 = place2;
        this.place3 = place3;
        this.place4 = place4;
    }

    public Annonce(String depart, String approdep, String destination, String approdest, boolean fumeur, boolean bavard, boolean men_only, boolean women_only, boolean animaux, LocalDate date_annonce, String horaire_depart, boolean regulier, int places, int tarif, String description, int id_membre, int id_voiture, int place1, int place2, int place3, int place4) {
        this.depart = depart;
        this.approdep = approdep;
        this.destination = destination;
        this.approdest = approdest;
        this.fumeur = fumeur;
        this.bavard = bavard;
        this.men_only = men_only;
        this.women_only = women_only;
        this.animaux = animaux;
        this.date_annonce = date_annonce;
        this.horaire_depart = horaire_depart;
        this.regulier = regulier;
        this.places = places;
        this.tarif = tarif;
        this.description = description;
        this.id_membre = id_membre;
        this.id_voiture = id_voiture;
        this.place1 = place1;
        this.place2 = place2;
        this.place3 = place3;
        this.place4 = place4;
    }

    public Annonce(String depart, String approdep, String destination, String approdest, boolean fumeur, boolean bavard, boolean men_only, boolean women_only, boolean animaux, LocalDate date_annonce, String horaire_depart, boolean regulier, int places, int tarif, String description, int id_voiture) {
        this.depart = depart;
        this.approdep = approdep;
        this.destination = destination;
        this.approdest = approdest;
        this.fumeur = fumeur;
        this.bavard = bavard;
        this.men_only = men_only;
        this.women_only = women_only;
        this.animaux = animaux;
        this.date_annonce = date_annonce;
        this.horaire_depart = horaire_depart;
        this.regulier = regulier;
        this.places = places;
        this.tarif = tarif;
        this.description = description;
        this.id_voiture = id_voiture;
    }

           public Annonce( String depart,String approdep, String destination, String approdest, int places, int tarif, String description)
           {
               this.depart=depart;
               this.approdep = approdep;
               this.destination = destination;
               this.approdest = approdest;
               this.places = places;
               this.tarif = tarif;
               this.description = description;
           }
           
 public Annonce(String depart, String destination, boolean fumeur, boolean bavard, boolean men_only, boolean women_only, boolean animaux, Date date_annonce, boolean regulier, String horaire_depart, int places, int tarif, String description, Membre m, Voiture v){
     this.depart=depart ;
     this.destination=destination;
     this.fumeur=fumeur ;this.bavard=bavard;
     this.men_only=men_only;
     this.women_only=women_only
             ;this.animaux=animaux;
             this.date_annonce=date_annonce.toLocalDate();
             this.regulier=regulier;
             this.horaire_depart=horaire_depart;
             this.description=description;
             id_membre=m.getId_member();
           //  id_voiture=v.getId_voiture();
 }

    public Annonce(int places) {
        this.places= places;
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getApprodep() {
        return approdep;
    }

    public void setApprodep(String approdep) {
        this.approdep = approdep;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getApprodest() {
        return approdest;
    }

    public void setApprodest(String approdest) {
        this.approdest = approdest;
    }

    public boolean isFumeur() {
        return fumeur;
    }

    public void setFumeur(boolean fumeur) {
        this.fumeur = fumeur;
    }

    public boolean isBavard() {
        return bavard;
    }

    public void setBavard(boolean bavard) {
        this.bavard = bavard;
    }

    public boolean isMen_only() {
        return men_only;
    }

    public void setMen_only(boolean men_only) {
        this.men_only = men_only;
    }

    public boolean isWomen_only() {
        return women_only;
    }

    public void setWomen_only(boolean women_only) {
        this.women_only = women_only;
    }

    public boolean isAnimaux() {
        return animaux;
    }

    public void setAnimaux(boolean animaux) {
        this.animaux = animaux;
    }

    public LocalDate getDate_annonce() {
        return date_annonce;
    }

    public void setDate_annonce(LocalDate date_annonce) {
        this.date_annonce = date_annonce;
    }

    public String getHoraire_depart() {
        return horaire_depart;
    }

    public void setHoraire_depart(String horaire_depart) {
        this.horaire_depart = horaire_depart;
    }

    public boolean isRegulier() {
        return regulier;
    }

    public void setRegulier(boolean regulier) {
        this.regulier = regulier;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public int getPlace1() {
        return place1;
    }

    public void setPlace1(int place1) {
        this.place1 = place1;
    }

    public int getPlace2() {
        return place2;
    }

    public void setPlace2(int place2) {
        this.place2 = place2;
    }

    public int getPlace3() {
        return place3;
    }

    public void setPlace3(int place3) {
        this.place3 = place3;
    }

    public int getPlace4() {
        return place4;
    }

    public void setPlace4(int place4) {
        this.place4 = place4;
    }

    @Override
    public String toString() {
        return "Annonce{" + "id_annonce=" + id_annonce + ", depart=" + depart + ", approdep=" + approdep + ", destination=" + destination + ", approdest=" + approdest + ", fumeur=" + fumeur + ", bavard=" + bavard + ", men_only=" + men_only + ", women_only=" + women_only + ", animaux=" + animaux + ", date_annonce=" + date_annonce + ", horaire_depart=" + horaire_depart + ", regulier=" + regulier + ", places=" + places + ", tarif=" + tarif + ", description=" + description + ", id_membre=" + id_membre + ", id_voiture=" + id_voiture + ", place1=" + place1 + ", place2=" + place2 + ", place3=" + place3 + ", place4=" + place4 + '}';
    }

   
    
    
}
