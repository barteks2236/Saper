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
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SaperView extends JPanel implements ActionListener, MouseListener{
	String buttonID;
	List<JButton> buttonsList = new ArrayList<JButton>();
	int nr = 1; // nr przycisku w celu indentyfikacji
	int bombTab[][];
	JButton[][] bombButton = new JButton[5][5];

	public SaperView() {
		MouseListener moused = new MouseListener() {
			
			public void mouseReleased(MouseEvent m) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent m) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent m) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent m) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent m) {
				// TODO Auto-generated method stub
				
			}
		};
		setLayout(new GridLayout(4, 4));
		addMouseListener(this);
		for (int x = 1; x <= 4; x++) { 			// pion
			for (int y = 1; y <= 4; y++) { 		// poziom
				bombButton[x][y] = new JButton("" + (nr++));
				buttonsList.add(bombButton[x][y]);
				add(bombButton[x][y]); // nr przycisku w celach testowych
				
				
				//if (SwingUtilities.isLeftMouseButton(addMouseListener(this))) {
				bombButton[x][y].addActionListener(hideButton(y, x));
				//}
			}
		}
		
	

//		JMenuBar pasekMenu = new JMenuBar();
//		JMenu menuGra = pasekMenu.add(new JMenu("Gra"));
//		add(pasekMenu);


	}
	
//	private void myszacz() {
//		addMouseListener(new MouseListener() {
//
//			public void mouseClicked(MouseEvent e) {
//				System.out.println("test");
//				
//			}
//
//			public void mouseEntered(MouseEvent e) {
//				
//				
//			}
//
//			public void mouseExited(MouseEvent e) {
//				
//				
//			}
//
//			public void mousePressed(MouseEvent e) {
//				
//				
//			}
//
//			public void mouseReleased(MouseEvent e) {
//				
//				
//			}
//		});
//		
//	}

	private ActionListener hideButton(int y, int x) {
		bombButton[x][y].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Klika sobie: " + e.getActionCommand());
				System.out.println(e.getID());
				buttonsList.get(Integer.parseInt(e.getActionCommand()) - 1).setVisible(false);
			}
		});
		return null;
	}

	// Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}

	
	public void actionPerformed(ActionEvent e) {
	}
	
	
	public void mouseClicked(MouseEvent arg0) {
		
		if (SwingUtilities.isLeftMouseButton(arg0)) {
			System.out.println("LEWY");
		}
		else
		System.out.println("prawy");	
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
