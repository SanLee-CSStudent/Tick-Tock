package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.JLayeredPane;

import GameObject.Player;
import PlayerInteract.DisplayPanel;
import PlayerInteract.Friendship;
import PlayerInteract.UserInterface;

public class PanelManager extends JLayeredPane{

	/**
	 * PanelManager manages panel including UI, drawing, and display
	 */
	private static final long serialVersionUID = 1L;
	public PanelManager() {
		// TODO Auto-generated constructor stub
		loadImage = new Images();
		scheduleDelay = Executors.newScheduledThreadPool(1);
		scheduleStatus = Executors.newScheduledThreadPool(1);
		this.cursor = new ManageCursor(loadImage);
		
		DisplayPanel  = new DisplayPanel(this, cursor);
		UserInterface = new UserInterface(this, DisplayPanel, cursor);
		player = new Player(this);
		Friendship  = new Friendship(player);
		
		friendshipBarFrame = loadImage.Bar[4];
		
		this.setLayer(this, JLayeredPane.DEFAULT_LAYER);
		this.setLayer(UserInterface, JLayeredPane.DRAG_LAYER);
		this.setLayer(player, JLayeredPane.MODAL_LAYER);
		
		UserInterface.setLocation(new Point(UserInterface.UIx, UserInterface.UIy));
		DisplayPanel.addBars();
		
		this.add(UserInterface);
		this.add(DisplayPanel);
		this.add(player);
		
		this.setPreferredSize(SCREEN_SIZE);
		this.setDoubleBuffered(true);
		this.setOpaque(false);

		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	private void drawPlayer(Graphics g2) {
	
		g2.drawImage(player.getFrame(), player.playerX, player.playerY, null);		
		
		g2.drawImage(Friendship.friendship, Friendship.friendshipX, Friendship.barY, null);		
		g2.drawImage(friendshipBarFrame, Friendship.friendshipX, Friendship.friendshipY, null);
	
		if(player.hearts.Hearts.size() > 0) {
			for(int i = 0; i < player.hearts.Hearts.size(); i++) {
				if(player.hearts.Hearts.get(i).reachLastFrame) {
					player.hearts.removeHeart(player.hearts.Hearts.get(i));
				}
				else {
					g2.drawImage(player.hearts.Hearts.get(i).getFrame(), player.hearts.Hearts.get(i).getX(), player.hearts.Hearts.get(i).getY(), null);
				}
			}
		}
		
		if(player.feed.foods.size() > 0) {
			// g2.drawRect(FeedButton.feed.foods.get(0).hitbox.x, FeedButton.feed.foods.get(0).hitbox.y, FeedButton.feed.foods.get(0).hitbox.width, FeedButton.feed.foods.get(0).hitbox.height);
			g2.drawImage(player.feed.foods.get(0).getFrame(), player.feed.foods.get(0).foodX, player.feed.foods.get(0).foodY, null);
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// g2.drawRect(player.hitbox.x, player.hitbox.y, player.hitbox.width, player.hitbox.height);
		drawPlayer(g2);
		
	}

	public Player player;
	public GameInterface gameInterface;
	public Friendship Friendship;
	public DisplayPanel DisplayPanel;
	public UserInterface UserInterface;
	public ManageCursor cursor;
	public Images loadImage;
	public ScheduledExecutorService scheduleDelay;
	public ScheduledExecutorService scheduleStatus;
	private BufferedImage friendshipBarFrame;
	private Graphics2D g2;
	
	public Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
}
