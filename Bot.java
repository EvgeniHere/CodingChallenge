import java.util.ArrayList;
import java.util.List;

public class Bot {
    List<Card> cards;
    String name;
    boolean placed, drawn, acceptedDraw; //gelegt, gezogen
    
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
    
    public void drawCard() { //variable count is true if there was no fitting card so the bot had to take one
        if (CardsStack.getAmount() > 0) {
            Card card = CardsStack.drawCard();
            System.out.print("Card drawn: ");
            Card.showCard(card);
            cards.add(card);
            Helper.sort(cards);
            if (drawn) {
                acceptedDraw = true;
                drawn = false;
            } else {
                drawn = true;
            }
        }
        System.out.println("Cards in stack: " + CardsStack.getAmount());
    }
    
    public void drawCards(int amount) {
        for (int i = 0; i < amount; i++) {
            drawCard();
        }
    }
    
    public boolean placedOrDrawn() {
        if (!acceptedDraw && CardsStack.getAmount() > 0 && drawn && !placed) {
            drawCard();
        }
        boolean drawnTemp = acceptedDraw;
        boolean placedTemp = placed;
        acceptedDraw = false;
        drawn = false;
        placed = false;
        return drawnTemp || placedTemp;
    }
    
    public Card getCardAt(int index) {
        return cards.get(index);
    }
    
    public void placeCard(int num) {
        if (!placed) {
            System.out.print("Card placed: ");
            Card.showCard(cards.get(num));
            CheatProtection.check(this, num);
            placed = true;
        } else {
            System.out.println("Bot tries to place two cards at the same time!");
        }
    }
    
    public int getCardAmount() {
        return cards.size();
    }
}
