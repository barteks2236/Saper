package com.Saper.ver1_0;

import java.awt.Component;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Main {

	private static final Component GameMouse = null;

	public static void main(String[] args) {

		
		JFrame gameArea = new JFrame("Saper/Mines");
		//GamePanel gamePanel = new GamePanel();
		
		
		//gameArea.add(gamePanel);
		gameArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameArea.setVisible(true);
		gameArea.pack();
		//gamePanel.addMouseListener((MouseListener) GameMouse);


	}

}
