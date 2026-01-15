package fr.centrale.nantes.infosi.tpnotemedev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour JeuPendu.
 * Couvre les transitions d'état, les lettres répétées et les conditions de victoire/défaite.
 */
public class JeuPenduTest {
    
    private JeuPendu instance;
    private final String MOT_TEST = "TEST";
    private final int MAX_ERREURS = 7;

    @BeforeEach
    public void setUp() {
        instance = new JeuPendu(MOT_TEST, MAX_ERREURS);
    }

    @Test
    public void testInitialisation() {
        assertEquals(0, instance.getNbErreur(), "Le nombre d'erreurs doit être 0 au début."); 
        assertEquals("_ _ _ _ ", instance.motMasque(), "Le mot doit être totalement masqué au début."); 
    }

    @Test
    public void testAppartientLettreCorrecte() {
        boolean result = instance.appartient('T');
        assertTrue(result, "La lettre T devrait appartenir au mot TEST."); 
        assertEquals("T_ _ T", instance.motMasque(), "Toutes les occurrences de T doivent être révélées."); 
    }

    @Test
    public void testAppartientLettreFausse() {
        boolean result = instance.appartient('Z');
        assertFalse(result, "La lettre Z ne devrait pas appartenir au mot TEST."); 
        assertEquals(1, instance.getNbErreur(), "Une erreur aurait dû être comptabilisée."); 
    }

    @Test
    public void testLettreRepetee() {
        instance.appartient('A'); 
        int erreursApresUn = instance.getNbErreur();
        
        instance.appartient('A'); 
        assertEquals(erreursApresUn, instance.getNbErreur(), 
            "Une lettre déjà proposée ne doit pas compter comme une erreur supplémentaire."); 
    }

    @Test
    public void testInsensibiliteCasse() {
        assertTrue(instance.appartient('t'), "Le jeu doit être insensible à la casse (t minuscule)."); 
    }

    @Test
    public void testVictoire() {
        instance.appartient('T');
        instance.appartient('E');
        instance.appartient('S');
        
        assertTrue(instance.partieGagne(), "La partie devrait être gagnée quand toutes les lettres sont trouvées."); 
        assertFalse(instance.partiePerdu());
    }

    @Test
    public void testDefaite() {
        char[] erreurs = {'A', 'B', 'C', 'D', 'F', 'G', 'H'};
        for (char l : erreurs) {
            instance.appartient(l);
        }
        
        assertTrue(instance.partiePerdu(), "La partie devrait être perdue après 7 erreurs."); 
        assertFalse(instance.partieGagne());
    }
}
