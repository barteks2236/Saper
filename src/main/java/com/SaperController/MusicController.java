package com.SaperController;

import javax.sound.sampled.*;
import java.io.File;

public class MusicController {
	
	public static Clip bomb;
	public static long bombTimePosition;
	public static String pathBombSiren = "D:\\Eclipse Workspace\\Saper\\src\\main\\resources\\BombSiren.wav";
	
	public static Clip explode;
	public static String pathExplodeSound = "D:\\Eclipse Workspace\\Saper\\src\\main\\resources\\ExplodeSound.wav";
	
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