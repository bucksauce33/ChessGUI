package chess;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Test {

	public static void main(String[] args) {
		
		//Game chess = new Game();
		//chess.printBoard();
		
		// java - get screen size using the Toolkit class
		
//		System.out.println(screenSize.getHeight());
//		System.out.println(screenSize.getWidth());
//		double x = 1366.0 / 768;
//		System.out.println(x);
//		double y = 16 / 9.0;
//		System.out.println(y);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double smallerDimension;
		if (screenSize.getWidth() < screenSize.getHeight()) {
			smallerDimension = screenSize.getWidth();
		} else {
			smallerDimension = screenSize.getHeight();
		}
		

	}

}
