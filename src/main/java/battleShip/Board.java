package battleShip;

public class Board {
    
 //-----------------------------------------------------------------------------   
 //                             PROPRIETEES  
 //-----------------------------------------------------------------------------
    private int grid[][];
    
    // Constante
    private static final int LENGHT = 10;        
    private static final int HEIGHT = 10;

//------------------------------------------------------------------------------   
//                              METHODES  
//------------------------------------------------------------------------------    
    
    // Constructeur
    public Board() {
        this.grid = new int[HEIGHT][LENGHT];
        initBoard();
    }
    
    // Initialisation de la map
    private void initBoard(){
        for(int ln = 0; ln < HEIGHT; ln++){
           for(int col = 0; col < LENGHT; col++){
                getGrid()[ln][col] = 0;
            } 
        }
    }
    
    // Affichage de la grille
    public void showBoard(){
       
        // Affichage des en-tête de colonnes
        String[] col_name = headerColumn();
        String col_line = "   ";
        for(int col=0; col < LENGHT; col++){
            col_line += col_name[col] + " ";
        }
        System.out.println(col_line);
        
        // Affichage d'une ligne de séparation
        System.out.println(line(LENGHT));
        
        // Affichage des ligne de la grille
        String[] line_name = headerLine();
        for (int ln = 0; ln < HEIGHT; ln++){
        String ln_line = "";
       
            ln_line += line_name[ln] + " |";
            for (int column = 0; column < LENGHT; column++){
                ln_line += showSquare(getGrid()[ln][column]);
            }
        System.out.println(ln_line);
        System.out.println(line(LENGHT));
        }
   }
    
    // Affichage de la case
    private String showSquare(int boardSquare) {
        
        String str_square = "";
        
        // Selon la valeur de la case
        switch(boardSquare){
            // case vide
            case 0: str_square = "   |";
                    break;
            // case bateau
            case 1: str_square = " O |";
                    break;
            // case attaquée
            case 2: str_square = " X |";
                    break;
            // case attaque ratée
            case 3: str_square = " @ |";
                    break;
            // case bateau caché
            case 4: str_square = "   |";
                    break;
        }
        return str_square;
    }

    // Ligne de séparation
    private String line(int nbColumn){
        String strLine = "  |";
        
        for(int i = 0; i < nbColumn; i++){
            strLine += "---|";
        }
        
        return strLine; 
    }

    // Titre des colonnes
    private String[] headerColumn(){
        String[] hd_col = new String[LENGHT];
        for(int i = 0; i < LENGHT; i++) {
            hd_col[i] = (" "+(i+1)+" ");
        }
        
        return hd_col;
    } 
    
    // Titre des lignes
    private String[] headerLine() {
        String[] result = new String[HEIGHT];
        for(int i = 0; i < HEIGHT; i++) {
            result[i] = Character.toString((char)('A'+ i));
        }
        return result;
    }

    // Assesseur de grid
    public int[][] getGrid() {
        return grid;
    }

    // Mutateur de grid
    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}

