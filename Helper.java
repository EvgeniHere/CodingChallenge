
import java.util.List;

/**
 * @author Evgeni
 */
public class Helper {
    
    public static Karte createKarte(String klasse, String farbe) {
        int wert;
        switch(klasse) {
            case "6":
                wert = 0;
            case "7":
                wert = 1;
            case "8":
                wert = 2;
            case "9":
                wert = 3;
            case "10":
                wert = 4;
            case "bube":
                wert = 5;
            case "dame":
                wert = 6;
            case "könig":
                wert = 7;
            case "ass":
                wert = 8;
            default:
                wert = 9;
        }
        
        Karte.Farbe f;
        switch(farbe) {
            case "karo":
                f = Karte.Farbe.KARO;
            case "herz":
                f = Karte.Farbe.HERZ;
            case "pik":
                f = Karte.Farbe.PIK;
            case "kreuz":
                f = Karte.Farbe.KREUZ;
            default:
                f = null;
        }
        
        return new Karte(wert, f);
    }
    
    public static List<Karte> sort(List<Karte> karten) {
        Karte temp;
        for(int i = 1; i < karten.size(); i++) {
            for(int j = 0; j < karten.size() - i; j++) {
                if(karten.get(j).getWert() > karten.get(j+1).getWert()) {
                    temp = karten.get(j);
                    karten.set(j, karten.get(j+1));
                    karten.set(j+1, temp);
                }
            }
        }
        return karten;
    }
}
