package battleShip.test;

import battleShip.Player;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestBattleShip {
    
    @Test
    public void testIsEmpty() {
        Player testPlayer = new Player();
        int abs = 1;
        int ord = 1;
        char dir = 'h';
        int height = 5;
        assertEquals(true, testPlayer.isEmpty(abs,ord,dir,height));
    }
}