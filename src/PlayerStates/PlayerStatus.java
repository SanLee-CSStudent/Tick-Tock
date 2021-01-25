package PlayerStates;

import java.awt.image.BufferedImage;

public abstract class PlayerStatus {

	public PlayerStatus() {
		// TODO Auto-generated constructor stub
		
	}
	
	abstract public void setFrameCounter(int num);
	
	abstract public int getFrameCounter();
	
	abstract public int getAnimationFrames();
	
	abstract public void updateFrameCounter(int num);
	
	public abstract void act();
	
	public abstract BufferedImage getCurrentFrame();
	
	protected final int AnimationFrames = 5;
	protected int FrameCounter = 1;
	protected final int PLAYER_WIDTH = 134;
	protected final int PLAYER_HEIGHT = 134;
	public BufferedImage currentFrame;
}
