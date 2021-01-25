package PlayerInteract;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import GUI.PanelManager;

public class Sanity extends Bar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5670040552783117750L;
	public Sanity(PanelManager PM) {
		// TODO Auto-generated constructor stub
		super(PM);
		sanity = PM.loadImage.Bar[2];
		sanityX = UI_WIDTH - offsetX - BAR_WIDTH;
		bar = this;
		
		this.setPreferredSize(new Dimension(90, 40));
		
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
	
	public BufferedImage sanity;
	public int sanityX;
	private final JComponent bar;
}
