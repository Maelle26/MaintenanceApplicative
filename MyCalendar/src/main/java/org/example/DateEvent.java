package org.example;

import java.time.LocalDateTime;

public record DateEvent(LocalDateTime valeur) {

    /**
     * Constructeur de la classe DateEvent
     * @param valeur la date de l'événement
     */
    public DateEvent {
        if (valeur == null) {
            throw new IllegalArgumentException("La date ne peut pas être nulle.");
        }
    }

    @Override
    public String toString() {
        return valeur.toString();
    }
}

