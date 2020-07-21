package SaperMVC;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.text.View;



public class Main implements MouseListener{

	public static void main(String[] args) {
		
		JFrame gameArea = new JFrame("Saper/Mines");
		SaperView gamePanel = new SaperView();

		gameArea.add(gamePanel);
		gameArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameArea.setVisible(true);
		gameArea.pack();
  


	    gameArea.setLocationRelativeTo(null);      
	    gameArea.setVisible(true);

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
