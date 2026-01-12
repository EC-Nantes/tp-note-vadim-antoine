/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.nantes.infosi.tpnotemedev;

/**
 *
 * @author agach
 */

import java.util.Scanner;

/**
 *
 * @author agach
 */
public class Interface {
    private Scanner scan;
    
    /**
     *Constructeur d'une interface
     */
    public Interface(){
        this.scan=new Scanner(System.in);
    }
    
    /**
     *Fonction qui affiche l'etat du jeu après un tour 
     * @param pendu
     */
    public void afficheEtatDeJeu(JeuPendu pendu){
        System.out.println("Etat actuel du jeu");
        System.out.println("Mot :" +"");
        System.out.println("Nombre d'erreur :" pendu.getNbErreur+" sur :"+pendu.getMax+" erreur autorisée");
        
    }
    
    /**
     *Fonction qui demande au joueur qui cherche le mot une lettre et qui le renvoie en tant que char
     * @return
     */
    public char recupererLettre(){
        System.out.println("Proposez une lettre :");
        String lettre = scan.nextLine();
        while(lettre.isEmpty()){
            System.out.println("Proposez une lettre :");
            lettre = scan.nextLine();
        }
        return lettre.charAt(0);
    }
    
    /**
     *fonction qui demande au joueur de rentrer son mot caché afin de commencer la partie
     * @return le mot (pas visible mais utilisable pour la partie
     */
    public String demanderMot(){
        System.out.println("Joueur 1 entrez votre mot secret :");
        String mot=scan.nextLine();
        return mot;
    }
    
}
