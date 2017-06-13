package chess;

import java.awt.image.BufferedImage;

public abstract class Piece {
	
	private final Player color;
	private final int initialRank, initialFile;
	private int currentRank, currentFile;
	private BufferedImage img;
	
	public Piece(Player color, int initialRank, int initialFile) {
		this.color = color;
		this.initialRank = initialRank;
		this.initialFile = initialFile;
		currentRank = initialRank;
		currentFile = initialFile;
	}

	public Player getColor() {
		return color;
	}
	
	public int getInitialRank() {
		return initialRank;
	}
	
	public int getInitialFile() {
		return initialFile;
	}
	
	public int getCurrentRank() {
		return currentRank;
	}
	
	public int getCurrentFile() {
		return currentFile;
	}
	
	public void move(int currentRank, int currentFile) { 
		this.currentRank = currentRank;
		this.currentFile = currentFile;
	}
	
	public void setImage(BufferedImage img) {
		this.img = img;
	}
	
	public BufferedImage getImage() {
		return img;
	}
	
	public abstract void draw();

}
