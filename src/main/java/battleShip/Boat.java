package battleShip;

public class Boat {

    private int hz;
    private int vt;
    private int height;
    private char direction;
    private String typeBoat; 
    
    // Constructeur
    public Boat(String Type, int Height){
        hz = 0;
        vt = 0;
        height = Height;
        direction = ' ';
        typeBoat = Type;
    }  
    

    // Assesceurs  
    public int getHz() {
        return hz;
    }

    public void setHz(int hz) {
        this.hz = hz;
    }

    public int getVt() {
        return vt;
    }

    public void setVt(int vt) {
        this.vt = vt;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char getDirection() {
        return direction;
    }
    
    public void setDirection(char aDirection) {
        direction = aDirection;
    }

    public String getTypeBoat() {
        return typeBoat;
    }

    public void setTypeBoat(String typeBoat) {
        this.typeBoat = typeBoat;
    }
}
