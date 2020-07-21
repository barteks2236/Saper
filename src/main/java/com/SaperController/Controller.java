package com.SaperController;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Controller {
	
	public static void buttons(JButton b, int x, int y) {
		b.setBounds(x, y, 200, 80);
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
	
	
	public static Clip bomb;
	public static long bombTimePosition;
	public static String pathBombSiren = "D:\\Eclipse Workspace\\Saper\\src\\main\\resources\\BombSiren.wav";
	public static void music(String path) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
			bomb = AudioSystem.getClip();
			bomb.open(ais);
			bomb.start();
			bomb.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Clip explode;
	public static String pathExplodeSound = "D:\\Eclipse Workspace\\Saper\\src\\main\\resources\\ExplodeSound.wav";
	public static void effects(String path) {
		try {
			AudioInputStream ais2 = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
			explode = AudioSystem.getClip();
			explode.open(ais2);
			explode.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
