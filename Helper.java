
import java.util.List;

/**
 * @author Evgeni
 */
public class Helper {
    
    public static List<Card> sort(List<Card> cards) {
        Card temp;
        for(int i = 1; i < cards.size(); i++) {
            for(int j = 0; j < cards.size() - i; j++) {
                if(cards.get(j).getValue() > cards.get(j+1).getValue()) {
                    temp = cards.get(j);
                    cards.set(j, cards.get(j+1));
                    cards.set(j+1, temp);
                }
            }
        }
        return cards;
    }
}
