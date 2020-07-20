package com.SaperMVC.ver2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class WidokSaper extends JFrame implements ActionListener, MouseListener {

	static JFrame saperRamka = new JFrame("Saper the Game of the year edition");
	static JPanel guziki = new JPanel();
	static int[][] bombTab;
	static JButton[][] guziczki;
	static int jakWielka;
	JButton odNowa = new JButton("Od nowa");
	JButton poddajSie = new JButton("Poddaje siê");
	final static int ileBomb = 10;
	Container kontenerBomb = new Container();

	public WidokSaper(int wielkoscGry) {
		super("Saper the Game of the year edition");

		this.jakWielka = wielkoscGry;
		bombTab = new int[wielkoscGry][wielkoscGry];
		guziczki = new JButton[wielkoscGry][wielkoscGry];

//	        saperRamka.setSize(900,900);                       
//	        saperRamka.setLayout(new BorderLayout());           
//	        saperRamka.add(guziki,BorderLayout.SOUTH);     
		odNowa.addActionListener(this);
		poddajSie.addActionListener(this);

		kontenerBomb.setLayout(new GridLayout(wielkoscGry, wielkoscGry));

		for (int x = 0; x < guziczki.length; x++) {
			for (int y = 0; y < guziczki[0].length; y++) {
				guziczki[x][y] = new JButton();
				guziczki[x][y].addActionListener(this);
				kontenerBomb.add(guziczki[x][y]);
			}
		}

		guziki.add(odNowa);
		guziki.add(poddajSie);

		saperRamka.add(kontenerBomb, BorderLayout.CENTER);
		KontrolerSaper.bomby(wielkoscGry);

		saperRamka.setLocationRelativeTo(null);
		saperRamka.setDefaultCloseOperation(EXIT_ON_CLOSE);
		saperRamka.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == odNowa) // resets grid
		{
			for (int x = 0; x < jakWielka; x++) {
				for (int y = 0; y < jakWielka; y++) {
					guziczki[x][y].setEnabled(true);
					guziczki[x][y].setText("");
				}
			}
			KontrolerSaper.bomby(30); // triggers a new game.
		}

		else if (ae.getSource() == poddajSie) // user has given up. trigger takeTheL( m!= 1).
		{
			KontrolerSaper.przegrana(0); // anything not = 1
		}

		else // click was on a cell
		{
			for (int x = 0; x < jakWielka; x++) {
				for (int y = 0; y < jakWielka; y++) {
					if (ae.getSource() == guziczki[x][y]) {
						switch (bombTab[x][y]) {
						case ileBomb:
							guziczki[x][y].setForeground(Color.RED);
							guziczki[x][y].setIcon(new ImageIcon("")); // add bomb image
							KontrolerSaper.przegrana(1); // user clicked on a mine
							break;
						case 0:
							guziczki[x][y].setText(bombTab[x][y] + "");
							guziczki[x][y].setEnabled(false);
							ArrayList<Integer> clear = new ArrayList<>();
							clear.add(x * 100 + y);
							KontrolerSaper.reszta(clear); // To recursively clear all surrounding '0' cells.
							KontrolerSaper.wygrana(); // checks win every move
							break;
						default:
							guziczki[x][y].setText("" + bombTab[x][y]);
							guziczki[x][y].setEnabled(false);
							KontrolerSaper.wygrana(); // its a number > 0 and not a mine, so just check for win
							break;
						}
					}
				}
			}
		}

	}

}
