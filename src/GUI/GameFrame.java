package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements Serializable{

	/**
	 * GameFrame class builds literally the frame of the game; however the actual frame will be invisible
	 */
	private static final long serialVersionUID = 7856046888785438219L;

	public GameFrame() {
		// TODO Auto-generated constructor stub
		// System.out.println("GameFrame()");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAutoRequestFocus(true);
		this.requestFocusInWindow(true);
		this.setUndecorated(true);
		
		final CountDownLatch latch = new CountDownLatch(1);
		Thread initialize = new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				layerManager = new PanelManager();
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
	
		gameInterface = new GameInterface(layerManager);
		gameInterface.start();
		
		layerManager.cursor.setCursor0(layerManager);
		
		setSize(SCREEN_SIZE.width, SCREEN_SIZE.height);
		setBackground(new Color(0,255,0,0));// set background to be invisible
		setContentPane(layerManager);
		// pack();
		
		icon = layerManager.loadImage.Player[0][0];
		
		this.setAlwaysOnTop(true);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setIconImage(layerManager.loadImage.Player[0][0]);
		
		layerManager.loadImage = null;
	}
	
	GameInterface gameInterface;
	PanelManager layerManager;
	Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	BufferedImage icon;
}
