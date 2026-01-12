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
import java.util.stream.Collectors;

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
        System.out.println("Mot :" +pendu.motMasque());
        System.out.println("Nombre d'erreur :"+pendu.getNbErreur()+" sur :"+pendu.getMax()+" erreur autorisée");
        System.out.println(" ");
        dessin(pendu.getNbErreur(),pendu.getMax());
        
        String lettre= pendu.getLettres().stream().map(String::valueOf).collect(Collectors.joining(" ,"));
        System.out.println("lettre essayée :"+lettre);
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
        return scan.nextLine();
    }
    
    /**
     *Methode qui affiche un message de victoire ou défaite à la fin du jeu
     * @param pendu
     */
    public void afficheFinDeJeu(JeuPendu pendu){
        if(pendu.partieGagne()){
            System.out.println("Vous avez trouve le mot caché qui etait "+pendu.getMotSecret());
        }else{
            System.out.println("Vous avez ete pendu");
            dessin(pendu.getMax(),pendu.getMax());
        }
    }
    
    public void afficheErreur(String message){
        System.out.println("Erreur :"+message);
    }
    /**
     *methode qui affiche le dessin du pendu en fonction de l'avancée du jeu
     * @param erreur
     * @param max
     */
    public void dessin(int erreur, int max){
        if(max-erreur==7){
            System.out.println(" +---+");
            System.out.println(" |   |");
            System.out.println("     |");
            System.out.println("     |");
            System.out.println("     |");
            System.out.println("     |");
            System.out.println("======");
        }else if(max-erreur==1){
            System.out.println(" +---+");
            System.out.println(" |   |");
            System.out.println(" 0   |");
            System.out.println("/||  |");
            System.out.println(" |   |");
            System.out.println("/    |");
            System.out.println("======");
        }else if(max-erreur==2){
            System.out.println(" +---+");
            System.out.println(" |   |");
            System.out.println(" 0   |");
            System.out.println("/||  |");
            System.out.println(" |   |");
            System.out.println("     |");
            System.out.println("======");
        }else if (max-erreur==3){
            System.out.println(" +---+");
            System.out.println(" |   |");
            System.out.println(" 0   |");
            System.out.println("/||  |");
            System.out.println("     |");
            System.out.println("     |");
            System.out.println("======");
        }else if (max-erreur==4){
            System.out.println(" +---+");
            System.out.println(" |   |");
            System.out.println(" 0   |");
            System.out.println("/|   |");
            System.out.println("     |");
            System.out.println("     |");
            System.out.println("======");
        }else if (max-erreur==5){
            System.out.println(" +---+");
            System.out.println(" |   |");
            System.out.println(" 0   |");
            System.out.println("/    |");
            System.out.println("     |");
            System.out.println("     |");
            System.out.println("======");
        }else if (max-erreur==6){
            System.out.println(" +---+");
            System.out.println(" |   |");
            System.out.println(" 0   |");
            System.out.println("     |");
            System.out.println("     |");
            System.out.println("     |");
            System.out.println("======");
        }else if(max-erreur==0){
            System.out.println(" +---+");
            System.out.println(" |   |");
            System.out.println(" 0   |");
            System.out.println("/||  |");
            System.out.println(" |   |");
            System.out.println("/ |  |");
            System.out.println("======");
        }
    }
}
    