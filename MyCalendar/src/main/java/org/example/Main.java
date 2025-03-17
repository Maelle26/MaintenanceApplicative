package org.example;


import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static CalendarManager calendar = new CalendarManager();
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> utilisateurs = new ArrayList<>(); //liste des utilisateurs enregistrés
    private static final List<String> motsDePasses = new ArrayList<>(); //liste des mots de passes des utilisateurs enregistrés
    private static final List<Evenement> evenements = new ArrayList<>(); //liste des événements
    protected static boolean continuer = true;

    public static void main(String[] args) {
        while (true) {
            afficherMenuPrincipal();
            String choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    connecterUtilisateur();
                    break;
                case "2":
                    creerCompte();
                    break;
                case "3":
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    /**
     * Affiche le menu principal
     */
    private static void afficherMenuPrincipal() {
        System.out.println("  _____         _                   _                __  __");
        System.out.println(" / ____|       | |                 | |              |  \\/  |");
        System.out.println(
                "| |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __    __ _   __ _   ___  _ __");
        System.out.println(
                "| |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|");
        System.out.println(
                "| |____ | (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |");
        System.out.println(
                " \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|");
        System.out.println(
                "                                                                                   __/ |");
        System.out.println(
                "                                                                                  |___/");
        System.out.println("1 - Se connecter");
        System.out.println("2 - Créer un compte");
        //        System.out.println("3. Quitter");
        System.out.println("Choix : ");

    }

    /**
     * Connecte les utilisateurs inscrits
     */
    private static void connecterUtilisateur() {
        System.out.print("Nom d'utilisateur : ");
        String nom = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String mdp = scanner.nextLine();

        for (int i = 0; i < utilisateurs.size(); i++) {
            if (utilisateurs.get(i).equals(nom) && motsDePasses.get(i).equals(mdp)) {
                System.out.println("Connexion réussie !");
                menuUtilisateur(nom);
                return;
            }
        }
        System.out.println("Échec de connexion, identifiants incorrects.");
    }

    /**
     * Créer un compte utilisateur
     */
    private static void creerCompte() {
        System.out.print("Choisissez un nom d'utilisateur : ");
        String nom = scanner.nextLine();
        if (utilisateurs.contains(nom)) {
            System.out.println("Ce nom d'utilisateur existe déjà.");
            return;
        }
        System.out.print("Choisissez un mot de passe : ");
        String mdp = scanner.nextLine();
        utilisateurs.add(nom);
        motsDePasses.add(mdp);
        System.out.println("Compte créé avec succès !");
    }

    /**
     * Affiche le menu de l'utilisateur
     * @param utilisateur le nom de l'utilisateur
     */
    private static void menuUtilisateur(String utilisateur) {
        while (continuer && utilisateur != null) {
            System.out.println("\nBonjour, " + utilisateur);
                System.out.println("=== Menu Gestionnaire d'Événements ===");
                System.out.println("1 - Voir les événements");
                System.out.println("2 - Ajouter un rendez-vous perso");
                System.out.println("3 - Ajouter une réunion");
                System.out.println("4 - Ajouter un évènement périodique");
                System.out.println("5 - Se déconnecter");
                System.out.print("Votre choix : ");
            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    voirEvenement(utilisateur);
                    break;
                case "2":
                    ajouterRdvPerso(utilisateur);
                    break;
                case "3":
                    ajouterReunion(utilisateur);
                    break;
                case "4":
                    ajouterEvenementPeriodique(utilisateur);
                    break;
                case "5":
                        System.out.println("Déconnexion ! Voulez-vous continuer ? (O/N)");
                        continuer = scanner.nextLine().trim().equalsIgnoreCase("oui");

                        utilisateur = null;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    /**
     * Ajout d'un evenement periodique à un utilisateur
     * @param utilisateur le nom de l'utilisateur
     */
    private static void ajouterEvenementPeriodique(String utilisateur) {
        // Ajout simplifié d'une réunion
        System.out.print("Titre de l'événement : ");
        String titre3 = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute3 = Integer.parseInt(scanner.nextLine());
        System.out.print("Frequence (en jours) : ");
        int frequence = Integer.parseInt(scanner.nextLine());

        calendar.ajouterEvent("PERIODIQUE", titre3, utilisateur,
                LocalDateTime.of(annee3, moisRdv3, jourRdv3, heure3, minute3), 0,
                "", "", frequence);

        System.out.println("Événement ajouté.");
    }

    /**
     * Ajout d'un rdv perso à un utilisateur
     * @param utilisateur le nom de l'utilisateur
     */
    private static void ajouterRdvPerso(String utilisateur) {
        // Ajout simplifié d'un RDV personnel
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Durée (en minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());

        calendar.ajouterEvent("RDV_PERSONNEL", titre, utilisateur,
                LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute), duree,
                "", "", 0);

        System.out.println("Événement ajouté.");
    }

    /**
     * Ajout simplifié d'une réunion à un utilisateur
     * @param utilisateur le nom de l'utilisateur
     */
    private static void ajouterReunion(String utilisateur) {
        // Ajout simplifié d'une réunion
                        System.out.print("Titre de l'événement : ");
                        String titre2 = scanner.nextLine();
                        System.out.print("Année (AAAA) : ");
                        int annee2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Mois (1-12) : ");
                        int moisRdv2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Jour (1-31) : ");
                        int jourRdv2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Heure début (0-23) : ");
                        int heure2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Minute début (0-59) : ");
                        int minute2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Durée (en minutes) : ");
                        int duree2 = Integer.parseInt(scanner.nextLine());
                        System.out.println("Lieu :");
                        String lieu = scanner.nextLine();

                        String participants = utilisateur;

                        boolean encore = true;
                        System.out.println("Ajouter un participant ? (oui / non)");
                        while (scanner.nextLine().equals("oui"))
                        {
                            System.out.print("Participants : " + participants);
                            participants += ", " + scanner.nextLine();
                        }

                        calendar.ajouterEvent("REUNION", titre2, utilisateur,
                                LocalDateTime.of(annee2, moisRdv2, jourRdv2, heure2, minute2), duree2,
                                lieu, participants, 0);

                        System.out.println("Événement ajouté.");
    }

    /**
     * Permet de voir la liste des événements en fonction de la période choisie
     * @param utilisateur le nom de l'utilisateur
     */
    private static void voirEvenement(String utilisateur) {
        System.out.println("\n=== Menu de visualisation d'Événements ===");
        System.out.println("1 - Afficher TOUS les événements");
        System.out.println("2 - Afficher les événements d'un MOIS précis");
        System.out.println("3 - Afficher les événements d'une SEMAINE précise");
        System.out.println("4 - Afficher les événements d'un JOUR précis");
        System.out.println("5 - Retour");
        System.out.print("Votre choix : ");

        String choix = scanner.nextLine();

        switch (choix) {
            case "1":
                calendar.afficherEvenements();
                break;

            case "2":
                System.out.print("Entrez l'année (AAAA) : ");
                int anneeMois = Integer.parseInt(scanner.nextLine());
                System.out.print("Entrez le mois (1-12) : ");
                int mois = Integer.parseInt(scanner.nextLine());

                LocalDateTime debutMois = LocalDateTime.of(anneeMois, mois, 1, 0, 0);
                LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);

                afficherListe(calendar.eventsDansPeriode(debutMois, finMois));
                break;

            case "3":
                System.out.print("Entrez l'année (AAAA) : ");
                int anneeSemaine = Integer.parseInt(scanner.nextLine());
                System.out.print("Entrez le numéro de semaine (1-52) : ");
                int semaine = Integer.parseInt(scanner.nextLine());

                LocalDateTime debutSemaine = LocalDateTime.now()
                        .withYear(anneeSemaine)
                        .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                        .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                        .withHour(0).withMinute(0);
                LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);

                afficherListe(calendar.eventsDansPeriode(debutSemaine, finSemaine));
                break;

            case "4":
                System.out.print("Entrez l'année (AAAA) : ");
                int anneeJour = Integer.parseInt(scanner.nextLine());
                System.out.print("Entrez le mois (1-12) : ");
                int moisJour = Integer.parseInt(scanner.nextLine());
                System.out.print("Entrez le jour (1-31) : ");
                int jour = Integer.parseInt(scanner.nextLine());

                LocalDateTime debutJour = LocalDateTime.of(anneeJour, moisJour, jour, 0, 0);
                LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);

                afficherListe(calendar.eventsDansPeriode(debutJour, finJour));
                break;
        }
    }

    /**
      * Permet d'afficher la liste d'évenements
      * @param evenements la liste d'évenements à afficher
      */
    private static void afficherListe(List<Event> evenements) {
        if (evenements.isEmpty()) {
            System.out.println("Aucun événement trouvé pour cette période.");
        } else {
            System.out.println("Événements trouvés : ");
            for (Event e : evenements) {
                System.out.println("- " + e.description());
            }
        }
    }

}


