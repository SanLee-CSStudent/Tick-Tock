package GameObject;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;
import Interface.AnimatedObject;
import Interface.MouseResponse;
import States.*;
import GUI.GameFrame;
import GUI.Images;
import GUI.ManageHeart;

public class Player extends JComponent implements AnimatedObject, MouseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6088949689473805765L;
	public Player() {
		// TODO Auto-generated constructor stub
		playerX = (int)GameFrame.SCREEN_SIZE.getWidth() - Images.PLAYER_WIDTH;
		playerY = (int)GameFrame.SCREEN_SIZE.getHeight() - Images.PLAYER_HEIGHT - OFFSET_Y;
		actTimer = new Timer();
		hearts = new ManageHeart();
		delayNum = 1000;
		hitbox = new Rectangle(playerX, playerY, Images.PLAYER_WIDTH, Images.PLAYER_HEIGHT);
		
		this.setLocation(new Point(playerX, playerY));
		this.setSize(new Dimension(Images.PLAYER_WIDTH, Images.PLAYER_HEIGHT));
		this.setBounds(hitbox);
		
		frame = Images.Player[0][0];
		currentFrameNumber = 0;
		STATUS = Status.IDLE;
		PS = new IDLE();
		DIR = Direction.LEFT;
		if(delayNum <= 0) {
			System.out.println(delayNum);
		}
		
		addMouseResponse();

		resumeAct();
	}
	public void live() {
		setAnimation();
		
		delayNum = rand.nextInt(3000) + 1000;

		PS.act();
	}
	
	private void resumeAct() {
		actTimer = new Timer();
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

	
	public void pause(Timer t) {
		t.cancel();
		t.purge();
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
	
	@Override
	public void addMouseResponse() {
		// TODO Auto-generated method stub
		// System.out.println("MouseResponse");
		Player pl = this;
		this.setOpaque(true);
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent l) {
				GameFrame.cursor.setCursor1(pl);
			}
			public void mouseReleased(MouseEvent l) {
				GameFrame.cursor.setCursor0(pl);
				heartDelay = 0;
			}
			public void mouseClicked(MouseEvent l) {
				if(!sitting) {
					PS = new SIT();// TICTOC is sitting
					sitting = true;
					pause(actTimer);
				}
				else {
					PS = new IDLE();
					resumeAct();
					sitting = false;
					
				}
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent l) {

				if(hearts.Hearts.size() < 8) {
					heartDelay++;
					if(heartDelay > MAX_HEART_DELAY) {
						// System.out.println(hearts.Hearts.size());
						hearts.addHeart();
						heartDelay = 0;
					}
				}
				
			}
		});
	}
	
	private BufferedImage frame;
	public static int currentFrameNumber;
	private int idleFrameCache = 0;
	private final int FPS = 6;
	
	private Timer actTimer;
	
	public ManageHeart hearts;
	public boolean flyingHeart;
	private int heartDelay = 0;
	private final int MAX_HEART_DELAY = 30;
	
	public static Direction DIR;
	@SuppressWarnings("unused")
	private Status STATUS;
	public Rectangle hitbox;
	private int actionNum = 0;
	private int directNum = 0;
	private int delayNum;
	public boolean sitting = false;
	private Random rand = new Random();
	public PlayerStatus PS;
	
	public int playerX;
	public int playerY;
	private final int OFFSET_Y = GameFrame.SCREEN_SIZE.height / 18;
	
}
