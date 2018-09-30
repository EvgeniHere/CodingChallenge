
public class Main {

    static Game game;
    static Statistics stats = new Statistics();
    
    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        //System.out.print("Set the amount of cards to begin: ");
        //int num = Integer.valueOf(scan.next());
        
        for (int i = 0; i < 100; i++) {
            game = new Game(32); 
            stats.addGame(game);
        }
        
        stats.output();
    }
}