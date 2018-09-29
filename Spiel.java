/*
 * @author Evgeni
 */
public class Spiel {
    
    static Spielfeld sf; 
    static Kartenstapel ks;
    static SecondBot kBot;
    static FirstBot eBot;
    static Bot winner;
    
    public Spiel(int kartenAnzahl) {
        ks = new Kartenstapel(kartenAnzahl);
        Spiel.kBot = new SecondBot(5);
        Spiel.eBot = new FirstBot(5);
        winner = null;
        System.out.println();
        
        Karte anfangsKarte = Kartenstapel.karteZiehen();
        System.out.print("SpielfeldKarte: ");
        Karte.zeigeKarte(anfangsKarte);
        
        Spielfeld.legeKarte(anfangsKarte);
        
        
        if ((int) (Math.random()*1000) > 499) {
            nextTurn(Spiel.eBot);
            Karten.stats.beginner(eBot);
        } else {
            nextTurn(Spiel.kBot);
            Karten.stats.beginner(kBot);
        }
    }
    
    public void nextTurn(Bot bot) {
        System.out.println();
        System.out.println(bot.getName() + " ist dran:");
        
        bot.ziehKarte(false);
        
        Karte.zeigeKarten(bot.getKarten());
        
        if (bot.equals(eBot)) {
            eBot.legeKarte(kBot.getKarten(), Spielfeld.getKarte());
        } else {
            kBot.legeKarte(eBot.getKarten(), Spielfeld.getKarte());
        }
        
        if (bot.warDran()) {
            if (bot.getKartenAnzahl() > 0) {
                if (bot.equals(eBot)) {
                    nextTurn(kBot);
                } else {
                    nextTurn(eBot);
                }
            } else {
                setWinner(bot);
            }
        } else {
            if (bot.equals(eBot)) {
                setWinner(kBot);
            } else {
                setWinner(eBot);
            }
        }
    }
    
    public void setWinner(Bot bot) {
        winner = bot;
        System.out.println(bot.getName() + " hat gewonnen!");
    }
    
    public boolean isFinished() {
        return winner != null;
    }
    
    public Bot getWinner() {
        return winner;
    }
}