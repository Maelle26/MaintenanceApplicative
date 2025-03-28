import org.example.AnniversaireEvent;
import org.example.CalendarManager;
import org.example.Event;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCalendrier {

    @Test
    public void testAjouterEvenementAnniversaire() {
        // Création d'un calendrier vide
        CalendarManager calendrier = new CalendarManager();

        // Création d'un événement anniversaire
        AnniversaireEvent anniversaire = new AnniversaireEvent(
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


}
