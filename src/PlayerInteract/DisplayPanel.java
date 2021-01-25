package PlayerInteract;

import javax.swing.JPanel;

import GUI.DisplayStatus;
import GUI.ManageCursor;
import GUI.PanelManager;

public class DisplayPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DisplayPanel(PanelManager pm, ManageCursor cursor) {
		// TODO Auto-generated constructor stub
		this.PM = pm;
		
		this.setLocation(0, 0);
		this.setPreferredSize(pm.SCREEN_SIZE);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	public void addBars() {
		BarPanel UIBarPanel = PM.UserInterface.getBars();
		DH = new DisplayStatus(PM, UIBarPanel.hungerBar, UIBarPanel.hungerBar.hungerX, 15);
		DS = new DisplayStatus(PM, UIBarPanel.sanityBar, UIBarPanel.sanityBar.sanityX, 15);
		
		UIBarPanel.hungerBar.addStatus(DH);
		UIBarPanel.sanityBar.addStatus(DS);
		
		this.add(DH);
		this.add(DS);
	}
	
	public DisplayStatus DH;
	public DisplayStatus DS;
	
	private PanelManager PM;
}
