package com.SaperMVC.ver2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class KontrolerSaper {

	public static void wygrana() {

		boolean wygrywasz = true;

		for (int x = 0; x < WidokSaper.jakWielka; x++)

		{

			for (int y = 0; y < WidokSaper.jakWielka; y++)

			{

				if (WidokSaper.bombTab[x][y] != WidokSaper.ileBomb && WidokSaper.guziczki[x][y].isEnabled())

				{
					wygrywasz = false;
				}
			}
		}

		if (wygrywasz)

		{
			JOptionPane.showMessageDialog(null, "WYGRANA!", "PRZE¯Y£EŒ TYM RAZEM!", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void przegrana(int m) {

		for (int x = 0; x < WidokSaper.jakWielka; x++)

		{

			for (int y = 0; y < WidokSaper.jakWielka; y++)

			{

				if (WidokSaper.guziczki[x][y].isEnabled()) {

					if (WidokSaper.bombTab[x][y] != WidokSaper.ileBomb) {
						WidokSaper.guziczki[x][y].setText("" + WidokSaper.bombTab[x][y]);
					}

					else

					{
						WidokSaper.guziczki[x][y].setText("X");

					}
					WidokSaper.guziczki[x][y].setEnabled(false);
				}
			}
		}

		JOptionPane.showMessageDialog(null, m == 1 ? "JESTEŒ W KAWA£KACH! :( " : "PRZEGRA£EŒ", "WYSADZI£EŒ SIÊ",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void bomby(int b) { // B: WYSADZAMY!!!!!!
		ArrayList<Integer> listaBomb = new ArrayList<>();

		for (int x = 0; x < b; x++) {
			for (int y = 0; y < b; y++) {
				listaBomb.add(x * 100 + y);
			}
		}

		WidokSaper.bombTab = new int[b][b];

		for (int a = 0; a < (int) (b * 1.5); a++) {
			int miejsceBomby = (int) (Math.random() * listaBomb.size());
			WidokSaper.bombTab[listaBomb.get(miejsceBomby) / 100][listaBomb.get(miejsceBomby)
					% 100] = WidokSaper.ileBomb;
			listaBomb.remove(miejsceBomby);
		}

		for (int x = 0; x < b; x++) {
			for (int y = 0; y < b; y++) {
				if (WidokSaper.bombTab[x][y] != WidokSaper.ileBomb) {
					int obok = 0;
					if (x > 0 && y > 0 && WidokSaper.bombTab[x - 1][y - 1] == WidokSaper.ileBomb) {
						obok++;
					}

					if (y > 0 && WidokSaper.bombTab[x][y - 1] == WidokSaper.ileBomb) {
						obok++;
					}
					if (y < WidokSaper.jakWielka - 1 && WidokSaper.bombTab[x][y + 1] == WidokSaper.ileBomb) {
						obok++;
					}

					if (x < WidokSaper.jakWielka - 1 && y > 0
							&& WidokSaper.bombTab[x + 1][y - 1] == WidokSaper.ileBomb) {
						obok++;
					}

					if (x > 0 && WidokSaper.bombTab[x - 1][y] == WidokSaper.ileBomb) {
						obok++;
					}
					if (x < WidokSaper.jakWielka - 1 && WidokSaper.bombTab[x + 1][y] == WidokSaper.ileBomb) {
						obok++;
					}

					if (x > 0 && y < WidokSaper.jakWielka - 1
							&& WidokSaper.bombTab[x - 1][y + 1] == WidokSaper.ileBomb) {
						obok++;
					}

					if (x < WidokSaper.jakWielka - 1 && y < WidokSaper.jakWielka - 1
							&& WidokSaper.bombTab[x + 1][y + 1] == WidokSaper.ileBomb) {
						obok++;
					}
					WidokSaper.bombTab[x][y] = obok;
				}
			}
		}
	}

	public static void reszta(ArrayList<Integer> zerujemy) { // B: Nie wiem jak nazwaæ te masowe znikanie okien wiêc
																// bêd¹ to resztki po wybuchu :D

		int x = zerujemy.get(0) / 100;
		int y = zerujemy.get(0) % 100;
		zerujemy.remove(0);
		if (WidokSaper.bombTab[x][y] == 0) {

			if (x > 0 && y > 0 && WidokSaper.guziczki[x - 1][y - 1].isEnabled())

			{
				WidokSaper.guziczki[x - 1][y - 1].setText(WidokSaper.bombTab[x - 1][y - 1] + "");
				WidokSaper.guziczki[x - 1][y - 1].setEnabled(false);
				if (WidokSaper.bombTab[x - 1][y - 1] == 0) {
					zerujemy.add((x - 1) * 100 + (y - 1));
				}
			}

			if (y > 0 && WidokSaper.guziczki[x][y - 1].isEnabled())

			{
				WidokSaper.guziczki[x][y - 1].setText(WidokSaper.bombTab[x][y - 1] + "");
				WidokSaper.guziczki[x][y - 1].setEnabled(false);
				if (WidokSaper.bombTab[x][y - 1] == 0) {
					zerujemy.add(x * 100 + (y - 1));
				}

			}

			if (y < WidokSaper.jakWielka - 1 && WidokSaper.guziczki[x][y + 1].isEnabled())

			{
				WidokSaper.guziczki[x][y + 1].setText(WidokSaper.bombTab[x][y + 1] + "");
				WidokSaper.guziczki[x][y + 1].setEnabled(false);
				if (WidokSaper.bombTab[x][y + 1] == 0) {
					zerujemy.add(x * 100 + (y + 1));
				}

			}

			if (x < WidokSaper.jakWielka - 1 && y > 0 && WidokSaper.guziczki[x + 1][y - 1].isEnabled())

			{

				WidokSaper.guziczki[x + 1][y - 1].setText(WidokSaper.bombTab[x + 1][y - 1] + "");
				WidokSaper.guziczki[x + 1][y - 1].setEnabled(false);
				if (WidokSaper.bombTab[x + 1][y - 1] == 0) {
					zerujemy.add((x + 1) * 100 + (y - 1));
				}

			}

			if (x > 0 && WidokSaper.guziczki[x - 1][y].isEnabled()) {
				WidokSaper.guziczki[x - 1][y].setText(WidokSaper.bombTab[x - 1][y] + "");
				WidokSaper.guziczki[x - 1][y].setEnabled(false);
				if (WidokSaper.bombTab[x - 1][y] == 0) {
					zerujemy.add((x - 1) * 100 + y);
				}

			}

			if (x < WidokSaper.jakWielka - 1 && WidokSaper.guziczki[x + 1][y].isEnabled()) {
				WidokSaper.guziczki[x + 1][y].setText(WidokSaper.bombTab[x + 1][y] + "");
				WidokSaper.guziczki[x + 1][y].setEnabled(false);
				if (WidokSaper.bombTab[x + 1][y] == 0) {
					zerujemy.add((x + 1) * 100 + y);
				}

			}

			if (x > 0 && y < WidokSaper.jakWielka - 1 && WidokSaper.guziczki[x - 1][y + 1].isEnabled())

			{
				WidokSaper.guziczki[x - 1][y + 1].setText(WidokSaper.bombTab[x - 1][y + 1] + "");
				WidokSaper.guziczki[x - 1][y + 1].setEnabled(false);
				if (WidokSaper.bombTab[x - 1][y + 1] == 0) {
					zerujemy.add((x - 1) * 100 + (y + 1));
				}

			}

			if (x < WidokSaper.jakWielka - 1 && y < WidokSaper.jakWielka - 1
					&& WidokSaper.guziczki[x + 1][y + 1].isEnabled())

			{
				WidokSaper.guziczki[x + 1][y + 1].setText(WidokSaper.bombTab[x + 1][y + 1] + "");
				WidokSaper.guziczki[x + 1][y + 1].setEnabled(false);
				if (WidokSaper.bombTab[x + 1][y + 1] == 0) {
					zerujemy.add((x + 1) * 100 + (y + 1));
				}

			}

			if (zerujemy.isEmpty())
				return;
		}
		reszta(zerujemy);
	}
}
