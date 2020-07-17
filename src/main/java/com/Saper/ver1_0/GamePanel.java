package com.Saper.ver1_0;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

	int nr = 1; //nr przycisku w celu indentyfikacji
	
	public GamePanel() {

		setLayout(new GridLayout(4,4));

		JButton bombButton = new JButton();
		bombButton.setBounds(100, 100, 50, 50);
		for (int i=1 ; i<=4 ; i++) {				//pion
			for (int j=1 ; j<=4 ; j++) {			//poziom
				add(new JButton(""+ (nr++)));		//nr przycisku w celach testowych
			
			
			
			}
		}
//		JButton bombButton = new JButton();
//		bombButton.setBounds(100, 100, 50, 50);
//		setVisible(true);
//		bombButton.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("klikbutton");
//			}
//
//		});
		
//		JMenuBar pasekMenu = new JMenuBar();
//		JMenu menuGra = pasekMenu.add(new JMenu("Gra"));
//		add(pasekMenu);
		


		
			addMouseListener(new MouseListener() {

				public void mouseClicked(MouseEvent e) {
					System.out.println("test");
					
				}

				public void mouseEntered(MouseEvent e) {
					
					
				}

				public void mouseExited(MouseEvent e) {
					
					
				}

				public void mousePressed(MouseEvent e) {
					
					
				}

				public void mouseReleased(MouseEvent e) {
					
					
				}
			});
		
		
		
	}



	//  Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}
}
