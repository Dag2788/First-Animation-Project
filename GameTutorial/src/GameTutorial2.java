import java.applet.Applet;
import java.awt.Graphics;


public class GameTutorial2 extends GameLoop3{

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
		g.drawImage(offscrean, 0,0, this);
	}
	
	public void update(Graphics g){
		paint(g);
	}
}
