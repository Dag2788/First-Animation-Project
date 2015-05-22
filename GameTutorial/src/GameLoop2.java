
/* GameLoop2: The cursor walking animation using a stick figure.
 * w1,w2,w3,w4 are the distinct pictures that together make up a walk on the right direction only.
 * After the release of the key, the stick figure returns to a static position.
 * 
 * 
 */
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class GameLoop2 extends Applet implements Runnable, KeyListener {

	public int x,y;
	public Image offscrean;
	public Graphics d;
	public boolean up,down,left,right;
	public BufferedImage background, foreground,w1,w2,w3,w4, person;
	public int counter;
	
	public void run() {
		x = 100;
		y = 100;
		try {
			background = ImageIO.read(new File("background.png"));
			foreground = ImageIO.read(new File("forground.png"));
			w1 = ImageIO.read(new File("w1.png"));
			w2 = ImageIO.read(new File("w2.png"));
			w3 = ImageIO.read(new File("w3.png"));
			w4 = ImageIO.read(new File("w4.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		person = w1;
		while(true){	//hazard for webpage
			counter++;
			if (counter >= 35){
				counter = 0;
			}
			if (counter <= 5 && right == true){
				person = w1;
			}
			if (counter >= 5 && counter <= 15 && right == true){
				person = w2;
			}
			if (counter <= 15  && counter >= 25 && right == true) {
				person = w3;
			}
			if (counter >= 25 && counter <= 35 && right == true){
				person = w4;
			}
			
			
			if (left == true){
				x--;
			}
			if (right == true){
				x++;
			}
			if (up == true){
				y--;
			}
			if (down == true){
				y++;
			}
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 37){
			left = true;
		}
		if (e.getKeyCode() == 39){
			right = true;
		}
		if (e.getKeyCode() == 38){
			up = true;
		}
		if (e.getKeyCode() == 40){
			down = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 37){
			left = false;
			person = w1;
		}
		if (e.getKeyCode() == 39){
			right = false;
			person = w1;
		}
		if (e.getKeyCode() == 38){
			up = false;
			person = w1;
		}
		if (e.getKeyCode() == 40){
			down = false;
			person = w1;
		}
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
