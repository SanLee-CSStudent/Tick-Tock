package PlayerInteract;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import GUI.ManageCursor;
import GUI.PanelManager;
import Interface.MouseResponse;

public class UserInterface extends JPanel implements MouseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7261034772372245326L;
	
	public UserInterface(PanelManager PM, DisplayPanel display, ManageCursor cursor) {
		// TODO Auto-generated constructor stub
		UIx = SCREEN_SIZE.width - UI_WIDTH - UI_offset;
		UIy = UI_offset;
		UIDisplay = display;
		this.cursor = cursor;
		this.PM = PM;
		this.UI = this;
		
		String = new BufferedImage[this.PM.loadImage.STRING_MAX_FRAMES];
		Number = new BufferedImage[this.PM.loadImage.NUMBER_MAX_FRAMES];
		
		for(int i = 0; i < this.PM.loadImage.STRING_MAX_FRAMES; i++) {
			String[i] = this.PM.loadImage.String[i];
		}
		
		for(int i = 0; i < this.PM.loadImage.NUMBER_MAX_FRAMES; i++) {
			Number[i] = this.PM.loadImage.Number[i];
		}
		
		Background = this.PM.loadImage.UI;
		Barground = this.PM.loadImage.Bar[5];
		Display = this.PM.loadImage.Display;
		
		bars = new BarPanel(PM);
		buttons = new ButtonPanel(PM);
		this.setOpaque(true);
		this.setDoubleBuffered(true);
		
		this.setSize(UI_WIDTH, UI_HEIGHT);
		this.setLocation(UIx, UIy);
		this.setBounds(new Rectangle(UI_WIDTH, UI_HEIGHT));
		
		this.add(bars);
		this.add(buttons);
		
		addMouseResponse();
		
		barY = bars.hungerBar.offsetY + bars.hungerBar.BAR_HEIGHT;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		
		g2.drawImage(Background, 0, 0, null);
		g2.drawImage(Barground, 29, barY+3,null);
		g2.drawImage(Barground, 35 + bars.sanityBar.BAR_WIDTH + 4, barY + 3,null);
		
		g2.drawImage(bars.hungerBar.frame, 25, barY, null);
		g2.drawImage(bars.hungerBar.hunger, 25, barY, null);
		
		g2.drawImage(bars.sanityBar.frame, 35 + bars.sanityBar.BAR_WIDTH, barY, null);
		g2.drawImage(bars.sanityBar.sanity, 35 + bars.sanityBar.BAR_WIDTH, barY, null);
		
		drawDisplay(g2);
	}
	
	private void drawDisplay(Graphics g2) {
		
		if(PM.player.HUNGER == 100) { digitWidth = 33;}
		else { digitWidth = 22;}
		
		if(UIDisplay.DH.mouseEntered) {
			g2.drawImage(Display, 10, barY/2 - 5,null);// DisplayPanel.DH.currentX, DisplayPanel.DH.currentY, null);
			g2.drawImage(String[0], 10 + 12, barY/2 - 5 + 6,null);
			
			// 10 = HoveringBar offset, 120 = Width of HoveringBar, 12 = Digit offset, 44 = Max Offset
			g2.drawImage(convertToImage(PM.player.HUNGER), 10 + 120 - 12 - 44 - digitWidth, barY/2 - 5 + 50 - 6 - 18, null);
			g2.drawImage(String[2], 10 + 120 - 12 - 44, barY/2 - 5 + 50 - 6 - 18, null);
		}
		
		if(PM.player.SANITY == 100) { digitWidth = 33;}
		else { digitWidth = 22;}
		
		if(UIDisplay.DS.mouseEntered) {
			g2.drawImage(Display, 20 + bars.sanityBar.BAR_WIDTH, barY/2 - 5, null);
			g2.drawImage(String[1], 20 + bars.sanityBar.BAR_WIDTH + 12, barY/2 - 5 + 6, null);
			
			g2.drawImage(convertToImage(PM.player.SANITY), 20 + bars.sanityBar.BAR_WIDTH + 120 - 12 - 44 - digitWidth, barY/2 - 5 + 50 - 6 - 18, null);
			g2.drawImage(String[2], 20 + bars.sanityBar.BAR_WIDTH + 120 - 12 - 44, barY/2 - 5 + 50 - 6 - 18, null);
			
		}
	}
	
	public void addMouseResponse() {
		// TODO Auto-generated method stub
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				cursor.setCursor1(UI);
				
				UIx = e.getX();
				UIy = e.getY();
			}
			
			public void mouseReleased(MouseEvent e) {
				cursor.setCursor0(UI);
			}
			
			public void mouseExited(MouseEvent l) {
				
			}
	
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				UI.setLocation(UI.getX() + e.getX() - UIx, UI.getY() + e.getY() - UIy);
			}
		});
	}
	
	private BufferedImage convertToImage(int stat) {
		if(stat == 100) {
			return Number[10];
		}
		
		if(stat < 10) {
			return Number[stat];
		}
		
		int left = stat / 10;
		int right = stat % 10;
		
		BufferedImage Tens = new BufferedImage(2*Number[0].getWidth(),Number[0].getHeight(),BufferedImage.TYPE_INT_RGB);
		
		Graphics g = Tens.getGraphics();
		g.drawImage(convertToImage(left),0,0,null);
		g.drawImage(convertToImage(right),11,0,null);
		
		return Tens;
	}
	
	public BarPanel getBars() {
		return bars;
	}
	
	public ButtonPanel getButtons() {
		return buttons;
	}
	
	public int UIx;
	public int UIy;
	
	public final int UI_WIDTH = 240;// ((int)GameFrame.WIDTH) / 8;// 240
	public final int UI_HEIGHT = 180;// ((int)GameFrame.HEIGHT) / 6;// 180
	private final int UI_offset = 38;
	
	private ButtonPanel buttons;
	private BarPanel bars;
	private DisplayPanel UIDisplay;
	private ManageCursor cursor;
	
	private BufferedImage[] String;
	private BufferedImage[] Number;
	private Image Background;
	private Image Barground;
	private Image Display;

	private PanelManager PM;
	private final UserInterface UI;
	private int barY;
	private int digitWidth;
	private Graphics2D g2;
	
	public boolean open = true;
	Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
}
