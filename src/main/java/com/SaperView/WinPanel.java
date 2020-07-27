package com.SaperView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;
import com.SaperController.*;

public class WinPanel extends JPanel {
	
	public WinPanel() {
		
		Controller.winFrame.setUndecorated(true);
		setLayout(null);
		setBackground(Color.BLACK);
		
		JLabel title = new JLabel("MISJA WYKONANA!");
		title.setBounds(60, 20, 330, 50);
		title.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		title.setForeground(new Color(226, 226, 0));
		add(title);
		
		JLabel lbl = new JLabel("Prze¿y³eœ tym razem!");
		lbl.setBounds(65, 70, 320, 50);
		lbl.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 25));
		lbl.setForeground(new Color(226, 226, 0));
		add(lbl);
		
		JLabel lbl2 = new JLabel("Wpisz siê na tablicê bohaterów!");
		lbl2.setBounds(45, 120, 360, 50);
		lbl2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		lbl2.setForeground(new Color(226, 226, 0));
		add(lbl2);
		
		final JTextField name = new JTextField();
		name.setBounds(75, 180, 300, 30);
		name.setBackground(new Color(226, 226, 0));
		add(name);
		
		JLabel lbl3 = new JLabel("Zapisz do rankingu dla levelu:");
		lbl3.setBounds(55, 230, 340, 50);
		lbl3.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		lbl3.setForeground(new Color(226, 226, 0));
		add(lbl3);
		
		JButton easyRanking = new JButton();
		Controller.universalButton(easyRanking, 45, 290, 100, 50, "EASY");
		add(easyRanking);
		easyRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Executor.query("INSERT INTO RANKING_EASY (NAME_EASY, SCORE_EASY) VALUES ('" + name.getText() + "', " + GameController.wynik + ")");
				name.setText("");
				GamePanelEasy.scoreAreaEasy.setText("");
				GameController.przegrana = false;
				GameController.wygrana = false;
				GameController.clock = new Date();
				GameController.rozgrywka();
				Controller.winFrame.dispose();
				
				if(OptionsPanel.switchOff2.isSelected())
					MusicController.explode.stop();
				else {
					MusicController.effects(MusicController.pathExplodeSound);
					MusicController.explode.start();
				}
			}
		});
		
		JButton mediumRanking = new JButton();
		Controller.universalButton(mediumRanking, 150, 290, 150, 50, "MEDIUM");
		add(mediumRanking);
		mediumRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Executor.query("INSERT INTO RANKING_MEDIUM (NAME_MEDIUM, SCORE_MEDIUM) VALUES ('" + name.getText() + "', " + GameController.wynik + ")");
				name.setText("");
				GamePanelMedium.scoreAreaMedium.setText("");
				GameController.przegrana = false;
				GameController.wygrana = false;
				GameController.clock = new Date();
				GameController.rozgrywka();
				Controller.winFrame.dispose();
				
				if(OptionsPanel.switchOff2.isSelected())
					MusicController.explode.stop();
				else {
					MusicController.effects(MusicController.pathExplodeSound);
					MusicController.explode.start();
				}
			}
		});
		
		JButton hardRanking = new JButton();
		Controller.universalButton(hardRanking, 305, 290, 100, 50, "HARD");
		add(hardRanking);
		hardRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Executor.query("INSERT INTO RANKING_HARD (NAME_HARD, SCORE_HARD) VALUES ('" + name.getText() + "', " + GameController.wynik + ")");
				name.setText("");
				GamePanelHard.scoreAreaHard.setText("");
				GameController.przegrana = false;
				GameController.wygrana = false;
				GameController.clock = new Date();
				GameController.rozgrywka();
				Controller.winFrame.dispose();
				
				if(OptionsPanel.switchOff2.isSelected())
					MusicController.explode.stop();
				else {
					MusicController.effects(MusicController.pathExplodeSound);
					MusicController.explode.start();
				}
			}
		});	
		
		JButton noSave = new JButton();
		Controller.universalButton(noSave, 45, 350, 360, 50, "NIE ZAPISUJ WYNIKU");
		add(noSave);
		noSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameController.przegrana = false;
				GameController.wygrana = false;
				GameController.clock = new Date();
				GameController.rozgrywka();
				Controller.winFrame.dispose();
				
				if(OptionsPanel.switchOff2.isSelected())
					MusicController.explode.stop();
				else {
					MusicController.effects(MusicController.pathExplodeSound);
					MusicController.explode.start();
				}	
			}
		});	
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(450, 430);
	}	
}