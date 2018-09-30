/*
 * @author Evgeni
 */
public class Game {
    
    static CardField sf; 
    static CardsStack ks;
    static SecondBot kBot;
    static FirstBot eBot;
    static Bot winner;
    
    public Game(int cardAmount) {
        ks = new CardsStack(cardAmount);
        Game.kBot = new SecondBot(5);
        Game.eBot = new FirstBot(5);
        winner = null;
        System.out.println();
        
        Card beginnerCard = CardsStack.drawCard();
        System.out.print("CardFieldCard: ");
        Card.showCard(beginnerCard);
        
        CardField.placeCard(beginnerCard);
        
        
        if ((int) (Math.random()*1000) > 499) {
            nextTurn(Game.eBot);
            Main.stats.beginner(eBot);
        } else {
            nextTurn(Game.kBot);
            Main.stats.beginner(kBot);
        }
    }
    
    public void nextTurn(Bot bot) {
        System.out.println();
        System.out.println(bot.getName() + "´s turn:");
        
        bot.drawCard();
        
        Card.showCards(bot.getCards());
        
        if (bot.equals(eBot)) {
            eBot.placeCard(kBot.getCards(), CardField.getCard());
        } else {
            kBot.placeCard(eBot.getCards(), CardField.getCard());
        }
        
        if (bot.placedOrDrawn()) {
            if (bot.getCardAmount() > 0) {
                if (bot.equals(eBot)) {
                    nextTurn(kBot);
                } else {
                    nextTurn(eBot);
                }
            } else {
                setWinner(bot);
            }
        } else {
            System.out.println("Not Placed!");
            if (bot.equals(eBot)) {
                setWinner(kBot);
            } else {
                setWinner(eBot);
            }
        }
    }
    
    public void setWinner(Bot bot) {
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