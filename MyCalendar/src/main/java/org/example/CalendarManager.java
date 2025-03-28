package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    //Attributs
    public final List<Event> events;

    /**
     * Constructeur
     */
    public CalendarManager() {
        this.events = new ArrayList<>();
    }

    /**
     * Méthode qui ajoute un événement à la liste des événements
     * @param event l'événement à ajouter
     */
    public void ajouterEvent(Event event) {
        events.add(event);
    }

    /**
     * Méthode qui retourne les événements dans une période donnée
     * @param debut date de début
     * @param fin date de fin
     * @return la liste des événements dans la période donnée
     */
    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();

        for (Event e : events) {
            if (e instanceof PeriodiqueEvent periodique) {
                LocalDateTime temp = periodique.dateDebut;
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(periodique);
                        break;
                    }
                    temp = temp.plusDays(periodique.frequenceJours);
                }
            } else if (!e.dateDebut.isBefore(debut) && !e.dateDebut.isAfter(fin)) {
                result.add(e);
            }
        }

        return result;
    }

    /**
     * Vérifie si un événement périodique entre en conflit avec un autre événement.
     * @param periodique L'événement périodique
     * @param autre L'autre événement
     * @return true s'il y a un conflit, false sinon
     */
    private boolean conflitPeriodique(PeriodiqueEvent periodique, Event autre) {
        LocalDateTime occurrence = periodique.dateDebut;
        LocalDateTime finAutre = autre.dateDebut.plusMinutes(autre.dureeMinutes);

        // Vérifier les occurrences de l'événement périodique sur une période de 1 an max
        while (occurrence.isBefore(autre.dateDebut.plusYears(1))) {
            LocalDateTime finOccurrence = occurrence.plusMinutes(periodique.dureeMinutes);

            if (occurrence.isBefore(finAutre) && finOccurrence.isAfter(autre.dateDebut)) {
                return true; // Conflit détecté
            }

            occurrence = occurrence.plusDays(periodique.frequenceJours);
        }
        return false;
    }

    /**
     * Méthode qui vérifie si deux événements périodiques sont en conflit
     * @param e1 Premier événement
     * @param e2 Deuxième événement
     * @return true si les événements sont en conflit, false sinon
     */
    public boolean conflit(Event e1, Event e2) {
        if (e1 instanceof PeriodiqueEvent periodique1) {
            return conflitPeriodique(periodique1, e2);
        }
        if (e2 instanceof PeriodiqueEvent periodique2) {
            return conflitPeriodique(periodique2, e1);
        }

        // Gestion classique des conflits pour événements non périodiques
        LocalDateTime fin1 = e1.dateDebut.plusMinutes(e1.dureeMinutes);
        LocalDateTime fin2 = e2.dateDebut.plusMinutes(e2.dureeMinutes);

        return e1.dateDebut.isBefore(fin2) && fin1.isAfter(e2.dateDebut);
    }

    /**
     * Méthode qui affiche tous les événements
     */
    public void afficherEvenements() {
        for (Event e : events) {
            System.out.println(e.description());
        }
    }
}
