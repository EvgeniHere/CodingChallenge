/*
 * @author Evgeni
 */
public class Game {
    
    static CardField sf; 
    static CardsStack ks;
    static FirstBot fBot;
    static SecondBot sBot;
    static Bot winner;
    static Design t;
    static boolean fBotsTurn = false;
    static boolean pause;
    static int waitingTime = 10; //Change this to a higher value while developing (e.g.: 1500)
    
    public Game(int cardAmount) {
        ks = new CardsStack(cardAmount);
        Game.sBot = new SecondBot(15);
        Game.fBot = new FirstBot(15);
        winner = null;
        System.out.println();
        
        Card beginnerCard = CardsStack.drawCard();
        System.out.print("Placed Card: ");
        Card.showCard(beginnerCard);
        CardField.placeCard(beginnerCard);
        
        System.out.println();
        System.out.println("FirstBots cards: ");
        Card.showCards(fBot.getCards());
        System.out.println();
        System.out.println("SecondBots cards: ");
        Card.showCards(sBot.getCards());
        System.out.println();
        
        t = new Design();
        
        if ((int) (Math.random()*10) > 4) {
            System.out.println(fBot.getName() + "´s first turn: ");
            fBot.drawCard();
            nextTurn(fBot);
            Main.stats.beginner(fBot);
        } else {
            System.out.println(sBot.getName() + "´s first turn: ");
            sBot.drawCard();
            nextTurn(sBot);
            Main.stats.beginner(sBot);
        }
    }
    
    public static void pauseGame(boolean stop) {
        pause = stop;
        System.out.println("Pause: " + stop);
    }
    
    public static boolean isPaused() {
        return pause;
    }
    
    public void nextTurn(Bot bot) {
        repaint();
        System.out.println();
        System.out.println(bot.getName() + "´s turn:");

        delay();
        while (isPaused()) {
            System.out.print("");
        }
        delay();
        
        if (bot.equals(fBot)) {
            fBotsTurn = true;
            repaint();
            delay();
            while (isPaused()) {
                System.out.print("");
            }
            delay();
            fBot.placeCard(sBot.getCards(), CardField.getCard());
        } else {
            fBotsTurn = false;
            repaint();
            delay();
            while (isPaused()) {
                System.out.print("");
            }
            delay();
            sBot.placeCard(fBot.getCards(), CardField.getCard());
        }
        
        if (bot.placed()) {
            if (bot.getCardAmount() > 0) {
                Card.showCards(bot.getCards());
                if (bot.equals(fBot)) {
                    nextTurn(sBot);
                } else {
                    nextTurn(fBot);
                }
            } else {
                setWinner(bot);
            }
        } else {
            if (bot.equals(fBot)) {
                setWinner(sBot);
            } else {
                setWinner(fBot);
            }
        }
    }
    
    public static void delay() {
        try {
            Thread.sleep(waitingTime/2);
        } catch (InterruptedException ex) {
        }
    }
    
    public static boolean fBotsTurn() {
        return fBotsTurn;
    }
    
    public static void repaint() {
        if (t != null) {
            t.repaint();
        }
    }
    
    private void setWinner(Bot bot) {
        if (t != null) {
            t.gameEnd();
        }
        repaint();
        winner = bot;
        System.out.println(bot.getName() + " won!");
    }
    
    public boolean isFinished() {
        return winner != null;
    }
    
    public Bot getWinner() {
        return winner;
    }
}