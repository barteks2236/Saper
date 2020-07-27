package com.SaperModel;

import java.util.*;

public class PlayerDataHard {
	
	private String name;
	private int score;
	public static ArrayList<PlayerDataHard> listHard = new ArrayList<PlayerDataHard>();
	
	public PlayerDataHard(String name, int score) {
		this.name = name;
		this.score = score;
		listHard.add(this);
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