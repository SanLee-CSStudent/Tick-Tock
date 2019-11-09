package GUI;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class Images {

	public Images() {
		// TODO Auto-generated constructor stub
		Player = new BufferedImage[PLAYER_STATES * PLAYER_FACING_DIRECTION][PLAYER_MAX_FRAMES];
		try {
			loadPlayer();
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	private void loadPlayer() throws IOException {
		for(int j=0; j<PLAYER_IDLE_FRAMES; j++) {// loading Idle Image looking to the left
			if(j < 10) {
				Player[0][j] = ImageIO.read(new FileInputStream("src//Sprites//Images//IdleImage_Tictoc//idle_L0" + j +".png"));
			}
			else {
				Player[0][j] = ImageIO.read(new FileInputStream("src//Sprites//Images//IdleImage_Tictoc//idle_L" + j +".png"));
			}
		}
		
		for(int j=0; j<PLAYER_IDLE_FRAMES; j++) {// loading Idle Image looking to the right
			if(j < 10) {
				Player[1][j] = ImageIO.read(new FileInputStream("src//Sprites//Images//IdleImage_Tictoc//idle_R0" + j +".png"));
			}
			else {
				Player[1][j] = ImageIO.read(new FileInputStream("src//Sprites//Images//IdleImage_Tictoc//idle_R" + j +".png"));
			}
		}
		
	}
	
	private final int PLAYER_STATES = 2;
	private final int PLAYER_FACING_DIRECTION = 2;
	public static final int PLAYER_MOVE_FRAMES = 6;
	public static final int PLAYER_IDLE_FRAMES = 12;
	private final int PLAYER_MAX_FRAMES = 12;

	public static final int PLAYER_WIDTH = 134;
	public static final int PLAYER_HEIGHT = 134;
	public static BufferedImage[][] Player;// 0~1 Idle_left and Idle_right
}
