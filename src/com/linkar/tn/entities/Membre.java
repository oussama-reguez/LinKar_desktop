/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.entities;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Rishya
 */
public class Membre {
    private int id_annonce;

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }
    
    private int id_member;
    private SimpleStringProperty last_name;
    private SimpleStringProperty first_name;
    private Date birth;
    private SimpleStringProperty email;
    private String password;
    private SimpleDoubleProperty  phone_number;
    private SimpleStringProperty gender;
    private SimpleBooleanProperty statut;

    public boolean isStatut() {
        return statut.get();
    }

    public void setStatut(boolean statut) {
        this.statut.set(statut);
    }
    private boolean verif_number;
    private boolean verif_cin;
    private boolean verif_email;
    private SimpleBooleanProperty role;
    private String url_cin;
    private String url_picture;
    private String address;

    public Membre()
    {}
 
    public Membre(int id_member, String last_name, String first_name, Date birth, String email, String password, double phone_number, String gender, boolean verif_number, boolean verif_cin, boolean verif_email, boolean role, String url_cin, String url_picture,String address) {
        this.id_member = id_member;
        this.last_name = new SimpleStringProperty(last_name);
        this.first_name = new SimpleStringProperty(first_name);
        this.birth = birth;
        this.email = new SimpleStringProperty(email);
        this.password = password;
        this.phone_number =  new SimpleDoubleProperty(phone_number);
        this.gender = new SimpleStringProperty(gender);
        this.verif_number = verif_number;
        this.verif_cin = verif_cin;
        this.verif_email = verif_email;
        this.role = new SimpleBooleanProperty (role);
        this.url_cin = url_cin;
        this.url_picture = url_picture;
        this.address = address;
    }
    
     public Membre(int id_member, String last_name, String first_name, Date birth, String email, String password, double phone_number, String gender, boolean verif_number, boolean verif_cin, boolean verif_email, boolean role, String url_cin, String url_picture,String address,boolean statut) {
        this.id_member = id_member;
        this.last_name = new SimpleStringProperty(last_name);
        this.first_name = new SimpleStringProperty(first_name);
        this.birth = birth;
        this.email = new SimpleStringProperty(email);
        this.password = password;
        this.phone_number =  new SimpleDoubleProperty(phone_number);
        this.gender = new SimpleStringProperty(gender);
        this.verif_number = verif_number;
        this.verif_cin = verif_cin;
        this.verif_email = verif_email;
        this.role = new SimpleBooleanProperty (role);
        this.url_cin = url_cin;
        this.url_picture = url_picture;
        this.address = address;
        this.statut=new SimpleBooleanProperty (statut);
    }
    public Membre(int id_member){
         this.id_member = id_member;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   

    public int getId_member() {
        return id_member;
    }

    public String getLast_name() {
        return last_name.get();
    }

    public String getFirst_name() {
        return first_name.get();
    }

    public Date getBirth() {
        return birth;
    }

    public String getEmail() {
        return email.get();
    }

    public String getPassword() {
        return password;
    }

    public double getPhone_number() {
        return phone_number.get();
    }

    public String getGender() {
        return gender.get();
    }

    public boolean isVerif_number() {
        return verif_number;
    }

    public boolean isVerif_cin() {
        return verif_cin;
    }

    public boolean isVerif_email() {
        return verif_email;
    }

    public boolean isRole() {
        return role.get();
    }

    public String getUrl_cin() {
        return url_cin;
    }

    public String getUrl_picture() {
        return url_picture;
    }

    public void setId_member(int id_member) {
        this.id_member = id_member;
    }

    public void setLast_name(String last_name) {
        this.last_name.set(last_name);
    }

    public void setFirst_name(String first_name) {
        this.first_name.set( first_name);
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_number(double phone_number) {
        this.phone_number.set( phone_number);
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public void setVerif_number(boolean verif_number) {
        this.verif_number = verif_number;
    }

    public void setVerif_cin(boolean verif_cin) {
        this.verif_cin = verif_cin;
    }

    public void setVerif_email(boolean verif_email) {
        this.verif_email = verif_email;
    }

    public void setRole(boolean role) {
        this.role.set(role);
    }

    public void setUrl_cin(String url_cin) {
        this.url_cin = url_cin;
    }

    public void setUrl_picture(String url_picture) {
        this.url_picture = url_picture;
    }

    @Override
    public String toString() {
        return "Membre{" + "id_member=" + id_member + ", last_name=" + last_name + ", first_name=" + first_name + ", birth=" + birth + ", email=" + email + ", password=" + password + ", phone_number=" + phone_number + ", gender=" + gender + ", statut=" + statut + ", verif_number=" + verif_number + ", verif_cin=" + verif_cin + ", verif_email=" + verif_email + ", role=" + role + ", url_cin=" + url_cin + ", url_picture=" + url_picture + ", address=" + address + '}';
    }

    
  


    
}
