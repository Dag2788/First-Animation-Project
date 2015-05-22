import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class GameLoop3 extends Applet implements Runnable, KeyListener {

	public int x,y;
	public Image offscrean;
	public Graphics d;
	public boolean up,down,left,right;
	public BufferedImage background, mov_up,mov_down,mov_left,mov_right, person;
	
	public void run() {
		x = 100;
		y = 100;
		try {
			background = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/background_ship.png"));
			mov_up = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/ship_up.png"));
			mov_down = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/ship_down.png"));
			mov_left = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/ship_left.png"));
			mov_right = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/ship_right.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		person = mov_right;
		while(true){	//hazard for webpage

			if (right == true){
				person = mov_right;
			}
			if (left == true){
				person = mov_left;
			}
			if (down == true) {
				person = mov_down;
			}
			if (up == true){
				person = mov_up;
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
		
		}
		if (e.getKeyCode() == 39){
			right = false;
			
		}
		if (e.getKeyCode() == 38){
			up = false;
		
		}
		if (e.getKeyCode() == 40){
			down = false;
			
		}
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
