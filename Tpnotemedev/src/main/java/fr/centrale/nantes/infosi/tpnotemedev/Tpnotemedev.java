/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fr.centrale.nantes.infosi.tpnotemedev;

import java.io.IOException;
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
        String mot;

        System.out.println("1. Mode 1 Joueur");
        System.out.println("2. Mode 2 Joueurs");
        System.out.print("Choix : ");
        int choix = sc.nextInt();
        sc.nextLine();
            try {
                if (choix == 1) {
                    ChargementDictionnaire c = new ChargementDictionnaire();
                    mot = c.chargement(); 
                } else {
                    mot = ui.demanderMot(); 
                    for(int i=0; i<50; i++) System.out.println();
                }
            } catch (IOException e) {
                ui.afficheErreur("Erreur dictionnaire : " + e.getMessage()); 
                return;
            }
        JeuPendu game = new JeuPendu(mot, 7);

        while (!game.partieGagne() && !game.partiePerdu()) {
            ui.afficheEtatDeJeu(game);
            try {
                char letter = ui.recupererLettre();
                game.appartient(letter); 
            } catch (IllegalArgumentException e) {
                ui.afficheErreur(e.getMessage());
            }
        }

        ui.afficheFinDeJeu(game);
    }

}
