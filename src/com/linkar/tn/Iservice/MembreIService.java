/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linkar.tn.Iservice;

import com.linkar.tn.entities.Membre;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    List<Membre> searchMembersByFullName(String search);

    List<String> getFirstNames(String search);

    List<String> getLastNames(String search);

    List<String> getFullNames(String search);

    List<Membre> searchMembersByFirstName(String search);

    List<Membre> searchMembersByLastName(String search);

    List<Membre> searchMembersByRole(boolean isAdmin);

    LinkedHashMap<Date, Integer> getStatCreatedUsers();

    LinkedHashMap<Date, Integer> getStatCreatedUsersbyYear();

    Map<String, Integer> getStatnbrUsersbyGender();

    int getBlockedUsers();

    int getNbrUsers();

    List<Membre> getActiveUsers(int nbAnnonce);

    Membre getMembre(int id);

    List<Membre> getRequestedMembers();

    List<Membre> getAllMembres();

    void changeRole(boolean role, int id_membre);

    void toggleMember(int id_membre, boolean isBlocked);

    void verifyAccount(int id_membre, boolean action);
    
    
    
   
  void edit(int id, String last_name, String first_name, Date birth, String phone_number, String address, String email);
  void editPass(int id,String pass);
  void editVerif_number(int id);

  void editImage(int id,String url);

}
