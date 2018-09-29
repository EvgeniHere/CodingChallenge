import java.util.List;

public class FirstBot extends Bot {
   
    public FirstBot(int anzahlKarten) {
        super(anzahlKarten, "FirstBot");
    }
    
    public void legeKarte(List<Karte> gegnerKarten, Karte spielfeldKarte) {
        //place Your Code here (you can find an example in SecondBot.java)
        for (int i = 0; i < karten.size(); i++) {
            if (karten.get(i).getWert() == spielfeldKarte.getWert() || karten.get(i).getFarbe() == spielfeldKarte.getFarbe())  {
                this.legeKarte(i);
                break;
            }
        }
    }
}