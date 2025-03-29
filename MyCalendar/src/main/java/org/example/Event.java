package org.example;

import java.time.LocalDateTime;

// Classe Event qui représente un événement dans le calendrier
public abstract class Event {
    // Attributs
    private static int compteur = 0;
    private final int eventId;
    public int id;
    public String title;
    public String proprietaire;
    public LocalDateTime dateDebut;
    public int dureeMinutes;

    public Event(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes) {
        //genere un entier unique
        this.eventId = compteur++;
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    public abstract String description();

    public int getId() {
        return eventId;
    }

}