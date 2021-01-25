package Button;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.ManageCursor;
import Interface.MouseResponse;

public class BaseButton extends JLabel implements MouseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2092753225182794409L;

	public BaseButton() {
		// TODO Auto-generated constructor stub
	}
	
	public BaseButton(ManageCursor cs, ImageIcon on, ImageIcon off) {
		enabled = on;
		disabled = off;
		this.cursor = cs;
		this.setIcon(on);

		final BaseButton BB = this;
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent l) {
				cursor.setCursor3(BB);
			}
			
			public void mouseExited(MouseEvent l) {
				cursor.setCursor0(BB);
			}
			public void mousePressed(MouseEvent l) {
				cursor.setCursor4(BB);
				BB.setIcon(disabled);
			}
			
			public void mouseReleased(MouseEvent l) {
				cursor.setCursor3(BB);
				BB.setIcon(enabled);
			}
		});
	}
	
	public void addMouseResponse() {
		// TODO Auto-generated method stub
		
	}
	
	protected ImageIcon enabled, disabled;
	protected ManageCursor cursor;
}
