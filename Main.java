import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Game game;
    static Statistics stats = new Statistics();
    public static MainFrame mainFrame;
    
    public static void main(String[] args) throws IOException {
        mainFrame = new MainFrame();
        mainFrame.setSize(1000, 600);
        mainFrame.setVisible(true);
        for (int i = 0; i < 1000; i++) {
            game = new Game(32);
            stats.addGame(game);
        }
        stats.output();
        
        Scanner s = new Scanner(System.in);
        s.nextLine();
    }
}