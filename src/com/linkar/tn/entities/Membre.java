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
    private String last_name;
    private String first_name;
    private Date birth;
    private String email;
    private String password;
    private String  phone_number;
    private String gender;
    private boolean statut;

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

   
    private boolean verif_number;
    private boolean verif_cin;
    private boolean verif_email;
    private SimpleBooleanProperty role;
    private String url_cin;
    private String url_picture;
    private String address;
    private int nbrAnnonce;

    
      private int sms_code;

    public int getSms_code() {
        return sms_code;
    }

    public void setSms_code(int sms_code) {
        this.sms_code = sms_code;
    }
    
    public Membre()
    {}
    
    public Membre(String last_name, String first_name, Date birth, String email, String password, String phone_number, String gender, boolean verif_number, boolean verif_cin, boolean verif_email, boolean role, String address, int sms_code) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.birth = birth;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.gender = gender;
        this.verif_number = verif_number;
        this.verif_cin = verif_cin;
        this.verif_email = verif_email;
        this.role =  new SimpleBooleanProperty(role);
        this.address = address;
        this.sms_code = sms_code;
    }

    public Membre(String last_name, String first_name, Date birth, String email, String password, String phone_number, String gender, boolean verif_number, boolean verif_cin, boolean verif_email, boolean role, String url_picture, String url_cin, String address, int sms_code) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.birth = birth;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.gender = gender;
        this.verif_number = verif_number;
        this.verif_cin = verif_cin;
        this.verif_email = verif_email;
        this.role =  new SimpleBooleanProperty(role);
        this.url_picture = url_picture;
        this.url_cin = url_cin;
        this.address = address;
        this.sms_code = sms_code;
    }
    
    public int getNbrAnnonce() {
        return nbrAnnonce;
    }

    public void setNbrAnnonce(int nbrAnnonce) {
        this.nbrAnnonce = nbrAnnonce;
    }
    

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public SimpleBooleanProperty getRole() {
        return role;
    }

    public void setRole(SimpleBooleanProperty role) {
        this.role = role;
    }

    
    
 
    public Membre(int id_member, String last_name, String first_name, Date birth, String email, String password, String phone_number, String gender, boolean verif_number, boolean verif_cin, boolean verif_email, boolean role, String url_cin, String url_picture,String address) {
        this.id_member = id_member;
        this.last_name = last_name;
        this.first_name = first_name;
        this.birth = birth;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.gender = gender;
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
        this.last_name = last_name;
        this.first_name = first_name;
        this.birth = birth;
        this.email = email;
        this.password = password;
         this.phone_number = String.valueOf(phone_number);
        this.gender = gender;
        this.verif_number = verif_number;
        this.verif_cin = verif_cin;
        this.verif_email = verif_email;
        this.role = new SimpleBooleanProperty (role);
        this.url_cin = url_cin;
        this.url_picture = url_picture;
        this.address = address;
        this.statut=statut;
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
