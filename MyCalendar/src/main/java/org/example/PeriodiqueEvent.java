package org.example;

import java.time.LocalDateTime;

public class PeriodiqueEvent extends Event {
    public int frequenceJours;

    public PeriodiqueEvent(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, int frequenceJours) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.frequenceJours = frequenceJours;
    }

    public String description() {
        return "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
    }
}
