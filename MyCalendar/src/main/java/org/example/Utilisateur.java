package org.example;

import java.util.ArrayList;
import java.util.List;

import static org.example.Main.*;

public class Utilisateur {
    private String nom; // Nom de l'utilisateur
    private List<Event> evenements; // Liste des événements associés à l'utilisateur

    // Constructeur
    public Utilisateur(String nom) {
        this.nom = nom;
        this.evenements = new ArrayList<>();
    }

    // Getter pour obtenir le nom de l'utilisateur
    public String getNom() {
        return nom;
    }

    // Méthode pour ajouter un événement à la liste
    public void ajouterEvenement(Event evenement) {
        evenements.add(evenement);
    }

    // Méthode pour obtenir la liste des événements
    public List<Event> getEvenements() {
        return new ArrayList<>(evenements);  // Retourne une copie de la liste pour éviter les modifications directes
    }

//    public void supprimerEvenement(Event evenement) {
//        evenements.remove(evenement);
//    }
}