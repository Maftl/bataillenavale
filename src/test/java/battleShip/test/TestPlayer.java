package battleShip.test;

import battleShip.Player;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPlayer {
    
    @Test
    public void testIsEmpty() {
        Player testPlayer = new Player();
        int abs = 1;
        int ord = 1;
        char dir = 'h';
        int height = 5;
        assertEquals(true, testPlayer.isEmpty(abs,ord,dir,height));
    }
    
    @Test
    public void canPlaceBoat(){
        Player testPlayer = new Player();
        int abs = 1;
        int ord = 1;
        char dir = 'h';
        int height = 5;
        assertEquals(true, testPlayer.placeBoat(abs,ord,dir,height));
    }
    @Test
    public void cantPlaceBoatWithInvalidCoordinates(){
        Player testPlayer = new Player();
        int abs = 1;
        int ord = 15;
        char dir = 'h';
        int height = 5;
        assertEquals(false, testPlayer.placeBoat(abs,ord,dir,height));
    }
}