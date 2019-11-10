package GameObject;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JLabel;

import GUI.FeedButton;
import GUI.GameFrame;
import GUI.GamePanel;
import GUI.Images;
import Interface.AnimatedObject;
import Interface.MouseResponse;

public class Food extends JComponent implements AnimatedObject, MouseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2852100400289331500L;
	public Food(int x, int y) {
		// TODO Auto-generated constructor stub
		foodX = x;
		foodY = y;
		this.setLocation(new Point(foodX, foodY));
		hitbox.setLocation(new Point(foodX, foodY));
		this.setBounds(hitbox);
		
		frame = Images.Food[currentFrameNumber];
		addMouseResponse();
	}

	@Override
	public void setAnimation() {
		// TODO Auto-generated method stub
		animateFrame();
		
		frame = Images.Food[currentFrameNumber];
	}

	@Override
	public void animateFrame() {
		// TODO Auto-generated method stub
		currentFrameNumber = foodCounter / FPS;
		currentFrameNumber %= Images.FOOD_MAX_FRAMES;
		
		if(foodCounter >= FPS * Images.FOOD_MAX_FRAMES) {
			foodCounter = 0;
		}
	}

	@Override
	public BufferedImage getFrame() {
		// TODO Auto-generated method stub
		setAnimation();
		
		foodCounter++;
		
		return frame;
	}
	
	@Override
	public void addMouseResponse() {
		// TODO Auto-generated method stub
		Food fd = this;
		this.setOpaque(true);
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent l) {
				// System.out.println("Food pressed");
				GameFrame.cursor.setCursor1(fd);
				foodX = l.getX();
				foodY = l.getY();
				foodX = l.getXOnScreen();
				foodY = l.getYOnScreen();
			}
			public void mouseReleased(MouseEvent l) {
				GameFrame.cursor.setCursor0(fd);
				
				if(hitbox.contains(GamePanel.player.hitbox)) {
					System.out.println("Food and Player Collided");
					FeedButton.feed.foodHover = false;
					FeedButton.feed.foods.remove(fd);
				}
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent l) {
				foodX = l.getXOnScreen();
				foodY = l.getYOnScreen();
				hitbox.setLocation(foodX, foodY);
				fd.setLocation(foodX, foodY);
			}
		});
	}
	
	private BufferedImage frame;
	public static int currentFrameNumber = 0;
	private int foodCounter = 0;
	
	public static final int FOOD_WIDTH = 39;
	public static final int FOOD_HEIGHT = 36;
	
	public final Rectangle hitbox = new Rectangle(FOOD_WIDTH, FOOD_HEIGHT);
	
	public int foodX=0;
	public int foodY=0;
	
}
