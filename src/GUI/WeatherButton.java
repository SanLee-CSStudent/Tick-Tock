package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Interface.MouseResponse;

public class WeatherButton extends BaseButton implements MouseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1534583946560336287L;

	public WeatherButton() {
		// TODO Auto-generated constructor stub
		super(new ImageIcon(Images.Buttons[2][0]), new ImageIcon(Images.Buttons[2][1]));
		
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
