import org.example.AnniversaireEvent;
import org.example.CalendarManager;
import org.example.Event;
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


}
