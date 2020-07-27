package com.SaperController;

import java.sql.*;

import com.SaperModel.PlayerDataEasy;
import com.SaperModel.PlayerDataHard;
import com.SaperModel.PlayerDataMedium;
import com.SaperView.GamePanelEasy;
import com.SaperView.GamePanelHard;
import com.SaperView.GamePanelMedium;
import com.SaperView.RankingPanel;

public class Executor {
	
	public static ResultSet select(String selectQuery) {
		
		try {
			Connection connection = Connect.connect();
			Statement statement = connection.createStatement();
			return statement.executeQuery(selectQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public static void query(String query) {
		
		try {
			Connection connection = Connect.connect();
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void resultEasy() {
		PlayerDataEasy.listEasy.clear();
		ResultSet data = Executor.select("SELECT * FROM RANKING_EASY ORDER BY SCORE_EASY DESC");
		try {
			while(data.next())
				new PlayerDataEasy(data.getString("NAME_EASY"), data.getInt("SCORE_EASY"));
			for(PlayerDataEasy pde: PlayerDataEasy.listEasy)
				GamePanelEasy.scoreAreaEasy.append("" + pde + "\n");
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
		
	public static void resultMedium() {
		PlayerDataMedium.listMedium.clear();
		ResultSet data = Executor.select("SELECT * FROM RANKING_MEDIUM ORDER BY SCORE_MEDIUM DESC");
		try {
			while(data.next())
				new PlayerDataMedium(data.getString("NAME_MEDIUM"), data.getInt("SCORE_MEDIUM"));
			for(PlayerDataMedium pdm: PlayerDataMedium.listMedium)
				GamePanelMedium.scoreAreaMedium.append("" + pdm + "\n");
		}catch (SQLException e1) {
			e1.printStackTrace();
		}	
	}
	
	public static void resultHard() {
		PlayerDataHard.listHard.clear();
		ResultSet data = Executor.select("SELECT * FROM RANKING_HARD ORDER BY SCORE_HARD DESC");
		try {
			while(data.next())
				new PlayerDataHard(data.getString("NAME_HARD"), data.getInt("SCORE_HARD"));
			for(PlayerDataHard pdh: PlayerDataHard.listHard)
				GamePanelHard.scoreAreaHard.append("" + pdh + "\n");
		}catch (SQLException e1) {
			e1.printStackTrace();
		}	
	}
}
