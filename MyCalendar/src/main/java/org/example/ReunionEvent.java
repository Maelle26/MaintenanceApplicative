package org.example;

import java.time.LocalDateTime;

public class ReunionEvent extends Event {
    public String lieu;
    public String participants;

    public ReunionEvent(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, String participants) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.lieu = lieu;
        this.participants = participants;
    }

    public String description() {
        return "Réunion : " + title + " à " + lieu + " avec " + participants;
    }
}
