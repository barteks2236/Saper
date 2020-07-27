package com.Saper.ver3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.SaperModel.DaneGracza;
import com.SaperModel.DaneGracza.OknoPodajImie;

import SaperMVC.MainMVC;

public class RamkaGry extends JFrame {

	int s = 1; 															// nasza odleglosc miedzy kwadratami
	static int rozmiarX=10;
	static int rozmiarY=9;
	public int mojX; 													// wspolrzedna x-owa kursora myszy
	public int mojY; 													// wspolrzedna y-owa kursora myszy
	static int[][] bomby = new int[rozmiarX][rozmiarY]; 				// nasza tablica podlozonych ladunkow
	static int[][] wPoblizu = new int[rozmiarX][rozmiarY]; 				//ilosc bomb w poblizu pola
	static boolean[][] rozbrojone = new boolean[rozmiarX][rozmiarY];	// tablica odkrytych pól, nazwa do zmiany potem
	static boolean[][] oznaczone = new boolean[rozmiarX][rozmiarY];		// tablica oznaczonych ladunkow
	public int zegarX = 720; 											// wspolrzedna x-owa zegara
	public int zegarY = 820; 											// wspolrzedna y-owa zegara
	public static long sekunda = 0; 									// zmienna czasowa
	public static boolean statusGry = false;							// mowi czy gra jest resetowana czy nie
	public int ustawionyCzas = 10; 									// czas na rozbrojenie ³adunkow w sekundach
	public int flagaX=0, flagaY=0;
	public boolean oflagowany = false;
	static Random r = new Random();
	int miejscaPodlozenia = r.nextInt(5);
	static int b = 0;
	static Date clock = new Date();
	public static boolean wygrana = false;
	public static boolean przegrana = false;
	ArrayList<Integer> czyscikLista = new ArrayList();
	static int iloscFlag = 0;
	
	public RamkaGry() {

		this.setSize(908, 930);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Ruszacz ruszacz = new Ruszacz();
		this.addMouseMotionListener(ruszacz);

		Klikacz klikacz = new Klikacz();
		this.addMouseListener(klikacz);

		OknoGry saperOkno = new OknoGry();
		this.setContentPane(saperOkno);

		for (int x = 0; x < rozmiarX; x++) {
			for (int y = 0; y < rozmiarY; y++) {
				if (r.nextInt(100) < 20) {			// % planszy na jakiej pojawi¹ siê ³adunki
					bomby[x][y] = 1;

				} 
				else {
					bomby[x][y] = 0;
				}
				rozbrojone[x][y] = false;
			}
		}

		rozgrywka();
	}

// metoda uruchomienia rozgrywki
	
	static void rozgrywka() {
		
		for (int x = 0; x < rozmiarX; x++) {			// Zeruje flagi przy kazdej grze
			for (int y = 0; y < rozmiarY; y++) {
				oznaczone[x][y] = false;
			}
		}	
		for (int x = 0; x < rozmiarX; x++) {
			for (int y = 0; y < rozmiarY; y++) {
				
				if (r.nextInt(100) < 20) {
					bomby[x][y] = 1;

				} else {
					bomby[x][y] = 0;
				}
				rozbrojone[x][y] = false;
			}
		}

		for (int x = 0; x < rozmiarX; x++) {
			for (int y = 0; y < rozmiarY; y++) {
				b = 0;
				for (int l = 0; l < rozmiarX; l++) {
					for (int k = 0; k < rozmiarY; k++) {
						if (l != x || k != y) {

							if (czyB(x, y, l, k) == true) {
								b++;
							}
						}
					}
					wPoblizu[x][y] = b;
				}
			}
		}

	}



	public class OknoGry extends JPanel {

		public OknoGry() {
			setLayout(null);
			setTitle("SAPER Game of the Year Edition");

			JButton poddajeSie = new JButton("Poddaje siê");
			poddajeSie.setBounds(20, 825, 120, 60);
			add(poddajeSie);
			poddajeSie.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					przegrana = true;
					statusGry = true;
					statusGry = false;
				}

			});

			JButton reset = new JButton("Restart");
			reset.setBounds(150, 825, 120, 60);
			add(reset);
			reset.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					przegrana = false;
					wygrana = false;
					clock = new Date();
					oflagowany=false;
