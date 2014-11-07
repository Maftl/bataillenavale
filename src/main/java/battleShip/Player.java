package battleShip;

import java.util.Scanner;

public class Player {

    private int nbBoat = 5;
    private Boat fleet[] = new Boat[nbBoat];

    Board myBoard = new Board();
    Board attackBoard = new Board();

    // Constructeur
    public  void Player(){
    }

    // Initialisation du joueur
    public void initPlayer(){

        // Remplissage de la collection de Bateau avec type et taille
        fleet[0] = new Boat("Porte Avions", 5);
        fleet[1] = new Boat("Croiseur", 4);
        fleet[2] = new Boat("Sous-marin", 3);
        fleet[3] = new Boat("Contre Torpilleur", 3);
        fleet[4] = new Boat("Torpilleur", 2);

        myBoard.showBoard();

        Scanner sc = new Scanner(System.in);
        char direction;

        int i = 0;
        while(i < nbBoat){

            // Saisie de l'orientation
            // devrait accepter les H et V majuscules
            do{
            System.out.print("Choisir l'orientation du " + fleet[i].getTypeBoat() + " (" + fleet[i].getHeight() + " cases)\n (\"h\" pour horizontal ou \"v\" pour vertical ): \n>> ");
            direction = sc.next().charAt(0);
            direction = orientationInput(direction, sc);
            System.out.println("direction :" + direction);

            // Saisie de la ligne
            System.out.println("Choisir les coordonnées d'origine du " + fleet[i].getTypeBoat() + " :");
            System.out.println("Ligne (une lettre majuscule attendue) :");
            char ordinate = sc.next().charAt(0);
            int num_ascii = (int) ordinate;
            num_ascii = lineInput(num_ascii, sc);

            // Saisie de la colonne
            System.out.println("Colonne (un chiffre attendu): \n>>");
            int abscissa = columnInput(sc);


            fleet[i].setDirection(direction);
            fleet[i].setHz(abscissa);
            fleet[i].setVt(num_ascii-64);


            }while((!verificationTotale(fleet[i].getHz(), fleet[i].getVt(), fleet[i].getDirection(),fleet[i].getHeight())) );


            placeBoat(fleet[i].getHz(),fleet[i].getVt(),fleet[i].getDirection(),fleet[i].getHeight());
            i++;

            if(i>=nbBoat){
                System.out.println("\n\nVotre flotte.");
            }

            System.out.flush();
            myBoard.showBoard();
        }

        System.out.println("\nGrille d'Attaque.");
        // Bateau en dur en horizontal A1 - longueur 3 cases
        initFalseBoard();
        attackBoard.showBoard();
        System.out.println("Prêt à jouer !");
}

  public void initFalseBoard(){
    // Porte Avions horizontal en B1
    attackBoard.getGrid()[1][0] = 4;
    attackBoard.getGrid()[1][1] = 4;
    attackBoard.getGrid()[1][2] = 4;
    attackBoard.getGrid()[1][3] = 4;
    attackBoard.getGrid()[1][4] = 4;

    // Croiseur en horizontal D4
    attackBoard.getGrid()[3][3] = 4;
    attackBoard.getGrid()[3][4] = 4;
    attackBoard.getGrid()[3][5] = 4;
    attackBoard.getGrid()[3][6] = 4;

    // Sous-marin en horizontal A1
    attackBoard.getGrid()[0][0] = 4;
    attackBoard.getGrid()[0][1] = 4;
    attackBoard.getGrid()[0][2] = 4;

    // Contre Torpilleur horizontal en B6
    attackBoard.getGrid()[1][5] = 4;
    attackBoard.getGrid()[1][6] = 4;
    attackBoard.getGrid()[1][7] = 4;

    // Torpilleur en horizontal J9
    attackBoard.getGrid()[9][8] = 4;
    attackBoard.getGrid()[9][9] = 4;

  }

    private int lineInput(int num_ascii, Scanner sc) {
        char ordinate;
        while ((num_ascii-64) < 1 || (num_ascii-64) > 10){
            System.out.print("Ligne incorrecte. Recommencer : \n>> ");
            ordinate = sc.next().charAt(0);
            num_ascii = (int) ordinate;
        }
        return num_ascii;
    }

    private char orientationInput(char direction, Scanner sc) {
        while (direction != 'h' && direction != 'v' ){
            System.out.print("Orientation incorrecte. Recommencer : \n>> ");
            direction = sc.next().charAt(0);
        }
        return direction;
    }
    // saisie de la colonne
    private int columnInput(Scanner sc) {
      // Saisie de la colonne / abscisse
       int abscissa = sc.nextInt();
        // doit tester les lettres et les exclure
        while (abscissa < 1 || abscissa > 10 ){
            System.out.print("Colonne incorrecte. Recommencer : \n>> ");
            abscissa = sc.nextInt();
            // à rajouter : le refactor de la méthode boatIsInGrid dans cette méthode
            // pour optimiser le test de la saisie d'abscisse
        }
        System.out.println("Colonne saisie: " + abscissa);
        return abscissa;
    }

