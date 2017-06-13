package chess;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bishop extends Piece {
	
	public Bishop(Player color, int initialRank, int initialFile) {
		super(color, initialRank, initialFile);
		try {
		    if (super.getColor().isWhite()) {
		    	super.setImage(ImageIO.read(new File("piece_images/WhiteBishop.png")));
		    } else {
		    	super.setImage(ImageIO.read(new File("piece_images/BlackBishop.png")));
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void move(int currentRank, int currentFile) {
		super.move(currentRank, currentFile);
	}
	
	@Override
	public String toString() {
		return super.getColor() + " Bishop";
	}

	@Override
	public void draw() {
		
		//img = img.getScaledInstance(img.getWidth(null)/40, img.getHeight(null), Image.SCALE_FAST);
	}

}
