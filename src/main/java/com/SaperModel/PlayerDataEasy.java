package com.SaperModel;

import java.util.*;

public class PlayerDataEasy {
	
	private String name;
	private int score;
	public static ArrayList<PlayerDataEasy> listEasy = new ArrayList<PlayerDataEasy>();
	
	public PlayerDataEasy(String name, int score) {
		this.name = name;
		this.score = score;
		listEasy.add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Gracz: " + name + " uzyska³ wynik: " + score;
	}
}