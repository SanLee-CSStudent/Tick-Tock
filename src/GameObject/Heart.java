package GameObject;

import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import GUI.GamePanel;
import GUI.Images;
import Interface.AnimatedObject;
import States.Direction;

public class Heart implements AnimatedObject{

	public Heart() {
		// TODO Auto-generated constructor stub
		frame = Images.Heart[currentFrameNumber];
		
		currentFrameNumber = 0;
		heartCounter = 0;
		
		rand = new Random();
		if(Player.DIR == Direction.LEFT) {
			// System.out.println("Tictoc is facing left");
			heartX = ((rand.nextInt() % Images.PLAYER_WIDTH/2) / 2) 
				+ (GamePanel.player.playerX + Images.PLAYER_WIDTH/4);
		}
		else {
			// System.out.println("Tictoc is facing right");
			heartX = ((rand.nextInt() % Images.PLAYER_WIDTH/2) / 2) 
					+ (GamePanel.player.playerX + Images.PLAYER_WIDTH / 2);
		}
		heartY = ((rand.nextInt() % Images.PLAYER_HEIGHT/2) / 3) 
				+ (GamePanel.player.playerY + Images.PLAYER_HEIGHT/2);
		
		killTimer = new Timer();
		killTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				heartRemoved = true;
			}
			
		}, life);
	}
	
	public void setMovement() {
		heartY--;
		heartX += ((heartY % 10) * Math.sin(heartY / 3));
	
	}

	@Override
	public void setAnimation() {
		// TODO Auto-generated method stub
		animateFrame();
		
		frame = Images.Heart[currentFrameNumber];
	}

	@Override
	public void animateFrame() {
		// TODO Auto-generated method stub
		currentFrameNumber = heartCounter / FPS;
		currentFrameNumber %= Images.HEART_MAX_FRAMES;
		
		if(heartCounter >= FPS * Images.HEART_MAX_FRAMES) {
			currentFrameNumber = 18;
			killTimer.cancel();
			reachLastFrame = true;
		}
	}

	@Override
	public BufferedImage getFrame() {
		// TODO Auto-generated method stub
		if(heartRemoved) {
			setAnimation();
			heartCounter++;
		}
		else {
			setMovement();
		}
		
		return frame;
	}
	
	public int getX() {
		// TODO Auto-generated method stub
		return heartX;
	}
	
	public int getY() {
		return heartY;
	}
	
	private int heartX = 0;
	private int heartY = 0;
	private Random rand;
	
	private Timer killTimer;
	
	private final int life = 1750;
	private BufferedImage frame;
	private boolean heartRemoved = false;
	public boolean reachLastFrame = false;
	public static int currentFrameNumber;
	private int heartCounter;
}
