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
	
	public void bombButtonsAction() {
		view.bombButton.addActionListener();
	}
	
	
	
	
	
}
