import java.util.List;

public class SecondBot extends Bot {
    
    public SecondBot(int anzahlKarten) {
        super(anzahlKarten, "SecondBot");
    }
    
    //Mein vorherige Kartenauswahlmethode. du kannst den Inhalt der Methode löschen, musst aber den Methodennamen behalten da dieser aufgerufen wird im Verlauf des Spiels.
    public void legeKarte(List<Karte> gegnerKarten, Karte spielfeldKarte) {
        boolean gelegt = false;
        for (int i = 0; i < karten.size(); i++) {
            boolean exist = false; //--> exist ist nach der forschleife true wenn es eine karte gibt auf die der gegner keine antwort hat.
            //somit muss der gegner danach eine karte ziehen oder er verliert das spiel
            if (karten.get(i).getWert() == spielfeldKarte.getWert() || karten.get(i).getFarbe() == spielfeldKarte.getFarbe())  {
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
                if (karten.get(i).getWert() == spielfeldKarte.getWert() || karten.get(i).getFarbe() == spielfeldKarte.getFarbe())  {
                    this.legeKarte(i);
                    break;
                }
            }
        }
    }
}
