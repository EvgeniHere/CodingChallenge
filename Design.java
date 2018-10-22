
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Evgeni
 */
public class Design {

    static MainPanel mp = new MainPanel();
    boolean first = true;
    
    public Design() {
        mp.setBackground(Color.LIGHT_GRAY);
        Main.mainFrame.add(mp);
        Main.mainFrame.setVisible(true);
    }
    
    public void gameEnd() {
        mp.setBackground(Color.CYAN);
    }
    
    public void repaint() {
        mp.repaint();
    }
}