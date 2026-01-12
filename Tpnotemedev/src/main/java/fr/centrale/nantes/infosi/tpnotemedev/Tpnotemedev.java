/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fr.centrale.nantes.infosi.tpnotemedev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author agach
 */
public class Tpnotemedev {

    public static void main(String[] args) {
        Interface ui = new Interface();
        Scanner sc = new Scanner(System.in);
        String mot = "";

        System.out.println("1. Mode 1 Joueur");
        System.out.println("2. Mode 2 Joueurs");
        System.out.print("Choix : ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
                Random r = new Random();
                int a = r.nextInt(50);
                List<String> mots = new ArrayList<>(Arrays.asList("ABEILLE", "HORIZON", "JONGLEUR", "QUARTZ", "ZODIAQUE",
                "BALLADE", "IGLOO", "KANGOUROU", "RIVIERE", "WAGON",
                "CASCADE", "JARDIN", "LUMIERE", "SOLEIL", "XYLOPHONE",
                "DAUPHIN", "KLAXON", "MONTAGNE", "TULIPE", "YAOURT",
                "ECUREUIL", "LAMPE", "NUAGE", "UNIVERS", "ZEPHYR",
                "FORET", "MIROIR", "OISEAU", "VALISE", "MYRTILLE",
                "GUITARE", "NATURE", "PHARE", "VOYAGE", "CACTUS",
                "HARPE", "ORANGE", "QUALITE", "ZENITUDE", "FRAMBOISE",
                "ILE", "POMME", "RENARD", "BONHEUR", "PAPILLON",
                "JOURNAL", "QUILLE", "SOURIRE", "ETOILE", "PLANETE"));
                mot = mots.get(a);
            } else {
                mot = ui.demanderMot();
                for(int i=0; i<50; i++) System.out.println();
            }
        JeuPendu game = new JeuPendu(mot, 7);

        while (!game.partieGagne() && !game.partiePerdu()) {
            ui.afficheEtatDeJeu(game);
            try {
                char letter = ui.recupererLettre();
                game.appartient(letter); // Mise à jour de l'état [cite: 58]
            } catch (IllegalArgumentException e) {
                ui.afficheErreur(e.getMessage());
            }
        }

        ui.afficheFinDeJeu(game);
    }

}
