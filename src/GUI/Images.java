package GUI;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class Images {

	public Images() {
		// TODO Auto-generated constructor stub
		Player = new BufferedImage[PLAYER_STATES * PLAYER_FACING_DIRECTION][PLAYER_MAX_FRAMES];
		Cursor = new Image[CURSOR_MAX_FRAMES];
		Heart = new BufferedImage[HEART_MAX_FRAMES];
		try {
			loadPlayer();
			loadCursor();
			loadHeart();
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
		
		for(int i=0; i<PLAYER_MOVE_FRAMES; i++) {// loading Move Image looking to the right
			Player[2][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//RunImage_Tictoc//run_L" + i + ".png"));
		}
		
		for(int i=0; i<PLAYER_MOVE_FRAMES; i++) {// loading Move Image looking to the right
			Player[3][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//RunImage_Tictoc//run_R" + i + ".png"));
		}
		
		for(int i=0; i<PLAYER_SIT_FRAMES; i++) {
			if(i < 10) {
				Player[4][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//SitImage_Tictoc//sit_L0" + i +".png"));
			}
			else {
				Player[4][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//SitImage_Tictoc//sit_L" + i +".png"));
			}
		}
		
		for(int i=0; i<PLAYER_SIT_FRAMES; i++) {
			if(i < 10) {
				Player[5][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//SitImage_Tictoc//sit_R0" + i +".png"));
			}
			else {
				Player[5][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//SitImage_Tictoc//sit_R" + i +".png"));
			}
		}
	}
	
	private void loadCursor() throws IOException {
		for(int i=0; i<CURSOR_MAX_FRAMES;i++) {
			Cursor[i] = ImageIO.read(new FileInputStream("src\\Sprites\\Icons\\Cursor\\Cursor" + i + ".png"));
		}
	}
	
	private void loadHeart() throws IOException {
		for(int i=0; i<HEART_MAX_FRAMES; i++) {
			Heart[i] = ImageIO.read(new FileInputStream("src\\Sprites\\Icons\\Heart\\heart" + (i+1) + ".png"));
		}
	}
	
	private final int PLAYER_STATES = 3;
	private final int PLAYER_FACING_DIRECTION = 2;
	public static final int PLAYER_MOVE_FRAMES = 6;
	public static final int PLAYER_IDLE_FRAMES = 12;
	public static final int PLAYER_SIT_FRAMES = 12;
	
	private final int PLAYER_MAX_FRAMES = 12;
	private final int CURSOR_MAX_FRAMES = 5;
	public static final int HEART_MAX_FRAMES = 19;

	public static final int PLAYER_WIDTH = 134;
	public static final int PLAYER_HEIGHT = 134;
	public static Image[] Cursor;
	public static BufferedImage[] Heart;
	public static BufferedImage[][] Player;// 0~1 Idle_left and Idle_right
}
