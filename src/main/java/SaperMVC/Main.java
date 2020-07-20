package SaperMVC;

import java.awt.event.MouseListener;

import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		
		JFrame gameArea = new JFrame("Saper/Mines");
		SaperView gamePanel = new SaperView();

		gameArea.add(gamePanel);
		gameArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameArea.setVisible(true);
		gameArea.pack();


	}

}
