package PlayerInteract;

import java.awt.Image;

import javax.swing.JComponent;

import GUI.DisplayStatus;
import GUI.PanelManager;
import Interface.MouseResponse;

public abstract class Bar extends JComponent implements MouseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4221467671511680170L;
	public Bar() {

	}
	
	public Bar(PanelManager PM) {
		frame = PM.loadImage.Bar[0];
		frame1 = PM.loadImage.Bar[3];
		this.PM = PM;
	}
	
	public void addStatus(DisplayStatus status) {
		DisplayStatus = status;
	}
	
	protected Image frame;
	protected Image frame1;
	public final int BAR_WIDTH = 90;
	public final int BAR_HEIGHT = 20;
	protected final int UI_WIDTH = 240;
	protected final int offsetX = -32;
	protected final int offsetY = 15;
	protected PanelManager PM;
	protected DisplayStatus DisplayStatus;
}
