/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.centrale.nantes.infosi.tpnotemedev;
import java.util.Set;
import java.util.HashSet;
/**
 *
 * @author agach
 */


public class JeuPendu {
    private String motSecret;
    private Set<Character> lettres;
    private int max;
    private int nbErreur;
    
    /**
     *
     * @param motSecret
     * @param max
     */
    public JeuPendu(String motSecret, int max) {
        this.motSecret = motSecret.toUpperCase();
        this.max = max;
        this.lettres = new HashSet<>();
        this.nbErreur = 0;
    }
    
    /**
     *La fonction retourne un booléen : True si la lettre appartient au mot cherché, False sinon.
     * @param l charactère testé par la fonction
     * @return un booléen
     */
    public boolean appartient(char l) {
        char lettre = Character.toUpperCase(l);
        if (!Character.isLetter(lettre)) {
            throw new IllegalArgumentException("Caractère invalide. Veuillez entrer une lettre.");
        }
        if (lettres.contains(lettre)) {
            return motSecret.indexOf(lettre) >= 0; 
        }

        lettres.add(lettre);

        boolean t = motSecret.indexOf(lettre) >= 0;
        if (!t) {
            nbErreur++; 
        }
        return t;
    }
}
