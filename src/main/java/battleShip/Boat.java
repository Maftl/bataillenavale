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
        
        if(direction == 'h' && height >= 0 && height <= 5){
            for (int i=0; i <= (height-1); i++){
                if (myBoard.map[x][y] == 0){
                    y++;
                }
                else{
                    checked = false;
                }
            }
        }

        if(direction == 'v' && height >= 0 && height <= 5){
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

        if (direction == 'h' && (x+height) <= 9){
            canbeplaced = true;
        }
        else{
            System.out.println("erreur horizontale");
        }

        if (direction == 'v' && (y+height) <= 9){
            canbeplaced = true;
        }
        else{
            System.out.println("erreur verticale");
        }

        return canbeplaced;
    }
}