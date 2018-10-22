import java.util.ArrayList;
import java.util.List;

public class SecondBot extends Bot {
    
    List<Card> opponentCards = new ArrayList<>();
    Card placedCard;
    
    public SecondBot(int cardAmount) {
        super(cardAmount, "SecondBot");
    }
    
    public void checkValues(int[][] cardVal) {
        int max = cardVal[0][0];
        int bestCardIndex = cardVal[0][1];
        for (int i = 0; i < cardVal.length; i++) {
            if (cardVal[i][0] > max) {
                max = cardVal[i][0];
                bestCardIndex = cardVal[i][1];
            }
            //System.out.println("Value --> " + cardVal[i][1] + ": " + cardVal[i][0]);
        }
        if (cards.get(bestCardIndex).getValue() == placedCard.getValue() || cards.get(bestCardIndex).getColor() == placedCard.getColor()) {
            this.placeCard(bestCardIndex);
        }
    }

//My example of a working method for placing cards.   
    public void placeCard(List<Card> opponentCards, Card placedCard) {
        this.placedCard = placedCard;
        this.opponentCards = opponentCards;
        
        int[][] cardVal = new int[cards.size()][2]; //CardValue --> the card with the highest calculated value will be placed
        int counter = 0;
        
        for (int i = 0; i < cards.size(); i++) {
            Card currentCard = cards.get(i);
            if (currentCard.getValue() == placedCard.getValue() || currentCard.getColor() == placedCard.getColor())  {
                for (int j = 0; j < opponentCards.size(); j++) {
                    if (currentCard.getValue() != opponentCards.get(j).getValue() && currentCard.getColor() != opponentCards.get(j).getColor()) {
                        cardVal[counter][0] += 2;
                    } else if (currentCard.getValue() != opponentCards.get(j).getValue() || currentCard.getColor() != opponentCards.get(j).getColor()) {
                        cardVal[counter][0]++;
                    }
                    cardVal[counter][1] = i;
                }
                for (int j = 0; j < cards.size(); j++) {
                    if (i != j) {
                        if (currentCard.getValue() == cards.get(j).getValue() || currentCard.getColor() == cards.get(j).getColor()) {
                            cardVal[counter][0]++;
                        }
                    }
                }
                counter++;
            }
        }
        checkValues(cardVal);
    }
}