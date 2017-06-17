package chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JComponent implements MouseListener {

	private Game chess;
	private JPanel grid;
	private PlayerPanel player1, player2;
	private SidePanel player1Side, player2Side;
	private SquarePanel[][] squareBoard;
	
	static final Color BLUE_SQUARE = new Color(26, 133, 255);
	static final Color WHITE_SQUARE = new Color(230, 242, 255);
	static final Color GREEN_SQUARE = new Color(0, 90, 0);
	
	public Board() {
		chess = new Game();
		
		addMouseListener(this);
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
		grid.addMouseListener(this);
		squareBoard = new SquarePanel[8][8];
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				squareBoard[i][j] = new SquarePanel(i,j);
				grid.add(squareBoard[i][j]);
				squareBoard[i][j].addMouseListener(this);
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
	
	// returns Piece if captured
	// this will throw null pointer if cR,cF doesn't have a piece on it
	// cR is current rank, cF is current file 
	// fR is final rank, fF is final file
	public Piece movePieceOnBoard(int cR, int cF, int fR, int fF) {
		if (chess.getBoard()[cR][cF] == null) {
			// only activate this method if cR,cF has piece on it
			return null;
		}
		chess.getBoard()[cR][cF].move(fR, fF);
		// updates instance variables of piece selected at cR, cF so it has new position
		Piece selected = chess.getBoard()[cR][cF];
		Piece captured = chess.setSquare(selected, fR, fF);
		// takes selected piece and moves it to new position on Game.board, a Piece[][]
		chess.setSquareNull(cR, cF);
		return captured;
		// returns captured piece, if any
	}
	
	public int[] seeSelectedSquares() {
		boolean move = false;
		int cR = -1, cF = -1, fR = -1, fF = -1;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (squareBoard[i][j].isFirstSelected()) {
					cR = i;
					cF = j;
				}
				if (squareBoard[i][j].isMoveSelected()) {
					fR = i;
					fF = j;
				}
				if (cR >= 0 && cF >= 0 && fR >= 0 && fF >= 0) {
					move = true;
					break;
				}
			}
			if (move) {
				break;
			}
		}
		if (move) {
			squareBoard[cR][cF].setFirstSelected(false);
			squareBoard[fR][fF].setMoveSelected(false);
			return new int[] {cR, cF, fR, fF};
		} else {
			return null;
		}
	}
	
	public void completelyMovePiece(int cR, int cF, int fR, int fF) {
		// execute underlying array method
		movePieceOnBoard(cR, cF, fR, fF);
		// set pieces on proper square panels
		displayPiecesOnBoard();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
//		int cR = 0, cF = 0, fR = 0, fF = 0;
//		boolean initialTriggered = false, finalTriggered = false, escape = false;
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 8; j++) {
//				if (squareBoard[i][j].isFinalSelection()) {
//					finalTriggered = true;
//					fR = i;
//					fF = j;
//				}
//				if (squareBoard[i][j].isInitialSelection()) {
//					initialTriggered = true;
//					cR = i;
//					cF = j;
//				}
//				if (finalTriggered && initialTriggered) {
//					escape = true;
//					continue;
//				}
//			}
//			if (escape) continue;
//		}
//		if (cR != fR || cF != fF) {
//			completelyMovePiece(cR, cF, fR, fF);
//		}
		repaint();
		int[] moveArray = seeSelectedSquares();
		if (moveArray != null) {
			completelyMovePiece(moveArray[0], moveArray[1], moveArray[2], moveArray[3]);
		}
		repaint();
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
		
//		papaKaranGodOfBlitz.chess.printBoard();
//		papaKaranGodOfBlitz.movePieceOnBoard(1,0,3,0);
//		papaKaranGodOfBlitz.chess.printBoard();
//		papaKaranGodOfBlitz.displayPiecesOnBoard();
//		papaKaranGodOfBlitz.movePieceOnBoard(7,6,5,5);
//		papaKaranGodOfBlitz.displayPiecesOnBoard();
	}
	
}
