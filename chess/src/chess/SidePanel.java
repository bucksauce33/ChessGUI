package chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SidePanel extends JPanel {
	
    public SidePanel() {
        //setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(60, 600);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
}