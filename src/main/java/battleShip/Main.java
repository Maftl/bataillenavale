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
        boolean inputIsOk = false;
        Boat myBoat = new Boat();
        Scanner sc = new Scanner(System.in);
        
       
        // à remplacer par le nom du bateau dans la boucle
        System.out.println("Tu as 5 bateaux dans ton port. \nChoisis l'orientation de ton premier bateau ");
        System.out.println("orientation : (h/v) ");
        char direction = sc.next().charAt(0);
        while (direction != 'h' && direction != 'v' ){
            System.out.println("Saisie incorrecte, veuillez recommencer");
            direction = sc.next().charAt(0);
        }
        System.out.println("direction :" + direction);
            
        
        
        System.out.println("Choisis les coordonnées d'origine du bateau :");
        System.out.println("Abscisse:");
        int abscissa = sc.nextInt();
        while (abscissa < 1 || abscissa > 10 ){
            System.out.println("Saisie incorrecte, veuillez recommencer");
            abscissa = sc.nextInt();
        }
        System.out.println("Abscisse saisie: " + abscissa);
        
        
        System.out.println("Ordonnées:");
        int ordinate = sc.nextInt();
        while (ordinate < 1 || ordinate > 10 ){
            System.out.println("Saisie incorrecte, veuillez recommencer");
            ordinate = sc.nextInt();
        }
        System.out.println("Ordonnée saisie: " + ordinate);
        
        myBoat.initAndPlaceBoat(abscissa, ordinate, direction, 5);
        
        
        
    }

}
