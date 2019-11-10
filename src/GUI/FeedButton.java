package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Interface.MouseResponse;

public class FeedButton extends BaseButton implements MouseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5440670740177461383L;

	public FeedButton() {
		// TODO Auto-generated constructor stub
		super(new ImageIcon(Images.Buttons[0][0]), new ImageIcon(Images.Buttons[0][1]));
		addMouseResponse();
	}
	
	public void addMouseResponse() {
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent l) {
				
			}
			
			public void mouseReleased(MouseEvent l) {
				
			}
		});
	}
	
}
