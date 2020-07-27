package com.SaperView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.SaperController.*;

public class LevelPanel extends JPanel{
	
	public LevelPanel() {
		
		setLayout(null);
		setBackground(Color.BLACK);

		JLabel lbl = new JLabel("");
		ImageIcon bomb = new ImageIcon(this.getClass().getResource("/sign.gif"));
		lbl.setIcon(bomb);
		lbl.setBounds(20, 20, 100, 100);
		add(lbl);
		
		JLabel lbl2 = new JLabel("");
		lbl2.setIcon(bomb);
		lbl2.setBounds(480, 20, 100, 100);
		add(lbl2);
		
		JLabel title = new JLabel("Saper");
		title.setBounds(150, 0, 300, 130);
		title.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 90));
		title.setForeground(new Color(226, 226, 0));
		add(title);
		
		JButton easy = new JButton("EASY");
		Controller.buttons(easy, 200, 200);
		add(easy);
		easy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameController.ramkaGry(Controller.easyFrame, RunController.gamePanelEasy);
				Controller.frame(Controller.easyFrame, "SAPER Game of the Year Edition");
				Controller.gameArea.setVisible(false);
				MusicController.bomb.close();
				Controller.easyFrame.addWindowListener(new WindowAdapter() {
					public void windowOpened(WindowEvent event) {
						MusicController.easyMusic.setMicrosecondPosition(0);
						MusicController.easyMusicTimePosition = 0;
						MusicController.easyMusic.start();
					}
					
					public void windowIconified(WindowEvent event) {
						MusicController.easyMusicTimePosition = MusicController.easyMusic.getMicrosecondPosition();
						MusicController.easyMusic.stop();	
					}
					
					public void windowDeiconified(WindowEvent event) {
						MusicController.easyMusic.setMicrosecondPosition(MusicController.easyMusicTimePosition);
						MusicController.easyMusic.start();
					}
				});	
							
				if(OptionsPanel.switchOff.isSelected())
					MusicController.easyMusic.stop();
				else {
					MusicController.musicLevelEasy(MusicController.pathEasyMusic);
					MusicController.easyMusic.start();
				}
				
				if(OptionsPanel.switchOff2.isSelected())
					MusicController.explode.stop();
				else {
					MusicController.effects(MusicController.pathExplodeSound);
					MusicController.explode.start();
				}	
			}
		});
		
		JButton medium = new JButton("MEDIUM");
		Controller.buttons(medium, 200, 300);
		add(medium);
		medium.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				GameController.ramkaGry(Controller.mediumFrame, RunController.gamePanelMedium);
				Controller.frame(Controller.mediumFrame, "SAPER Game of the Year Edition");
				MusicController.bomb.close();
				Controller.gameArea.setVisible(false);
				Controller.mediumFrame.addWindowListener(new WindowAdapter() {
					public void windowOpened(WindowEvent event) {
						MusicController.mediumMusic.setMicrosecondPosition(0);
						MusicController.mediumMusicTimePosition = 0;
						MusicController.mediumMusic.start();
					}
					
					public void windowIconified(WindowEvent event) {
						MusicController.mediumMusicTimePosition = MusicController.mediumMusic.getMicrosecondPosition();
						MusicController.mediumMusic.stop();	
					}
					
					public void windowDeiconified(WindowEvent event) {
						MusicController.mediumMusic.setMicrosecondPosition(MusicController.mediumMusicTimePosition);
						MusicController.mediumMusic.start();
					}
				});	
				
				if(OptionsPanel.switchOff.isSelected()) {
					MusicController.musicLevelMedium(MusicController.pathMediumMusic);
					MusicController.mediumMusic.stop();
				}else {
					MusicController.musicLevelMedium(MusicController.pathMediumMusic);
					MusicController.mediumMusic.start();
				}
				
				if(OptionsPanel.switchOff2.isSelected())
					MusicController.explode.stop();
				else {
					MusicController.effects(MusicController.pathExplodeSound);
					MusicController.explode.start();
				}	
			}
		});
		
		
		JButton hard = new JButton("HARD");
		Controller.buttons(hard, 200, 400);
		add(hard);
		hard.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				GameController.ramkaGry(Controller.hardFrame, RunController.gamePanelHard);
				Controller.frame(Controller.hardFrame, "SAPER Game of the Year Edition");
				Controller.gameArea.setVisible(false);
				
				if(OptionsPanel.switchOff2.isSelected())
					MusicController.explode.stop();
				else {
					MusicController.effects(MusicController.pathExplodeSound);
					MusicController.explode.start();
				}	
			}
		});
		
		JButton back = new JButton();
		Controller.backButton(back, 480, 440);
		add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.switchPanels(Controller.levelPanel, Controller.startPanel);
				if(OptionsPanel.switchOff2.isSelected())
					MusicController.explode.stop();
				else {
					MusicController.effects(MusicController.pathExplodeSound);
					MusicController.explode.start();
				}
			}
		});	
	}
}