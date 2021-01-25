package GUI;

import Interface.KeyResponse;

public class GameInterface extends Thread {
	
	public GameInterface() {
		// TODO Auto-generated constructor stub

	}
	
	public GameInterface(PanelManager gamePanel) {
		// TODO Auto-generated constructor stub
		PanelManager = gamePanel;
		this.key = new KeyResponse(PanelManager);
		
		PanelManager.addKeyListener(key);
	
	}
	
	public void run() {// when gameInterface is started, this will run the Thread
		while(gameRunning) {
			if(PanelManager.player.alive) {
				PanelManager.player.live();// updating player does not really affect CPU usage
			}
			else {
				PanelManager.player.die();
			}
			
			PanelManager.repaint();// "not drawing" does improve CPU usage, causes memory leak
			
			try {
				Thread.sleep(MAIN_SLEEP_TIME);// increasing sleep time improves CPU usage
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean gameRunning = true;
	private GUI.PanelManager PanelManager;
	private KeyResponse key;
	
	private static final int MAIN_SLEEP_TIME = 19;
}
