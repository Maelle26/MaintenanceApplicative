package org.example;

public record TitreEvent(String valeur) {

    /**
     * Constructeur de la classe TitreEvenement
     * @param valeur le titre de l'événement
     */
    public TitreEvent {
        if (valeur == null || valeur.isBlank()) {
            throw new IllegalArgumentException("Le titre ne peut pas être vide.");
        }
    }

    /**
     * Méthode pour obtenir le titre de l'événement
     * @return le titre de l'événement
     */
    @Override
    public String toString() {
        return valeur;
    }
}
