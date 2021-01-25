package Button;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import GUI.PanelManager;
import Interface.MouseResponse;

public class SleepButton extends BaseButton implements MouseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3948737277870238081L;

	public SleepButton(PanelManager PM) {
		// TODO Auto-generated constructor stub
		super(PM.cursor, new ImageIcon(PM.loadImage.Buttons[1][0]), new ImageIcon(PM.loadImage.Buttons[1][1]));
		this.PM = PM;
		
		addMouseResponse();
	}
	
	public void addMouseResponse() {
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent l) {
				
			}
			
			public void mouseReleased(MouseEvent l) {

				if(PM.UserInterface.getButtons().checkSleeping) {
					PM.player.sleeping = true;
					PM.player.sleep();
				}
				else {
					PM.player.sleeping = false;
					PM.player.sleep();
				}
				
				PM.UserInterface.getButtons().invertSleep();
			}
		});
	}
	
	private PanelManager PM;
}
