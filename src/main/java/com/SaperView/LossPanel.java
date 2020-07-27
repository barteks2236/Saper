package com.SaperView;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import com.SaperController.*;

public class LossPanel extends JPanel{
	
	public LossPanel() {
		
		Controller.lossFrame.setUndecorated(true);
		setLayout(null);
		setBackground(Color.BLACK);
		
		JLabel infoLbl = new JLabel("Jesteœ w kawa³kach!");
		infoLbl.setBounds(25, 20, 350, 60);
		infoLbl.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		infoLbl.setForeground(new Color(226, 226, 0));
		add(infoLbl);
		
		JButton reset = new JButton();
		Controller.universalButton(reset, 125, 100, 150, 50, "RESTART");
		add(reset);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameController.przegrana = false;
				GameController.wygrana = false;
				GameController.clock = new Date();
				GameController.rozgrywka();
				Controller.lossFrame.dispose();
			}
		});
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 200);
	}	
}