package chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SquarePanel extends JPanel {
	
	boolean light;
	Color squareColor;
	Piece pieceOnSquare;
	Image pieceImage;
	
    public SquarePanel(int rank, int file) {
    	setBorder(BorderFactory.createLineBorder(Color.BLACK));
        if (rank % 2 == 1) {
        	if (file % 2 == 0) {
        		light = true;
        	} else {
        		light = false;
        	}
        } else {
        	if (file % 2 == 1) {
        		light = true;
        	} else {
        		light = false;
        	}
        }
        if (light) {
        	squareColor = new Color(230, 242, 255);
        } else {
        	squareColor = new Color(26, 133, 255);
        }
        
    }
    
    public Piece getPieceOnSquare() {
    	return pieceOnSquare;
    }
    
    public void setPieceOnSquare(Piece newPiece) {
    	pieceOnSquare = newPiece;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(60,60);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(squareColor);
        if (pieceOnSquare == null) {
        } else {
        	pieceImage = pieceOnSquare.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_FAST);
        	g.drawImage(pieceImage, 0, 0, null);
        }
    }

}
