package States;
import java.awt.image.BufferedImage;

import GUI.Images;
import GameObject.Player;

public class IDLE extends PlayerStatus{

	public IDLE() {
		// TODO Auto-generated constructor stub
		
	}
	
	public IDLE(int currentFrameNumber) {
		Player.currentFrameNumber = currentFrameNumber;
		FrameCounter = currentFrameNumber * 6;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		FrameCounter++;
	}
	
	public BufferedImage getCurrentFrame() {
		if(Player.DIR.equals(Direction.LEFT)) {
			return Images.Player[0][Player.currentFrameNumber];
		}
		else {
			return Images.Player[1][Player.currentFrameNumber];
		}
	}
	
	public void setDelay(int delay) {
		return;
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
	
	private final int AnimationFrames = Images.PLAYER_IDLE_FRAMES;
	private int FrameCounter = 0;
}
