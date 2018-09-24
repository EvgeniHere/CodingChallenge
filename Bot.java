import java.util.ArrayList;
import java.util.List;

public class Bot {
    List<Karte> karten;
    String name;
    
    public Bot(int anzahlKarten, String name) {
        karten = new ArrayList<>();
        ziehKarten(anzahlKarten);
    }
    
    public List<Karte> getKarten() {
        return karten;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void ziehKarte() {
        if (Kartenstapel.getAnzahl() > 0) {
            Karte karte = Kartenstapel.karteZiehen();
            karten.add(karte);
        }
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
    }
    
    public int getKartenAnzahl() {
        return karten.size();
    }
}