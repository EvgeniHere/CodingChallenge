import java.util.List;

public class SecondBot extends Bot {
    
    public SecondBot(int cardAmount) {
        super(cardAmount, "SecondBot");
    }

//My example of a working method for placing cards. you have to use this methodname and the parameters.    
    public void placeCard(List<Card> opponentCards, Card cardFieldCard) {
        boolean placed = false;
        for (int i = 0; i < cards.size(); i++) {
            boolean exist = false;
            if (cards.get(i).getValue() == cardFieldCard.getValue() || cards.get(i).getColor() == cardFieldCard.getColor())  {
                for (int j = 0; j < opponentCards.size(); j++) {
                    if (cards.get(i).getValue() != opponentCards.get(j).getValue() && cards.get(i).getColor() != opponentCards.get(j).getColor()) {
                        exist = true;
                    } else {
                        exist = false;
                        break;
                    }
                }
                if (exist) {
                    this.placeCard(i);
                    placed = true;
                    break;
                }
            }
        }
        
        if (!placed) {
            for (int i = 0; i < cards.size(); i++) {
                if (cards.get(i).getValue() == cardFieldCard.getValue() || cards.get(i).getColor() == cardFieldCard.getColor())  {
                    this.placeCard(i);
                    break;
                }
            }
        }
    }
}