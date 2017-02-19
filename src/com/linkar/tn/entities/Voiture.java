/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.entities;

/**
 *
 * @author Rishya
 */
public class Voiture {
    private int id_voiture;
    private String brand;
    private String model;
    private int id_member;
    private String confort;
    private int number_places;
    private String url_car_selfie;
    private String color;

    public Voiture() {
    }

    public Voiture(String brand, String model, int id_member, String confort, int number_places, String url_car_selfie, String color) {
        this.brand = brand;
        this.model = model;
        this.id_member = id_member;
        this.confort = confort;
        this.number_places = number_places;
        this.url_car_selfie = url_car_selfie;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getConfort() {
        return confort;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public int getId_member() {
        return id_member;
    }

    public String getModel() {
        return model;
    }

    public int getNumber_places() {
        return number_places;
    }

    public String getUrl_car_selfie() {
        return url_car_selfie;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setConfort(String confort) {
        this.confort = confort;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public void setId_member(int id_member) {
        this.id_member = id_member;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumber_places(int number_places) {
        this.number_places = number_places;
    }

    public void setUrl_car_selfie(String url_car_selfie) {
        this.url_car_selfie = url_car_selfie;
    }


    
    
}
