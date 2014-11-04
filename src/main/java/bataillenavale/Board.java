/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataillenavale;

public class Board {
    public int[][] map = new int[10][10];
    
    public void Board(){
        initBoard();
    }
    
    // Initialisation de la map
    public void initBoard(){
        for(int i=1; i<=10; i++){
           for(int j=1; j<=10; j++){
               map[i][j] = 0;
            } 
        }
    }
    
    // Affichage de la map
   public void showBoard(){
        for(int i=0; i<10; i++){
           String line = "";
           for(int j=0; j<10; j++){
               line += map[i][j];
            }
           System.out.println(line+"\n");
        }
    }
}
