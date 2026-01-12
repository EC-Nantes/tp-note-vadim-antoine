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
     *
     * @return
     */
    public String getMotSecret() {
        return motSecret;
    }

    /**
     *
     * @return
     */
    public Set<Character> getLettres() {
        return new HashSet<>(lettres);
    }

    /**
     *
     * @return
     */
    public int getMax() {
        return max;
    }

    /**
     *
     * @return
     */
    public int getNbErreur() {
        return nbErreur;
    }

    /**
     *
     * @param motSecret
     */
    public void setMotSecret(String motSecret) {
        this.motSecret = motSecret;
    }

    /**
     *
     * @param lettres
     */
    public void setLettres(Set<Character> lettres) {
        this.lettres = lettres;
    }

    /**
     *
     * @param max
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     *
     * @param nbErreur
     */
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
    
    /**
     *Affiche le mot avec des _ lorsque les lettres ne sont pas trouvées.
     * @return
     */
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

    /**
     *Renvoie True si la partie est gagnée.
     * @return Booléen
     */
    public boolean partieGagne() {
        for (char c : motSecret.toCharArray()) {
            if (!lettres.contains(c)) return false;
        }
        return true;
    }

    /**
     *Renvoie True si la partie est perdue.
     * @return Booléen
     */
    public boolean partiePerdu() {
        return nbErreur >= max; 
    }
}
