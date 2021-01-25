package PlayerStates;

import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import GUI.PanelManager;
import PlayerInteract.*;
import Interface.PlayerStatistics;

public class HungerStats implements PlayerStatistics {

	public HungerStats(PanelManager UI) {
		// TODO Auto-generated constructor stub
		this.PM = UI;
		BarPanel = PM.UserInterface.getBars();
		HUNGER_BAR = this.PM.loadImage.Bar[1];
		resume();
	}

	public void resume() {
		// TODO Auto-generated method stub
		// hungry = Executors.newScheduledThreadPool(1);
		PM.scheduleDelay.scheduleAtFixedRate(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub	
				if(PM.player.HUNGER <= 1) {
					PM.player.HUNGER = 0;
					PM.player.alive = false;

					pause();
				}
				else {
					update();// UserInteract.hungerBar.hunger = UserInteract.hungerBar.
					// 		hunger.getScaledInstance((int)(((double)HUNGER / UserInteract.hungerBar.BAR_WIDTH) * 81), UserInteract.hungerBar.BAR_HEIGHT, Image.SCALE_FAST);
					PM.player.HUNGER--;
				}
			}
			
		}, HUNGER_DELAY, HUNGER_DELAY, TimeUnit.SECONDS);
	}

	public void pause() {
		// TODO Auto-generated method stub
		PM.scheduleDelay.shutdown();
	}
	
	public void update() {
		BarPanel.hungerBar.hunger = HUNGER_BAR.getSubimage(0, 
				0, 
				(int)(((double)PM.player.HUNGER / BarPanel.hungerBar.BAR_WIDTH) * 81), 
				BarPanel.hungerBar.BAR_HEIGHT);
	}
	
	private final int HUNGER_DELAY = 10;//10,000 ms or 10 seconds
	private PanelManager PM;
	private BarPanel BarPanel;
	private BufferedImage HUNGER_BAR;
}
