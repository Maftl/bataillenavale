package battleShip;

public class Boat {

//-----------------------------------------------------------------------------   
//                             PROPRIETEES  
//-----------------------------------------------------------------------------    
    
    private int hz = 0;
    private int vt = 0;
    private int height;
    private char direction = ' ';
    private String typeBoat; 
 
//------------------------------------------------------------------------------   
//                              METHODES  
//------------------------------------------------------------------------------    
    
    // Constructeur
    public Boat(String Type, int Height){
        height = Height;
        typeBoat = Type;
    }  
    
//----------------------------[ Assesceurs ]------------------------------------  
    public int getHz() {
        return hz;
    } 

    public int getVt() {
        return vt;
    }

    public int getHeight() {
        return height;
    }

    public char getDirection() {
        return direction;
    }
    
    public String getTypeBoat() {
        return typeBoat;
    }
    
//------------------------------[ Mutateurs ]-----------------------------------
    
    public void setHz(int hz) {
        this.hz = hz;
    }
    
    public void setVt(int vt) {
        this.vt = vt;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public void setDirection(char aDirection) {
        direction = aDirection;
    }
    
    public void setTypeBoat(String typeBoat) {
        this.typeBoat = typeBoat;
    }
}

