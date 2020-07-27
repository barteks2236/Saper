package com.SaperController;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.SaperView.*;

public class GameController {
	
	private static int rozmiarX = 15;
	private static int rozmiarY = 15;
	public static int mojX, mojY;
	private static int sizeSquare = 90;
	
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
	public static long sekunda = 0;
	private static int iloscFlag = 0;
	public static int wynik;
	
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
	
	public static int getSizeSquare() {
		return sizeSquare;
	}

	public static void setSizeSquare(int sizeSquare) {
		GameController.sizeSquare = sizeSquare;
	}
	
	
	public static void ramkaGry(JFrame frame, JPanel panel) {
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
//						System.out.println("Myszka jest w " + sprawdzaczX() + " ; " + sprawdzaczY() + " w poblizu: "
//								+ wPoblizu[sprawdzaczX()][sprawdzaczY()]);
						if (oflagowany == true && rozbrojone[sprawdzaczX()][sprawdzaczY()]==false) {

							if (oznaczone[sprawdzaczX()][sprawdzaczY()] == false) {
								oznaczone[sprawdzaczX()][sprawdzaczY()] = true;
								iloscFlag++;
							}else {
								oznaczone[sprawdzaczX()][sprawdzaczY()] = false;
								iloscFlag--;
							}		
						}else
							rozbrojone[sprawdzaczX()][sprawdzaczY()] = true;	
					} 
				}
				
				if (SwingUtilities.isRightMouseButton(e)) {
					if (oflagowany == false) {
						oflagowany = true;
						GamePanelEasy.flagMode.setText("FLAG MODE ON");
						GamePanelEasy.flagMode.setBackground(Color.GREEN);
						GamePanelMedium.flagMode.setText("FLAG MODE ON");
						GamePanelMedium.flagMode.setBackground(Color.GREEN);
						GamePanelHard.flagMode.setText("FLAG MODE ON");
						GamePanelHard.flagMode.setBackground(Color.GREEN);
					}else {
						oflagowany =  false;
						GamePanelEasy.flagMode.setText("FLAG MODE OFF");
						GamePanelEasy.flagMode.setBackground(Color.RED);
						GamePanelMedium.flagMode.setText("FLAG MODE OFF");
						GamePanelMedium.flagMode.setBackground(Color.RED);
						GamePanelHard.flagMode.setText("FLAG MODE OFF");
						GamePanelHard.flagMode.setBackground(Color.RED);
					}	
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
				if (mojX >= s + x * getSizeSquare() && mojX < x * getSizeSquare() + getSizeSquare() - s && mojY >= s + y * getSizeSquare() && mojY < y * getSizeSquare() + getSizeSquare() - s)
					return (x);
			}
		}
		return (-1);
	}
	
	public static int sprawdzaczY() {
		for (int x = 0; x < getRozmiarX(); x++) {
			for (int y = 0; y < getRozmiarY(); y++) {
				if (mojX >= s + x * getSizeSquare() && mojX < x * getSizeSquare() + getSizeSquare() - s && mojY >= s + y * getSizeSquare() && mojY < y * getSizeSquare() + getSizeSquare() - s)
					return (y);
			}
		}
		return (-1);
	}
	
	
	public static void rozgrywka() {
		int b = 0;
		
		for (int x = 0; x < getRozmiarX(); x++) {			// Zeruje flagi przy kazdej grze
			for (int y = 0; y < getRozmiarY(); y++) {
				oznaczone[x][y] = false;
			}
		}	

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
	
	public static void wygrana() {
		for (int x = 0; x < getRozmiarX(); x++) {
			for (int y = 0; y < getRozmiarY(); y++) {
				if (rozbrojone[x][y] == true && bomby[x][y] == 1)
					przegrana = true;
			}	
		}

		if (iloscFlag == pozostaleBomby()  && sekunda > 0) {	// Gramy poki nie OFLAGUJEMY wszystkich Bomb
			wygrana = true;
			wynik = (int) sekunda;
		}
	}
	
	private static int pozostaleBomby() {
		int suma = 0;
		for (int x = 0; x < getRozmiarX(); x++) {
			for (int y = 0; y < getRozmiarY(); y++) {
				if (bomby[x][y] == 1) {
					suma++;
				}
			}
		}
		return suma;
	}
	
	public static void podpowiedzi(int x, int y, Graphics g) {
		if (bomby[x][y] == 0) {
						
			if (x > 0 && y > 0 && rozbrojone[x - 1][y - 1] == true) {
				czcionkaPodpowiedzi(x,y,g);
			}
			if (y > 0 && rozbrojone[x][y-1] == true) {
				czcionkaPodpowiedzi(x,y,g);
			}
			if (y < rozmiarY - 1 && rozbrojone[x][y+1] == true) {
				czcionkaPodpowiedzi(x,y,g);
			}
			if (x < rozmiarX - 1 && y > 0 && rozbrojone[x+1][y-1] == true) {
				czcionkaPodpowiedzi(x,y,g);
			}
			if (x > 0 && rozbrojone[x-1][y] == true) {
				czcionkaPodpowiedzi(x,y,g);
			}						
			if (x < rozmiarX - 1 && rozbrojone[x+1][y] == true) {
				czcionkaPodpowiedzi(x,y,g);
			}
			if (x > 0 && y < rozmiarY -1 && rozbrojone[x-1][y+1] == true) {
				czcionkaPodpowiedzi(x,y,g);
			}	
			if (x < rozmiarX - 1 && y < rozmiarY - 1 && rozbrojone[x+1][y+1] == true) {
				czcionkaPodpowiedzi(x,y,g);
			}						
		}
	}
	
	private static void czcionkaPodpowiedzi(int x, int y, Graphics g) {
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial", Font.BOLD, 35));
		g.drawString(Integer.toString(wPoblizu[x][y]), x * getSizeSquare() + 36, y * getSizeSquare() + 57);
	}
}