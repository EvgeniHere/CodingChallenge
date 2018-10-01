/**
 * @author Evgeni
 */
public class CardField {
    
    static Card card;
    
    public CardField() {
        card = null;
    }
    
    public static void placeCard(Card newCard) {
        card = newCard;
    }
    
    public static Card getCard() {
        return card;
    }
}
