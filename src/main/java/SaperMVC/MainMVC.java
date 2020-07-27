package SaperMVC;

import java.awt.event.*;
import com.SaperController.*;

public class MainMVC {

	public static void main(String[] args) {
		
		Controller.gameArea.add(Controller.startPanel);
		Controller.frame(Controller.gameArea, "SAPER Game of the Year Edition");
		MusicController.music(MusicController.pathBombSiren);
		Controller.gameArea.addWindowListener(new WindowAdapter() {
			
			public void windowOpened(WindowEvent event) {
				MusicController.bomb.setMicrosecondPosition(0);
				MusicController.bombTimePosition = 0;
				MusicController.bomb.start();
			}
			
			public void windowIconified(WindowEvent event) {
				MusicController.bombTimePosition = MusicController.bomb.getMicrosecondPosition();
				MusicController.bomb.stop();	
			}
			
			public void windowDeiconified(WindowEvent event) {
				MusicController.bomb.setMicrosecondPosition(MusicController.bombTimePosition);
				MusicController.bomb.start();
			}
		});	
	}
}