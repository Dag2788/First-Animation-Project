import java.applet.Applet;
import java.awt.Graphics;


public class GameTutorial_Halo extends GameLoop_Halo{

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
		d.drawImage(person, x, y, this);
		d.drawString(score2, 25,25);
		d.fill3DRect(650, 291, 50, 105, true);
		g.drawImage(offscrean, 0,0, this);
	}
	
	public void update(Graphics g){
		paint(g);
	}
}
