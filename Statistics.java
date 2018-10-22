public class Statistics {
    
    int sWins = 0, fWins = 0;
    int fBegin = 0, sBegin = 0;
    
    public void addGame(Game game) {
        if (game.isFinished()) {
            if (game.getWinner().equals(Game.fBot)) {
                fWins++;
            } else {
                sWins++;
            }
        }
        MainPanel.showWins(fWins, sWins);
    }
    
    public void beginner(Bot bot) {
        if (bot.equals(Game.fBot)) {
            fBegin++;
        } else {
            sBegin++;
        }
    }
    
    public void output() {
        MainPanel.showWins(fWins, sWins);
        System.out.println(Game.fBot.getName() + " has won " + fWins + " times.");
        System.out.println(Game.sBot.getName() + " has won " + sWins + " times.");
        System.out.println(Game.fBot.getName() + " has started the game " + fBegin + " times.");
        System.out.println(Game.sBot.getName() + " has started the game " + sBegin + " times.");
    }
}