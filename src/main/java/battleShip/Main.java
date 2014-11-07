package battleShip;

/**
 * Created by mariealine on 03/11/14.
 */
public class Main {

    public static void main(String[] args)
    {

        System.out.println("   _____      _____  ______________________.____     ");
        System.out.println("  /     \\    /  _  \\ \\_   _____/\\__    ___/|    |    ");
        System.out.println(" /   \\/  \\ /  /_\\  \\ |    __)    |    |   |    |    ");
        System.out.println("/    Y    \\/    |    \\|     \\     |    |   |    |___ ");
        System.out.println("\\____|__  /\\____|__  /\\___  /     |____|   |_______ \\ ");
        System.out.println("        \\/         \\/     \\/                       \\/ ");

        Player joueur1 = new Player();

        joueur1.initPlayer();

        joueur1.gamePlay();
    }
}
