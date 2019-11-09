package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GameFrame extends JFrame{

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
		
		gamePanel = new GamePanel();
		gameInterface = new GameInterface(gamePanel);
		gameInterface.start();
		
		this.add(gamePanel);
		
		setSize(SCREEN_SIZE.width, SCREEN_SIZE.height);
		setBackground(new Color(0,255,0,0));// set background to be invisible
		setContentPane(gamePanel);
		pack();
		
		this.setAlwaysOnTop(true);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}
	
	GamePanel gamePanel;
	GameInterface gameInterface;
	
	public static Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
}
