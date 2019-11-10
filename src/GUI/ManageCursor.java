package GUI;

import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JComponent;

public class ManageCursor {

	public ManageCursor() {
		// TODO Auto-generated constructor stub
	}
	
	public void setCursor0(JComponent object) {
		object.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Images.Cursor[0], new Point(0,0), "Cursor0"));
	}
	public void setCursor1(JComponent object) {
		object.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Images.Cursor[1], new Point(0,0), "Cursor1"));
	}
	public void setCursor2(JComponent object) {
		object.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Images.Cursor[2], new Point(0,0), "Cursor2"));
	}
	public void setCursor3(JComponent object) {
		object.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Images.Cursor[3], new Point(0,0), "Cursor3"));
	}
	public void setCursor4(JComponent object) {
		object.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Images.Cursor[4], new Point(0,0), "Cursor4"));
	}
	

}
