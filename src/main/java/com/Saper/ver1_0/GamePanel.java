package com.Saper.ver1_0;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	public GamePanel() {

		setLayout(new GridLayout(2,6));

		JButton bombButton = new JButton();
		bombButton.setBounds(100, 100, 50, 50);
		for (int i=0 ; i<2 ; i++) {
			for (int j=0 ; j<2 ; j++) {
				add(new JButton(""+ (j+1)));
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
		return new Dimension(800, 800);
	}
}
