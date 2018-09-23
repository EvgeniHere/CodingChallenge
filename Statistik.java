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
        System.out.println("EBot has won " + eWins + " times.");
        System.out.println("KBot has won " + kWins + " times.");
        System.out.println("EBot has started the game " + eBegin + " times.");
        System.out.println("KBot has started the game " + kBegin + " times.");
    }
}