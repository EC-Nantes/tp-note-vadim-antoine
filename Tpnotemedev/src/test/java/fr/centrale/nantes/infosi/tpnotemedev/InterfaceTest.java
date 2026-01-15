/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fr.centrale.nantes.infosi.tpnotemedev;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author agach
 */
public class InterfaceTest {
    private Interface inter;
    public InterfaceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        inter= new Interface();
    }
    
    @AfterEach
    public void tearDown() {
    }


    /**
     * Test of recupererLettre method, of class Interface. Test que le résultat vaut bien le mot demandé 
     */
    @Test
    public void testRecupererLettre() {
        String input = "\nB\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Interface test = new Interface();
        
        char lettre = test.recupererLettre();
        assertEquals('B', lettre, "L'interface doit ignorer les lignes vides et renvoyer le premier caractère.");
    }

    /**
     * Test of demanderMot method, of class Interface. Test que le resultat vaut bien la lettre donné
     */
    @Test
    public void testDemanderMot() {
        String input = "JAVA\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Interface test = new Interface();
        
        String resultat = test.demanderMot();
        assertEquals("JAVA", resultat, "Le mot récupéré doit être celui saisi par l'utilisateur.");
    }

    /**
     * Test of dessin method, of class Interface. Test que la fonction ne plante pas peut importe les valeurs données
     */
    @Test
    public void testDessin() {
        assertDoesNotThrow(() -> {
            inter.dessin(0, 7);
            inter.dessin(7, 7);
            inter.dessin(3, 10);
        });
    }
    
}