//					for (int x = 0; x < rozmiarX; x++) {
//						for (int y = 0; y < rozmiarY; y++) {
//							oznaczone[x][y] = false;
//						}
//					}
					rozgrywka();
					
					
					
					
				}

			});
		
		}

		public void paintComponent(Graphics g) {
			g.setColor(Color.yellow);
			g.fillRect(0, 0, getWidth(), getHeight());

			
			
			for (int x = 0; x < rozmiarX; x++) {
				for (int y = 0; y < rozmiarY; y++) {
					g.setColor(Color.gray);
//					if (bomby[x][y] == 1) {
//						g.setColor(Color.yellow);		//Podœwietlenie bomb na ¿ó³to
//					}
//					else
//						g.setColor(Color.GREEN);
					
					if (rozbrojone[x][y] == true) {
						g.setColor(Color.WHITE);
						if (bomby[x][y] == 1) {
							g.setColor(Color.red);
						}		
					}
					if (mojX >= s + x * 90 && mojX < x * 90 + 90 - s && mojY >= s + y * 90 && mojY < y * 90 + 90 - s) {
						g.setColor(Color.lightGray);
					}

					g.fillRect(s + x * 90, s + y * 90, 90 - 2 * s, 90 - 2 * s);
					
					if (rozbrojone[x][y] == true) {
						g.setColor(Color.black);

						if (bomby[x][y] == 0) {

							g.setFont(new Font("Arial", Font.BOLD, 35));
							g.drawString(Integer.toString(wPoblizu[x][y]), x * 90 + 36, y * 90 + 57);
						}

						else if (bomby[x][y] == 1) {

							g.fillRect(s + x * 90 + 36, s + y * 90 + 26, 10, 30);
							g.fillRect(s + x * 90 + 26, s + y * 90 + 36, 30, 10);
							g.fillRect(s + x * 90 + 31, s + y * 90 + 31, 20, 20);

						}
					}
					
	// Flagi
					
					if (oznaczone[x][y]==true) {
						g.setColor(Color.DARK_GRAY);
						g.fillRect(x * 90+50, y * 90+15, 10, 60); // Kijek
						g.setColor(Color.red);
						g.fillRect(x * 90+20, y * 90+15, 30, 25); // Flaga
						g.fillRect(x * 90+10, y * 90+15, 35, 10);
						g.setColor(Color.BLACK);
						g.fillRect(x * 90+25, y * 90+70, 55, 5);
						
					}
					podpowiedzi(x, y, g);					
				}
			}

			
	// Czas
			
			
			g.setColor(Color.BLACK);
			g.fillRect(zegarX, zegarY, 180, 80);
			
			if (przegrana == false && wygrana == false ) {
				sekunda = ustawionyCzas - ((new Date().getTime() - clock.getTime()) / 1000);
//				sekunda=20 + (int)(new Date().getTime() - clock.getTime()) / 1000 - (int)(new Date().getTime() - clock.getTime()) / 1000;
//				sekunda=clock.getTime()/1000;					// do skasowania potem
//				sekunda=((new Date().getTime() - clock.getTime()) / 1000) - ((new Date().getTime() - clock.getTime()) / 1000) + sekunda;
				
			}

			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 90));
			g.drawString(Integer.toString((int) sekunda), zegarX + 20, zegarY + 70);
			if (sekunda <= 15) {
				g.setColor(Color.red);
				g.setFont(new Font("Arial", Font.BOLD, 90));
				g.drawString(Integer.toString((int) sekunda), zegarX + 20, zegarY + 70);
				
			}
			if (sekunda==0) {
				przegrana = true;		// Jesli czas sie skonczy, przgrywamy
			}

		}
		
	}

	public class Ruszacz implements MouseMotionListener {

		
		public void mouseDragged(MouseEvent arg0) {
		}

	
		public void mouseMoved(MouseEvent m) {
			mojX = m.getX();
			mojY = m.getY();
		}
	}



	public class Klikacz implements MouseListener {

		
		public void mouseClicked(MouseEvent e) {

			if (SwingUtilities.isLeftMouseButton(e)) {

			
//				if (sprawdzaczX() != -1 && sprawdzaczY() != -1) {		// sprawdzacz sprawdza czy kursor jest w obszarze przycisku
//					rozbrojone[sprawdzaczX()][sprawdzaczY()] = true;
//				}

				if (sprawdzaczX() != -1 && sprawdzaczY() != -1) {
					System.out.println("Myszka jest w " + sprawdzaczX() + " ; " + sprawdzaczY() + " w poblizu: "
							+ wPoblizu[sprawdzaczX()][sprawdzaczY()]);
					if (oflagowany == true && rozbrojone[sprawdzaczX()][sprawdzaczY()]==false) {

						if (oznaczone[sprawdzaczX()][sprawdzaczY()] == false) {
							oznaczone[sprawdzaczX()][sprawdzaczY()] = true;
							iloscFlag++;
						}
						else {
							oznaczone[sprawdzaczX()][sprawdzaczY()] = false;
							iloscFlag--;
						}
					}
					else {
						rozbrojone[sprawdzaczX()][sprawdzaczY()] = true;
					}
					
				} 
				else {					
					System.out.println("Nale¿y klikaæ na miejsca do tego przeznaczone");
				}
			}
			if (SwingUtilities.isRightMouseButton(e)) {
				
				if (oflagowany == false) {
						oflagowany = true;
				System.out.println("oflagowany true");
				}
				else {
					oflagowany =false;
					System.out.println("oflagowany false");
				}

			}
		}

	
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
	}
	
		public int sprawdzaczX() {
			for (int x = 0; x < rozmiarX; x++) {
				for (int y = 0; y < rozmiarY; y++) {

					if (mojX >= s + x * 90 && mojX < x * 90 + 90 - s && mojY >= s + y * 90 && mojY < y * 90 + 90 - s) {
						return (x);
					}
				}
			}

			return (-1);
		}

		public int sprawdzaczY() {
			for (int x = 0; x < rozmiarX; x++) {
				for (int y = 0; y < rozmiarY; y++) {

					if (mojX >= s + x * 90 && mojX < x * 90 + 90 - s && mojY >= s + y * 90 && mojY < y * 90 + 90 - s) {
						return (y);
					}
				}
			}

			return (-1);
		}

		public static boolean czyB(int bX, int bY, int aX, int aY) {
			if ((bX - aX < 2) && (bX - aX > -2) && (bY - aY < 2) && (bY - aY > -2) && (bomby[aX][aY] == 1)) {
				return true;
			}
			return false;
		}
		
		public static void wygrana() {
			for (int x = 0; x < rozmiarX; x++) {
				for (int y = 0; y < rozmiarY; y++) {
					if (rozbrojone[x][y] == true && bomby[x][y] == 1) {
						przegrana = true;
					}
				}
				
				
			}
//			if (iloscOdkrytych() >= 90 - pozostaleBomby()) { // wielkosc 10*9, do uzaleznienia od jednej zmiennej w pozniej i Gramy aby odslonic wszystkie NIEZAMINOWANE pola
			if (iloscFlag == pozostaleBomby()) {	// Gramy poki nie OFLAGUJEMY wszystkich Bomb
								
				wygrana = true;
				OknoPodajImie.wynik = (int)RamkaGry.sekunda;				
				JOptionPane.showMessageDialog(null, "WYGRANA!", 
						"PRZE¯Y£EŒ TYM RAZEM!", JOptionPane.INFORMATION_MESSAGE);	
				Main.saper.setVisible(false);
				MainMVC.gameArea.setVisible(false);
				MainMVC.daneGracza.setVisible(true);
			}
		}
		
		public static int iloscOdkrytych() {
			int suma = 0;
			for (int x = 0; x < rozmiarX; x++) {
				for (int y = 0; y < rozmiarY; y++) {
					if (rozbrojone[x][y] == true) {
						suma++;
					}
				}
			}
			return suma;
		}
		
		public static int pozostaleBomby() {
			int suma =0;
			for (int x = 0; x < rozmiarX; x++) {
				for (int y = 0; y < rozmiarY; y++) {
					if (bomby[x][y] == 1) {
						suma++;
					}
				}
			}
			return suma;
		}
		
		public void czcionkaPodpowiedzi(int x, int y, Graphics g) {
			g.setColor(Color.GREEN);
			g.setFont(new Font("Arial", Font.BOLD, 35));
			g.drawString(Integer.toString(wPoblizu[x][y]), x * 90 + 36, y * 90 + 57);
		}
		
		public void podpowiedzi(int x, int y, Graphics g) {
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
		
//		public void uwaga() {
//	 		
//			JFrame uwaga = new JFrame();
//	 		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	 		this.setVisible(true);
//	 		this.setSize(200, 200);
//	 		this.add(uwaga);
//	 	}
}
