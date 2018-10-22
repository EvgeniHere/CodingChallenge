import java.util.ArrayList;
import java.util.List;

public class Bot {
    List<Card> cards;
    String name;
    int amountDrawn;
    boolean placed; //gelegt, gezogen, gezogen da keine pssende karte auf der hand
    
    public Bot(int cardAmount, String name) {
        cards = new ArrayList<>();
        drawCards(cardAmount);
        this.name = name;
    }
    
    public List<Card> getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }
    
    public void drawCard() { //in this gamemode disabled (all cards (32) are already in the players hands)
        if (CardsStack.getAmount() > 0) { //always false
            Card card = CardsStack.drawCard();
            System.out.print("    Card drawn: ");
            Card.showCard(card);
            cards.add(card);
            Helper.sort(cards);
            Game.repaint();
        }
    }
    
    public void drawCards(int amount) {
        for (int i = 0; i < amount; i++) {
            drawCard();
        }
    }
    
    public boolean placed() {
        boolean placedTemp = placed;
        placed = false;
                
        return placedTemp;
    }
    
    public Card getCardAt(int index) {
        return cards.get(index);
    }
    
    public void placeCard(int num) {
        if (!placed) {
            System.out.print("Card placed: ");
            Card.showCard(cards.get(num));
            CheatProtection.check(this, num);
            Game.repaint();
            placed = true;
        } else {
            System.out.println("Bot tries to place two cards at the same time!");
        }
    }
    
    public int getCardAmount() {
        return cards.size();
    }
}