import java.util.ArrayList;
import java.util.List;

public class Bot {
    List<Karte> karten;
    String name;
    boolean gelegt, gezogen;
    
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
    
    public void ziehKarte(boolean count) { //variable count ist true wenn keine passende karte vorhanden war und gezogen wurde
        if (Kartenstapel.getAnzahl() > 0) {
            Karte karte = Kartenstapel.karteZiehen();
            System.out.print("Karte gezogen: ");
            Karte.zeigeKarte(karte);
            karten.add(karte);
            Helper.sort(karten);
            gezogen = count;
        }
        System.out.println("Anzahl Karten im Kartenstapel: " + Kartenstapel.getAnzahl());
    }
    
    public void ziehKarten(int anzahl) {
        for (int i = 0; i < anzahl; i++) {
            ziehKarte(false);
        }
    }
    
    public boolean warDran() {
        boolean gezogenTemp = gezogen;
        boolean gelegtTemp = gelegt;
        gezogen = false;
        gelegt = false;
        return gezogenTemp || gelegtTemp;
    }
    
    public Karte getKarteAt(int index) {
        return karten.get(index);
    }
    
    public void legeKarte(int num) {
        if (!gelegt) {
            System.out.print("Karte gelegt: ");
            Karte.zeigeKarte(karten.get(num));
            CheatProtection.check(this, num);
            gelegt = true;
        } else {
            System.out.println("Bot versucht zwei Karten auf einmal zu legen!");
        }
    }
    
    public int getKartenAnzahl() {
        return karten.size();
    }
}