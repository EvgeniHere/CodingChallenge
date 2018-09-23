import java.util.List;

public class FirstBot extends Bot {
    
    public FirstBot(int anzahlKarten) {
        super(anzahlKarten, "EvgenisBot");
    }
    
    public void legeKarte(List<Karte> gegnerKarten) {
        boolean gelegt = false;
        for (int i = 0; i < karten.size(); i++) {
            if (karten.get(i).getWert() == Spielfeld.getKarte().getWert() || karten.get(i).getFarbe() == Spielfeld.getKarte().getFarbe())  {
                boolean exist = false;
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
                    System.out.println("Fuck...");
                    Spiel.botWin(Spiel.kBot);
                }
            }
        }
    }
}