package com.SaperMVC.ver2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class WidokSaper extends JFrame implements ActionListener, MouseListener {

	final static int ileBomb = 10;
	static JFrame saperRamka = new JFrame("Saper the Game of the year edition");
	static JPanel guziki = new JPanel();
	ImageIcon bomb = new ImageIcon("D:\\Google Drive\\IT\\Java_CS_4\\Eclipse_workspace\\Saper\\src\\main\\java\\com\\SaperMVC\\ver2\\bomb.jpg");
	
	
	int wysGuzika;
	int szerGuzika;
	static int[][] bombTab;
	static JButton[][] guziczki;
	static int jakWielka;

	
	

	Container kontenerBomb = new Container();

	public WidokSaper(int wielkoscGry) {
		super("Saper the Game of the year edition");
		this.jakWielka = wielkoscGry;
		guziczki = new JButton[wielkoscGry][wielkoscGry];
		bombTab = new int[wielkoscGry][wielkoscGry];
   


		kontenerBomb.setLayout(new GridLayout(wielkoscGry, wielkoscGry));

		for (int x = 0; x < guziczki.length; x++) {
			for (int y = 0; y < guziczki[0].length; y++) {

				guziczki[x][y] = new JButton();
				guziczki[x][y].addActionListener(this);
				guziczki[x][y].addMouseListener(this);
				kontenerBomb.add(guziczki[x][y]);

			}
		}


		saperRamka.add(kontenerBomb);
		saperRamka.setLocationRelativeTo(null);
		saperRamka.setDefaultCloseOperation(EXIT_ON_CLOSE);
		saperRamka.setVisible(true);
		KontrolerSaper.bomby(wielkoscGry);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			guziczki[getX()][getY()].setText("uzbrojone");
			System.out.println("LEWY");
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

	@Override
	public void actionPerformed(ActionEvent akcjaErrorWysadzamy) {

		
		
		for (int x = 0; x < jakWielka; x++) {
			for (int y = 0; y < jakWielka; y++) {
				if (akcjaErrorWysadzamy.getSource() == guziczki[x][y]) {
					if (bombTab[x][y] != 0) {
						guziczki[x][y].setForeground(Color.RED);
						guziczki[x][y].setIcon(bomb);
						KontrolerSaper.przegrana(1);
					}

					if (bombTab[x][y] == 0) {
						guziczki[x][y].setText(bombTab[x][y] + "");
						guziczki[x][y].setEnabled(false);
						ArrayList<Integer> czyscidlo = new ArrayList<>();
						czyscidlo.add(x * 100 + y);
						KontrolerSaper.reszta(czyscidlo);
						KontrolerSaper.wygrana();
					} 
					if (bombTab[x][y] > 0 && bombTab[x][y] != 0){
						guziczki[x][y].setText("" + bombTab[x][y]);
						guziczki[x][y].setEnabled(false);
						
						
						
						
					}
				}
			}
		}
	}
}
