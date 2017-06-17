package chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SquarePanel extends JPanel implements MouseListener {
	
	private boolean light;
	private Color squareColor;
	// think about deleting ^these two, only used in constructor right now
	
	private Piece pieceOnSquare;
	private Image pieceImage;
	// updates from pieceOnSquare every time paintComponent is called
	
	private boolean firstSelected;
	private boolean moveSelected;
	
    public SquarePanel(int rank, int file) {
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
        	squareColor = Board.WHITE_SQUARE;
        } else {
        	squareColor = Board.BLUE_SQUARE;
        }
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        addMouseListener(this);
    }
    
    public Piece getPieceOnSquare() {
    	return pieceOnSquare;
    }
    
    public void setPieceOnSquare(Piece newPiece) {
    	pieceOnSquare = newPiece;
    }
    
    public boolean isFirstSelected() {
		return firstSelected;
	}
    
    public void setFirstSelected(boolean firstSelected) {
    	this.firstSelected = firstSelected;
    }
	
	public boolean isMoveSelected() {
		return moveSelected;
	}
	
	public void setMoveSelected(boolean moveSelected) {
    	this.moveSelected = moveSelected;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(60,60);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(squareColor);
        if (firstSelected || moveSelected) {
        	setBackground(Board.GREEN_SQUARE);
        }
        if (pieceOnSquare == null) {
        } else {
        	pieceImage = pieceOnSquare.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        	g.drawImage(pieceImage, 0, 0, null);
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		if (pieceOnSquare != null) {
			firstSelected = !firstSelected;
		} else {
			moveSelected = !moveSelected;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
