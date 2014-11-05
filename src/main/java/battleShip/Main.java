package battleShip;
import java.util.Scanner;

/**
 * Created by mariealine on 03/11/14.
 */
public class Main {
    
    
    
    public static void main(String[] args)
    {
        Player joueur1 = new Player();
        
        // Création de la Board
        Board map = new Board();
        map.showBoard();
        
        // Création d'un Bateau
        Boat myBoat = new Boat();
        Scanner sc = new Scanner(System.in);
        System.out.println("Tu as 5 bateaux dans ton port.");
       
         // à remplacer par le nom du bateau dans la boucle
        System.out.println("Choisis l'orientation de ton premier bateau ");
        
        
        char direction = ' ';

        // Saisie de l'orientation du bateau
        while(direction != 'h' && direction != 'v'){
            System.out.println("ortientation : (h/v) ");
            direction = sc.next().charAt(0);     
        }
        System.out.println("direction :" + direction);
        
        // Saisie de l'abscisse
        System.out.println("Choisis les coordonnées d'origine du bateau :");
        System.out.println("Abscisse:");
        int abscissa = sc.nextInt() -1;
        System.out.println("Abscisse saisie: " + abscissa);
        
        System.out.println("Ordonnées:");
        int ordinate = sc.nextInt()-1;
        System.out.println("Abscisse saisie: " + ordinate);
        
        joueur1.placeBoat(abscissa, ordinate, direction, 5);
        
    }

}
