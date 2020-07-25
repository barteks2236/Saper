package com.SaperController;

import java.util.Date;
import javax.swing.JOptionPane;


public class RunController implements Runnable {
	
	{
		Thread saperThread = new Thread(new RunController());
		saperThread.start();
	}
	
	public void run() {
		while (true) {
			if (GameController.statusGry==false) {
				//GameController.wygrana();
//				System.out.println(RamkaGry.wygrana +"  :   " + RamkaGry.przegrana);
				
			}
			if (GameController.wygrana == true && GameController.przegrana == false) {
				JOptionPane.showMessageDialog(null, "Jesteœ w kawa³kach! :( ", "Podda³eœ siê!",
						JOptionPane.INFORMATION_MESSAGE);
				
				GameController.przegrana = false;
				GameController.wygrana = false;
				GameController.clock = new Date();
				GameController.rozgrywka();
			}
			if (GameController.wygrana == false && GameController.przegrana == true) {
				JOptionPane.showMessageDialog(null, "Jesteœ w kawa³kach! :( ", "Podda³eœ siê!",
						JOptionPane.INFORMATION_MESSAGE);
				GameController.przegrana = false;
				GameController.wygrana = false;
				GameController.clock = new Date();
				GameController.rozgrywka();
			}

		}

	}

}
