package com.Saper.ver1_0;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	int nr = 1; //nr przycisku w celu indentyfikacji
	
	public GamePanel() {

		setLayout(new GridLayout(4,4));

		JButton bombButton = new JButton();
		bombButton.setBounds(100, 100, 50, 50);
		for (int i=1 ; i<=4 ; i++) {					//pion
			for (int j=1 ; j<=4 ; j++) {				//poziom
				add(new JButton(""+ (nr++)));		//nr przycisku w celach testowych
			}
		}
		setVisible(true);
//		bombButton.addActionListener(new ActionListener() {
//
////			@Override
//			public void actionPerformed(ActionEvent e) {
//
//			}
//
//		});



	}

//  Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}
}
