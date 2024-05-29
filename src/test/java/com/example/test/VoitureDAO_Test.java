package com.example.test;

import com.example.evaluation_dardari_gwendoline.Voiture;
import com.example.evaluation_dardari_gwendoline.VoitureDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoitureDAO_Test {
    @Test
    void getVoiture(){
        VoitureDAO voitures = new VoitureDAO();
        voitures.supprimerToutesVoitures();
        Voiture voiture = new Voiture("mercedes",1000);
        voitures.ajouterVoiture(voiture);
        assertEquals(1,voitures.getVoiture().size());
    }
    @Test
    void ajouterVoiture(){
        VoitureDAO voitures = new VoitureDAO();
        voitures.supprimerToutesVoitures();
        Voiture voiture= new Voiture("mercedes",1000);
        int nbVoituresDebut = voitures.getVoiture().size();
        voitures.ajouterVoiture(voiture);
        int nbVoituresFin = voitures.getVoiture().size();
        assertEquals(1,nbVoituresFin-nbVoituresDebut);
    }
    @Test
    void supprimerToutesVoitures(){
        VoitureDAO voitures = new VoitureDAO();
        voitures.supprimerToutesVoitures();
        Voiture voiture = new Voiture("mercedes",1000);
        voitures.ajouterVoiture(voiture);
        voitures.supprimerToutesVoitures();
        assertEquals(0,voitures.getVoiture().size());
    }
}
