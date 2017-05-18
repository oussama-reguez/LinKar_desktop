package com.linkar.tn.Iservice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.linkar.tn.entities.Reclamation;
import java.util.List;

/**
 *
 * @author Oussama Reguez
 */
public interface ReclamationIService {

    void addReclamation(Reclamation r);

    void removeReclamation(Reclamation r);

    void modifyReclamation(Reclamation r);

    Reclamation getReclamationById(int id);

    List<Reclamation> getAllReclamation();

    void markReclamation(boolean mark, int id_reclamation);

    List<Reclamation> getAllReclamation(boolean marked);
}
