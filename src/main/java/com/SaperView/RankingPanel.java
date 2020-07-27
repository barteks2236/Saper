package com.SaperView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import com.SaperController.*;

public class RankingPanel extends JPanel {
	
	public RankingPanel() {
		
		Controller.rankingFrame.setUndecorated(true);
		setLayout(null);
		setBackground(Color.BLACK);
		
		JLabel title = new JLabel("TABLICA BOHATERÓW");
		title.setBounds(35, 20, 380, 50);
		title.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		title.setForeground(new Color(226, 226, 0));
		add(title);
		
		GamePanelEasy.scoreAreaEasy.setBounds(80, 80, 290, 300);
		GamePanelEasy.scoreAreaEasy.setEditable(false);
		add(GamePanelEasy.scoreAreaEasy);
		
		Controller.universalButton(GamePanelEasy.downloadButtonEasy, 400, 80, 150, 50, "EASY");
		add(GamePanelEasy.downloadButtonEasy);
		
		GamePanelMedium.scoreAreaMedium.setBounds(80, 80, 290, 300);
		GamePanelMedium.scoreAreaMedium.setEditable(false);
		add(GamePanelMedium.scoreAreaMedium);
		
		Controller.universalButton(GamePanelMedium.downloadButtonMedium, 400, 140, 150, 50, "MEDIUM");
		add(GamePanelMedium.downloadButtonMedium);
		
		GamePanelHard.scoreAreaHard.setBounds(80, 80, 290, 300);
		GamePanelHard.scoreAreaHard.setEditable(false);
		add(GamePanelHard.scoreAreaHard);
		
		Controller.universalButton(GamePanelHard.downloadButtonHard, 400, 200, 150, 50, "HARD");
		add(GamePanelHard.downloadButtonHard);
		
		
		JButton back = new JButton();
		Controller.universalButton(back, 400, 330, 150, 50, "ZAMKNIJ");
		add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GamePanelEasy.scoreAreaEasy.setText("");
				GamePanelMedium.scoreAreaMedium.setText("");
				Controller.rankingFrame.dispose();
				
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
		return new Dimension(570, 400);
	}	
}