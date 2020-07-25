package com.SaperView;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import com.SaperController.*;

public class GamePanelEasy extends JPanel {
	
	private int zegarX = 650;
	private int zegarY = 510;										 
	public long sekunda = 0;
	public int ustawionyCzas = 30;
	
	public GamePanelEasy() {
		
		GameController.setRozmiarX(7);
		GameController.setRozmiarY(6);
	
		setLayout(null);
		
		JButton poddajeSie = new JButton("PODDAJÊ SIÊ");
		Controller.buttons(poddajeSie, 650, 330);
		add(poddajeSie);
		poddajeSie.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				GameController.przegrana = true;
				GameController.statusGry = true;
				JOptionPane.showMessageDialog(null, "Jesteœ w kawa³kach! :( ", "Podda³eœ siê!", 
						JOptionPane.INFORMATION_MESSAGE);
			
				GameController.statusGry = false;
			}
		});
		
		JButton reset = new JButton("RESTART");
		Controller.buttons(reset, 650, 420);
		add(reset);
		reset.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				GameController.przegrana = false;
				GameController.wygrana = false;
				GameController.clock = new Date();
				GameController.oflagowany=false;
				GameController.rozgrywka();

			}
		});
		
		JButton back = new JButton();
		Controller.backButton(back, 10, 555);
		add(back);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		for (int x = 0; x < GameController.getRozmiarX(); x++) {
			for (int y = 0; y < GameController.getRozmiarY(); y++) {
				g.setColor(Color.gray);
				
				if (GameController.bomby[x][y] == 1)
					g.setColor(Color.yellow);		//Podœwietlenie bomb na ¿ó³to				
				
				if (GameController.rozbrojone[x][y] == true) {
					g.setColor(Color.WHITE);
					if (GameController.bomby[x][y] == 1)
						g.setColor(Color.red);	
				}

				if (GameController.mojX >= GameController.s + x * 90 && GameController.mojX < x * 90 + 90 - GameController.s && GameController.mojY >= GameController.s + y * 90 && GameController.mojY < y * 90 + 90 - GameController.s)
					g.setColor(Color.lightGray);
				
				g.fillRect(GameController.s + x * 90, GameController.s + y * 90, 90 - 2 * GameController.s, 90 - 2 * GameController.s);
				
				if (GameController.rozbrojone[x][y] == true) {
					g.setColor(Color.black);

					if (GameController.bomby[x][y] == 0 && GameController.wPoblizu[x][y] != 0) {
						g.setFont(new Font("Arial", Font.BOLD, 35));
						g.drawString(Integer.toString(GameController.wPoblizu[x][y]), x * 90 + 36, y * 90 + 57);
					} 
					else if (GameController.bomby[x][y] == 1) {
						g.fillRect(GameController.s + x * 90 + 36, GameController.s + y * 90 + 26, 10, 30);
						g.fillRect(GameController.s + x * 90 + 26, GameController.s + y * 90 + 36, 30, 10);
						g.fillRect(GameController.s + x * 90 + 31, GameController.s + y * 90 + 31, 20, 20);
					}
				}
				
				// dodanie flagi
				if (GameController.oznaczone[x][y]==true) {
					g.setColor(Color.orange);
					g.fillRect(x * 90+35, y * 90+15, 15, 60); // Kijek
					g.setColor(Color.red);
					g.fillRect(x * 90+5, y * 90+15, 30, 25); // Flaga	
				}
			repaint();
			}
		}
	
// Czas
		g.setColor(Color.BLACK);
		g.fillRect(zegarX, zegarY, 180, 80);
		
		if (GameController.przegrana == false && GameController.wygrana == false )
			sekunda = ustawionyCzas - ((new Date().getTime() - GameController.clock.getTime()) / 1000);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 90));
		g.drawString(Integer.toString((int) sekunda), zegarX + 20, zegarY + 70);
		
		if (sekunda <= 15) {
			g.setColor(Color.red);
			g.setFont(new Font("Arial", Font.BOLD, 90));
			g.drawString(Integer.toString((int) sekunda), zegarX + 20, zegarY + 70);
		}
		
		if (sekunda==0) 
			GameController.przegrana = true;		// Jesli czas sie skonczy, przgrywamy
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(850, 600);
	}
}