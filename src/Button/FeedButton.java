package Button;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import GUI.ManageFood;
import GUI.PanelManager;
import GameObject.Food;
import Interface.MouseResponse;

public class FeedButton extends BaseButton implements MouseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5440670740177461383L;

	public FeedButton(PanelManager PM) {
		// TODO Auto-generated constructor stub
		super(PM.cursor, new ImageIcon(PM.loadImage.Buttons[0][0]), new ImageIcon(PM.loadImage.Buttons[0][1]));
		this.PM = PM;
		
		addMouseResponse();
		
		feed = new ManageFood(this.PM);
	}
	
	public void addMouseResponse() {
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent l) {
				food = new Food(PM, PM.UserInterface.getX() + PM.UserInterface.getWidth() - Food.FOOD_WIDTH, PM.UserInterface.getY() + PM.UserInterface.getHeight());
				PM.player.feed.addFood(food);
			}
			
			public void mouseReleased(MouseEvent l) {
				
			}
		});
	}
	
	private Food food;
	public ManageFood feed;
	private PanelManager PM;
}
