package battleShip;
public class Boat {

    public static char direction;
    Board myBoard = new Board();
    public Boat(){
        
    }
    
    public void initAndPlaceBoat(int abs1, int ord1, char direction, int height){
        switch(direction) {
            case 'h':
            case 'H':
                if (verificationTotale(abs1, ord1, direction, height)) {
                    for (int i = 0; i < height; i++) {
                        myBoard.map[(ord1 - 1) ][abs1 - 1 + i] = 1;
                    }
                    System.out.flush();
                    myBoard.showBoard();
            }
            break;
            case 'v':
            case 'V':
                if (verificationTotale(abs1, ord1, direction, height)) {
                    for (int i=0; i < height; i++){
                        myBoard.map[(ord1 - 1)+i][abs1-1] = 1;
                    }
                    System.out.flush();
                    myBoard.showBoard();
            }
            break;
            default:
                System.out.println("erreur");
        } 
        
    }

    // Vérifie si la case saisie est vide est que les cases suivantes, suivant la taille du bateau, sont vides
    public boolean isEmpty(int abs2, int ord2, char direction, int height){
        boolean checked = true;
        int i = 0;
        switch(direction) {
            case 'h':
            case 'H':
                while(checked==true && i < height){
                    if (myBoard.map[ord2-1][abs2-1] == 0){
                        abs2++;
                    }
                    else{
                        checked = false;
                    }
                i++;
            }
            break;
            case 'v':
            case 'V':
                while(checked==true && i < height){
                    if (myBoard.map[ord2-1][abs2-1] == 0){
                        ord2++;
                    }
                    else{
                        checked = false;
                    }
                i++;
            }
        }
        return checked;
    }

    public boolean isIn(int abs3, int ord3, char direction, int height){
        boolean canBePlaced = false;
        switch(direction){
            case 'h':
            case 'H':
                int absTest = abs3 + height;
                if(absTest <= 10){
                    canBePlaced = true; 
                }
                else{
                    System.out.println("débordement de la grille à la horizontale");
                }
            break;
            case 'v':
            case 'V':
                if ((ord3+height) <= 10){
                    canBePlaced = true;
                }
                else{
                    System.out.println("débordement de la grille à la verticale");
                }
            break;
            default:
                System.out.println("erreur isIn");
        }
        return canBePlaced;
    }
     
    private boolean verificationTotale(int abs1, int ord1, char direction, int height){
        boolean verification = false;
        if (this.isIn(abs1, ord1, direction, height) && this.isEmpty(abs1, ord1, direction, height)) {
            verification = true;
        }
        return verification;
    }
}