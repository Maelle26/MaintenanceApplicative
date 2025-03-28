package org.example;

import java.time.LocalDateTime;

public class RdvPersoEvent extends Event {
    public RdvPersoEvent(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
    }

    public String description() {
        return "RDV : " + title + " à " + dateDebut.toString();
    }
}
