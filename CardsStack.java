import java.util.ArrayList;
import java.util.List;

class CardsStack {
    
    static List<Card> cards = new ArrayList<>();
    static int amount = 0;
    
    public CardsStack(int max) {
        cards.clear();
        amount = max;
        for (int i = 0; i < max/4; i++) {
            addNewCardSet(i);
        }
    }
    
    public static Card drawCard() {
        int num = (int) (Math.random() * cards.size());
        Card card = cards.get(num);
        cards.remove(num);
        return card;
    }
    
    public static int getAmount() {
        return cards.size();
    }
    
    public static int getStartAmount() {
        return amount;
    }
    
    public static void addNewCardSet(int cardClass) {
        cards.add(new Card(cardClass, Card.Color.HEART));
        cards.add(new Card(cardClass, Card.Color.SPADE));
        cards.add(new Card(cardClass, Card.Color.CLUB));
        cards.add(new Card(cardClass, Card.Color.DIAMOND));
    }
}