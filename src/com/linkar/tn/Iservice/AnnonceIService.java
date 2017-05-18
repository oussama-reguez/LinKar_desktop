package com.linkar.tn.Iservice;

import com.linkar.tn.entities.Annonce;
import com.linkar.tn.entities.Membre;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface AnnonceIService {

   

   

    List<Annonce> getAllAnnonces();

    double getAvgAnnoncePerDay();

    List<String> getYears();

    LinkedHashMap<Integer, Integer> getStatCreatedAnnoncePerMonth(String year);

    int getNbrAnnonce();

    double getAvgAnnoncePerYear();

  

    Map<String, Integer> getStatNbrAnnoncebyStatus();

    Map<String, Integer> getStatnbrAnnoncebyDestination();

    Map<String, Integer> getStatnbrAnnoncebydepart();

    void removeAnnonce(int a);

    List<Annonce> getAnnonceByUser(Membre m);
}
