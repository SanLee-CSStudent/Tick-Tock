package PlayerInteract;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import GUI.PanelManager;

public class Hunger extends Bar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1537756284876084453L;
	public Hunger(PanelManager PM) {
		// TODO Auto-generated constructor stub
		super(PM);
		hunger = PM.loadImage.Bar[1];
		hungerX = offsetX;
		
		this.setMinimumSize(new Dimension(90, 20));
		this.setPreferredSize(new Dimension(90, 40));
		
		this.PM = PM;
		this.bar = this;
		addMouseResponse();
		
		this.setVisible(true);
	}
	
	public void addMouseResponse() {
		// TODO Auto-generated method stub
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				// System.out.println("Mouse Entered");
				DisplayStatus.mouseEntered = true;
				PM.cursor.setCursor3(bar);
			}
			
			public void mouseExited(MouseEvent e) {
				DisplayStatus.mouseEntered = false;
			}
		});
	}
	
	public boolean onEnter = false;
	public BufferedImage hunger;
	public int hungerX;
	private final JComponent bar;
}
