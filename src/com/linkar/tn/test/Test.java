/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.Test;

import com.linkar.tn.entities.Membre;
import com.linkar.tn.services.MembreServices;



/**
 *
 * @author Rishya
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.sql.Date sqlDate = new java.sql.Date(2013, 02, 23);

        Membre m = new Membre(0,"hello","dfd",sqlDate,"ous@gmailtretgfdghghthg","sd",32,"Non-binary",false, false, false, false, "edf", "sdfsdf","Tunis");
        MembreServices s = new MembreServices() ;
        s.add(m);
        m.setId_member(1);
        s.delete(m);
        

    }
    
}
