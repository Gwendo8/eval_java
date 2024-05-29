package com.example.evaluation_dardari_gwendoline;

import java.util.List;

public class Main {
    public static void main(String[]args) {
        VoitureDAO voitures = new VoitureDAO();
        MotoDAO motos = new MotoDAO();
        Voiture voit = new Voiture("audi",5000);
        Moto mot = new Moto("sasuke",1000);
        voitures.ajouterVoiture(voit);
        motos.ajouterMoto(mot);
        //voitures.supprimerToutesVoitures();
        afficherVoiture();
        afficherMoto();
    }
    public static void afficherVoiture(){
        List<Voiture> voitures = (new VoitureDAO().getVoiture());
        voitures.stream().forEach((voiture -> {
            System.out.println(voiture.toString());
        }));
    }
    public static void afficherMoto(){
        List<Moto> motos = (new MotoDAO().getMoto());
        motos.stream().forEach((moto -> {
            System.out.println(moto.toString());
        }));
    }
}
