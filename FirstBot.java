package de.hesse.martin;

import java.util.List;

public class FirstBot extends Bot {
   
    public FirstBot(int cardAmount) {
        super(cardAmount, "FirstBot");
    }
    
    public void placeCard(List<Card> opponentCards, Card cardFieldCard) {
		//place Your Code here (you can find an example in SecondBot.java)
		
		boolean placed = false;
		boolean existBest = false;
		boolean existSecondBest = false;
		
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getValue() == cardFieldCard.getValue() || cards.get(i).getColor() == cardFieldCard.getColor())  {
				for (int j = 0; j < opponentCards.size(); j++) {
					if (cards.get(i).getValue() != opponentCards.get(j).getValue() && cards.get(i).getColor() != opponentCards.get(j).getColor()) {
						existBest = true;
					} else {
						existBest = false;
						break;
					}
				}
				if (existBest){
					this.placeCard(i);
					placed = true;
//					System.out.println("Yeah!");
					return;
				}
			}
		}

		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getValue() == cardFieldCard.getValue() || cards.get(i).getColor() == cardFieldCard.getColor())  {
				for (int j = 0; j < opponentCards.size(); j++) {
					if (cards.get(i).getValue() != opponentCards.get(j).getValue()) {
						existSecondBest = true;
					} else {
						existSecondBest = false;
						break;
					}
				}
				if (existSecondBest){
					this.placeCard(i);
					placed = true;
//					System.out.println("Yeah!");
					return;
				}
			}
		}
				
		if (!placed) {
		    for (int i = 0; i < cards.size(); i++) {
		        if (cards.get(i).getValue() == cardFieldCard.getValue() || cards.get(i).getColor() == cardFieldCard.getColor())  {
		            this.placeCard(i);
		            return;
		        }
		    }
		}
    }
}