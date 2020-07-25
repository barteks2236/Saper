package com.SaperView;

import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.Clip;
import javax.swing.*;
import com.SaperController.*;

public class OptionsPanel extends JPanel {
	
	public static JRadioButton switchOn2;
	public static JRadioButton switchOff2;
		
	public OptionsPanel() {
		
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
		
		JButton back = new JButton();
		Controller.backButton(back, 480, 440);
		add(back);
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Controller.switchPanels(Controller.optionsPanel, Controller.startPanel);
				if(switchOff2.isSelected()) {
					MusicController.explode.stop();
				}else {
					MusicController.effects(MusicController.pathExplodeSound);
					MusicController.explode.start();
				}
			}
		});
		
		JLabel soundEffects = new JLabel("DŸwiêk");
		soundEffects.setBounds(250, 150, 100, 60);
		soundEffects.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		soundEffects.setForeground(new Color(226, 226, 0));
		add(soundEffects);
		
		final JRadioButton switchOn = new JRadioButton("W³¹cz");
		Controller.radioButton(switchOn, 210, 225);
		add(switchOn);
		switchOn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MusicController.bomb.start();
				MusicController.bomb.loop(Clip.LOOP_CONTINUOUSLY);
			}
		});
		
		final JRadioButton switchOff = new JRadioButton("Wy³¹cz");
		Controller.radioButton(switchOff, 310, 225);
		add(switchOff);
		switchOff.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MusicController.bomb.stop();	
			}
		});
		
		final ButtonGroup switches = new ButtonGroup();
		switches.add(switchOn);
		switches.add(switchOff);
		
		JLabel gameEffects = new JLabel("DŸwiêki gry");
		gameEffects.setBounds(225, 250, 150, 60);
		gameEffects.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		gameEffects.setForeground(new Color(226, 226, 0));
		add(gameEffects);
		
		switchOn2 = new JRadioButton("W³¹cz");
		Controller.radioButton(switchOn2, 210, 325);
		add(switchOn2);

		switchOff2 = new JRadioButton("Wy³¹cz");
		Controller.radioButton(switchOff2, 310, 325);
		add(switchOff2);
		
		final ButtonGroup switches2 = new ButtonGroup();
		switches2.add(switchOn2);
		switches2.add(switchOff2);
				
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 500);
	}
}