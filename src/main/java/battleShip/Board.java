/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleShip;

public class Board {
    public int[][] map = new int[TAILLE][TAILLE];
    public String[] alpha = headersLine();
    
    private static final int TAILLE = 10;
    
    public Board() {
        
    }
    
    public void Board(){
        initBoard();
    }
    
    // Initialisation de la map
    public void initBoard(){
        for(int i=1; i<=TAILLE; i++){
           for(int j=1; j<=TAILLE; j++){
               map[i][j] = 0;
            } 
        }
    }
    
    
    // Affichage de la map
    public void showBoard(){
       
       System.out.print("\n  1 2 3 4 5 6 7 8 10");
            line();
                  
            for (int ligne = 0; ligne < TAILLE; ligne++){
                
                System.out.print("\n" + alpha[ligne] + " " + "|");
                for (int colonne = 0; colonne < TAILLE; colonne++){
                    showSquare(map[ligne][colonne]);
                }
                
                if (ligne < 9)
                    line();
                else
                    bottomLine();
            }
   }
    
    private static void showSquare(final int aCase) {
        final String bordure = "|";
        final String vide = " "+ bordure;
        final String bateau = "O" + bordure;
        final String touche = "X" + bordure;
        final String rate = "@" + bordure;

        String gCase = "";
        if (aCase == 0)
            gCase = vide;
        if (aCase == 1)
            gCase = bateau;
        if (aCase == 2)
            gCase = touche;
         if (aCase == 3)
            gCase = rate;
        System.out.print(gCase);
        }   
    
    static void line(){        
        System.out.print("\n  |-");
        for (int elem = 2; elem <= TAILLE; elem++)
            System.out.print("|-");
        System.out.print("|");
        }

    static void bottomLine(){
        System.out.print("\n  |-");
        for (int elem = 2; elem <= TAILLE; elem++)
            System.out.print("|-");
        System.out.print("| \n\n");
    }

    static String[] headersLine() {
        String[] result = new String[TAILLE];
        for(int i=0; i < TAILLE;i++) {
            result[i] = Character.toString((char)('A'+ i));
        }
        return result;
    }
}      
      