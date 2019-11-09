package States;

import java.awt.image.BufferedImage;

public abstract class PlayerStatus {

	public PlayerStatus() {
		// TODO Auto-generated constructor stub
		
	}
	
	abstract public void setFrameCounter(int num);
	
	abstract public int getFrameCounter();
	
	abstract public int getAnimationFrames();
	
	public abstract void act();
	public abstract BufferedImage getCurrentFrame();
	protected final int AnimationFrames = 5;
	protected int FrameCounter = 1;
	public BufferedImage currentFrame;
}
