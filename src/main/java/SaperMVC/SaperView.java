package SaperMVC;

import java.awt.*;
import javax.swing.*;

import com.SaperModel.BombButton;

public class SaperView extends JPanel{
	
	private final int dimension = 10;
	private JButton[][] bombButton = new JButton[dimension][dimension];

	public SaperView() {
		
		createGameArea();
	
	}
	

	public void createGameArea() {
		
		setLayout(new GridLayout(dimension, dimension));
		
		for (int x = 0; x < dimension; x++) { // pion
			for (int y = 0; y < dimension; y++) { // poziom
				bombButton[x][y] = new JButton();
				add(bombButton[x][y]);
			}
			
		}
	}
			
	
	


	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}
}
