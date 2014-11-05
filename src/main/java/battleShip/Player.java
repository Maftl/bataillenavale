package battleShip;
 
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    
     int nbBoat = 5;
     Boat fleet[] = new Boat[nbBoat];
     
     Board myBoard = new Board();
    
    
    // Constructeur
    public  void Player(){
    }
    
    // Initialisation du joueur
    public void initPlayer(){

        // Remplissage de la colection de Bateau avec type et taille
        fleet[0] = new Boat("Aircraft carrier", 5);
        fleet[1] = new Boat("Cruiser", 4);
        fleet[2] = new Boat("Submarin", 3);
        fleet[3] = new Boat("Destroyer", 3);
        fleet[4] = new Boat("Torpedo", 2);
        
        Scanner sc = new Scanner(System.in);
        char direction;
        
        int i = 0;
        while(i < nbBoat){
                       
            // Saisie de l'orientation
            System.out.println("Choisis l'orientation de ton "+fleet[i].getTypeBoat());
            System.out.println("orientation : (h/v) ");
            direction = sc.next().charAt(0);
            while (direction != 'h' && direction != 'v' ){
                System.out.println("Saisie incorrecte, recommence !");
                direction = sc.next().charAt(0);
            }
            System.out.println("direction :" + direction);

            // Saisie de l'abscisse
            System.out.println("Choisis les coordonnées d'origine du bateau :");
            System.out.println("Abscisse:");
            int abscissa = sc.nextInt() -1;
            while (abscissa < 1 || abscissa > 10 ){
                System.out.println("Saisie incorrecte, recommence !");
                abscissa = sc.nextInt() -1;
            }
            System.out.println("Abscisse saisie: " + abscissa);
            
            // Saisie de l'ordonnée
            System.out.println("Ordonnées:");
            int ordinate = sc.nextInt()-1;
            while (ordinate < 1 || ordinate > 10 ){
                System.out.println("Saisie incorrecte, recommence !");
                ordinate = sc.nextInt() -1;
            }
            System.out.println("Ordonnée saisie: " + ordinate);
            
            fleet[i].setDirection(direction);
            fleet[i].setHz(abscissa);
            fleet[i].setVt(ordinate);
            
            placeBoat(fleet[i].getHz(),fleet[i].getVt(),fleet[i].getDirection(),fleet[i].getHeight());
            i++;
        }
    }
    
    // Retourne le Player
    public Player getPlayer(){
        return this;  
    }
    
    // Attaque du joueur
    public void attack(){
        
    }
    
    public void placeBoat(int abs, int ord, char dir, int height ){
        
        
        //if (this.isIn(abs,ord,dir,height) && this.isEmpty(abs,ord,dir,height) && dir == 'h'){
        if (this.isIn(abs,ord,dir,height) && dir == 'h'){    
            for (int i=0; i < height; i++){
                myBoard.map[abs][ord] = 1;
                ord++;
            }

            System.out.flush();
            myBoard.showBoard();
        }

        //if (this.isIn(abs,ord,dir,height) && this.isEmpty(abs,ord,dir,height) && dir == 'v'){
        if (this.isIn(abs,ord,dir,height) && dir == 'v'){    
            for (int i=0; i < height; i++){
                myBoard.map[abs][ord] = 1;
                abs++;
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
