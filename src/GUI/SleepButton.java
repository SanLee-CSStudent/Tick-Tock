package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Interface.MouseResponse;

public class SleepButton extends BaseButton implements MouseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3948737277870238081L;

	public SleepButton() {
		// TODO Auto-generated constructor stub
		super(new ImageIcon(Images.Buttons[1][0]), new ImageIcon(Images.Buttons[1][1]));
		
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
