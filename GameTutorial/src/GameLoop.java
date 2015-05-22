import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameLoop extends Applet implements Runnable, KeyListener {

	public int x,y;
	public Image offscrean;
	public Graphics d;
	public boolean up,down,left,right;
	
	
	public void run() {
		x = 100;
		y = 100;
		while(true){	//hazard for webpage
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
