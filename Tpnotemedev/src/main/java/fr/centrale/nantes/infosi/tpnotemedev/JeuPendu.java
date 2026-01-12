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

    public String getMotSecret() {
        return motSecret;
    }

    public Set<Character> getLettres() {
        return lettres;
    }

    public int getMax() {
        return max;
    }

    public int getNbErreur() {
        return nbErreur;
    }

    public void setMotSecret(String motSecret) {
        this.motSecret = motSecret;
    }

    public void setLettres(Set<Character> lettres) {
        this.lettres = lettres;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setNbErreur(int nbErreur) {
        this.nbErreur = nbErreur;
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
    
    public String motMasque() {
        StringBuilder sb = new StringBuilder();
        for (char c : motSecret.toCharArray()) {
            if (lettres.contains(c)) {
                sb.append(c);
            } else {
                sb.append("_");
            }
        }
        return sb.toString();
    }
}
