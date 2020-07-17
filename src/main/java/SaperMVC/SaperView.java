package SaperMVC;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class SaperView extends JPanel {
	String buttonID;
	ArrayList buttonsList = new ArrayList<JButton>();
	int nr = 1; // nr przycisku w celu indentyfikacji
	int bombTab[][];
	JButton[][] bombButton = new JButton[5][5];

	public SaperView() {

		setLayout(new GridLayout(4, 4));

		bombTab = new int[4][4];
		
		
		
		// bombButton.setBounds(100, 100, 50, 50);
		for (int x = 1; x <= 4; x++) { // pion
			for (int y = 1; y <= 4; y++) { // poziom
				
				
				
				
				bombButton[x][y] = new JButton("" + (nr++));
				buttonID = nr + "BB" + x + y;
				buttonsList.add(new JButton("" + (nr)));	
				
				add(bombButton[x][y]); // nr przycisku w celach testowych
//				bombButton[x][y].setVisible(false);
				Object a=buttonsList.get(nr);
				
				buttonsList.a.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {

						System.out.println("Klika sobie: " + e.getActionCommand());

						System.out.println(e.getID());
					}

				});

			}
		}
		
	

//		JButton bombButton = new JButton();
//		bombButton.setBounds(100, 100, 50, 50);
//		setVisible(true);
//		bombButton.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("klikbutton");
//			}
//
//		});

//		JMenuBar pasekMenu = new JMenuBar();
//		JMenu menuGra = pasekMenu.add(new JMenu("Gra"));
//		add(pasekMenu);

//		
//			addMouseListener(new MouseListener() {
//
//				public void mouseClicked(MouseEvent e) {
//					System.out.println("test");
//					
//				}
//
//				public void mouseEntered(MouseEvent e) {
//					
//					
//				}
//
//				public void mouseExited(MouseEvent e) {
//					
//					
//				}
//
//				public void mousePressed(MouseEvent e) {
//					
//					
//				}
//
//				public void mouseReleased(MouseEvent e) {
//					
//					
//				}
//			});

	}

	// Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}
}
