public class CheatProtection {
    public static void check(Bot bot, int index) {
        Card card = bot.getCardAt(index);
        if (CardField.getCard().getColor() == card.getColor() || CardField.getCard().getValue() == card.getValue()) {
            CardField.placeCard(bot.getCardAt(index));
            bot.getCards().remove(index);
        } else {
            System.out.println("Cheat detected!");
            System.out.println("Your Card does not fit to the current one on the field!");
            System.exit(0);
        }
    }
}