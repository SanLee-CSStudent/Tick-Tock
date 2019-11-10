package States;

import java.awt.image.BufferedImage;

import GUI.Images;
import GameObject.Player;

public class SLEEP extends PlayerStatus {

	public SLEEP() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void act() {
		// TODO Auto-generated method stub
		FrameCounter++;
		if(Player.currentFrameNumber == Images.PLAYER_SLEEP_FRAMES-1 && sleep) {
			FrameCounter = 0;
			Player.currentFrameNumber = 0;
			AnimationFrames = Images.PLAYER_SLEEPING_FRAMES;
			
			sleep = false;
		}
	}
	
	public BufferedImage getCurrentFrame() {
		if(sleep) {
			if(Player.DIR.equals(Direction.LEFT)) {
				return Images.Player[6][Player.currentFrameNumber];
			}
			else {
				return Images.Player[7][Player.currentFrameNumber];
			}
		}
		else {
			if(Player.DIR.equals(Direction.LEFT)) {
				return Images.Player[8][Player.currentFrameNumber];
			}
			else {
				return Images.Player[9][Player.currentFrameNumber];
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
	private boolean sleep = true;
	private int AnimationFrames = Images.PLAYER_SLEEP_FRAMES;
	private int FrameCounter = 0;

}
