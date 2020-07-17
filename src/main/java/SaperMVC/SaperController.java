package SaperMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaperController {

	private SaperModel model;
	private SaperView view;
	
	public SaperController(SaperModel model, SaperView view) {
		this.model = model;
		this.view = view;
	}
	

	
//	private ActionListener hideButton(int y, int x) {
//		view.bombButton[x][y].addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Klika sobie: " + e.getActionCommand());
//				System.out.println(e.getID());
//				view.buttonsList.get(Integer.parseInt(e.getActionCommand()) - 1).setVisible(false);
//			}
//		});
//		return null;
//	}
	
	
	
}
