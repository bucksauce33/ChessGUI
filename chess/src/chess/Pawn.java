package chess;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pawn extends Piece {

	private boolean moved;
	
	public Pawn(Player color, int initialRank, int initialFile) {
		super(color, initialRank, initialFile);
		moved = false;
		try {
		    if (super.getColor().isWhite()) {
		    	super.setImage(ImageIO.read(new File("piece_images/WhitePawn.png")));
		    } else {
		    	super.setImage(ImageIO.read(new File("piece_images/BlackPawn.png")));
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean hasMoved() {
		return moved;
	}
	
	@Override
	public void move(int currentRank, int currentFile) {
		super.move(currentRank, currentFile);
		if (!moved) {
			moved = true;
		}
	}
	
	@Override
	public String toString() {
		return super.getColor() + " Pawn";
	}
	
	@Override
	public void draw() {
//		img = (BufferedImage) img.getScaledInstance(img.getWidth()/40, img.getHeight(), Image.SCALE_FAST);
	}

}
