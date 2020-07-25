package com.SaperView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.Saper.ver3.Main;
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
				new GameController().ramkaGry(Controller.easyFrame, Controller.gamePanelEasy);
				Controller.frame(Controller.easyFrame);
				
				MusicController.bomb.close();
				Controller.gameArea.dispose();
				if(OptionsPanel.switchOff2.isSelected()) {
					MusicController.explode.stop();
				}else {
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
				new Thread(new Main()).start();
				Controller.gameArea.dispose();
				if(OptionsPanel.switchOff2.isSelected()) {
					MusicController.explode.stop();
				}else {
					MusicController.effects(MusicController.pathExplodeSound);
					MusicController.explode.start();
				}	
			}
		});
		
		
		JButton hard = new JButton("HARD");
		Controller.buttons(hard, 200, 400);
		add(hard);
		
		JButton back = new JButton("Menu");
		Controller.backButton(back, 480, 440);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Controller.switchPanels(Controller.levelPanel, Controller.startPanel);
				if(OptionsPanel.switchOff2.isSelected()) {
					MusicController.explode.stop();
				}else {
					MusicController.effects(MusicController.pathExplodeSound);
					MusicController.explode.start();
				}
			}
		});
		
	}
}