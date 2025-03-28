package org.example;

import java.time.LocalDateTime;

public class AnniversaireEvent extends Event {
    //Attibut
    public String cadeau;

    public AnniversaireEvent(String title, String personne, LocalDateTime dateDebut, int dureeMinutes, String cadeau) {
        super(title, personne, dateDebut, dureeMinutes);
        this.cadeau = cadeau;
    }

    public String description() {
        return "Anniversaire : " + title + " avec " + cadeau;
    }
}
