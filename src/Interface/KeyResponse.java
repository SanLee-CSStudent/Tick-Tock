package Interface;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

import GUI.PanelManager;

public class KeyResponse implements KeyListener{
	
	public KeyResponse(PanelManager PM){
		 activeKeys = new HashSet<Integer>();
		 this.PM = PM;
	}
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		activeKeys.add(e.getKeyCode());
		manageKeys();
	}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void manageKeys() {
		// TODO Auto-generated method stub
		HashSet<Integer> currentKeys = KeyResponse.activeKeys;

		if (currentKeys.contains(KeyEvent.VK_F9)) {
			// System.out.println("KEY_PRESSED");
			if(PM.UserInterface.open) {
				PM.UserInterface.setVisible(false);
				PM.UserInterface.open = false;
			}
			else {
				PM.UserInterface.setVisible(true);
				PM.UserInterface.open = true;
			}
			KeyResponse.activeKeys.clear();
		}
	}
	
	public static HashSet<Integer> activeKeys;
	private PanelManager PM;
}
