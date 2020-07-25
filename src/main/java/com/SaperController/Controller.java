package com.SaperController;

import java.awt.*;
import javax.swing.*;
import com.SaperView.*;

public class Controller {
	
	public static JFrame gameArea = new JFrame("SAPER Game of the Year Edition");
	public static JFrame easyFrame = new JFrame("SAPER Game of the Year Edition");
	public static StartPanel startPanel = new StartPanel();
	public static OptionsPanel optionsPanel = new OptionsPanel();
	public static LevelPanel levelPanel = new LevelPanel();
	public static GamePanelEasy gamePanelEasy = new GamePanelEasy();
	
	public static void frame(JFrame f) {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		f.pack();
		f.setLocationRelativeTo(null);
		ImageIcon icon = new ImageIcon("D:\\Eclipse Workspace\\Saper\\src\\main\\resources\\icon.png");
		f.setIconImage(icon.getImage());	
	}
	
	public static void switchPanels(JPanel panel1, JPanel panel2) {
		panel1.setVisible(false);
		panel2.setVisible(true);
		gameArea.add(panel2);
	}
	
	public static void buttons(JButton b, int x, int y) {
		b.setBounds(x, y, 200, 80);
		b.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC,20));
		b.setBackground(new Color(226, 226, 0));
		b.setBorderPainted(false);	
	}
	
	public static void backButton(JButton b, int x, int y) {
		b.setText("MENU");
		b.setBounds(x, y, 100, 40);
		b.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC,20));
		b.setBackground(new Color(226, 226, 0));
		b.setBorderPainted(false);
		
	}
	
	public static void radioButton(JRadioButton rb, int x, int y) {
		rb.setBounds(x, y, 80, 20);
		rb.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		rb.setForeground(new Color(226, 226, 0));
		rb.setBackground(Color.BLACK);	
	}
}