/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleShip;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Thomas
 */
public class BoatTest {
    
    @Test
    public void checkIsIn() {
        Boat boat  = new Boat();
        assertEquals("est bien dans la grille", true, boat.isIn(3, 1, 'h', 5));
    }
    
}
