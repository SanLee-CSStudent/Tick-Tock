package GUI;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GameObject.Heart;

public class ManageHeart {

	public ManageHeart(PanelManager PM) {
		// TODO Auto-generated constructor stub
		Hearts = new ArrayList<Heart>();
		this.PM = PM;
		
		this.HEART_MAX_FRAMES = this.PM.loadImage.HEART_MAX_FRAMES;
		Heart = new BufferedImage[this.HEART_MAX_FRAMES];
		
		for(int i = 0; i < this.HEART_MAX_FRAMES; i++) {
			Heart[i] = this.PM.loadImage.Heart[i];
		}
		
	}
	
	public void addHeart() {
		if(Hearts.size() < 16) {
			Heart heart = new Heart(PM);
			Hearts.add(heart);
		}
	}
	
	public void removeHeart(Heart dead) {
		Hearts.remove(dead);
		
		if(PM.player.FRIENDSHIP < 100) {
			PM.player.FRIENDSHIP += 1;
		}
		
		PM.Friendship.incrementFriendship();

	}
	public ArrayList<Heart> Hearts;
	private PanelManager PM;
	public BufferedImage[] Heart;
	public int HEART_MAX_FRAMES;
}
