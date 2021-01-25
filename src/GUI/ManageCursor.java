package GUI;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JComponent;

public class ManageCursor {
	

	public ManageCursor(Images images) {
		// TODO Auto-generated constructor stub
		this.images = images;
		
		Cursor = new Image[5];
		for(int i = 0; i < 5; i++) {
			Cursor[i] = this.images.Cursor[i];
		}
		start = new Point(0,0);
		
		this.images = null;
	}
	
	public void setCursor0(JComponent object) {
		object.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Cursor[0], start, "Cursor0"));
	}
	public void setCursor1(JComponent object) {
		object.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Cursor[1], start, "Cursor1"));
	}
	public void setCursor2(JComponent object) {
		object.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Cursor[2], start, "Cursor2"));
	}
	public void setCursor3(JComponent object) {
		object.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Cursor[3], start, "Cursor3"));
	}
	public void setCursor4(JComponent object) {
		object.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Cursor[4], start, "Cursor4"));
	}
	
	private Images images;
	private Image[] Cursor;
	private Point start;
}
