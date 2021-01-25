package PlayerInteract;

import java.awt.image.BufferedImage;

import GameObject.Player;

public class Friendship extends Bar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1307004900758359356L;
	public Friendship(Player player) {
		// TODO Auto-generated constructor stub
		this.player = player;
		
		friendship = this.player.PanelManager.loadImage.Bar[3];
		FRIENDSHIP_BAR = this.player.PanelManager.loadImage.Bar[3];
		friendshipX = this.player.playerX + this.player.PanelManager.loadImage.PLAYER_WIDTH - 20;
		friendshipY = this.player.playerY;
		barY = friendshipY + 60;
		incrementFriendship();
	}
	
	public void incrementFriendship() {
		this.friendship = FRIENDSHIP_BAR.getSubimage(0, 60 - (int)(((double)player.FRIENDSHIP / FRIENDSHIP_BAR.getHeight()) * 36), 20, (int)(((double)player.FRIENDSHIP / FRIENDSHIP_BAR.getHeight()) * 36));
		barY = friendshipY - (int)(((double)player.FRIENDSHIP / FRIENDSHIP_BAR.getHeight()) * 36) + 60;
	}
	
	public void addMouseResponse() {
		// TODO Auto-generated method stub
		
	}
	
	private Player player;
	
	public BufferedImage friendship;
	private BufferedImage FRIENDSHIP_BAR;
	public int friendshipX;
	public int friendshipY;
	public int barY;
}
