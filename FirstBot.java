import java.util.List;

public class FirstBot extends Bot {
   //Important: you are able to change the variable "waitingTime", so everything can get slower
    public FirstBot(int cardAmount) {
        super(cardAmount, "FirstBot");
    }
    
    public void placeCard(List<Card> opponentCards, Card cardFieldCard) {
        //place Your Code here (you can find an example in SecondBot.java)
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getValue() == cardFieldCard.getValue() || cards.get(i).getColor() == cardFieldCard.getColor())  {
                this.placeCard(i);
                break;
            }
        }
    }
}