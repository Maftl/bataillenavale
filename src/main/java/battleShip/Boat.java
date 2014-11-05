package battleShip;
public class Boat {


    private int hz, vt, height;
    public static char direction;
    Board myBoard = new Board();
    public Boat(){

    }
    public void initAndPlaceBoat(int hz, int vt, char direction, int height){
        if (this.isIn(hz,vt,direction,height) && this.isEmpty(hz,vt,direction,height) && direction == 'h'){
            for (int i=0; i < height; i++){
                myBoard.map[hz][vt] = 1;
                vt++;
            }

            System.out.flush();
            myBoard.showBoard();
        }

        if (this.isIn(hz,vt,direction,height) && this.isEmpty(hz,vt,direction,height) && direction == 'v'){
            for (int i=0; i < height; i++){
                myBoard.map[hz][vt] = 1;
                hz++;
            }
            System.out.flush();
            myBoard.showBoard();
        }
    }

    // Vérifie si la case saisie est vide est que les cases suivantes, suivant la taille du bateau, sont vides
    public boolean isEmpty(int hz, int vt, char direction, int height){
        boolean checked = true;
        int i = 0;

        //Si horizontal
        if(direction == 'h'){

            while(checked==true && i < height){
                    if (myBoard.map[hz][vt] == 0){
                        vt++;
                    }
                    else{
                        checked = false;
                    }
                i++;
            }
        }

        //Si vertical
        if(direction == 'v'){
            while(checked==true && i < height){
                    if (myBoard.map[hz][vt] == 0){
                        vt++;
                    }
                    else{
                        checked = false;
                    }
                i++;
            }
        }
        return checked;
    }

    public boolean isIn(int hz, int vt, char direction, int height){
        boolean canBePlaced = false;

        // a fihzer : le double affichage de l'erreur en cas de saisie trop haute
        // peut etre que ça passe 2 fois vu qu'il vt a abscisse et ordonnées.
        // Il faut limiter juste à H ou V

        if (direction == 'h'){
            if((hz+height) <= 9){
                canBePlaced = true;
                System.out.println("Ok horizontale");
            }
            else{
                System.out.println("erreur horizontale");
            }
        }
        else{
            if ((vt+height) <= 9){
                canBePlaced = true;
                System.out.println("Ok vertical");
            }
            else{
                System.out.println("erreur verticale");
            }
        }
        return canBePlaced;
    }
}
