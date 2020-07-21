package com.Saper.ver3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class RamkaGry extends JFrame {

	int s = 1; // nasza odleglosc miedzy kwadratami
	public int mojX; // wspolrzedna x-owa kursora myszy
	public int mojY; // wspolrzedna y-owa kursora myszy
	static int[][] bomby = new int[16][9]; // nasza tablica podlozonych ladunkow
	int[][] wPoblizu = new int[16][9]; //
	static boolean[][] rozbrojone = new boolean[16][9]; // tablica rozbrojonych bomb
	static boolean[][] oznaczone = new boolean[16][9]; // tablica oznaczonych ladunkow
	public int zegarX = 720; // wspolrzedna x-owa kursora myszy
	public int zegarY = 820;
	public long sekunda = 0;
	public static boolean statusGry = false;			// mowi czy gra jest resetowana czy nie
	public int ustawionyCzas = 30; // czas na rozbrojenie ³adunkow w sekundach
	
	Random r = new Random();
	int miejscaPodlozenia = r.nextInt(5);
	int b = 0;
	Date clock = new Date();
	public static boolean wygrana = false;
	public static boolean przegrana = false;

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

		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 9; y++) {
				if (r.nextInt(100) < 20) {
					bomby[x][y] = 1;

				} else {
					bomby[x][y] = 0;
				}
				rozbrojone[x][y] = false;
			}
		}

		rozgrywka();
	}
	


	private void rozgrywka() {
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 9; y++) {
				if (r.nextInt(100) < 20) {
					bomby[x][y] = 1;

				} else {
					bomby[x][y] = 0;
				}
				rozbrojone[x][y] = false;
			}
		}

		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 9; y++) {
				b = 0;
				for (int l = 0; l < 16; l++) {
					for (int k = 0; k < 9; k++) {
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

			JButton reset = new JButton("Poddaje siê");
			reset.setBounds(20, 825, 120, 60);
			add(reset);
			reset.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					przegrana = true;
					statusGry = true;
					JOptionPane.showMessageDialog(null, "Jesteœ w kawa³kach! :( ", "Podda³eœ siê!", 
							JOptionPane.INFORMATION_MESSAGE);
					
					statusGry = false;
				}

			});

			JButton poddajeSie = new JButton("Restart");
			poddajeSie.setBounds(150, 825, 120, 60);
			add(poddajeSie);
			poddajeSie.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					przegrana = false;
					wygrana = false;
					clock = new Date();
					rozgrywka();

				}

			});
		
		}

		public void paintComponent(Graphics g) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 0, getWidth(), getHeight());

			for (int x = 0; x < 16; x++) {
				for (int y = 0; y < 9; y++) {
					g.setColor(Color.gray);
//					if (bomby[x][y] == 1) {
//						g.setColor(Color.yellow);		//Podœwietlenie bomb na ¿ó³to
//					}
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

						if (bomby[x][y] == 0 && wPoblizu[x][y] != 0) {

							g.setFont(new Font("Arial", Font.BOLD, 35));
							g.drawString(Integer.toString(wPoblizu[x][y]), x * 90 + 36, y * 90 + 57);
						}

						else if (bomby[x][y] == 1) {

							g.fillRect(s + x * 90 + 36, s + y * 90 + 26, 10, 30);
							g.fillRect(s + x * 90 + 26, s + y * 90 + 36, 30, 10);
							g.fillRect(s + x * 90 + 31, s + y * 90 + 31, 20, 20);

						}
					}
				}
			}

	// Czas
			
			
			g.setColor(Color.BLACK);
			g.fillRect(zegarX, zegarY, 180, 80);
			
			if (przegrana == false && wygrana == false ) {
				sekunda = ustawionyCzas - ((new Date().getTime() - clock.getTime()) / 1000);
			}
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 90));
			g.drawString(Integer.toString((int) sekunda), zegarX + 20, zegarY + 70);
			if (sekunda <= 15) {
				g.setColor(Color.red);
				g.setFont(new Font("Arial", Font.BOLD, 90));
				g.drawString(Integer.toString((int) sekunda), zegarX + 20, zegarY + 70);
			}
			
		}
	}

	public class Ruszacz implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent arg0) {
		}

		@Override
		public void mouseMoved(MouseEvent m) {
			mojX = m.getX();
			mojY = m.getY();
		}
	}

	public class Przyciskacz implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}

	public class Klikacz implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			if (SwingUtilities.isLeftMouseButton(e)) {

				System.out.println("LEWY");

				if (sprawdzaczX() != -1 && sprawdzaczY() != -1) {
					rozbrojone[sprawdzaczX()][sprawdzaczY()] = true;
				}

				if (sprawdzaczX() != -1 && sprawdzaczY() != -1) {
					System.out.println("Myszka jest w " + sprawdzaczX() + " ; " + sprawdzaczY() + " w poblizu: "
							+ wPoblizu[sprawdzaczX()][sprawdzaczY()]);
				} else {
					System.out.println("Myszka nie jest nigdzie");
				}
			}
			else {
				
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}
		public int sprawdzaczX() {
			for (int x = 0; x < 16; x++) {
				for (int y = 0; y < 9; y++) {

					if (mojX >= s + x * 90 && mojX < x * 90 + 90 - s && mojY >= s + y * 90 && mojY < y * 90 + 90 - s) {
						return (x);
					}
				}
			}

			return (-1);
		}

		public int sprawdzaczY() {
			for (int x = 0; x < 16; x++) {
				for (int y = 0; y < 9; y++) {

					if (mojX >= s + x * 90 && mojX < x * 90 + 90 - s && mojY >= s + y * 90 && mojY < y * 90 + 90 - s) {
						return (y);
					}
				}
			}

			return (-1);
		}

		public boolean czyB(int bX, int bY, int aX, int aY) {
			if ((bX - aX < 2) && (bX - aX > -2) && (bY - aY < 2) && (bY - aY > -2) && (bomby[aX][aY] == 1)) {
				return true;
			}
			return false;
		}
		
		public static void wygrana() {
			for (int x = 0; x < 16; x++) {
				for (int y = 0; y < 9; y++) {
					if (rozbrojone[x][y] == true && bomby[x][y] == 1) {
						przegrana = true;
						JOptionPane.showMessageDialog(null, "Jesteœ w kawa³kach! :( ", "Podda³eœ siê!", 
								JOptionPane.INFORMATION_MESSAGE);
						
						
					}
				}
			}if (iloscOdkrytych() >= 144 - pozostaleBomby()) { //16*9
				wygrana = true;
				
				JOptionPane.showMessageDialog(null, "WYGRANA!", 
						"PRZE¯Y£EŒ TYM RAZEM!", JOptionPane.INFORMATION_MESSAGE);		// Trzeba zrobiæ wyjscie do menu po roozgrywce
			}
		}
		
		public static int iloscOdkrytych() {
			int suma = 0;
			for (int x = 0; x < 16; x++) {
				for (int y = 0; y < 9; y++) {
					if (rozbrojone[x][y] == true) {
						suma++;
					}
				}
			}
			return suma;
		}
		
		public static int pozostaleBomby() {
			int suma =0;
			for (int x = 0; x < 16; x++) {
				for (int y = 0; y < 9; y++) {
					if (bomby[x][y] == 1) {
						suma++;
					}
				}
			}
			return suma;
		}
		
	
	
		
		
}
