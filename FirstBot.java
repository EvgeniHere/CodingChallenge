import java.util.ArrayList;
import java.util.List;

public class FirstBot extends Bot {
   //Important: you are able to change the variable "waitingTime" in Game.java, so everything can get slower
    
    List<Card> opponentCards = new ArrayList<>();
    Card placedCard;
    
    public FirstBot(int cardAmount) {
        super(cardAmount, "FirstBot");
    }
    
    public void placeCard(List<Card> opponentCards, Card placedCard) {
        this.placedCard = placedCard;
        this.opponentCards = opponentCards;
        
        for (int i = 0; i < cards.size(); i++) {
            Card currentCard = cards.get(i);
            if (currentCard.getValue() == placedCard.getValue() || currentCard.getColor() == placedCard.getColor())  {
                this.placeCard(i);
                return;
            }
        }
    }
}