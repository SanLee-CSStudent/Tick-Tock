package GUI;

import java.util.ArrayList;

import GameObject.Heart;

public class ManageHeart {

	public ManageHeart() {
		// TODO Auto-generated constructor stub
		Hearts = new ArrayList<Heart>();
	}
	
	public void addHeart() {
		if(Hearts.size() < 12) {
			Heart heart = new Heart();
			Hearts.add(heart);
		}
	}
	
	public ArrayList<Heart> Hearts;
}
