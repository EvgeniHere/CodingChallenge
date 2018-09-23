import java.util.Scanner;

public class Karten {

    static Spiel spiel;
    static Statistik stats = new Statistik();
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Anzahl Karten: ");
        int num = Integer.valueOf(scan.next());
        
        for (int i = 0; i < 100; i++) {
            spiel = new Spiel(num); 
            stats.addSpiel(spiel);
        }
        
        stats.ausgabe();
    }
}