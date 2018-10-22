/**
 * @author Evgeni
 */
public class CardField {
    
    static Card card;
    static boolean important = true;
    
    public CardField() {
        card = null;
    }
    
    public static void placeCard(Card newCard) {
        card = newCard;
    }
    
    public static Card getCard() {
        return card;
    }
    
    public static boolean checkCard(Card card) {
        if (getCard().getColor() == card.getColor() || getCard().getValue() == card.getValue()) {
            return true;
        } else {
            return false;
        }
    }
}