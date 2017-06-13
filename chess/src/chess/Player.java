package chess;

public class Player {

	private final boolean white;
	private boolean castleLeft;
	private boolean castleRight;
	private boolean inCheck;
	
	public Player(boolean white) {
		this.white = white;
		castleLeft = false;
		castleRight = false;
		inCheck = false;
	}
	
	public boolean isWhite() {
		return white;
	}
	
	public boolean canCastleLeft() {
		return castleLeft;
	}
	
	public boolean canCastleRight() {
		return castleRight;
	}
	
	public boolean isInCheck() {
		return inCheck;
	}
	
	public void setInCheck(boolean inCheck) {
		this.inCheck = inCheck;
	}
	
	@Override
	public String toString() {
		if (white) {
			return "W";
		} else {
			return "B";
		}
	}
	
}
