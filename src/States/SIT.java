package States;

import java.awt.image.BufferedImage;

import GUI.Images;
import GameObject.Player;

public class SIT extends PlayerStatus{

	public SIT() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		FrameCounter++;
	}
	
	public BufferedImage getCurrentFrame() {
		if(Player.DIR.equals(Direction.LEFT)) {
			return Images.Player[4][Player.currentFrameNumber];
		}
		else {
			return Images.Player[5][Player.currentFrameNumber];
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
	
	private final int AnimationFrames = Images.PLAYER_SIT_FRAMES;
	private int FrameCounter = 0;

}
