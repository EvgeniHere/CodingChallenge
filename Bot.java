import java.util.ArrayList;
import java.util.List;

public class Bot {
    List<Karte> karten;
    String name;
    boolean gelegt;
    
    public Bot(int anzahlKarten, String name) {
        karten = new ArrayList<>();
        ziehKarten(anzahlKarten);
        this.name = name;
    }
    
    public List<Karte> getKarten() {
        return karten;
    }

    public String getName() {
        return name;
    }
    
    public boolean ziehKarte() {
        if (Kartenstapel.getAnzahl() > 0) {
            Karte karte = Kartenstapel.karteZiehen();
            karten.add(karte);
            return true;
        } else {
            return false;
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
        if (!gelegt) {
            CheatProtection.check(this, num);
            gelegt = true;
        } else {
            System.out.println("Bot versucht zwei Karten auf einmal zu legen!");
        }
    }

    public boolean hatGelegt() {
        boolean gelegtTemp = gelegt;
        gelegt = false;
        return gelegtTemp;
    }
    
    public int getKartenAnzahl() {
        return karten.size();
    }
}
