import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;


public class GameLoop_Halo_Game extends GameTutorial_Halo_Game{

	public void init(){
		setSize(800,600);
		Thread th = new Thread(this);
		th.start();
		offscrean  = createImage(800,600);
		d = offscrean.getGraphics();
		addKeyListener(this);
	}
	public void paint(Graphics g){
		d.clearRect(0, 0,800, 600);
		d.drawImage(background, 0, 0, this);
		d.drawString(score2, 25,25);
		d.drawImage(brick, 300, 200, this);
		d.drawImage(brick, 500, 250, this);
		d.drawImage(person, x, y, this);
		d.drawImage(enemy, x2, y2, this);
		d.setColor(Color.BLACK);
		if(fired == true){
			if(fired_left){
				d.fillRect(nx3, y3, 5, 5);
			}else
			d.fillRect(x3, y3, 5, 5);
		}
		d.drawImage(tube, 650, 276, this);
		d.drawImage(cloud, 100, 20, this);
		d.drawImage(cloudL, 600, 20, this);
		g.drawImage(offscrean, 0,0, this);
	}
	
	public void update(Graphics g){
		paint(g);
	}
}
