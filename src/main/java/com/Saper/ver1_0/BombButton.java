package com.Saper.ver1_0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BombButton extends JPanel {

	BombButton(int i) {
		JButton bombButton = new JButton();
		bombButton.setBounds(100, 100, 50, 50);
		add(bombButton);
		bombButton.addActionListener(new ActionListener() {

//			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});
	}
}
