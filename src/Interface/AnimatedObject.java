package Interface;

import java.awt.image.BufferedImage;

public interface AnimatedObject {
	abstract public void setAnimation();// equivalent to C++ pure virtual
	abstract public void animateFrame();
	abstract public BufferedImage getFrame();
	
	public final int FPS = 6;
}
