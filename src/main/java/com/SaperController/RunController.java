package com.SaperController;

import java.util.Date;
import com.SaperView.*;

public class RunController implements Runnable {
	
	public static GamePanelEasy gamePanelEasy = new GamePanelEasy();
	public static GamePanelMedium gamePanelMedium = new GamePanelMedium();
	public static GamePanelHard gamePanelHard = new GamePanelHard();

	static{
		Thread saperThread = new Thread(new RunController());
		saperThread.start();
	}
	
	public void run() {
		while (true) {
			gamePanelEasy.repaint();
			gamePanelMedium.repaint();
			gamePanelHard.repaint();
			
			if (GameController.statusGry==false)
				GameController.wygrana();
				
			if (GameController.wygrana == true && GameController.przegrana == false) {
				Controller.winFrame.add(Controller.winPanel);
				Controller.frame(Controller.winFrame, "Wygrana!");
				GameController.przegrana = false;
				GameController.wygrana = false;
				GameController.rozgrywka();
			}
			
			if (GameController.wygrana == false && GameController.przegrana == true) {
				Controller.lossFrame.add(Controller.lossPanel);
				Controller.frame(Controller.lossFrame, "Przegrana!");
			}
		}
	}
}