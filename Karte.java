
import java.util.List;

public class Karte {
    
    private final int klasse;
    private final Farbe farbe;
    
    public Karte(int klasse, Farbe farbe) {
        this.klasse = klasse;
        this.farbe = farbe;
    }
    
    public int getWert() {
        return klasse;
    }
    
    public Farbe getFarbe() {
        return farbe;
    }
    
    public enum Farbe {
        KARO, HERZ, PIK, KREUZ
    }
    
    public String getKlasse() {
        switch(klasse) {
            case 0:
                return "6";
            case 1:
                return "7";
            case 2:
                return "8";
            case 3:
                return "9";
            case 4:
                return "10";
            case 5:
                return "Bube";
            case 6:
                return "Dame";
            case 7:
                return "König";
            case 8:
                return "Ass";
            default:
                return "null";
        }
    }
    
    public static void zeigeKarten(List<Karte> karten) {
        for (int i = 0; i < karten.size(); i++) {
            zeigeKarte(karten.get(i));
        }
    }
    
    public static void zeigeKarte(Karte karte) {
        System.out.println(karte.getKlasse() + " | " + karte.getFarbe());
    }
}