package GUI;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GameObject.Food;

public class ManageFood {
	
	public ManageFood(PanelManager PM) {
		foods = new ArrayList<Food>();
		this.PM = PM;
		
		FOOD_MAX_FRAMES = this.PM.loadImage.FOOD_MAX_FRAMES;
		Food = new BufferedImage[FOOD_MAX_FRAMES];
		for(int i = 0; i < this.FOOD_MAX_FRAMES; i++) {
			Food[i] = this.PM.loadImage.Food[i];
		}
		
		HUNGER_BAR = PM.loadImage.Bar[1];
	}
	
	public void addFood(Food fd) {
		food = fd;
		
		PM.add(food);
		foods.add(food);
	}

	public ArrayList<Food> foods;
	public BufferedImage[] Food;
	public BufferedImage HUNGER_BAR;
	private Food food;
	private PanelManager PM;
	public int FOOD_MAX_FRAMES;
}
