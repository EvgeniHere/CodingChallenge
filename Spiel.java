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
        System.out.println(bot.getName() + " ist dran:");
        
        bot.ziehKarte();
        if (bot.equals(eBot)) {
            eBot.legeKarte(kBot.getKarten(), Spielfeld.getKarte());
        } else {
            kBot.legeKarte(eBot.getKarten(), Spielfeld.getKarte());
        }

        System.out.println("Karte gelegt: " + bot.hatGelegt());
        
        if (bot.hatGelegt()) {
            System.out.println("Noch Karten: " + bot.getKartenAnzahl());
            if (bot.equals(eBot)) {
                nextTurn(kBot);
            } else {
                nextTurn(eBot);
            }
        } else {
            if (!bot.ziehKarte()) {
                if (bot.equals(eBot)) {
                    winner = kBot;
                    System.out.println(kBot.getName() + " hat gewonnen! 2");
                } else {
                    winner = eBot;
                    System.out.println(eBot.getName() + " hat gewonnen! 2");
                }
            } else {
                if (bot.equals(eBot)) {
                    nextTurn(kBot);
                } else {
                    nextTurn(eBot);
                }
            }
        }
    }
    
    public boolean isFinished() {
        return winner != null;
    }
    
    public Bot getWinner() {
        return winner;
    }
}
