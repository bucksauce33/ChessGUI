package chess;

public class Game {
	
	private Player white = new Player(true);
	private Player black = new Player(false);
	
	private Piece[][] board = new Piece[8][8];
	// only need pieces, not square or board class
	
	public Game() {
		for (int i = 0; i < 8; i++) {
			switch (i) {
				case 0:
				case 7:
					for (int j = 0; j < 8; j++) {
						switch (j) {
							case 0:
							case 7:
								if (i == 0) {
									board[i][j] = new Rook(white, i, j);
								} else {
									board[i][j] = new Rook(black, i, j);
								}
								break;
							case 1:
							case 6:
								if (i == 0) {
									board[i][j] = new Knight(white, i, j);
								} else {
									board[i][j] = new Knight(black, i, j);
								}
								break;
							case 2:
							case 5:
								if (i == 0) {
									board[i][j] = new Bishop(white, i, j);
								} else {
									board[i][j] = new Bishop(black, i, j);
								}
								break;
							case 3:
								if (i == 0) {
									board[i][j] = new Queen(white, i, j);
								} else {
									board[i][j] = new Queen(black, i, j);
								}
								break;
							case 4:
								if (i == 0) {
									board[i][j] = new King(white, i, j);
								} else {
									board[i][j] = new King(black, i, j);
								}
								break;
						}
					}
				break;
			case 1:
			case 6:
				for (int j = 0; j < 8; j++) {
					if (i == 1) {
						board[i][j] = new Pawn(white, i, j);
					} else {
						board[i][j] = new Pawn(black, i, j);
					}
				}
				break;
			default:
			}
		}
	}
	
//	public Board() {
//		positions = new Square[8][8];
//		for (int i = 0; i < 8; i++) {
//			int rank = i + 1;
//			for (int j = 0; j < 8; j++) {
//				char file = (char) (j + 97);
//				positions[i][j] = new Square(rank, file);
//			}
//		}
//	}
	
	public void printBoard() {
		for (int i = 0; i < 8; i++) {
			int file = i + 1;
			for (int j = 0; j < 8; j++) {
				char rank = (char) (j + 97);
				
				if (board[i][j] == null) {
					System.out.print(rank + "" + file + "\t\t");
				} else {
					System.out.print(rank + "" + file + ": " + board[i][j].toString() + "\t");
				}
			}
			System.out.println();
		}
	}
	
	public Player getWhite() {
		return white;
	}
	
	public Player getBlack() {
		return black;
	}
	
	public Piece[][] getBoard() {
		return board;
	}
	
	
}
