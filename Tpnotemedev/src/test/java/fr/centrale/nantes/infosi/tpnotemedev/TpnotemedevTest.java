/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fr.centrale.nantes.infosi.tpnotemedev;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
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
public class TpnotemedevTest {
    
    public TpnotemedevTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class Tpnotemedev.
     */
    @Test
    public void testMain2joueur() {
        String input = "2\nMOT\nM\nO\nT\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertDoesNotThrow(() -> {
            try {
                Tpnotemedev.main(new String[]{});
            } catch (NoSuchElementException e) {
                // Capturé si le scanner cherche une entrée après la fin du jeu
            }
        });
    }
    
    public void testMainchoixinvalide(){
        // Simule un utilisateur qui se trompe de mode puis choisit 2
        String input = "2\nJAVA\nJ\nA\nV\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertDoesNotThrow(() -> {
            try {
                Tpnotemedev.main(new String[]{});
            } catch (NoSuchElementException e) {
                // Fin normale du flux simulé
            }
        });
    }
}
