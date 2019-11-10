package GUI;

import java.awt.*;

import javax.swing.JPanel;

import GameObject.Player;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2693863158529022511L;

	public GamePanel() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		gamepanel = this;
		
		player = new Player();// only one player object should exist
		this.add(player);
		
		UI = new UserInterface();
		UI.setLocation(new Point(UI.UIx, UI.UIy));
		this.add(UI);
		
		setBackground(new Color(255, 255, 255, 0));
		
		this.setPreferredSize(GameFrame.SCREEN_SIZE);
		
		this.setDoubleBuffered(true);
		this.setOpaque(false);
		
		// this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(player.getFrame(), player.playerX, player.playerY, null);
		// g2.drawRect(player.hitbox.x, player.hitbox.y, player.hitbox.width, player.hitbox.height);
		
		if(player.hearts.Hearts.size() > 0) {
			for(int h=0; h<player.hearts.Hearts.size(); h++) {
				// System.out.println("drawHeart");
				try {
					g2.drawImage(player.hearts.Hearts.get(h).getFrame(), player.hearts.Hearts.get(h).getX(), player.hearts.Hearts.get(h).getY(), null);
					if(player.hearts.Hearts.get(h).reachLastFrame) {
						player.hearts.Hearts.remove(player.hearts.Hearts.get(h));
					}
				} catch(IndexOutOfBoundsException e) {
					e.addSuppressed(e);
				}
			}
		}
		
		if(FeedButton.feed.foodHover) {
			// g2.drawRect(FeedButton.feed.foods.get(0).hitbox.x, FeedButton.feed.foods.get(0).hitbox.y, FeedButton.feed.foods.get(0).hitbox.width, FeedButton.feed.foods.get(0).hitbox.height);
			g2.drawImage(FeedButton.feed.foods.get(0).getFrame(), FeedButton.feed.foods.get(0).foodX, FeedButton.feed.foods.get(0).foodY, null);
		}
	}
	
	public static Player player;
	public static GamePanel gamepanel;
	public static UserInterface UI;

}
