package com.SaperController;

import java.awt.event.*;
import java.util.Date;
import java.util.Random;
import javax.swing.*;

import com.Saper.ver3.RamkaGry;

public class GameController {
	
	private static int rozmiarX = 10;
	private static int rozmiarY = 10;
	public static int mojX, mojY;
	public static int[][] bomby = new int[getRozmiarX()][getRozmiarY()];
	public static int[][] wPoblizu = new int[getRozmiarX()][getRozmiarY()];
	public static boolean[][] rozbrojone = new boolean[getRozmiarX()][getRozmiarY()];
	public static boolean[][] oznaczone = new boolean[getRozmiarX()][getRozmiarY()];
	public static int s = 1;
	public static boolean oflagowany = false;
	private static Random r = new Random();
	public static boolean wygrana = false;
	public static boolean przegrana = false;
	public static boolean statusGry = false;
	public static Date clock = new Date();
	
	public static int getRozmiarX() {
		return rozmiarX;
	}

	public static void setRozmiarX(int rozmiarX) {
		GameController.rozmiarX = rozmiarX;
	}

	public static int getRozmiarY() {
		return rozmiarY;
	}

	public static void setRozmiarY(int rozmiarY) {
		GameController.rozmiarY = rozmiarY;
	}
		
	
	public void ramkaGry(JFrame frame, JPanel panel) {
		frame.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				mojX = e.getX();
				mojY = e.getY();
			}	
		}); 
		
		frame.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					if (sprawdzaczX() != -1 && sprawdzaczY() != -1) {
						System.out.println("Myszka jest w " + sprawdzaczX() + " ; " + sprawdzaczY() + " w poblizu: "
								+ wPoblizu[sprawdzaczX()][sprawdzaczY()]);
						if (oflagowany == true && rozbrojone[sprawdzaczX()][sprawdzaczY()]==false) {

							if (oznaczone[sprawdzaczX()][sprawdzaczY()] == false) 
								oznaczone[sprawdzaczX()][sprawdzaczY()] = true;
							else 
								oznaczone[sprawdzaczX()][sprawdzaczY()] = false;
						} else
							rozbrojone[sprawdzaczX()][sprawdzaczY()] = true;	
					} 
				}
				
				if (SwingUtilities.isRightMouseButton(e)) {
					if (oflagowany == false)
							oflagowany = true;
					else
						oflagowany =  false;
				}
			}	
		});
		
		frame.setContentPane(panel);
		
		for (int x = 0; x < getRozmiarX(); x++) {
			for (int y = 0; y < getRozmiarY(); y++) {
				if (r.nextInt(100) < 20) 
					bomby[x][y] = 1;
				else 
					bomby[x][y] = 0;
				rozbrojone[x][y] = false;
			}
		}
		rozgrywka();
	}
	
	public static int sprawdzaczX() {
		for (int x = 0; x < getRozmiarX(); x++) {
			for (int y = 0; y < getRozmiarY(); y++) {
				if (mojX >= s + x * 90 && mojX < x * 90 + 90 - s && mojY >= s + y * 90 && mojY < y * 90 + 90 - s)
					return (x);
			}
		}
		return (-1);
	}
	
	public static int sprawdzaczY() {
		for (int x = 0; x < getRozmiarX(); x++) {
			for (int y = 0; y < getRozmiarY(); y++) {
				if (mojX >= s + x * 90 && mojX < x * 90 + 90 - s && mojY >= s + y * 90 && mojY < y * 90 + 90 - s)
					return (y);
			}
		}
		return (-1);
	}
	
	
	public static void rozgrywka() {
		int b = 0;
		
		for (int x = 0; x < getRozmiarX(); x++) {
			for (int y = 0; y < getRozmiarY(); y++) {
				if (r.nextInt(100) < 20)
					bomby[x][y] = 1;
				else
					bomby[x][y] = 0;
				
				rozbrojone[x][y] = false;
			}
		}

		for (int x = 0; x < getRozmiarX(); x++) {
			for (int y = 0; y < getRozmiarY(); y++) {
				b = 0;
				for (int l = 0; l < getRozmiarX(); l++) {
					for (int k = 0; k < getRozmiarY(); k++) {
						if (l != x || k != y) {
							if (czyB(x, y, l, k) == true)
								b++;	
						}
					}
					wPoblizu[x][y] = b;
				}
			}
		}
	}
	
	
	private static boolean czyB(int bX, int bY, int aX, int aY) {
		if ((bX - aX < 2) && (bX - aX > -2) && (bY - aY < 2) && (bY - aY > -2) && (bomby[aX][aY] == 1))
			return true;
		
		return false;
	}
}