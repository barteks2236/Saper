package com.Saper.ver1_0;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class GameMouse implements MouseListener{
	


		public void mouseClicked(MouseEvent e) {
			System.out.println("klikku");
			
		}

		public void mouseEntered(MouseEvent e) {
			System.out.println("klikku");			
		}

		public void mouseExited(MouseEvent e) {
			System.out.println("klikku");			
		}

		public void mousePressed(MouseEvent e) {
			System.out.println("klikku");			
		}

		public void mouseReleased(MouseEvent e) {
			System.out.println("klikku");			
		}

}

