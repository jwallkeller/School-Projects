/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keller_project1;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jack
 */
public class MediaTest {
    
    public MediaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of editLibrary method, of class Media.
     */
    @Test
    public void testEditLibrary() {
        System.out.println("editLibrary");
        ArrayList<Media> library = new ArrayList<>();
        int choice = 1;
        Media m1 = new Media("Diablo 3", "Xbox");
        ArrayList<Media> result = m1.editLibrary(library, choice);
        assertEquals(library.size(), 1);

        choice = 1;
        Media m2 = new Media("Man of Steel", "Blu-Ray");
        result = m2.editLibrary(library, choice);
        assertEquals(library.size(), 2);
        
        choice = 1;
        Media m3 = new Media("Diablo 3", "Xbox");
        result = m3.editLibrary(library, choice);
        assertEquals(library.size(), 2);
        
        choice = 5;
        Media m4 = new Media("Diablo 3", "");
        result = m4.editLibrary(library, choice);
        assertEquals(library.size(), 1);
        
        choice = 5;
        Media m5 = new Media("Diablo 3", "");
        result = m5.editLibrary(library, choice);
        assertEquals(library.size(), 1);
    }
    
}
