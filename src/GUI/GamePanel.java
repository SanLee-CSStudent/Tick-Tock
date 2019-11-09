package GUI;

import java.awt.*;

import javax.swing.JPanel;

import GameObject.Player;

public class GamePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2693863158529022511L;

	public GamePanel() {
		// TODO Auto-generated constructor stub
		player = new Player();// only one player object should exist
		
		setBackground(new Color(255, 255, 255, 0));
		
		this.setPreferredSize(GameFrame.SCREEN_SIZE);
		
		this.setLayout(null);

		this.setDoubleBuffered(true);
		this.setOpaque(false);
		
		// this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(player.getFrame(), player.playerX, player.playerY, null);
	}
	
	public static Player player;
}
