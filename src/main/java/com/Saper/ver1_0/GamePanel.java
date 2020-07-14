package com.Saper.ver1_0;

import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	public GamePanel() {

	}
	
//  Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 800);
	}
}
