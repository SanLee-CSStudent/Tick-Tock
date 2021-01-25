package GameObject;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import GUI.PanelManager;
import Interface.AnimatedObject;
import Interface.MouseResponse;

public class Food extends JComponent implements AnimatedObject, MouseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2852100400289331500L;
	public Food(PanelManager PM, int x, int y) {
		// TODO Auto-generated constructor stub
		foodX = x;
		foodY = y;
		this.setLocation(foodX, foodY);
		hitbox.setLocation(foodX, foodY);
		this.setBounds(hitbox);
		
		this.PM = PM;
		
		frame = this.PM.player.feed.Food[currentFrameNumber];
		
		addMouseResponse();
	}

	public void setAnimation() {
		// TODO Auto-generated method stub
		animateFrame();
		
		frame = this.PM.player.feed.Food[currentFrameNumber];
	}

	public void animateFrame() {
		// TODO Auto-generated method stub
		currentFrameNumber = foodCounter / FPS;
		currentFrameNumber %= this.PM.player.feed.FOOD_MAX_FRAMES;
		
		if(foodCounter >= FPS * this.PM.player.feed.FOOD_MAX_FRAMES) {
			foodCounter = 0;
		}
	}

	public BufferedImage getFrame() {
		// TODO Auto-generated method stub
		setAnimation();
		
		foodCounter++;
		
		return frame;
	}
	
	public void addMouseResponse() {
		// TODO Auto-generated method stub
		final Food fd = this;
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent l) {
				// System.out.println("Food pressed");
				PM.cursor.setCursor1(PM);
				foodX = l.getX();
				foodY = l.getY();
				foodX = l.getXOnScreen();
				foodY = l.getYOnScreen();
			}
			public void mouseReleased(MouseEvent l) {
				PM.cursor.setCursor0(PM);
				if(PM.player.hitbox.contains(PM.player.feed.foods.get(0).hitbox) && PM.player.alive) {
					PM.player.feed.foods.remove(0);
					
					PM.player.HUNGER += 25;
					if(PM.player.HUNGER > 100) {
						PM.player.HUNGER = 100;
					}
					
					PM.UserInterface.getBars().hungerBar.hunger = PM.player.feed.HUNGER_BAR
							.getSubimage(0, 0, (int)(((double)PM.player.HUNGER / PM.UserInterface.getBars().hungerBar.BAR_WIDTH) * 81), PM.UserInterface.getBars().hungerBar.BAR_HEIGHT);
					
				}
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent l) {
				foodX = l.getXOnScreen();
				foodY = l.getYOnScreen();
				
				fd.setLocation(foodX, foodY);
				hitbox.setLocation(foodX, foodY);
			}
		});
	}
	
	private BufferedImage frame;
	
	public static int currentFrameNumber = 0;
	private int foodCounter = 0;
	private PanelManager PM;
	
	public static final int FOOD_WIDTH = 39;
	public static final int FOOD_HEIGHT = 36;
	
	public final Rectangle hitbox = new Rectangle(FOOD_WIDTH, FOOD_HEIGHT);
	
	public int foodX=0;
	public int foodY=0;
}
