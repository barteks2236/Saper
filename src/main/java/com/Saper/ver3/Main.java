package com.Saper.ver3;

import javax.swing.JOptionPane;

public class Main implements Runnable {

	RamkaGry saper = new RamkaGry();

	public static void main(String[] args) {

		new Thread(new Main()).start();

	}

	@Override
	public void run() {
		while (true) {
			saper.repaint();
			if (RamkaGry.statusGry==false) {
				RamkaGry.wygrana();
//				System.out.println(RamkaGry.wygrana +"  :   " + RamkaGry.przegrana);
				
			}

		}

	}

}