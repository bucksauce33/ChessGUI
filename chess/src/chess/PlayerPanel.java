package chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel {

	String player;
	
    public PlayerPanel(boolean white) {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        if (white) {
        	player = "Player 1";
        } else {
        	player = "Player 2";
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,60);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        g.drawString(player, 10, 20);
    }
}
