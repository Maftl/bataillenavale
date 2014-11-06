
package battleShip;

import java.util.Scanner;

public class Player {
    
     private int nbBoat = 5;
     private Boat fleet[] = new Boat[nbBoat];
     
     Board myBoard = new Board();

    // Constructeur
    public  void Player(){
    }
    
    // Initialisation du joueur
    public void initPlayer(){

        // Remplissage de la collection de Bateau avec type et taille
        fleet[0] = new Boat("Aircraft carrier", 5);
        fleet[1] = new Boat("Cruiser", 4);
        fleet[2] = new Boat("Submarin", 3);
        fleet[3] = new Boat("Destroyer", 3);
        fleet[4] = new Boat("Torpedo", 2);
        
        myBoard.showBoard();
        
        Scanner sc = new Scanner(System.in);
        char direction;
        
        int i = 0;
        while(i < nbBoat){
                       
            // Saisie de l'orientation
            System.out.print("Choisis l'orientation de ton " + fleet[i].getTypeBoat() + "orientation (h/v) : \n>> ");
            direction = sc.next().charAt(0);
            while (direction != 'h' && direction != 'v' ){
                System.out.print("Saisie incorrecte, veuillez recommencer : \n>> ");
                direction = sc.next().charAt(0);
            }
            System.out.println("direction :" + direction);

            
            System.out.println("Choisis les coordonnées d'origine du bateau :");
            int abscissa = abscissaInput(sc, "Ligne :");
            
            // Saisie de l'ordonnée
            System.out.println("Ordonnées:");
            char ordinate = sc.next().charAt(0);
            int num_ascii = (int) ordinate;

            while ((num_ascii) < 1 + 'a' || (num_ascii) > 10 + 'a' ){
                System.out.print("Saisie incorrecte, veuillez recommencer : \n>> ");
                ordinate = sc.next().charAt(0);
                num_ascii = (int) ordinate;
            }
            System.out.println("Abscisse saisie: " + ordinate);
                
            
            fleet[i].setDirection(direction);
            fleet[i].setHz(abscissa);
            fleet[i].setVt(num_ascii-64);
            
            placeBoat(fleet[i].getHz(),fleet[i].getVt(),fleet[i].getDirection(),fleet[i].getHeight());
            i++;
        }
        
        myBoard.showBoard();
        System.out.println("Prêt à jouer !!!");
}
    // saisie de la colonne
    private int abscissaInput(Scanner sc, String msg) {
        // Saisie de l'abscisse
        System.out.println(msg);
        int abscissa = sc.nextInt();
        while (abscissa < 1 || abscissa > 10 ){
            System.out.print(msg + " incorrecte, veuillez recommencer : \n>> ");
            abscissa = sc.nextInt();
            // à rajouter : le refactor de la méthode isIn dans cette méthode
            // pour optimiser le test de la saisie d'abscisse
        }
        System.out.println("Ligne saisie: " + abscissa);
        return abscissa;
    }
    
    // Retourne le Player
    public Player getPlayer(){
        return this;  
    }
    
    // Attaque du joueur
    public void attack(){
        
    }
    
    public void placeBoat(int abs, int ord, char dir, int height ){
        
        
        switch(dir) {
            case 'h':
            case 'H':
                if (verificationTotale(abs, ord, dir, height)) {
                    for (int i = 0; i < height; i++) {
                        myBoard.getGrid()[(ord - 1) ][abs - 1 + i] = 1;
                    }
                    System.out.flush();
                    myBoard.showBoard();
            }
            break;
            case 'v':
            case 'V':
                if (verificationTotale(abs, ord, dir, height)) {
                    for (int i=0; i < height; i++){
                        myBoard.getGrid()[(ord - 1)+i][abs-1] = 1;
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
    public boolean isEmpty(int abs, int ord, char dir, int height){
        boolean checked = true;
        int i = 0;

        //Si horizontal
        switch(dir) {
            case 'h':
            case 'H':
                while(checked==true && i < height){
                    if (myBoard.getGrid()[ord-1][abs-1] == 0){
                        abs++;
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
                    if (myBoard.getGrid()[ord-1][abs-1] == 0){
                        ord++;
                    }
                    else{
                        checked = false;
                    }
                i++;
            }
        }
        return checked;
    }

    public boolean isIn(int abs, int ord, char dir, int height){
        boolean canBePlaced = false;
        switch(dir){
            case 'h':
            case 'H':
                int absTest = abs + height;
                if(absTest <= 10){
                    canBePlaced = true; 
                }
                else{
                    System.out.println("débordement de la grille à la horizontale");
                }
            break;
            case 'v':
            case 'V':
                if ((ord+height) <= 10){
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
    
    public int attackOrder(){
        
        System.out.println("Coordonnées d'attaque : \n>> ");
        Scanner sc = new Scanner(System.in);
        int abscissa = abscissaInput(sc, "Ligne :");
        
        return abscissa;   
    }

    
}
