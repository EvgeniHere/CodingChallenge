import java.util.List;

public class SecondBot extends Bot {
    
    public SecondBot(int anzahlKarten) {
        super(anzahlKarten, "KauansBot");
    }
    
    //Mein vorherige Kartenauswahlmethode für den bot. du kannst das löschen
    public void legeKarte(List<Karte> gegnerKarten) {
        boolean gelegt = false;
        for (int i = 0; i < karten.size(); i++) {
            boolean exist = false;
            if (karten.get(i).getWert() == Spielfeld.getKarte().getWert() || karten.get(i).getFarbe() == Spielfeld.getKarte().getFarbe())  {
                for (int j = 0; j < gegnerKarten.size(); j++) {
                    if (karten.get(i).getWert() != gegnerKarten.get(j).getWert() && karten.get(i).getFarbe() != gegnerKarten.get(j).getFarbe()) {
                        exist = true;
                    } else {
                        exist = false;
                        break;
                    }
                }
                if (exist) {
                    this.legeKarte(i);
                    gelegt = true;
                    break;
                }
            }
        }
        
        if (!gelegt) {
            for (int i = 0; i < karten.size(); i++) {
                if (karten.get(i).getWert() == Spielfeld.getKarte().getWert() || karten.get(i).getFarbe() == Spielfeld.getKarte().getFarbe())  {
                    this.legeKarte(i);
                    gelegt = true;
                    break;
                }
            }
            if (!gelegt) {
                if (Kartenstapel.getAnzahl() > 0) {
                    this.ziehKarte();
                } else {
                    System.out.println("Ich hab verloren.");
                    Spiel.botWin(Spiel.eBot);
                }
            }
        }
    }
}