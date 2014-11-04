package battleShip;
public class Boat {

    private int x, y, height;
    public static char direction;
    Board myBoard = new Board();
    public Boat(){

    }

    public void initAndPlaceBoat(int x, int y, char direction, int height){
        if (this.isIn(x,y,direction,height) && this.isEmpty(x,y,direction,height) && direction == 'h'){
            for (int i=0; i < height; i++){
                myBoard.map[x][y] = 1;
                y++;
            }
            
            System.out.flush();
            myBoard.showBoard();
        }
        
        if (this.isIn(x,y,direction,height) && this.isEmpty(x,y,direction,height) && direction == 'v'){
            for (int i=0; i < height; i++){
                myBoard.map[x][y] = 1;
                x++;
            }
            System.out.flush();
            myBoard.showBoard();      
        }
    }
    public boolean isEmpty(int x, int y, char direction, int height){
        boolean checked = true;
        
        if(direction == 'h'){
            for (int i=0; i <= (height-1); i++){
                if (myBoard.map[x][y] == 0){
                    y++;
                }
                else{
                    checked = false;
                }
            }
        }

        if(direction == 'v'){
            for (int i=0; i <= (height-1); i++){
                if (myBoard.map[x][y] == 0){
                    x++;
                }
                else{
                    checked = false;
                }
            }
        }
        return checked;
    }

    public boolean isIn(int x, int y, char direction, int height){
        boolean canbeplaced = false;
        
        // a fixer : le double affichage de l'erreur en cas de saisie trop haute
        // peut etre que ça passe 2 fois vu qu'il y a abscisse et ordonnées.
        // Il faut limiter juste à H ou V

        if (direction == 'h'){
            if((x+height) <= 9){
                canbeplaced = true;
                System.out.println("Ok horizontale");
            }
            else{
                System.out.println("erreur horizontale");
            }
        }
        else{
            if ((y+height) <= 9){
                canbeplaced = true;
                System.out.println("Ok vertical");
            }
            else{
                System.out.println("erreur verticale");
            }   
        }
        return canbeplaced;
    }   
}     