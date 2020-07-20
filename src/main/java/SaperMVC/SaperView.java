package SaperMVC;


import java.awt.*;
import javax.swing.*;

import com.SaperModel.BombButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SaperView extends JPanel implements ActionListener, MouseListener{
	String buttonID;
	List<JButton> buttonsList = new ArrayList<JButton>();
	int nr = 0; // nr przycisku w celu indentyfikacji
	String nr2="";
	int bombTab[][];
	JButton[][] bombButton = new JButton[5][5];
	protected MouseEvent a;
	static Container kontenerBomb = new Container();
	JPanel guziki = new JPanel();
	JButton[][] guziczki;     
	
	
	public SaperView() {

		//setLayout(new GridLayout(4, 4));
		guziczki = new JButton[4][4];
		kontenerBomb.setLayout(new GridLayout(4,4));    

	     for(int x = 0; x < guziczki.length; x++){
	         for(int y = 0; y < guziczki[0].length; y++){
	             guziczki[x][y] = new JButton();            
	             guziczki[x][y].addActionListener(this);     
	             kontenerBomb.add(guziczki[x][y]);                  
	         }
	     }


	     
	     
//		for (int x = 0; x < 4; x++) { 			// pion
//			for (int y = 0; y < 4; y++) { 		// poziom
//				
//				buttonsList.add(bombButton[x][y]);
//
//				bombButton[x][y] = new JButton("" + (nr++));
//				add(bombButton[x][y]); // nr przycisku w celach testowych
//				
//				
//				
//				bombButton[x][y].addMouseListener(mouseButton(x, y));
////				if (SwingUtilities.isLeftMouseButton(
//				bombButton[x][y].addActionListener(hideButton(x, y));
//
//				
//
//				
//				
//				//				if (SwingUtilities.isLeftMouseButton(addMouseListener(this))) {
////				System.out.println("dupa");
////				}
//				//}
//			}
//		}
		
	

//		JMenuBar pasekMenu = new JMenuBar();
//		JMenu menuGra = pasekMenu.add(new JMenu("Gra"));
//		add(pasekMenu);


	}
	


//	private ActionListener hideButton(int x, int y) {
//		
//		bombButton[x][y].addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				System.out.println("Klika sobie: " + e.getActionCommand());
//
//				System.out.println(nr2);
////				buttonsList.get(Integer.parseInt(e.getActionCommand()) - 1)
//				
//				
//				
////				if (SwingUtilities.isRightMouseButton(a)) {
////					System.out.println("LEWY");
//
//					
//			//		buttonsList.get(nr-1).setVisible(false);
//					
//					
//					
//					
////				}
////				if (SwingUtilities.isLeftMouseButton(null)){
////				buttonsList.get(Integer.parseInt(e.getActionCommand()) - 1).setVisible(false); 
//
////				}
//			}
//		});
//		return null;
//	}
	
//	private MouseListener mouseButton(int x, int y) {
//		
//		bombButton[x][y].addMouseListener(new MouseListener() {
//
//			public void mouseClicked(MouseEvent a) {
//
//				if (SwingUtilities.isLeftMouseButton(a)) {
//					System.out.println("LEWY");
//
//					
//	//				buttonsList.get(nr-1).setVisible(false);
//				}
//				else {
//					System.out.println("PRAWY!!!!!!");
//					buttonsList.get(nr-1).setText("dupa");
//				}
//			}
//
//			public void mouseEntered(MouseEvent e) {
//			}
//
//			public void mouseExited(MouseEvent e) {}
//
//			public void mousePressed(MouseEvent e) {}
//
//			public void mouseReleased(MouseEvent e) {}
//		});
//		return null;
//	}
	
	
	
	
	
	
	


	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}
	
	public void actionPerformed(ActionEvent e) {
	}
		
		
		
	public void mouseClicked(MouseEvent a) {
//		if (SwingUtilities.isRightMouseButton(a)) {
//			System.out.println("LEWY");
//
//			
//			buttonsList.get(nr-1).setVisible(false);
//			
//			
//			
//			
//		}
//		else {
//			System.out.println("PRAWY!!!!!!");
//			buttonsList.get(nr-1).getDisabledIcon();
//		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
}
