public class Statistics {
    
    int kWins = 0, eWins = 0;
    int eBegin = 0, kBegin = 0;
    
    public void addGame(Game game) {
        if (game.isFinished()) {
            if (game.getWinner().equals(Game.eBot)) {
                eWins++;
            } else {
                kWins++;
            }
        }
    }
    
    public void beginner(Bot bot) {
        if (bot.equals(Game.eBot)) {
            eBegin++;
        } else {
            kBegin++;
        }
    }
    
    public void output() {
        System.out.println(Game.eBot.getName() + " has won " + eWins + " times.");
        System.out.println(Game.kBot.getName() + " has won " + kWins + " times.");
        System.out.println(Game.eBot.getName() + " has started the game " + eBegin + " times.");
        System.out.println(Game.kBot.getName() + " has started the game " + kBegin + " times.");
    }
}