    // Retourne le Player
    public Player getPlayer(){
        return this;
    }

    public boolean placeBoat(int abs, int ord, char dir, int height ){
        
        boolean placed = false;
        switch(dir) {
            case 'h':
            case 'H':
                if (verificationTotale(abs, ord, dir, height)) {
                    for (int i = 0; i < height; i++) {
                        myBoard.getGrid()[(ord - 1) ][abs - 1 + i] = 1;
                    }
                    placed = true;
            }
            break;
            case 'v':
            case 'V':
                if (verificationTotale(abs, ord, dir, height)) {
                    for (int i=0; i < height; i++){
                        myBoard.getGrid()[(ord - 1)+i][abs-1] = 1;
                    }
                    placed = true;
                }
            break;
            default:
                System.out.println("Erreur placeBoat");
                placed = true;
        }
        return placed;
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
                        System.out.println("Impossible, un bateau est déja sur cet emplacement");
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
                        System.out.println("Impossible, un bateau est déja sur cet emplacement");
                        checked = false;
                    }
                i++;
            }
        }
        return checked;
    }

    public boolean boatIsInGrid(int abs, int ord, char dir, int height){
        boolean canBePlaced = false;
        switch(dir){
            case 'h':
            case 'H':
                int absTest = abs + height;
                if(absTest <= 11){
                    canBePlaced = true;
                }
                else{
                    System.out.println("Débordement de la grille à l'horizontale");
                    // doit retourner à la saisie de l'utilisateur
                }
            break;
            case 'v':
            case 'V':
                int ordtest = ord+height;
                if ((ordtest) <= 11){
                    canBePlaced = true;
                }
                else{
                    System.out.println("Débordement de la grille à la verticale");
                    // doit retourner à la saisie de l'utilisateur
                }
            break;
            default:
                System.out.println("Erreur boatIsInGrid");
        }
        return canBePlaced;
    }

    private boolean verificationTotale(int abs1, int ord1, char direction, int height){
        boolean verification = false;
        if (this.boatIsInGrid(abs1, ord1, direction, height) && this.isEmpty(abs1, ord1, direction, height)) {
            verification = true;
        }
        return verification;
    }

    public void attackOrder(){

        initFalseBoard();
        attackBoard.showBoard();

        Scanner sc = new Scanner(System.in);

        // Saisie de la ligne / ordonnée
        System.out.println("Saisie de la ligne d'attaque \n (une lettre majuscule attendue entre A et J) :\n>>");
        char ordinate = sc.next().charAt(0);
        int num_ascii = (int) ordinate;
        while ((num_ascii-64) < 1 || (num_ascii-64) > 10){
            System.out.println("Ligne incorrecte. Recommencer : \n>> ");
            ordinate = sc.next().charAt(0);
            num_ascii = (int) ordinate;
        }
        System.out.println("Ligne saisie :" + ordinate);

        // Saisie de la colonne / abscisse
        System.out.println("Saisie de la colonne d'attaque \n (chiffre attendu entre 1 et 10) :\n>> ");
        int abscissa = columnInput(sc);

        attack(abscissa, (num_ascii-64));
    }

    public void attack(int abs, int ord){
        // le [ord-1][abs-1] de la saisie utilisateur correspond à l'origne de la matrice
        switch(attackBoard.getGrid()[ord-1][abs-1]){
            // attaque sur case vide, dans le vent
            case 0: attackBoard.getGrid()[ord-1][abs-1] = 3;
                    System.out.println("Loupé c'est dans l'eau, dommage !");
                    // pour update la grille du second joueur :
                    // secondPlayer.myBoard.setGrid()[abs][ord] = 3;
                    break;
            // attaque sur bateau déjà touché
            case 2: attackBoard.getGrid()[ord-1][abs-1] = 2;
                    System.out.println("Bateau déjà touché, dommage !");
                    break;
            // attaque sur une ancienne attaque
            case 3: attackBoard.getGrid()[ord-1][abs-1] = 3;
                    System.out.println("Encore une attaque dans le vide, dommage !");
                    break;
            // attaque sur un bateau
            case 4: attackBoard.getGrid()[ord-1][abs-1] = 2;
                    System.out.println("Bateau touché !");
                    break;
        }
        attackBoard.showBoard();
    }

    //  a faire
//    public boolean SquareIsInGrid(char abs, int ord){
//        boolean canBePlaced = false;
//
//
//    }
}
