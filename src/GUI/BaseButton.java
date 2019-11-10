package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Interface.MouseResponse;

public class BaseButton extends JLabel implements MouseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2092753225182794409L;

	public BaseButton() {
		// TODO Auto-generated constructor stub
	}
	
	public BaseButton(ImageIcon on, ImageIcon off) {
		enabled = on;
		disabled = off;
		this.setIcon(on);

		BaseButton BB = this;
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent l) {
				GameFrame.cursor.setCursor3(BB);
			}
			
			public void mouseExited(MouseEvent l) {
				GameFrame.cursor.setCursor0(BB);
			}
			public void mousePressed(MouseEvent l) {
				GameFrame.cursor.setCursor4(BB);
				BB.setIcon(disabled);
			}
			
			public void mouseReleased(MouseEvent l) {
				GameFrame.cursor.setCursor3(BB);
				BB.setIcon(enabled);
			}
		});
	}
	
	@Override
	public void addMouseResponse() {
		// TODO Auto-generated method stub
		
	}
	
	protected ImageIcon enabled, disabled;
}
