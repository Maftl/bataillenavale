package battleShip.test;

import battleShip.Boat;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestBoat {
    
    @Test
    public void testGetHz(){
        Boat test_boat = new Boat("Test", 5);
        test_boat.setHz(1);
        
        assertEquals(1,test_boat.getHz());
    }
    
    
    @Test
    public void testGetVt(){
        Boat test_boat = new Boat("Test", 5);
        test_boat.setVt(1);
        
        assertEquals(1,test_boat.getVt());
    }
}
