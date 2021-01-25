package PlayerStates;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GameObject.Player;

public class IDLE extends PlayerStatus{

	public IDLE(Player pl) {
		// TODO Auto-generated constructor stub
		player = pl;
		
		Player = new ArrayList<BufferedImage[]>();
		
		AnimationFrames = player.PanelManager.loadImage.PLAYER_IDLE_FRAMES;
		
		for(int i = 0; i < 2; i++) {
			BufferedImage[] IDLE_FRAMES = new BufferedImage[AnimationFrames];
			for(int j = 0; j < AnimationFrames; j++) {
				IDLE_FRAMES[j] = this.player.PanelManager.loadImage.Player[i][j];
			}
			
			Player.add(IDLE_FRAMES);
		}
	}
	
	@Override
	public void act() {
		// TODO Auto-generated method stub
		FrameCounter++;
	}
	
	public BufferedImage getCurrentFrame() {
		if(player.DIR.equals(Direction.LEFT)) {
			return Player.get(0)[player.currentFrameNumber];
		}
		else {
			return Player.get(1)[player.currentFrameNumber];
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
	
	@Override
	public void updateFrameCounter(int currentFrameNumber) {
		// TODO Auto-generated method stub
		player.currentFrameNumber = currentFrameNumber;
		FrameCounter = currentFrameNumber * 6;
	}
	
	private int AnimationFrames;
	private int FrameCounter = 0;
	private Player player;
	private ArrayList<BufferedImage[]> Player;
	
}
