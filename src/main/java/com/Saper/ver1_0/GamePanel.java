package com.Saper.ver1_0;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	int nr = 1; //nr przycisku w celu indentyfikacji
	
	public GamePanel() {
		
		
		
		setLayout(new GridLayout(10, 10));
		playGame();
		
//		bombButton.addActionListener(new ActionListener() {
//
////			@Override
//			public void actionPerformed(ActionEvent e) {
//
//			}
//
//		});
	}


private void playGame() {
	
	for (int i = 0 ; i < 10 ; i++) {					//pion
		for (int j = 0 ; j < 10 ; j++) {				//poziom
			add(new JButton());
		}
	}
}




@Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}
}
