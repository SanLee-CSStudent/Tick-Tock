package GUI;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import javax.imageio.ImageIO;

public class Images {

	public Images() {
		// TODO Auto-generated constructor stub
		
		final CountDownLatch latch = new CountDownLatch(1);
		Thread initialize = new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				File imagesaves = new File("TICKTOCK_lib\\image.tock");
				Player = new BufferedImage[PLAYER_STATES * PLAYER_FACING_DIRECTION][PLAYER_MAX_FRAMES];
				Player_Dead = new BufferedImage[PLAYER_FACING_DIRECTION][PLAYER_DIE_FRAMES];
				Cursor = new Image[CURSOR_MAX_FRAMES];
				Bar = new BufferedImage[BAR_MAX_FRAMES];
				Heart = new BufferedImage[HEART_MAX_FRAMES];
				Food = new BufferedImage[FOOD_MAX_FRAMES];
				String = new BufferedImage[STRING_MAX_FRAMES];
				Number = new BufferedImage[NUMBER_MAX_FRAMES];
				Buttons = new Image[BUTTON_TYPES][BUTTON_STATES];
				
				if(!imagesaves.exists()) {
					loadImages();
					
					serialized = new Serializer(images);
				}
				else {
					serialized = new Serializer(imagesaves);
					
					decodeImages();
				}
				latch.countDown();
			}
			
		});
		initialize.start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void decodeImages() {
		ArrayList<BufferedImage> imageArrays = serialized.getImageArray();
		int k = 0;
		for(int i=0; i < PLAYER_IDLE_FRAMES; i++) {

			Player[0][i] = imageArrays.get(k);
			imageArrays.remove(k);			
		}
		
		for(int i=0; i<PLAYER_IDLE_FRAMES; i++) {// loading Idle Image looking to the right
			
			Player[1][i] = imageArrays.get(k);
			imageArrays.remove(k);	
		}
		
		for(int i=0; i<PLAYER_MOVE_FRAMES; i++) {// loading Move Image looking to the right
			
			Player[2][i] = imageArrays.get(k);
			imageArrays.remove(k);	
		}
		
		for(int i=0; i<PLAYER_MOVE_FRAMES; i++) {// loading Move Image looking to the right
			
			Player[3][i] = imageArrays.get(k);
			imageArrays.remove(k);	
		}
		
		for(int i=0; i<PLAYER_SIT_FRAMES; i++) {
			Player[4][i] = imageArrays.get(k);
			imageArrays.remove(k);	
		}
		
		for(int i=0; i<PLAYER_SIT_FRAMES; i++) {
			Player[5][i] = imageArrays.get(k);
			imageArrays.remove(k);	
		}
		
		for(int i=0; i<PLAYER_SLEEP_FRAMES; i++) {
			Player[6][i] = imageArrays.get(k);
			imageArrays.remove(k);	
		}
		
		for(int i=0; i<PLAYER_SLEEP_FRAMES; i++) {
			Player[7][i] = imageArrays.get(k);
			imageArrays.remove(k);	

		}
		
		for(int i=0; i<PLAYER_SLEEPING_FRAMES; i++) {
			Player[8][i] = imageArrays.get(k);
			imageArrays.remove(k);	
		}
		
		for(int i=0; i<PLAYER_SLEEPING_FRAMES; i++) {
			Player[9][i] = imageArrays.get(k);
			imageArrays.remove(k);	
		}
		
		for(int i=0; i<PLAYER_DIE_FRAMES; i++) {
			Player_Dead[0][i] = imageArrays.get(k);
			imageArrays.remove(k);	
		}
		
		for(int i=0; i<PLAYER_DIE_FRAMES; i++) {
			Player_Dead[1][i] = imageArrays.get(k);
			imageArrays.remove(k);	
		}
		
		for(int i=0; i<CURSOR_MAX_FRAMES;i++) {
			Cursor[i] = imageArrays.get(k);
			imageArrays.remove(k);
		}
		
		for(int i=0; i<HEART_MAX_FRAMES; i++) {
			Heart[i] = imageArrays.get(k);
			imageArrays.remove(k);
		}
		
		for(int i=0; i<FOOD_MAX_FRAMES; i++) {
			Food[i] = imageArrays.get(k);
			imageArrays.remove(k);
		}
		
		for(int j=0; j<BUTTON_TYPES; j++) {
			for(int i=0; i<BUTTON_STATES; i++) {
				// System.out.println(j + "; " + i + "; " + (2*j + i));
				Buttons[j][i] = imageArrays.get(k);
				imageArrays.remove(k);
			}
		}
		
		UI = imageArrays.get(0);
		imageArrays.remove(0);
		
		for(int i = 0; i < STRING_MAX_FRAMES; i++) {
			String[i] = imageArrays.get(k);
			imageArrays.remove(k);
		}
		
		for(int i = 0; i < NUMBER_MAX_FRAMES; i++) {
			
			Number[i] = imageArrays.get(k);
			imageArrays.remove(k);
		}
		
		for(int i=0; i<BAR_MAX_FRAMES; i++) {
			Bar[i] = imageArrays.get(k);
			imageArrays.remove(k);
		}
		
		Display = imageArrays.get(0);
		imageArrays.remove(0);
	}
	
	private void loadImages() {
		
		try {
			loadPlayer();
			loadCursor();
			loadObjects();
			loadUI();
			loadExtra();
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
			images.add(Player[0][j]);
		}
		
		for(int j=0; j<PLAYER_IDLE_FRAMES; j++) {// loading Idle Image looking to the right
			if(j < 10) {
				Player[1][j] = ImageIO.read(new FileInputStream("src//Sprites//Images//IdleImage_Tictoc//idle_R0" + j +".png"));
				
			}
			else {
				Player[1][j] = ImageIO.read(new FileInputStream("src//Sprites//Images//IdleImage_Tictoc//idle_R" + j +".png"));
				
			}
			images.add(Player[1][j]);
		}
		
		for(int i=0; i<PLAYER_MOVE_FRAMES; i++) {// loading Move Image looking to the right
			Player[2][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//RunImage_Tictoc//run_L" + i + ".png"));
			images.add(Player[2][i]);
		}
		
		for(int i=0; i<PLAYER_MOVE_FRAMES; i++) {// loading Move Image looking to the right
			Player[3][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//RunImage_Tictoc//run_R" + i + ".png"));
			images.add(Player[3][i]);
		}
		
		for(int i=0; i<PLAYER_SIT_FRAMES; i++) {
			if(i < 10) {
				Player[4][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//SitImage_Tictoc//sit_L0" + i +".png"));
				
			}
			else {
				Player[4][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//SitImage_Tictoc//sit_L" + i +".png"));
				
			}
			images.add(Player[4][i]);
		}
		
		for(int i=0; i<PLAYER_SIT_FRAMES; i++) {
			if(i < 10) {
				Player[5][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//SitImage_Tictoc//sit_R0" + i +".png"));
				
			}
			else {
				Player[5][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//SitImage_Tictoc//sit_R" + i +".png"));
				
			}
			images.add(Player[5][i]);
		}
		
		for(int i=0; i<PLAYER_SLEEP_FRAMES; i++) {
			if(i < 10) {
				Player[6][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//SleepImage_Tictoc//sleep_L0" + i +".png"));
				images.add(Player[6][i]);
			}
		}
		
		for(int i=0; i<PLAYER_SLEEP_FRAMES; i++) {
			if(i < 10) {
				Player[7][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//SleepImage_Tictoc//sleep_R0" + i +".png"));
				images.add(Player[7][i]);
			}

		}
		
		for(int i=0; i<PLAYER_SLEEPING_FRAMES; i++) {
			if(i < 10) {
				Player[8][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//SleepImage_Tictoc//sleeping_L0" + i +".png"));
			}
			else {
				Player[8][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//SleepImage_Tictoc//sleeping_L" + i +".png"));
			}
			images.add(Player[8][i]);
		}
		
		for(int i=0; i<PLAYER_SLEEPING_FRAMES; i++) {
			if(i < 10) {
				Player[9][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//SleepImage_Tictoc//sleeping_R0" + i +".png"));
			}
			else {
				Player[9][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//SleepImage_Tictoc//sleeping_R" + i +".png"));
			}
			images.add(Player[9][i]);
		}
		
		for(int i=0; i<PLAYER_DIE_FRAMES; i++) {
			Player_Dead[0][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//DieImage_Tictoc//Die_L" + (i+1) +".png"));
			images.add(Player_Dead[0][i]);
		}
		
		for(int i=0; i<PLAYER_DIE_FRAMES; i++) {
			Player_Dead[1][i] = ImageIO.read(new FileInputStream("src//Sprites//Images//DieImage_Tictoc//Die_R" + (i+1) +".png"));
			images.add(Player_Dead[1][i]);
		}
	}
	
	private void loadCursor() throws IOException {
		for(int i=0; i<CURSOR_MAX_FRAMES;i++) {
			Cursor[i] = ImageIO.read(new FileInputStream("src\\Sprites\\Icons\\Cursor\\Cursor" + i + ".png"));
			images.add((BufferedImage) Cursor[i]);
		}
	}
	
	private void loadObjects() throws IOException {
		for(int i=0; i<HEART_MAX_FRAMES; i++) {
			Heart[i] = ImageIO.read(new FileInputStream("src\\Sprites\\Icons\\Heart\\heart" + (i+1) + ".png"));
			images.add(Heart[i]);
		}
		
		for(int i=0; i<FOOD_MAX_FRAMES; i++) {
			Food[i] = ImageIO.read(new FileInputStream("src\\Sprites\\Icons\\Food\\Food" + (i+1) + ".png"));
			images.add(Food[i]);
		}
	}
	
	private void loadUI() throws IOException{
		for(int j=0; j<BUTTON_TYPES; j++) {
			for(int i=0; i<BUTTON_STATES; i++) {
				// System.out.println(j + "; " + i + "; " + (2*j + i));
				Buttons[j][i] = ImageIO.read(new FileInputStream("src\\Sprites\\Images\\UI\\UI_Button" + (2*j + i) + ".png" ));
				images.add((BufferedImage) Buttons[j][i]);
			}
		}
		
		UI = ImageIO.read(new FileInputStream("src\\Sprites\\Images\\UI\\UI_Background.png"));
		images.add((BufferedImage) UI);
		for(int i = 0; i < STRING_MAX_FRAMES; i++) {
			String[i] = ImageIO.read(new FileInputStream("src\\Sprites\\Icons\\String\\String" + i + ".png"));
			images.add(String[i]);
		}
		
		for(int i = 0; i < NUMBER_MAX_FRAMES; i++) {
			Number[i] = ImageIO.read(new FileInputStream("src\\Sprites\\Icons\\String\\Number" + i + ".png"));
			images.add(Number[i]);
		}
		
		for(int i=0; i<BAR_MAX_FRAMES; i++) {
			Bar[i] = ImageIO.read(new FileInputStream("src\\Sprites\\Icons\\Bar\\Bar" + (i+1) + ".png"));
			images.add(Bar[i]);
		}
	}
	
	private void loadExtra() throws IOException{
		// Background = ImageIO.read(new FileInputStream("src\\Sprites\\Images\\Background\\Ocean.png"));
		Display = ImageIO.read(new FileInputStream("src\\Sprites\\Icons\\Bar\\HoveringBar.png"));
		images.add((BufferedImage) Display);
	}
	
	private final int PLAYER_STATES = 5;
	private final int PLAYER_FACING_DIRECTION = 2;
	public final int PLAYER_MOVE_FRAMES = 6;
	public final int PLAYER_IDLE_FRAMES = 12;
	public final int PLAYER_SIT_FRAMES = 12;
	public final int PLAYER_SLEEP_FRAMES = 5;
	public final int PLAYER_SLEEPING_FRAMES = 12;
	public final int PLAYER_DIE_FRAMES = 17;
	public final int BUTTON_TYPES = 4;
	public final int BUTTON_STATES = 2;
	public final int FOOD_MAX_FRAMES = 8;
	
	private final int BAR_MAX_FRAMES = 6;
	private final int PLAYER_MAX_FRAMES = 12;
	private final int CURSOR_MAX_FRAMES = 5;
	public final int STRING_MAX_FRAMES = 3;
	public final int NUMBER_MAX_FRAMES = 11;
	public final int HEART_MAX_FRAMES = 19;

	public final int PLAYER_WIDTH = 134;
	public final int PLAYER_HEIGHT = 134;
	
	// public Image Background;
	public Image Display;
	public Image[] Cursor;
	public Image[][] Buttons;
	public Image UI;
	public BufferedImage[] Number;
	public BufferedImage[] String;
	public BufferedImage[] Bar;
	public BufferedImage[] Heart;
	public BufferedImage[] Food;
	public BufferedImage[][] Player;// 0~1 Idle_left and Idle_right
	public BufferedImage[][] Player_Dead;
	
	volatile transient ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
	volatile private Serializer serialized;
}
