package GameObject;

import java.awt.image.BufferedImage;
import java.util.Random;

import GUI.PanelManager;
import Interface.AnimatedObject;
import PlayerStates.Direction;

public class Heart implements AnimatedObject{

	public Heart(PanelManager PM) {
		// TODO Auto-generated constructor stub
		currentFrameNumber = 0;
		heartCounter = 0;
	
		this.PM = PM;
		
		Player = this.PM.player;
		frame = Player.hearts.Heart[currentFrameNumber];
		
		rand = new Random();
		if(Player.DIR == Direction.LEFT) {
			// System.out.println("Tictoc is facing left");
			heartX = ((rand.nextInt() % this.Player.PLAYER_WIDTH/2) / 2) 
				+ (Player.playerX + this.Player.PLAYER_WIDTH/4);
		}
		else {
			// System.out.println("Tictoc is facing right");
			heartX = ((rand.nextInt() % this.Player.PLAYER_WIDTH/2) / 2) 
					+ (Player.playerX + this.Player.PLAYER_WIDTH / 2);
		}
		heartY = ((rand.nextInt() % this.Player.PLAYER_HEIGHT/2) / 3) 
				+ (Player.playerY + this.Player.PLAYER_HEIGHT/2);
		
		life = (rand.nextInt() % 30) + 75;
		
	}
	
	public void setMovement() {
		heartY--;
		heartX += ((heartY % 10) * Math.sin(heartY / 3));
	}

	public void setAnimation() {
		// TODO Auto-generated method stub
		animateFrame();
		
		frame = Player.hearts.Heart[currentFrameNumber];
		heartCounter++;
	}

	public void animateFrame() {
		// TODO Auto-generated method stub
		currentFrameNumber = heartCounter / FPS;
		currentFrameNumber %= Player.hearts.HEART_MAX_FRAMES;
		
		if(heartCounter >= FPS * Player.hearts.HEART_MAX_FRAMES) {
			currentFrameNumber = 18;
			reachLastFrame = true;
		}
	}

	public BufferedImage getFrame() {
		// TODO Auto-generated method stub
		if(life > 0) {
			setMovement();
			life -= 1;
		}
		else {
			setAnimation();
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
	
	private Player Player;
	
	private int life;
	private BufferedImage frame;
	public boolean reachLastFrame = false;
	public static int currentFrameNumber;
	private int heartCounter;
	private PanelManager PM;
	
	
}
