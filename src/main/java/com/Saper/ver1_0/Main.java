package com.Saper.ver1_0;

import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {


		JFrame gameArea = new JFrame("Saper/Mines");
		GamePanel gamePanel = new GamePanel();

		gameArea.add(gamePanel);
		gameArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameArea.setVisible(true);
		gameArea.pack();
	


	}

}
