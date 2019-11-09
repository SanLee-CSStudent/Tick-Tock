import javax.swing.SwingUtilities;

import GUI.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main()");
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				System.out.println("invokeLater() in Main");
				@SuppressWarnings("unused")
				GameFrame gameFrame = new GameFrame();
				
			}
		});
	}

}
