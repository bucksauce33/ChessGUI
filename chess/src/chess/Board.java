package chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JComponent implements MouseListener, MouseMotionListener {

	private Game chess;
	private JPanel grid;
	private PlayerPanel player1;
	private PlayerPanel player2;
	private SidePanel player1Side;
	private SidePanel player2Side;
	private SquarePanel[][] squareBoard;
	
	public Board() {
		chess = new Game();
		
		addMouseListener(this);
		addMouseMotionListener(this);
		setLayout(new BorderLayout());
		
		player1 = new PlayerPanel(true);
		this.add(player1, BorderLayout.SOUTH);
		player2 = new PlayerPanel(false);
		this.add(player2, BorderLayout.NORTH);
		player1Side = new SidePanel();
		this.add(player1Side, BorderLayout.WEST);
		player2Side = new SidePanel();
		this.add(player2Side, BorderLayout.EAST);
		
		grid = new JPanel(new GridLayout(8, 8));
		grid.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(grid, BorderLayout.CENTER);
		squareBoard = new SquarePanel[8][8];
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				squareBoard[i][j] = new SquarePanel(i,j);
				grid.add(squareBoard[i][j]);
			}
		}
	}
	
	// takes pieces in Game and puts them on their respective SquarePanels
	// basically displays the pieces on their squares of the board
	public void displayPiecesOnBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				squareBoard[i][j].setPieceOnSquare(chess.getBoard()[i][j]);
				repaint();
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
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

	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
	}
	
	public static void main(String[] args) {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double smallerDimension;
		if (screenSize.getWidth() < screenSize.getHeight()) {
			smallerDimension = screenSize.getWidth();
		} else {
			smallerDimension = screenSize.getHeight();
		}
		int displayLength = (int) (9.0 / 10 * smallerDimension);
		
		Board papaKaranGodOfBlitz = new Board();
		papaKaranGodOfBlitz.displayPiecesOnBoard();
		JFrame frame = new JFrame("CHESS");
		frame.setSize(displayLength, displayLength);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(papaKaranGodOfBlitz);
		frame.setVisible(true);
	}
	
}
