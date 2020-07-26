package com.SaperModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.Saper.ver3.*;
import com.SaperView.StartPanel;

import SaperMVC.MainMVC;

public class DaneGracza extends JFrame{

	public DaneGracza() {
	this.setSize(420, 220);
	this.setTitle("Podaj sw¹ godnoœc Bohaterze");
	this.setVisible(true);
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setResizable(true);
	this.repaint();
	}
	
	
	public static class OknoPodajImie extends JPanel {
		public static OknoPodajImie podajNazwe = new OknoPodajImie();
		public static int wynik=0;
		public static String imie = " ";
		
		public OknoPodajImie() {
			this.setLayout(null);
			
			JLabel imieLabel = new JLabel("Podaj swoj¹ Nazwê: ");
			imieLabel.setBounds(10, 40, 130, 25);
			add(imieLabel);
			
			final JTextField imieText = new JTextField();
			imieText.setBounds(145, 40, 200, 25);
			add(imieText);
			
			JButton zapisz = new JButton("Zapisz");
			zapisz.setBounds(130, 100, 120,40);
			add(zapisz);
			zapisz.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					imie = imieText.getText();
//					wynik = (int)RamkaGry.sekunda;

					MainMVC.ranking.add(imie + " z czasem: " + wynik);
					MainMVC.daneGracza.setVisible(false);
					
					MainMVC.gameArea.setVisible(true);
			//		MainMVC.gameArea.add(MainMVC.startPanel);
					System.out.println(MainMVC.ranking);	// Podglad rankingu w tablicy
					
					
				}

			});
}
		
	}
}
