package Button;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Executors;

import javax.swing.ImageIcon;

import GUI.PanelManager;
import Interface.MouseResponse;

public class WeatherButton extends BaseButton implements MouseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1534583946560336287L;

	public WeatherButton(PanelManager PM) {
		// TODO Auto-generated constructor stub
		super(PM.cursor, new ImageIcon(PM.loadImage.Buttons[2][0]), new ImageIcon(PM.loadImage.Buttons[2][1]));
		
		this.PM = PM;
		
		addMouseResponse();
	}
	
	public void addMouseResponse() {
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent l) {
				if(!PM.player.alive) {
					
				}
				else {
					
				}
			}
			
			public void mouseReleased(MouseEvent l) {
				if(!PM.player.alive) {
					Thread revivePlayer = new Thread(new Runnable() {
						public void run() {
							PM.scheduleDelay = Executors.newScheduledThreadPool(1);
							PM.player.playerX += 22;
							PM.player.playerY += 20;
							
							PM.player.resumeStat();
							PM.player.resumeAct();
							
							if(PM.player.HUNGER == 0 && PM.player.SANITY == 0) {
								PM.player.hunger.resume();
								PM.player.HUNGER += 25;
								
								PM.player.sanity.resume();
								PM.player.SANITY += 10;
							}
							else if(PM.player.SANITY == 0) {
								PM.player.sanity.resume();
								PM.player.SANITY += 10;
							}
							else {
								PM.player.hunger.resume();
								PM.player.HUNGER += 25;
							}
							
							PM.player.initializeStats();
						}
					});
					
					revivePlayer.start();
				}
			}
		});
	}
	
	private PanelManager PM;
}
