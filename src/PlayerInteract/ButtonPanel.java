package PlayerInteract;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Button.BaseButton;
import Button.ExitButton;
import Button.FeedButton;
import Button.SleepButton;
import Button.WeatherButton;
import GUI.PanelManager;

public class ButtonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -389867867018017243L;
	public ButtonPanel(PanelManager PM) {
		// TODO Auto-generated constructor stub
		this.setLayout(new GridLayout(2, 2, 10, 10));
		this.setOpaque(false);
		// this.setBackground(new Color(0, 0, 0, 0));
		this.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 0));
		
		feed = new FeedButton(PM);
		sleep = new SleepButton(PM);
		weather = new WeatherButton(PM);
		exit = new ExitButton(PM);
		
		this.add(feed);
		this.add(sleep);
		this.add(weather);
		this.add(exit);
		
		this.setVisible(true);
	}
	
	public void invertSleep() {
		checkSleeping = !checkSleeping;
	}
	
	public BaseButton feed;
	public BaseButton sleep;
	private BaseButton weather;
	private BaseButton exit;
	
	public boolean checkSleeping = true;
}
