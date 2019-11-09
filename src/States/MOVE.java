package States;

import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import GUI.GameFrame;
import GUI.GamePanel;
import GUI.Images;
import GameObject.Player;

public class MOVE extends PlayerStatus{

	public MOVE() {
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
	
		if(Player.DIR.equals(Direction.LEFT)) {

			if(GamePanel.player.playerX <= 0) {
				Player.DIR = Direction.RIGHT;
				GamePanel.player.playerX += 3;
			}
			else {
				GamePanel.player.playerX -= 3;
			}
		}
		else {

			if(GamePanel.player.playerX >= GameFrame.SCREEN_SIZE.width - Images.PLAYER_WIDTH) {
				Player.DIR = Direction.LEFT;
				GamePanel.player.playerX -= 3;
			}
			else {
				GamePanel.player.playerX += 3;
			}
		}
		
		FrameCounter++;
	}
	
	public BufferedImage getCurrentFrame() {
		// TODO Auto-generated method stub
		if(Player.DIR.equals(Direction.LEFT)) {
			return Images.Player[2][Player.currentFrameNumber];
		}
		else {
			return Images.Player[3][Player.currentFrameNumber];
		}
	}
	
	public void setDelay(int delay) {
		this.delay = delay;
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
	
	public final int AnimationFrames = Images.PLAYER_MOVE_FRAMES;
	private int FrameCounter = 0;
	private int directNum;
	private int delay = 0;
	private Random rand = new Random();
}
