
import java.util.List;

public class Card {
    
    private final int cardClass;
    private final Color cardColor;
    
    public Card(int cardClass, Color color) {
        this.cardClass = cardClass;
        this.cardColor = color;
    }
    
    public int getValue() {
        return cardClass;
    }
    
    public Color getColor() {
        return cardColor;
    }
    
    public enum Color {
        DIAMOND, HEART, SPADE, CLUB
      //KARO   , Herz , PIK  , KREUZ
    }
    
    public String getCardClass() {
        switch(cardClass) {
            case 0:
                return "7";
            case 1:
                return "8";
            case 2:
                return "9";
            case 3:
                return "10";
            case 4:
                return "Jack";
            case 5:
                return "Queen";
            case 6:
                return "King";
            case 7:
                return "Ace";
            default:
                return "null";
        }
    }
    
    public static void showCards(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            showCard(cards.get(i));
        }
    }
    
    public static void showCard(Card card) {
        System.out.println(card.getCardClass() + " | " + card.getColor());
    }
}
