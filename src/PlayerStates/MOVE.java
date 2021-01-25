package PlayerStates;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GameObject.Player;

public class MOVE extends PlayerStatus{

	public MOVE(Player player) {
		// TODO Auto-generated constructor stub
		this.player = player;
		
		Player = new ArrayList<BufferedImage[]>();
		
		AnimationFrames = this.player.PanelManager.loadImage.PLAYER_MOVE_FRAMES;
		
		for(int i = 0; i < 2; i++) {
			BufferedImage[] MOVE_FRAMES = new BufferedImage[AnimationFrames];
			for(int j = 0; j < AnimationFrames; j++) {
				MOVE_FRAMES[j] = this.player.PanelManager.loadImage.Player[i+2][j];
			}
			
			Player.add(MOVE_FRAMES);
		}
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
	
		if(player.DIR.equals(Direction.LEFT)) {

			if(player.playerX <= 0) {
				player.DIR = Direction.RIGHT;
				player.playerX += 3;
				player.PanelManager.Friendship.friendshipX += 3;
			}
			else {
				player.playerX -= 3;
				player.PanelManager.Friendship.friendshipX -= 3;
			}
		}
		else {

			if(player.playerX >= player.SCREEN_SIZE.width - PLAYER_WIDTH) {
				player.DIR = Direction.LEFT;
				player.playerX -= 3;
				player.PanelManager.Friendship.friendshipX -= 3;
			}
			else {
				player.playerX += 3;
				player.PanelManager.Friendship.friendshipX += 3;
			}
		}
	
		FrameCounter++;
		player.setLocation(player.playerX, player.playerY);
		player.hitbox.setLocation(player.playerX, player.playerY);
	}
	
	public BufferedImage getCurrentFrame() {
		// TODO Auto-generated method stub
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
	public void updateFrameCounter(int num) {
		// TODO Auto-generated method stub
		
	}
	
	public final int AnimationFrames;
	private int FrameCounter = 0;
	private ArrayList<BufferedImage[]> Player;
	private Player player;
	
}
