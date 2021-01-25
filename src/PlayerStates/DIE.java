package PlayerStates;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GameObject.Player;

public class DIE extends PlayerStatus{

	public DIE(Player pl) {
		// TODO Auto-generated constructor stub
		player = pl;
		
		Player = new ArrayList<BufferedImage[]>();
		AnimationFrames = this.player.PanelManager.loadImage.PLAYER_DIE_FRAMES;
		
		for(int i = 0; i < 2; i++) {
			BufferedImage[] DIE_FRAMES = new BufferedImage[this.AnimationFrames];
			for(int j = 0; j < this.AnimationFrames; j++) {
				DIE_FRAMES[j] = this.player.PanelManager.loadImage.Player_Dead[i][j];
			}
			
			Player.add(DIE_FRAMES);
		}
	}

	@Override
	public void setFrameCounter(int num) {
		// TODO Auto-generated method stub
		FrameCounter = num;
	}

	@Override
	public int getFrameCounter() {
		// TODO Auto-generated method stub
		return FrameCounter;
	}

	@Override
	public int getAnimationFrames() {
		// TODO Auto-generated method stub
		return AnimationFrames;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		FrameCounter++;
	}

	@Override
	public BufferedImage getCurrentFrame() {
		// TODO Auto-generated method stub
		if(player.DIR.equals(Direction.LEFT)) {
			return Player.get(0)[player.currentFrameNumber];
		}
		else {
			return Player.get(1)[player.currentFrameNumber];
		}
	}
	
	@Override
	public void updateFrameCounter(int num) {
		// TODO Auto-generated method stub
		player.playerX -= 22;
		player.playerY -= 20;
		
		player.PanelManager.scheduleDelay.shutdown();
		player.PanelManager.scheduleStatus.shutdown();
	}
	
	private int AnimationFrames;
	private int FrameCounter = 0;
	Player player;
	private ArrayList<BufferedImage[]> Player;
}
