package com.SaperMVC.ver2;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import SaperMVC.SaperView;

public class Main {

	public static void main(String[] args) {
//		JFrame gameArea = new JFrame("Saper/Mines");
//		SaperView gamePanel = new SaperView();
//
//		gameArea.add(gamePanel);
//		gameArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		gameArea.setVisible(true);
//		gameArea.pack();
//		gameArea.add(SaperView.kontenerBomb,BorderLayout.CENTER);   
//	                         //calling function to start the game by filling mines.
//
//	    gameArea.setLocationRelativeTo(null);      
//	    gameArea.setVisible(true);

        WidokSaper.saperRamka.setSize(900,900);                       
        WidokSaper.saperRamka.setResizable(false);
        
//		WidokSaper.setIconImage(bomb.getImage("C:\\Users\\Bartosz\\Desktop\\bomb.jpg"));
        WidokSaper.saperRamka.setLayout(new BorderLayout());           
        WidokSaper.saperRamka.add(WidokSaper.guziki,BorderLayout.SOUTH);     
        
		
		
		
		
		
		
		
		
		
		new WidokSaper(5);
	}

}
