package GameObject;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.concurrent.*;

import javax.swing.JComponent;

import Interface.AnimatedObject;
import Interface.MouseResponse;
import PlayerStates.*;
import GUI.*;


public class Player extends JComponent implements AnimatedObject, MouseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6088949689473805765L;
	public Player(PanelManager PM) {
		// TODO Auto-generated constructor stub
		PanelManager = PM;
		OFFSET_Y = (SCREEN_SIZE.height / 18) - PanelManager.loadImage.PLAYER_HEIGHT / 67;
		playerX = (int)SCREEN_SIZE.getWidth() - PanelManager.loadImage.PLAYER_WIDTH;
		playerY = (int)SCREEN_SIZE.getHeight() - PanelManager.loadImage.PLAYER_HEIGHT - OFFSET_Y;
		cursor = PanelManager.cursor;
		PLAYER_WIDTH = PanelManager.loadImage.PLAYER_WIDTH;
		PLAYER_HEIGHT = PanelManager.loadImage.PLAYER_HEIGHT;
		pl = this;
		
		hearts = new ManageHeart(PanelManager);
		feed = new ManageFood(PanelManager);
		
		hunger = new HungerStats(PanelManager);
		sanity = new SanityStats(PanelManager);

		hitbox = new Rectangle(playerX, playerY, PanelManager.loadImage.PLAYER_WIDTH, PanelManager.loadImage.PLAYER_HEIGHT);
		
		this.setLocation(new Point(playerX, playerY));
		this.setSize(new Dimension(PanelManager.loadImage.PLAYER_WIDTH, PanelManager.loadImage.PLAYER_HEIGHT));
		this.setBounds(hitbox);
		
		idle = new IDLE(this);
		move = new MOVE(this);
		sleep = new SLEEP(this);
		die = new DIE(this);
		sit = new SIT(this);
		
		frame = PanelManager.loadImage.Player[0][0];
		currentFrameNumber = 0;
		STATUS = Status.IDLE;
		PS = idle;
		DIR = Direction.LEFT;
		
		addMouseResponse();

		resumeAct();
	}
	
	public void live() {
		setAnimation();

		PS.act();
	}
	
	public void sleep() {
		if(sleeping) {
			PS = sleep;
			pauseStat();
			PS.setFrameCounter(0);
		}
		else {
			PS = idle;
			sitting = false;
			
			resumeStat();
			resumeAct();
		}
		
	}
	
	public void die() {
		if(!(PS instanceof DIE)) {
	
			PS = die;
			PS.updateFrameCounter(0);
		}

		setAnimation();
		if(currentFrameNumber < 10) {
			PS.act();
		}
	}
	
	public void resumeAct() {
		PanelManager.scheduleStatus.scheduleAtFixedRate(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				delayNum = rand.nextInt(3) + 1;
			}
			
		}, 0, 3, TimeUnit.SECONDS);
		
		PanelManager.scheduleStatus.scheduleAtFixedRate(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				actionNum = rand.nextInt(4);

				if(actionNum <= 1) {
					PS = idle;
				}
				else {
					if(!(PS instanceof MOVE)) {
						PS = move;
					}
					directNum = rand.nextInt(2);
					if(directNum == 0) {
						DIR = Direction.LEFT;
					}
					else {
						DIR = Direction.RIGHT;
					}
				}
				System.gc();
			}
			
		}, delayNum, delayNum, TimeUnit.SECONDS);
	}

	
	public void pauseStat() {
		PanelManager.scheduleStatus.shutdown();
	}
	
	public void resumeStat() {
		PanelManager.scheduleStatus = Executors.newScheduledThreadPool(1);
	}
	
	public void setAnimation() {
		// TODO Auto-generated method stub
		animateFrame();
		frame = PS.getCurrentFrame();
	}

	public void animateFrame() {
		// TODO Auto-generated method stub
		currentFrameNumber = PS.getFrameCounter() / FPS;
		currentFrameNumber %= PS.getAnimationFrames();
		
		if(PS.getFrameCounter() > FPS * PS.getAnimationFrames()) {
			PS.setFrameCounter(0);
		}
		
		if(actionNum <= 1) {
			idleFrameCache = currentFrameNumber;
		}
	}

	public BufferedImage getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
	
	public void addMouseResponse() {
		// TODO Auto-generated method stub	
		 
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent l) {
				cursor.setCursor1(pl);
			}
			public void mouseReleased(MouseEvent l) {
				cursor.setCursor0(pl);
				heartDelay = 0;
			}
			public void mouseClicked(MouseEvent l) {
				if(alive) {
					if(!sitting) {
						// System.out.println("sitting");
						PanelManager.UserInterface.getButtons().checkSleeping = true;
						PS = sit;// TICTOC is sitting
						sitting = true;
						
						pauseStat();
					}
					else {
						// System.out.println("not sitting");
						PanelManager.UserInterface.getButtons().checkSleeping = true;
						PS = idle;
						
						resumeStat();
						resumeAct();
						
						sitting = false;
					}	
				}
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent l) {
				if(alive) {

					if(hearts.Hearts.size() < 8) {
						heartDelay++;
						if(heartDelay > MAX_HEART_DELAY) {
							// System.out.println(hearts.Hearts.size());
							hearts.addHeart();
							heartDelay = 0;
						}
					}
				}
			}
		});
	}
	
	public void setCursor(ManageCursor cursor) {
		this.cursor = cursor;
	}
	
	public void initializeStats() {
		sleeping = false;
		sitting = false;
		alive = true;
		PanelManager.UserInterface.getButtons().checkSleeping = true;
		
		hunger.update();
		sanity.update();
		PS = idle;
		setAnimation();
		STATUS = Status.IDLE;
	}
	
	private BufferedImage frame;
	public int currentFrameNumber;
	@SuppressWarnings("unused")
	private int idleFrameCache = 0;
	
	public ManageHeart hearts;
	public boolean flyingHeart;
	public boolean sleeping = false;
	public boolean alive = true;
	private int heartDelay = 0;
	private final int MAX_HEART_DELAY = 30;
	
	public ManageFood feed;
	
	public int HUNGER = 100;
	public int SANITY = 100;
	public int FRIENDSHIP = 5;
	
	public HungerStats hunger;
	@SuppressWarnings("unused")
	public SanityStats sanity;
	private ManageCursor cursor;
	public PanelManager PanelManager;
	
	public Direction DIR;
	@SuppressWarnings("unused")
	private Status STATUS;
	public Rectangle hitbox;
	private int actionNum = 0;
	private int directNum = 0;
	private int delayNum = 1;
	public boolean sitting = false;
	private Random rand = new Random();
	public PlayerStatus PS;
	final Player pl;
	
	public int playerX;
	public int playerY;
	public Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	private int OFFSET_Y;
	public int PLAYER_WIDTH;
	public int PLAYER_HEIGHT;
	
	private PlayerStatus idle;
	private PlayerStatus move;
	private PlayerStatus sleep;
	private PlayerStatus die;
	private PlayerStatus sit;
	
}
