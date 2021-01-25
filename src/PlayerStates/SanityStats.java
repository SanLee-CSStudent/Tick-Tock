package PlayerStates;

import java.util.concurrent.TimeUnit;

import GUI.PanelManager;
import Interface.PlayerStatistics;
import PlayerInteract.*;

public class SanityStats implements PlayerStatistics {

	public SanityStats(PanelManager PM) {
		// TODO Auto-generated constructor stub
		this.PM = PM;
		BarPanel = PM.UserInterface.getBars();
		
		resume();
	}

	public void resume() {
		// TODO Auto-generated method stub
		PM.scheduleDelay.scheduleAtFixedRate((new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				currentSanity = PM.player.SANITY + "/ 100";
				if(PM.player.SANITY <= 1) {
					PM.player.SANITY = 0;
					
					pause();
				}
				else {
					PM.player.SANITY--;
					update();
				}
			}
			
		}), SANITY_DELAY, SANITY_DELAY, TimeUnit.SECONDS);
	}

	public void pause() {
		// TODO Auto-generated method stub
		PM.scheduleDelay.shutdown();
	}
	
	public void update() {
		// TODO Auto-generated method stub
		BarPanel.sanityBar.sanity = BarPanel.sanityBar.sanity.getSubimage(0, 
				0, 
				(int)(((double)PM.player.SANITY / BarPanel.sanityBar.BAR_WIDTH) * 81), 
				BarPanel.sanityBar.BAR_HEIGHT);
	
	}
	
	private final int SANITY_DELAY = 60;// 1 minutes
	private PanelManager PM;
	private BarPanel BarPanel;
	
	public String currentSanity;
}
