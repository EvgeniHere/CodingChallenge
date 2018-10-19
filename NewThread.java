
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
public class NewThread extends Thread {

    static MainFrame mf = new MainFrame();
    static MainPanel mp = new MainPanel();
    
    public NewThread() {
        this.start();
        mp.setBackground(Color.LIGHT_GRAY);
    }
    
    public void gameEnd() {
        mp.setBackground(Color.CYAN);
    }
    
    public void repaint() {
        mp.repaint();
    }
    
    @Override
    public void run() {
        mf.add(mp);
        mf.setSize(1000, 600);
        mf.setVisible(true);
    }
}
