package com.linkar.tn.Iservice;

import com.linkar.tn.entities.Annonce;
import java.util.List;

public interface AnnonceIService {
    
    void addAnnonce(Annonce a);
     void removeAnnonce(Annonce a);
    void modifyAnnonce(Annonce a);
    Annonce getAnnonceById(int id_annonce);
    List<Annonce> getAllAnnonces();
    
}
