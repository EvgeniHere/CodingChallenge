
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Evgeni
 */
public class MainPanel extends javax.swing.JPanel {

    List<Card> cardsToDraw = new ArrayList<>();
    int width = 980;
    int height = 600;
    boolean pause;
    int distance = width / 2;
    
    public MainPanel() {
        initComponents();
        setBackground(Color.LIGHT_GRAY);
        jLabel1.setText(Game.fBot.getName());
        jLabel2.setText(Game.sBot.getName());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.GREEN);
        if (Game.fBotsTurn) {
            g.fillRect(0, 0, width / 2, height);
        } else {
            g.fillRect(width / 2, 0, width, height);
        }
        
        Color c = g.getColor();
        g.setColor(new Color(250, 252, 68));
        g.fillRect(0, 0, width+10, distance);
        g.setColor(c);
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        
        g2.setColor(Color.BLACK);
        g2.draw(new Line2D.Float(width / 2, 40, width / 2, height));
        g2.draw(new Line2D.Float(0, 40, width, 40));
        
        drawCards(g, Game.fBot.getCards(), 0);
        drawCards(g, Game.sBot.getCards(), width/2);
        drawCard(g, CardField.getCard(), width / 2 - 40, 2 * (height / 3));
    }
    
    public void drawCards(Graphics g, List<Card> cards, int startPosX) {
        int y = 50;
        int moveX = -1;
        int maxCards = 5;
        for (int i = 0; i < cards.size(); i++) {
            if (i > maxCards) {
                maxCards += 6;
                y += cards.get(i).getImage().getHeight() + 20;
                moveX = -1;
                distance = y + cards.get(i).getImage().getHeight() + 10;
            }
            moveX++;
            
            Color c = g.getColor();
            if (cards.get(i).getValue() == CardField.getCard().getValue() || cards.get(i).getColor() == CardField.getCard().getColor()) {
                g.setColor(Color.YELLOW);
                g.fillRect(startPosX + moveX * 80 + 4, y - 3, cards.get(i).getImage().getWidth() + 6, cards.get(i).getImage().getHeight() + 6);
            }
            g.setColor(c);
            
            g.drawImage(cards.get(i).getImage(), startPosX + moveX * 80 + 7, y, null);
        }
    }
    
    public void drawCard(Graphics g, Card card, int x, int y) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x - 3, y - 3, card.getImage().getWidth() + 6, card.getImage().getHeight() + 6);
        g.drawImage(card.getImage(), x, y, null);
        g.setColor(c);
    }
    
    public static void showWins(int fWins, int sWins) {
        jLabel3.setText(fWins + "");
        jLabel5.setText(sWins + "");
    }
    
    /**
     * Creates new form MainPanel
     */
        /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Pause Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("0");

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel4.setText("Wins");

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(781, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 489, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Game.pauseGame(!Game.isPaused());
        if (pause) {
            pause = false;
            jButton1.setText("Pause Game");
        } else {
            pause = true;
            jButton1.setText("Start Game");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private static javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
