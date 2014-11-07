package battleShip;

/**
 * Created by mariealine on 03/11/14.
 */
public class Main {

    public static void main(String[] args)
    {

        System.out.println("   _____      _____  ______________________.____     ");
        System.out.println("  /     \\    /  _  \\ \\_   _____/\\__    ___/|    |    ");
        System.out.println(" /   \\/  \\  /  /_\\  \\|    __)     |    |   |    |    ");
        System.out.println("/    Y    \\/    |    \\|     \\     |    |   |    |___ ");
        System.out.println("\\____|__  /\\____|__  /\\___  /     |____|   |_______ \\ ");
        System.out.println("        \\/         \\/     \\/                       \\/ ");

        System.out.println("   ___         _          _  _  _             __                     _");
        System.out.println("  / __\\  __ _ | |_  __ _ (_)| || |  ___    /\\ \\ \\ __ _ __   __ __ _ | |  ___ ");
        System.out.println(" /__\\// / _` || __|/ _` || || || | / _ \\  /  \\/ // _` |\\ \\ / // _` || | / _ \\ ");
        System.out.println("/ \\/  \\| (_| || |_| (_| || || || ||  __/ / /\\  /| (_| | \\ V /| (_| || ||  __/");
        System.out.println("\\_____/ \\__,_| \\__|\\__,_||_||_||_| \\___| \\_\\ \\//  \\__,_|  \\_/  \\__,_||_| \\___|");

        Player joueur1 = new Player();

        joueur1.initPlayer();

        joueur1.gamePlay();
    }
}
