package com.example.test;

import com.example.evaluation_dardari_gwendoline.Voiture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Voiture_Test {
    @Test
    void get_nom(){
        Voiture nom = new Voiture("mercedes",80000);
        assertEquals("mercedes",nom.getNom());
        assertNotEquals("bmw",nom.getNom());
    }
    @Test
    void set_nom(){
        Voiture nom = new Voiture("merceded",80000);
        nom.setNom("porsche");
        assertEquals("porsche",nom.getNom());
        assertNotEquals("mercedes",nom.getNom());
    }

    @Test
    void get_prix() {
        Voiture prix = new Voiture("mercedes", 80000);
        assertEquals(80000, prix.getPrix());
        assertNotEquals(70000, prix.getPrix());
    }

    @Test
    void set_prix() {
        Voiture prix = new Voiture("mercedes", 80000);
        prix.setPrix(90000);
        assertEquals(90000, prix.getPrix());
        assertNotEquals(80000, prix.getPrix());
    }
}
