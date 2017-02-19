/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.Iservices;

import com.linkar.tn.entities.Membre;
import java.sql.Date;

/**
 *
 * @author Ryshya
 */
public interface MembreIService {
  void add(Membre m);
  void edit(int id, String last_name, String first_name, Date birth, String phone_number, String address, String email);
  void editPass(int id,String pass);
  void editVerif_number(int id);
  void delete(Membre m); 
  Membre getById(Integer id);
}