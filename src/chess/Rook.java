package chess;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rook extends Piece {

	private boolean moved;
	
	public Rook(Player color, int initialRank, int initialFile) {
		super(color, initialRank, initialFile);
		moved = false;
		try {
		    if (super.getColor().isWhite()) {
		    	super.setImage(ImageIO.read(new File("piece_images/WhiteRook-min.png")));
		    } else {
		    	super.setImage(ImageIO.read(new File("piece_images/BlackRook-min.png")));
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
		return super.getColor() + " Rook";
	}
	
	@Override
	public void draw() {
//		
//		super.setImage(super.getImage().getScaledInstance(
//	    		super.getImage().getWidth(null)/40, super.getImage().getHeight(null)/40, Image.SCALE_FAST)
//	    		);
	}
	
	

}
