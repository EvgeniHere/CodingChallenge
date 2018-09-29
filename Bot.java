import java.util.ArrayList;
import java.util.List;

public class Bot {
    List<Karte> karten;
    String name;
    boolean gelegt, verloren;
    
    public Bot(int anzahlKarten, String name) {
        karten = new ArrayList<>();
        ziehKarten(anzahlKarten);
        verloren = false;
    }
    
    public List<Karte> getKarten() {
        return karten;
    }

    public String getName() {
        return name;
    }
    
    public void ziehKarte() {
        if (Kartenstapel.getAnzahl() > 0) {
            Karte karte = Kartenstapel.karteZiehen();
            karten.add(karte);
        } else {
            verloren = true;
        }
    }

    public boolean hatGezogen() {
        return verloren;
    }
    
    public void ziehKarten(int anzahl) {
        for (int i = 0; i < anzahl; i++) {
            ziehKarte();
        }
    }
    
    public Karte getKarteAt(int index) {
        return karten.get(index);
    }
    
    public void legeKarte(int num) {
        CheatProtection.check(this, num);
        gelegt = true;
    }

    public boolean hatGelegt() {
        if (gelegt) {
            gelegt = false;
            return true;
        } else {
            return false;
        }
    }
    
    public int getKartenAnzahl() {
        return karten.size();
    }
}