/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleShip;

public class Board {
    public int[][] map = new int[SIZE][SIZE];
    public String[] alpha = headerLine();
    
    private static final int SIZE = 10;

    
    public int[][] Board(){
        initBoard();
        return map;
    }
    
    // Initialisation de la map
    public void initBoard(){
        for(int i=0; i<SIZE; i++){
           for(int j=0; j<SIZE; j++){
               map[i][j] = 0;
            } 
        }
    }
    
    // Affichage de la map
    public void showBoard(){
       
       System.out.print("\n   1 2 3 4 5 6 7 8 9 10 ");
            line();
                  
            for (int ligne = 0; ligne < SIZE; ligne++){
                
                System.out.print("\n" + alpha[ligne] + " " + "|");
                for (int column = 0; column < SIZE; column++){
                    showSquare(map[ligne][column]);
                }
                
                if (ligne < 9)
                    line();
                else
                    bottomLine();
            }
   }
    
    private static void showSquare(final int aCase) {
        final String border = "|";
        final String empty = " "+ border;
        final String boat = "O" + border;
        final String reached = "X" + border;
        final String failed = "@" + border;

        String gCase = "";
        if (aCase == 0)
            gCase = empty;
        if (aCase == 1)
            gCase = boat;
        if (aCase == 2)
            gCase = reached;
         if (aCase == 3)
            gCase = failed;
        System.out.print(gCase);
        }   
    
    static void line(){        
        System.out.print("\n  |-");
        for (int elem = 2; elem <= SIZE; elem++)
            System.out.print("|-");
        System.out.print("|");
        }

    static void bottomLine(){
        System.out.print("\n  |-");
        for (int elem = 2; elem <= SIZE; elem++)
            System.out.print("|-");
        System.out.print("| \n\n");
    }

    static String[] headerLine() {
        String[] result = new String[SIZE];
        for(int i=0; i < SIZE;i++) {
            result[i] = Character.toString((char)('A'+ i));
        }
        return result;
    }
}      
      