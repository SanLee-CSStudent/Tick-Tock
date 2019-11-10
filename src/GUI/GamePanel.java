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
		player = new Player();// only one player object should exist
		this.add(player);
		
		UI = new UserInterface();
		this.add(UI);
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
	}
	
	public static Player player;
	public static UserInterface UI;
}
