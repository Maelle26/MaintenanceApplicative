import org.example.*;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class TestCalendrier {

    /**
     * Fonctionnalités n°1: Ajouter un nouvel évenement (ANNIVERSAIRE)
     */
    @Test
    public void testAjouterEvenementAnniversaire() {
        // Création d'un calendrier vide
        CalendarManager calendrier = new CalendarManager();

        // Création d'un événement anniversaire
        Event anniversaire = new AnniversaireEvent(
                "40ème Anniversaire de Pierre", "Pierre", LocalDateTime.of(2021, 10, 10, 10, 0), 60, "un gâteau");

        //Liste des événements
        List<Event> events = calendrier.events;
        //Vérification que la liste des événements est vide
        assertEquals(0, events.size());

        // Ajout de l'événement au calendrier
        calendrier.ajouterEvent(anniversaire);

        //Vérification si la liste des événements contient un événement
        assertEquals(1, events.size());
        //Vérification si l'événement ajouté est bien l'anniversaire
        assertEquals(anniversaire, events.get(0));

    }

    /**
     * Fonctionnalités n°2: Obtenir les événements dans une période donnée
     */
    @Test
    public void testObtenirEvenementsParPeriode() {
        // Création d'un calendrier avec quelques événements
        CalendarManager calendrier = new CalendarManager();

        // Création d'événements à différentes dates
        Event evenement1 = new AnniversaireEvent("Anniversaire de Pierre", "Pierre", LocalDateTime.of(2021, 10, 10, 10, 0), 60, "un gâteau");
        Event evenement2 = new AnniversaireEvent("Anniversaire de Marie", "Marie", LocalDateTime.of(2021, 10, 15, 15, 0), 90, "une montre");
        Event evenement3 = new AnniversaireEvent("Anniversaire de Jean", "Jean", LocalDateTime.of(2021, 11, 1, 11, 0), 120, "un livre");

        // Ajout des événements dans le calendrier
        calendrier.ajouterEvent(evenement1);
        calendrier.ajouterEvent(evenement2);
        calendrier.ajouterEvent(evenement3);

        //Période de recherche
        LocalDateTime debutPeriode = LocalDateTime.of(2021, 10, 1, 0, 0);
        LocalDateTime finPeriode = LocalDateTime.of(2021, 10, 20, 23, 59);

        //Liste des evenemets dans la periode donnée
        List<Event> evenementsTrouves = calendrier.obtenirEvenementsParPeriode(debutPeriode, finPeriode);

        // Vérifications
        assertEquals(2, evenementsTrouves.size()); // 2 evenements à trouver
        assertTrue(evenementsTrouves.contains(evenement1)); // Dans la liste
        assertTrue(evenementsTrouves.contains(evenement2)); // Dans la liste
        assertFalse(evenementsTrouves.contains(evenement3)); //Pas dans la liste
    }

    /**
     * Fonctionnalités n°3: Controle automatique des conflits
     */
    @Test
    public void testDetectionConflitEvenements() {
        // Création du calendrier
        CalendarManager calendrier = new CalendarManager();

        // Création de deux événements qui se chevauchent
        Event event1 = new AnniversaireEvent("Anniversaire de Pierre", "Pierre",
                LocalDateTime.of(2024, 3, 28, 14, 0), 60, "un gâteau"); // 14:00 - 15:00

        Event event2 = new AnniversaireEvent("Anniversaire de Marie", "Marie",
                LocalDateTime.of(2024, 3, 28, 14, 30), 90, "une montre"); // 14:30 - 16:00 (chevauchement)

        // Ajout du premier événement
        calendrier.ajouterEvent(event1);

        // Vérification qu'il y a un chevauchement
        assertTrue(calendrier.conflit(event1, event2));
    }

    /**
     * Fonctionnalités n°4: Descritpion en fonction du type d'événement
     */
    //ANNIVERSAIRE
    @Test
    public void testDescriptionAnniversaire() {
        // Création d'un événement Anniversaire
        AnniversaireEvent anniv = new AnniversaireEvent("40 ans de Pierre", "Pierre",
                LocalDateTime.of(2025, 10, 10, 18, 0), 120, "un voyage surprise");

        // Vérification que la description est ok
        String descriptionAttendue = "Anniversaire : 40 ans de Pierre avec un voyage surprise";
        assertEquals(descriptionAttendue, anniv.description());
    }

    //RDV perso
    @Test
    public void testDescriptionRDV() {
        // Création d'un événement RDV
        Event rdv = new Event("RDV médical", "Alice",
                LocalDateTime.of(2025, 12, 1, 14, 0), 30) {
            @Override
            public String description() {
                return "RDV : " + title + " à " + dateDebut.toString();
            }
        };

        // Vérification que la description est pk
        String descriptionAttendue = "RDV : RDV médical à 2025-12-01T14:00";
        assertEquals(descriptionAttendue, rdv.description());
    }

    //REUNION
    @Test
    public void testDescriptionReunion() {
        // Création d'un événement Réunion
        ReunionEvent reunion = new ReunionEvent("Réunion projet", "Alice",
                LocalDateTime.of(2025, 12, 1, 14, 0), 90, "Salle 101", "[Paul, Sophie]");

        // Vérification que la description est ok
        String descriptionAttendue = "Réunion : Réunion projet à Salle 101 avec [Paul, Sophie]";
        assertEquals(descriptionAttendue, reunion.description());
    }

    //PERIODIQUE
    @Test
    public void testDescriptionPeriodique() {
        // Création d'un événement Périodique
        PeriodiqueEvent periodique = new PeriodiqueEvent("Yoga du matin", "Paul",
                LocalDateTime.of(2025, 11, 1, 8, 0), 60, 7);

        // Vérification que la description est ok
        String descriptionAttendue = "Événement périodique : Yoga du matin tous les 7 jours";
        assertEquals(descriptionAttendue, periodique.description());
    }

    /**
     * Fonctionnalités n°5: Supprimer un evenement
     */
    @Test
    public void testSupprimerEventParId() {
        // Création du gestionnaire de calendrier
        CalendarManager calendrier = new CalendarManager();

        // Ajout d'un événement avec un identifiant unique
        Event event = new ReunionEvent("Réunion d'équipe", "Alice",
                LocalDateTime.of(2025, 12, 1, 14, 0), 90, "Salle 101",
                "[Paul, Sophie]");

        calendrier.ajouterEvent(event);

        // Vérification que l'événement est bien ajouté
        assertEquals(1, calendrier.events.size());

        // Suppression de l'événement via son identifiant métier
        boolean suppressionReussie = calendrier.supprimerEvent(event.getId());

        // Vérification que l'événement a bien été supprimé
        assertTrue(suppressionReussie);
        assertEquals(0, calendrier.events.size());
    }
}
