package GameObject;

import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;
import Interface.AnimatedObject;
import States.*;
import GUI.GameFrame;
import GUI.Images;

public class Player extends JComponent implements AnimatedObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6088949689473805765L;
	public Player() {
		// TODO Auto-generated constructor stub
		playerX = (int)GameFrame.SCREEN_SIZE.getWidth() - Images.PLAYER_WIDTH;
		playerY = (int)GameFrame.SCREEN_SIZE.getHeight() - Images.PLAYER_HEIGHT - OFFSET_Y;
		actTimer = new Timer();
		delayNum = 1000;
		
		frame = Images.Player[0][0];
		currentFrameNumber = 0;
		STATUS = Status.IDLE;
		PS = new IDLE();
		DIR = Direction.LEFT;
		if(delayNum <= 0) {
			System.out.println(delayNum);
		}

		actTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				// System.out.println(delayNum);
				actionNum = rand.nextInt(3);
				if(actionNum == 0) {
					PS = new IDLE(idleFrameCache);
				}
				else {
					PS = new MOVE();
					directNum = rand.nextInt(2);
					if(directNum == 0) {
						DIR = Direction.LEFT;
					}
					else {
						DIR = Direction.RIGHT;
					}
				}
				
				
			}
			
		}, delayNum, delayNum);

	}
	public void live() {
		setAnimation();
		
		delayNum = rand.nextInt(3000) + 1000;

		PS.act();
	}
	
	@Override
	public void setAnimation() {
		// TODO Auto-generated method stub
		animateFrame();
		frame = PS.getCurrentFrame();
		
	}

	@Override
	public void animateFrame() {
		// TODO Auto-generated method stub
		// System.out.println(currentFrameNumber);
		
		currentFrameNumber = PS.getFrameCounter() / FPS;
		currentFrameNumber %= PS.getAnimationFrames();
		
		// System.out.println(currentFrameNumber + "; " + PS.getFrameCounter() + "; " + PS.getAnimationFrames());
		if(actionNum == 0) {
			idleFrameCache = currentFrameNumber;
		}
		
		if(PS.getFrameCounter() > FPS * PS.getAnimationFrames()) {
			PS.setFrameCounter(0);
		}

	}

	@Override
	public BufferedImage getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
	
	private BufferedImage frame;
	public static int currentFrameNumber;
	private int idleFrameCache = 0;
	private final int FPS = 6;
	
	private Timer actTimer;
	
	public static Direction DIR;
	private Status STATUS;
	private int actionNum = 0;
	private int directNum = 0;
	private int delayNum;
	private Random rand = new Random();
	private PlayerStatus PS;
	public int playerX;
	public int playerY;
	private final int OFFSET_Y = GameFrame.SCREEN_SIZE.height / 18;
}
