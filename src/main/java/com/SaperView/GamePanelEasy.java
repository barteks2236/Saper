package com.SaperView;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import com.SaperController.*;
import com.SaperModel.PlayerDataEasy;

public class GamePanelEasy extends JPanel {
	
	private int zegarX = 650;
	private int zegarY = 510;										 
	private int ustawionyCzas = 90;
	public static JButton flagMode = new JButton();
	public static JTextArea scoreAreaEasy = new JTextArea();
	public static JButton downloadButtonEasy = new JButton();

	public GamePanelEasy() {
		setLayout(null);
		
		flagMode.setBounds(650, 240, 200, 80);
		flagMode.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC,15));
		flagMode.setText("FLAG MODE OFF");
		flagMode.setBackground(Color.RED);
		flagMode.setBorderPainted(false);
		add(flagMode);
		
		JButton ranking = new JButton("RANKING");
		Controller.buttons(ranking, 650, 330);
		add(ranking);
		ranking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.rankingFrame.add(Controller.rankingPanel);
				Controller.frame(Controller.rankingFrame, "RANKING");
				downloadButtonEasy.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						scoreAreaEasy.setText("");
						Executor.resultEasy();	
					}
				});
			
				if(OptionsPanel.switchOff2.isSelected())
					MusicController.explode.stop();
				else {
					MusicController.effects(MusicController.pathExplodeSound);
					MusicController.explode.start();
				}
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
				GameController.rozgrywka();
				
				if(OptionsPanel.switchOff2.isSelected())
					MusicController.explode.stop();
				else {
					MusicController.effects(MusicController.pathExplodeSound);
					MusicController.explode.start();
				}
			}
		});
		
		JButton back = new JButton();
		Controller.backButton(back, 10, 555);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Controller.easyFrame.dispose();
				Controller.gameArea.setVisible(true);
				Controller.gameArea.add(Controller.levelPanel);
				MusicController.easyMusic.stop();
				
				if(OptionsPanel.switchOff.isSelected())
					MusicController.bomb.stop();
				else {
					MusicController.music(MusicController.pathBombSiren);
					MusicController.bomb.start();
				}
				
				if(OptionsPanel.switchOff2.isSelected())
					MusicController.explode.stop();
				else {
					MusicController.effects(MusicController.pathExplodeSound);
					MusicController.explode.start();
				}
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		GameController.setSizeSquare(90);
		GameController.setRozmiarX(7);
		GameController.setRozmiarY(6);
		for (int x = 0; x < GameController.getRozmiarX(); x++) {
			for (int y = 0; y < GameController.getRozmiarY(); y++) {
				g.setColor(Color.gray);
				
//				if (GameController.bomby[x][y] == 1)
//					g.setColor(Color.yellow);		//Podœwietlenie bomb na ¿ó³to				
				
				if (GameController.rozbrojone[x][y] == true) {
					g.setColor(Color.WHITE);
					if (GameController.bomby[x][y] == 1)
						g.setColor(Color.red);	
				}

				if (GameController.mojX >= GameController.s + x * GameController.getSizeSquare() && GameController.mojX < x * GameController.getSizeSquare() + GameController.getSizeSquare() - GameController.s && GameController.mojY >= GameController.s + y * GameController.getSizeSquare() && GameController.mojY < y * GameController.getSizeSquare() + GameController.getSizeSquare() - GameController.s)
					g.setColor(Color.lightGray);
				
				g.fillRect(GameController.s + x * GameController.getSizeSquare(), GameController.s + y * GameController.getSizeSquare(), GameController.getSizeSquare() - 2 * GameController.s, GameController.getSizeSquare() - 2 * GameController.s);
				
				if (GameController.rozbrojone[x][y] == true) {
					g.setColor(Color.black);

					if (GameController.bomby[x][y] == 0 && GameController.wPoblizu[x][y] != 0) {
						g.setFont(new Font("Arial", Font.BOLD, 35));
						g.drawString(Integer.toString(GameController.wPoblizu[x][y]), x * GameController.getSizeSquare() + 36, y * GameController.getSizeSquare() + 57);
					} 
					else if (GameController.bomby[x][y] == 1) {
						g.fillRect(GameController.s + x * GameController.getSizeSquare() + 36, GameController.s + y * GameController.getSizeSquare() + 26, 10, 30);
						g.fillRect(GameController.s + x * GameController.getSizeSquare() + 26, GameController.s + y * GameController.getSizeSquare() + 36, 30, 10);
						g.fillRect(GameController.s + x * GameController.getSizeSquare() + 31, GameController.s + y * GameController.getSizeSquare() + 31, 20, 20);
					}
				}
				
				// dodanie flagi
				if (GameController.oznaczone[x][y]==true) {
					g.setColor(Color.DARK_GRAY);
					g.fillRect(x * GameController.getSizeSquare()+50, y * GameController.getSizeSquare()+15, 10, 60); // Kijek
					g.setColor(Color.red);
					g.fillRect(x * GameController.getSizeSquare()+20, y * GameController.getSizeSquare()+15, 30, 25); // Flaga
					g.fillRect(x * GameController.getSizeSquare()+10, y * GameController.getSizeSquare()+15, 35, 10);
					g.setColor(Color.BLACK);
					g.fillRect(x * GameController.getSizeSquare()+25, y * GameController.getSizeSquare()+70, 55, 5);
				}
			GameController.podpowiedzi(x, y, g);
			}
		}
	
// Czas
		g.setColor(Color.BLACK);
		g.fillRect(zegarX, zegarY, 180, 80);
		
		if (GameController.przegrana == false && GameController.wygrana == false ) {
			GameController.sekunda = ustawionyCzas - ((new Date().getTime() - GameController.clock.getTime()) / 1000);
		}
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 90));
		g.drawString(Integer.toString((int) GameController.sekunda), zegarX + 20, zegarY + 70);
		
		if (GameController.sekunda <= 15) {
			g.setColor(Color.red);
			g.setFont(new Font("Arial", Font.BOLD, 90));
			g.drawString(Integer.toString((int) GameController.sekunda), zegarX + 20, zegarY + 70);
		}
	
		if (GameController.sekunda == 0) 
			GameController.przegrana = true;		// Jesli czas sie skonczy, przgrywamy
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(850, 600);
	}	
}