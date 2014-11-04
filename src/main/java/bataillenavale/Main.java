package bataillenavale;
import java.util.Scanner;

/**
 * Created by mariealine on 03/11/14.
 */
public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tu as 5 bateaux dans ton port.");
        System.out.println("Choisis les coordonnées d'origine du bateau :");
        System.out.println("Abscisse:");
        String aircraftCarrierAbscissa = sc.nextLine(); 
        System.out.println("Abscisse saisie: " + aircraftCarrierAbscissa);
        System.out.println("Ordonnées:");
        
        String aircraftCarrierOrdinate = sc.nextLine();
        System.out.println("Abscisse saisie: " + aircraftCarrierOrdinate);

    }

}


