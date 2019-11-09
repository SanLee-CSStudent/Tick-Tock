package GUI;

import GameObject.Player;

public class GameInterface extends Thread{

	public GameInterface(GamePanel gamePanel) {
		// TODO Auto-generated constructor stub
		this.gamePanel = gamePanel;
		
	}
	
	public void run() {// when gameInterface is started, this will run the Thread
		while(gameRunning) {
			GamePanel.player.live();
			
			gamePanel.repaint();
			
			try {
				Thread.sleep(MAIN_SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean gameRunning = true;
	private GamePanel gamePanel;
	
	private static final int MAIN_SLEEP_TIME = 20;
}
