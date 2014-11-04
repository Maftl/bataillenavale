package battleShip;
import java.util.Scanner;

/**
 * Created by mariealine on 03/11/14.
 */
public class Main {
    public static void main(String[] args)
    {
        Board map = new Board();
        map.showBoard();
        
        Boat myBoat = new Boat();
        Scanner sc = new Scanner(System.in);
        System.out.println("Tu as 5 bateaux dans ton port.");
        
        System.out.println("Choisis l'orientation de ton premier bateau "); // à remplacer par le nom du bateau dans la boucle
        System.out.println("ortientation : (h/v) ");
        char direction = sc.next().charAt(0);
        System.out.println("direction :" + direction);
        System.out.println("Choisis les coordonnées d'origine du bateau :");
        System.out.println("Abscisse:");
        int abscissa = sc.nextInt() -1;
        System.out.println("Abscisse saisie: " + abscissa);
        System.out.println("Ordonnées:");
        int ordinate = sc.nextInt()-1;
        System.out.println("Abscisse saisie: " + ordinate);
        
        myBoat.initAndPlaceBoat(abscissa, ordinate, direction, 5);
        

    }

}
