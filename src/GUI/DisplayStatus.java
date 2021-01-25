package GUI;

import java.awt.Dimension;
import javax.swing.JPanel;
import PlayerInteract.Bar;

public class DisplayStatus extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8099236528888511534L;

	public DisplayStatus(PanelManager pm, Bar bar, int x, int y) {
		// TODO Auto-generated constructor stub
		currentX = x + pm.UserInterface.UIx;
		currentY = y + pm.UserInterface.UIy;
		
		// this.setLayout(null);
		this.setPreferredSize(new Dimension(120, 50));
		this.setOpaque(true);
	}
	
	public int currentX;
	public int currentY;
	
	public boolean mouseEntered = false;
}
