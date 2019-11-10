package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Interface.MouseResponse;

public class UserInterface extends JPanel implements MouseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7261034772372245326L;

	public UserInterface() {
		// TODO Auto-generated constructor stub
		this.setSize(new Dimension(UI_WIDTH, UI_HEIGHT));
		this.setLocation(new Point(UIx, UIy));
		this.setBounds(new Rectangle(UI_WIDTH, UI_HEIGHT));
		
		this.setLayout(new GridLayout(2, 2, 15, 15));
		
		feed = new FeedButton();
		sleep = new SleepButton();
		weather = new WeatherButton();
		exit = new ExitButton();
		
		this.add(feed);
		this.add(sleep);
		this.add(weather);
		this.add(exit);
		
		this.setBorder(BorderFactory.createEmptyBorder(60, 20, 15, 15));
		addMouseResponse();
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(Images.UI, 0, 0, null);
	}

	@Override
	public void addMouseResponse() {
		// TODO Auto-generated method stub
		UserInterface UI = this;
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// MouseResponse.cursor = new ImageIcon(ImageIO.read(new java.io.FileInputStream("basicSystem\\src\\icons\\Cursor\\masterHand1.png")));
				GameFrame.cursor.setCursor1(UI);
				
				UIx = e.getX();
				UIy = e.getY();
			}
			
			public void mouseReleased(MouseEvent e) {
				GameFrame.cursor.setCursor0(UI);
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				UI.setLocation(UI.getX() + e.getX() - UIx, UI.getY() + e.getY() - UIy);
				
			}
		});
	}
	
	private int UIx = GameFrame.SCREEN_SIZE.width - UI_WIDTH - UI_offset;
	private int UIy = UI_offset;
	
	public static final int UI_WIDTH = 240;// ((int)GameFrame.WIDTH) / 8;// 240
	public static final int UI_HEIGHT = 180;// ((int)GameFrame.HEIGHT) / 6;// 180
	private static final int UI_offset = 38;
	
	private BaseButton feed;
	private BaseButton sleep;
	private BaseButton weather;
	private BaseButton exit;

}
