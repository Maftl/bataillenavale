
package battleShip;
 
public class Player {
      
    Boat[] fleet = new Boat[5];
    
    // Constructeur
    public static void Player(){
        
    }
    
    // Retourne le Player
    public Player getPlayer(){
        return this;  
    }
    
    // Attaque du joueur
    public void attack(){
        
    }
    
    public void placeBoat(int abs, int ord, char dir, int height ){
        myBoat.initAndPlaceBoat(abs, ord, dir, height);
    }
}
