import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

class CardsStack {
    
    static List<Card> cards = new ArrayList<>();
    static int amount = 0;
    static BufferedImage[] sprites = new BufferedImage[32];
    private BufferedImage image;
    final int width = 596;
    final int height = 380;
    final int rows = 4;
    final int cols = 8;
    
    public CardsStack(int max) {
        cards.clear();
        amount = max;
        int num = 0;
        
        try {
            image = ImageIO.read(getClass().getClassLoader().getResource("skat.png"));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        int index = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++){
                sprites[index] = image.getSubimage(i * (width / 8), j * (height / 4), width / 8, height / 4);
                index++;
            }
        }
        
        for (int i = 0; i < max/4; i++) {
            addNewCardSet(i, num);
            num += 4;
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
    
    public static void addNewCardSet(int cardClass, int id) {
        cards.add(new Card(cardClass, Card.Color.DIAMOND, sprites[id]));
        cards.add(new Card(cardClass, Card.Color.HEART, sprites[id + 1]));
        cards.add(new Card(cardClass, Card.Color.SPADE, sprites[id + 2]));
        cards.add(new Card(cardClass, Card.Color.CLUB, sprites[id + 3]));
    }
}