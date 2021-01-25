package PlayerStates;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GameObject.Player;
import Interface.PlayerStatistics;
import PlayerInteract.*;

public class SLEEP extends PlayerStatus implements PlayerStatistics{

	public SLEEP(Player player) {
		// TODO Auto-generated constructor stub
		this.player = player;
		BarPanel = this.player.PanelManager.UserInterface.getBars();
		
		Player = new ArrayList<BufferedImage[]>();
		
		AnimationFrames = this.player.PanelManager.loadImage.PLAYER_SLEEPING_FRAMES;
		
		for(int i = 0; i < 2; i++) {
			BufferedImage[] SLEEPING_FRAMES = new BufferedImage[this.AnimationFrames];
			for(int j = 0; j < this.AnimationFrames; j++) {
				SLEEPING_FRAMES[j] = this.player.PanelManager.loadImage.Player[i+8][j];
			}
			
			Player.add(SLEEPING_FRAMES);
		}
		
		AnimationFrames = this.player.PanelManager.loadImage.PLAYER_SLEEP_FRAMES;
		
		for(int i = 0; i < 2; i++) {
			BufferedImage[] SLEEP_FRAMES = new BufferedImage[this.AnimationFrames];
			for(int j = 0; j < this.AnimationFrames; j++) {
				SLEEP_FRAMES[j] = this.player.PanelManager.loadImage.Player[i+6][j];
			}
			
			Player.add(SLEEP_FRAMES);
		}
		
		SANITY_BAR = this.player.PanelManager.loadImage.Bar[2];
	}
	@Override
	public void act() {
		// TODO Auto-generated method stub
		resume();
		FrameCounter++;
		
		if(player.currentFrameNumber == AnimationFrames-1 && sleep) {
			FrameCounter = 0;
			player.currentFrameNumber = 0;
			AnimationFrames = 12;
			
			sleep = false;
			
		}
	}
	
	public BufferedImage getCurrentFrame() {
		if(sleep) {
			if(player.DIR.equals(Direction.LEFT)) {
				return Player.get(2)[player.currentFrameNumber];
			}
			else {
				return Player.get(3)[player.currentFrameNumber];
			}
		}
		else {
			if(player.DIR.equals(Direction.LEFT)) {
				return Player.get(0)[player.currentFrameNumber];
			}
			else {
				return Player.get(1)[player.currentFrameNumber];
			}
		}
	}
	
	public void setFrameCounter(int num) {
		FrameCounter = num;
	}
	
	public int getFrameCounter() {
		return FrameCounter;
	}
	
	public int getAnimationFrames() {
		return AnimationFrames;
	}
	
	public void resume() {
		// TODO Auto-generated method stub
		if(RECOVER_DELAY > 0) {
			RECOVER_DELAY -= 1;
		}
		if(RECOVER_DELAY <= 0) {
			if(this.player.SANITY < 100) {
				this.player.SANITY += 1;
			}
			this.player.PanelManager.UserInterface.getBars().sanityBar.sanity = SANITY_BAR
					.getSubimage(0, 0, (int)(((double)this.player.PanelManager.player.SANITY / this.player.PanelManager.
							UserInterface.getBars().sanityBar.BAR_WIDTH) * 81), this.player.PanelManager.UserInterface.getBars().sanityBar.BAR_HEIGHT);
			RECOVER_DELAY = MAX_RECOVER_DELAY;
		}
	}

	@Override
	public void updateFrameCounter(int num) {
		// TODO Auto-generated method stub
		
	}
	
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	private boolean sleep = true;
	private int AnimationFrames;
	private int FrameCounter = 0;
	private Player player;
	private ArrayList<BufferedImage[]> Player;
	
	BarPanel BarPanel;
	
	private BufferedImage SANITY_BAR;
	private int RECOVER_DELAY = 700;
	private final int MAX_RECOVER_DELAY = 700;
}
