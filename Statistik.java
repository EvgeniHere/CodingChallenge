public class Statistik {
    
    int kWins = 0, eWins = 0;
    int eBegin = 0, kBegin = 0;
    
    public void addSpiel(Spiel spiel) {
        if (spiel.isFinished()) {
            if (spiel.getWinner().equals(Spiel.eBot)) {
                eWins++;
            } else {
                kWins++;
            }
        }
    }
    
    public void beginner(Bot bot) {
        if (bot.equals(Spiel.eBot)) {
            eBegin++;
        } else {
            kBegin++;
        }
    }
    
    public void ausgabe() {
        System.out.println(Spiel.eBot.getName() + " has won " + eWins + " times.");
        System.out.println(Spiel.kBot.getName() + " has won " + kWins + " times.");
        System.out.println(Spiel.eBot.getName() + " has started the game " + eBegin + " times.");
        System.out.println(Spiel.kBot.getName() + " has started the game " + kBegin + " times.");
    }
}