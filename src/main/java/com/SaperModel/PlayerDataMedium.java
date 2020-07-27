package com.SaperModel;

import java.util.*;

public class PlayerDataMedium {
	
	private String name;
	private int score;
	public static ArrayList<PlayerDataMedium> listMedium = new ArrayList<PlayerDataMedium>();
	
	public PlayerDataMedium(String name, int score) {
		this.name = name;
		this.score = score;
		listMedium.add(this);
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