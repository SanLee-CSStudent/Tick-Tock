package PlayerInteract;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import GUI.PanelManager;

public class BarPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7217535241955288191L;

	public BarPanel(PanelManager PM) {
		// TODO Auto-generated constructor stub
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
		this.setSize(240, 50);
		this.setLayout(new GridLayout(1, 2, 10, 0));
		
		hungerBar = new Hunger(PM);
		sanityBar = new Sanity(PM);
		
		this.add(hungerBar);
		this.add(sanityBar);
	}
	
	public Hunger hungerBar;
	public Sanity sanityBar;
}
