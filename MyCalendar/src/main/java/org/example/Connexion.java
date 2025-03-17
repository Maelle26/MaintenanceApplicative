package org.example;

import java.util.List;
import java.util.Scanner;

public class Connexion {
    private List<Utilisateur> utilisateurs;
    private List<String> motsDePasses;
    private Scanner scanner;

    public Connexion(List<Utilisateur> utilisateurs, List<String> motsDePasses, Scanner scanner) {
        this.utilisateurs = utilisateurs;
        this.motsDePasses = motsDePasses;
        this.scanner = scanner;

        // Ajout des utilisateurs par défaut
        if (utilisateurs.isEmpty()) {
            utilisateurs.add(new Utilisateur("Roger"));
            motsDePasses.add("Chat");
            utilisateurs.add(new Utilisateur("Pierre"));
            motsDePasses.add("KiRouhl");
        }
    }

    /**
     * Connecte les utilisateurs inscrits
     */
    public boolean connecterUtilisateur() {
        System.out.print("Nom d'utilisateur : ");
        String nom = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String mdp = scanner.nextLine();

        for (int i = 0; i < utilisateurs.size(); i++) {
            if (utilisateurs.get(i).getNom().equals(nom) && motsDePasses.get(i).equals(mdp)) {
                System.out.println("Connexion réussie !");
                return true;  // Connexion réussie
            }
        }
        System.out.println("Échec de connexion, identifiants incorrects.");
        return false;  // Échec de la connexion
    }

    /**
     * Créer un compte utilisateur
     */
    public void creerCompte() {
        System.out.print("Choisissez un nom d'utilisateur : ");
        String nom = scanner.nextLine();
        boolean utilisateurExistant = utilisateurs.stream().anyMatch(u -> u.getNom().equals(nom));

        if (utilisateurExistant) {
            System.out.println("Ce nom d'utilisateur existe déjà.");
            return;
        }

        System.out.print("Choisissez un mot de passe : ");
        String mdp = scanner.nextLine();
        utilisateurs.add(new Utilisateur(nom));
        motsDePasses.add(mdp);
        System.out.println("Compte créé avec succès !");
    }
}
