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
        Spiel.kBot = new SecondBot(3);
        Spiel.eBot = new FirstBot(3);
        winner = null;
        
        Spielfeld.legeKarte(Kartenstapel.karteZiehen());
        
        System.out.println();
        
        if ((int) (Math.random()*1000) > 499) {
            nextTurn(Spiel.eBot);
            Karten.stats.beginner(eBot);
        } else {
            nextTurn(Spiel.kBot);
            Karten.stats.beginner(kBot);
        }
    }
    
    public void nextTurn(Bot bot) {
        bot.ziehKarte();
        if (bot.equals(eBot)) {
            eBot.legeKarte(kBot.getKarten(), Spielfeld.getKarte());
        } else {
            kBot.legeKarte(eBot.getKarten(), Spielfeld.getKarte());
        }

        if (bot.hatGelegt()) {
            if (!bot.getKarten().isEmpty()) { //könnte Fehler sein
                if (!isFinished()) {
                    if (bot.equals(eBot)) {
                        nextTurn(kBot);
                    } else {
                        nextTurn(eBot);
                    }
                }
            } else {
                winner = bot;
            }
        }
    }
    
    //public static void botWin(Bot bot) { //könnte Fehler sein
   //    winner = bot;
   // }
    
    public boolean isFinished() {
        return winner != null;
    }
    
    public Bot getWinner() {
        return winner;
    }
}