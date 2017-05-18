/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.entities;

import java.sql.Date;

/**
 *
 * @author WIKI
 */
public class Message {
    
    int id_message ;
    int id_receiver ;
    int id_sender ;
    int seen ;
    Date date ;
    String text ;
    Annonce A ;

    public Message(int id_message, int id_receiver, int id_sender, int seen, String text,Date date) {
        this.id_message = id_message;
        this.id_receiver = id_receiver;
        this.id_sender = id_sender;
        this.seen = seen;
        this.text = text;
     //   this.A = A;
        this.date= date ;
    }

    public Date getDate() {
        return date;
    }
    

    public int getId_message() {
        return id_message;
    }

    public int getId_receiver() {
        return id_receiver;
    }

    public int getId_sender() {
        return id_sender;
    }

    public int getSeen() {
        return seen;
    }

    public String getText() {
        return text;
    }

    public Annonce getA() {
        return A;
    }

    @Override
    public String toString() {
        return "Message{" + "id_message=" + id_message + ", id_receiver=" + id_receiver + ", id_sender=" + id_sender + ", seen=" + seen + ", date=" + date + ", text=" + text + ", A=" + A + '}';
    }
    
    
    
}
