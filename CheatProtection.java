public class CheatProtection {
    
    public static void check(Bot bot, int index) {
        Karte karte = bot.getKarteAt(index);
        if (Spielfeld.getKarte().getFarbe() == karte.getFarbe() || Spielfeld.getKarte().getWert() == karte.getWert()) {
            Spielfeld.legeKarte(bot.getKarteAt(index));
            bot.getKarten().remove(index);
        } else {
            System.out.println("Cheat detected!!!");
            System.exit(0);
        }
    }
}