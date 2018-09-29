/**
 * @author Evgeni
 */
public class Spielfeld {
    
    static Karte karte;
    
    public Spielfeld() {
        karte = null;
    }
    
    public static void legeKarte(Karte newKarte) {
        karte = newKarte;
    }
    
    public static Karte getKarte() {
        return karte;
    }
}
