/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.Iservice;

import com.linkar.tn.entities.Membre;

/**
 *
 * @author Ryshya
 */
public interface MembreIService {
  void add(Membre m);
  void edit(Membre m);
  void editPass(Membre m);
  void editEmail(Membre m);
  void delete(Membre m); 
  Membre getById(Integer id);
}