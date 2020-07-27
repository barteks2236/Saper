package com.SaperController;

import javax.sound.sampled.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class MusicController {
	
	public static Clip bomb;
	public static long bombTimePosition;
	public static String pathBombSiren = "D:\\Google Drive\\IT\\Java_CS_4\\Eclipse_workspace\\Saper\\src\\main\\resources\\BombSiren.wav";
	
	public static Clip easyMusic;
	public static long easyMusicTimePosition;
	public static String pathEasyMusic = "D:\\Google Drive\\IT\\Java_CS_4\\Eclipse_workspace\\Saper\\src\\main\\resources\\levelEasyMusic.wav";
	
	public static Clip mediumMusic;
	public static long mediumMusicTimePosition;
	public static String pathMediumMusic = "D:\\Google Drive\\IT\\Java_CS_4\\Eclipse_workspace\\Saper\\src\\main\\resources\\levelMediumMusic.wav";
	
	public static Clip explode;
	public static String pathExplodeSound = "D:\\Google Drive\\IT\\Java_CS_4\\Eclipse_workspace\\Saper\\src\\main\\resources\\ExplodeSound.wav";
	
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
	
	public static void musicLevelEasy(String path) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
			easyMusic = AudioSystem.getClip();
			easyMusic.open(ais);
			easyMusic.start();
			easyMusic.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void musicLevelMedium(String path) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
			mediumMusic = AudioSystem.getClip();
			mediumMusic.open(ais);
			mediumMusic.start();
			mediumMusic.loop(Clip.LOOP_CONTINUOUSLY);
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