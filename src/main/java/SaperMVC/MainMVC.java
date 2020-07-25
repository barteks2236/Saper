package SaperMVC;
import com.SaperModel.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import com.SaperController.*;
import com.SaperModel.DaneGracza;
import com.SaperModel.DaneGracza.OknoPodajImie;
import com.SaperView.OptionsPanel;
import com.SaperView.StartPanel;

public class MainMVC {
	
	public static JFrame gameArea = new JFrame("SAPER the game of the year edition");
	public static StartPanel startPanel = new StartPanel();
	public static OptionsPanel optionsPanel = new OptionsPanel();
	public static DaneGracza daneGracza = new DaneGracza();
	public static ArrayList<String> ranking = new ArrayList<String>();

	public static void main(String[] args) {
				
		daneGracza.add(DaneGracza.OknoPodajImie.podajNazwe);	// Ramka z danymi do rankingu
		daneGracza.setVisible(false);
		
		gameArea.add(startPanel);
		gameArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameArea.setVisible(true);
		gameArea.setResizable(false);
		gameArea.pack();
		gameArea.setLocationRelativeTo(null);
		Controller.music(Controller.pathBombSiren);

	        
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