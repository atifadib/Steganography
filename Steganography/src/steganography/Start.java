/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JWindow;

/**
 *
 * @author ATIF ADIB
 */
public class Start extends JWindow implements Runnable{
     
	private static final long serialVersionUID = -1348168212720533419L;
    /**
     * @param args the command line arguments
     */
    Start() {
		setVisible(true);
		setSize(600,400);
		setLocationRelativeTo(null);
		
		Thread t = new Thread(this);
		t.start();
	} 
    public void run() {
		try {
			//Splash screen for 5 seconds
			Thread.sleep(10000);
			//Close splash screen image
			dispose();
			//Start the authentication process for using the application
			new Login();
		} catch (InterruptedException intEx) {
			System.out.print("Process interrupted abnormally!");
			System.exit(1);
		}
	} 
    public void paint(Graphics g) {
		Image splashScreen = null;
		try {
			splashScreen = ImageIO.read(getClass().getResource("new.jpg"));
                        //splashScreen= null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Image splashScreen = Toolkit.getDefaultToolkit().getImage("images\\start_splash.jpg");
		//Displaying splash screen at the center position of the screen
		int xPosition = (this.getWidth() - splashScreen.getWidth(null)) / 2;
		int yPosition = (this.getHeight() - splashScreen.getHeight(null)) / 2;
		g.drawImage(splashScreen, xPosition, yPosition, this);
	}
    public static void main(String[] args) {
        // TODO code application logic here
        	@SuppressWarnings("unused")
		Start newInstance = new Start();
	
    }
    
}
