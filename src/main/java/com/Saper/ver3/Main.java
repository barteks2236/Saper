package com.Saper.ver3;

import java.util.Date;

import javax.swing.JOptionPane;

import SaperMVC.MainMVC;

public class Main implements Runnable {

	public static RamkaGry saper = new RamkaGry();

	public static void main(String[] args) {

		Thread saperThread = new Thread(new Main());
//		Main saperMain = new Main(saperThread);
//		new Thread(new Main()).start();
		saperThread.start();

	}

	public void run() {
		while (true) {

			saper.repaint(RamkaGry.sekunda);
			
			if (RamkaGry.statusGry == false) {
				RamkaGry.wygrana();
				
//				System.out.println(RamkaGry.wygrana +"  :   " + RamkaGry.przegrana);
				
			}
			if (RamkaGry.wygrana == true && RamkaGry.przegrana == false) {
//				JOptionPane.showMessageDialog(null, "Jesteœ w kawa³kach! :( ", "Podda³eœ siê!",
//						JOptionPane.INFORMATION_MESSAGE);
//				
				RamkaGry.przegrana = false;
				RamkaGry.wygrana = false;
				RamkaGry.clock = new Date();
				RamkaGry.rozgrywka();
			}
			if (RamkaGry.wygrana == false && RamkaGry.przegrana == true) {
//	-->		JOptionPane.showMessageDialog(null, "Jesteœ w kawa³kach! :( ", "Podda³eœ siê!",
//					JOptionPane.INFORMATION_MESSAGE);
				RamkaGry.przegrana = false;
				RamkaGry.wygrana = false;
				RamkaGry.clock = new Date();
				RamkaGry.rozgrywka();
			}

		}

	}

	
}