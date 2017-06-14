package chess;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Knight extends Piece {
	
	public Knight(Player color, int initialRank, int initialFile) {
		super(color, initialRank, initialFile);
		try {
		    if (super.getColor().isWhite()) {
		    	super.setImage(ImageIO.read(new File("piece_images/WhiteKnight-min.png")));
		    } else {
		    	super.setImage(ImageIO.read(new File("piece_images/BlackKnight-min.png")));
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
		return super.getColor() + " Knight";
	}

	@Override
	public void draw() {
		
		//img = (BufferedImage) img.getScaledInstance(img.getWidth()/40, img.getHeight(), Image.SCALE_FAST);
	}

}
