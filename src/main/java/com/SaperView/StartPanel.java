package com.SaperView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.SaperController.Controller;
import SaperMVC.Main;

public class StartPanel extends JPanel{
	
	public StartPanel() {
		
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
		
		JButton start = new JButton("START");
		Controller.buttons(start, 200, 200);
		add(start);
		start.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(OptionsPanel.switchOff2.isSelected()) {
					Controller.explode.stop();
				}else {
					Controller.effects(Controller.pathExplodeSound);
					Controller.explode.start();
				}	
			}
		});
		
		JButton options = new JButton("OPCJE");
		Controller.buttons(options, 200, 300);
		add(options);
		options.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Main.switchPanels(Main.startPanel, Main.optionsPanel);
				if(OptionsPanel.switchOff2.isSelected()) {
					Controller.explode.stop();
				}else {
					Controller.effects(Controller.pathExplodeSound);
					Controller.explode.start();
				}	
			}
		});
		
	}
	

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 500);
	}
}
