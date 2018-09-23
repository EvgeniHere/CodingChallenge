import java.util.ArrayList;
import java.util.List;

class Kartenstapel {
    
    static List<Karte> karten = new ArrayList<>();
    static int anzahl = 0;
    
    public Kartenstapel(int max) {
        karten.clear();
        anzahl = max;
        for (int i = 0; i < max/4; i++) {
            addNewKartenSet(i);
        }
    }
    
    public static Karte karteZiehen() {
        int num = (int) (Math.random() * karten.size());
        Karte karte = karten.get(num);
        karten.remove(num);
        return karte;
    }
    
    public static int getAnzahl() {
        return karten.size();
    }
    
    public static int getStartAnzahl() {
        return anzahl;
    }
    
    public static void addNewKartenSet(int klasse) {
        karten.add(new Karte(klasse, Karte.Farbe.HERZ));
        karten.add(new Karte(klasse, Karte.Farbe.PIK));
        karten.add(new Karte(klasse, Karte.Farbe.KREUZ));
        karten.add(new Karte(klasse, Karte.Farbe.KARO));
    }
}