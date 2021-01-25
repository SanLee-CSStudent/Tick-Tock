package Button;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import GUI.PanelManager;
import Interface.MouseResponse;

public class ExitButton extends BaseButton implements MouseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4782760754409748093L;

	public ExitButton(PanelManager PM) {
		// TODO Auto-generated constructor stub
		super(PM.cursor, new ImageIcon(PM.loadImage.Buttons[3][0]), new ImageIcon(PM.loadImage.Buttons[3][1]));
		addMouseResponse();
	}
	
	public void addMouseResponse() {
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent l) {
				System.exit(1);
			}
		});
	}

}
