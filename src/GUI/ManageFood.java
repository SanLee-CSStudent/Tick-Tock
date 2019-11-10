package GUI;

import java.util.ArrayList;

import GameObject.Food;

public class ManageFood {
	
	public ManageFood() {
		foods = new ArrayList<Food>();
	}
	
	public ManageFood(Food fd) {
		// TODO Auto-generated constructor stub
		foods = new ArrayList<Food>();
		food = fd;

	}
	
	public void addFood(Food fd) {
		food = fd;
		
		GamePanel.gamepanel.add(food);
		foods.add(food);
	}

	public boolean foodHover = false;
	public ArrayList<Food> foods;
	private Food food;
}
