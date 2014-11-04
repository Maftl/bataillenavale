public class Boat {

    public Boat(){

    }
    
    public void initBoat(int x, int y, String direction, int height){
        // Paramètre du constructeur :
        //  tableau de coordonnées d'origine [A,3]
        //  orientation
        //  longeur
        
        int[] coordinatesOrigin = new int[10];

        switch(height) {
            case 5:
                Boat aircraftCarrier = new Boat();
                break;
            case 4:
                Boat cruiser = new Boat();
                break;
            case 3:
                Boat destroyers = new Boat();
                break;
            case 2:
                Boat submarin = new Boat();
                break;
            case 1:
                Boat torpedo = new Boat();
                break;
        }

    }
}
