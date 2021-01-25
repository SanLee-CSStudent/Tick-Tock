package PlayerStates;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GameObject.Player;

public class SIT extends PlayerStatus{

	public SIT(Player player) {
		// TODO Auto-generated constructor stub
		this.player = player;
		
		Player = new ArrayList<BufferedImage[]>();
		
		AnimationFrames = this.player.PanelManager.loadImage.PLAYER_SIT_FRAMES;
		
		for(int i = 0; i < 2; i++) {
			BufferedImage[] SIT_FRAMES = new BufferedImage[AnimationFrames];
			for(int j = 0; j < this.AnimationFrames; j++) {
				SIT_FRAMES[j] = this.player.PanelManager.loadImage.Player[i+4][j];
			}
			
			Player.add(SIT_FRAMES);
		}
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		FrameCounter++;
	}
	
	public BufferedImage getCurrentFrame() {
		if(player.DIR.equals(Direction.LEFT)) {
			return this.Player.get(0)[player.currentFrameNumber];
		}
		else {
			return this.Player.get(1)[player.currentFrameNumber];
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
	public void updateFrameCounter(int num) {
		// TODO Auto-generated method stub
		
	}
	
	private final int AnimationFrames;
	private int FrameCounter = 0;
	private Player player;
	private ArrayList<BufferedImage[]> Player;
}
