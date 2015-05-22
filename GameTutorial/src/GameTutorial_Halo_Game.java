import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class GameTutorial_Halo_Game extends Applet implements Runnable, KeyListener {

	public int x,y;
	public int x2,y2,xvel = 2, yvel = 2;
	public int x3, nx3, y3, x3vel = 5, y3vel = 3, nx3vel = -5;
	public Image offscrean;
	public Graphics d;
	public boolean up,down,left,right,fire, fired_left;
	public BufferedImage hit2, hit, brick, cloud, cloudL, tube, background,foreground,stance, stance_left, r1, r2, r3, r4, r5, r6, r7, r8 ,r9 ,r10 , l1,l2,l3,l4,l5,l6,l7,l8,l9,l10, d1, d1L, d2, d2L, dw1, dw1L, dw2, dw2L, j1, j1L, j2, j2L, shoot, shoot_left, person, enemy, enemy_stance, enemy_stance_left;
	public void load_sprites(){
		try {
			hit2 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_hit2.png"));
			hit = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_hit.png"));
			brick = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_brick.png"));
			cloud = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_cloud.png"));
			cloudL = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_cloud_left.png"));
			tube = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_pipe.png"));
			background = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/background_halo.png"));
			foreground = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/foreground_halo.png"));
			stance = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_stance.png"));
			stance_left = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_stance_left.png"));
			enemy_stance = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_enemy.jpg"));
			enemy_stance_left = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_enemy_left.jpg"));			
			shoot = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_shoot.png"));
			shoot_left = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_shoot_left.png"));
			r1 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run1.png"));
			l1 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run1_left.png"));
			r2 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run2.png"));
			l2 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run2_left.png"));
			r3 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run3.png"));
			l3 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run3_left.png"));
			r4 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run4.png"));
			l4 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run4_left.png"));
			r5 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run5.png"));
			l5 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run5_left.png"));
			r6 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run6.png"));
			l6 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run6_left.png"));
			r7 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run7.png"));
			l7 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run7_left.png"));
			r8 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run8.png"));
			l8 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run8_left.png"));
			r9 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run9.png"));
			l9 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run9_left.png"));
			r10 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run10.png"));
			l10 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_run10_left.png"));
			
			d1 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_down1.png"));
			d1L = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_down1_left.png"));
			d2 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_down2.png"));
			d2L = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_down2_left.png"));
		
			
			j1 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_jump1.png"));
			j1L = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_jump1_left.png"));
			j2 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_jump2.png"));
			j2L = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_jump2_left.png"));
			
			dw1 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_down_walk1.png"));
			dw1L = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_down_walk1_left.png"));
			dw2 = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_down_walk2.png"));
			dw2L = ImageIO.read(new File("/Users/DanielGarza/Documents/workspace/GameTutorial/src/halo_down_walk2_left.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public int counter;
	public double counter2 = 4;
	public boolean lookingLeft, onBlock = false;
	public int score = 0;
	public String score2 = "";
	public boolean fired = false;
	public boolean good_shot = false;
	
	public void run() {
		x = 100;
		y = 100;
		x2 = 500;
		y2 = 100;
		x3 = x;
		y3 = y;
		
		load_sprites();

		person = stance;
		enemy = enemy_stance;
		while(true){	
			//281 is ground level
			//System.out.println("x = " + x + " y = " + y);

		////// SCOREBOARD ///////////
			score2 = String.valueOf(score);
			if (x >= 600 && x <= 650 && y >= 250 && y<= 290){
				score++;
			}
			
		///////// GRAVITY /////////////////
			if ( y<= 279 && up != true ){
				if(x >= 600 && x <= 705 && y >= 165 && y <= 205){
					
				}
				else
				if(x >= 432 && x <= 530 && y >= 135 && y <= 150){
					
				}
				else
					if(x >= 248 && x <= 320 && y >= 85 && y <= 95){
						
					}else
					y+=10;
			}
		
			
			
			
		///////////////////////////////////////////////		
			counter++;
			if (counter >= 59){
				counter = 0;
			}

			if ( down != true){
			///////MOVEMENT TO THE RIGHT
				if (counter <= 5 && right == true){
					person = r1;
				}
				if (counter >= 5 && counter <= 10 && right == true){
					person = r2;
				}
				if (counter >= 10  && counter >= 15 && right == true) {
					person = r3;
				}
				if (counter >= 15 && counter <= 20 && right == true){
					person = r4;
				}
				if (counter >= 20  && counter >= 25 && right == true) {
					person = r5;
				}
				if (counter >= 25 && counter <= 30 && right == true){
					person = r6;
				}
				if (counter >= 30  && counter >= 35 && right == true) {
					person = r7;
				}
				if (counter >= 35 && counter <= 40 && right == true){
					person = r8;
				}
				if (counter >= 40  && counter >= 45 && right == true) {
					person = r9;
				}
				if (counter >= 55 && counter <= 59 && right == true){
					person = r10;
				}

			///////MOVEMENT TO THE LEFT
				if (counter <= 5 && left == true){
					person = l1;
				}
				if (counter >= 5 && counter <= 10 && left == true){
					person = l2;
				}
				if (counter >= 10  && counter >= 15 && left == true) {
					person = l3;
				}
				if (counter >= 15 && counter <= 20 && left == true){
					person = l4;
				}
				if (counter >= 20  && counter >= 25 && left == true) {
					person = l5;
				}
				if (counter >= 25 && counter <= 30 && left == true){
					person = l6;
				}
				if (counter >= 30  && counter >= 35 && left == true) {
					person = l7;
				}
				if (counter >= 35 && counter <= 40 && left == true){
					person = l8;
				}
				if (counter >= 40  && counter >= 45 && left == true) {
					person = l9;
				}
				if (counter >= 55 && counter <= 59 && left == true){
					person = l10;
				}

			}
			
		///// ADVANCE THE CHARACTER LEFT OR RIGHT ////
			if (left == true){
				x-=4;
				lookingLeft = true;
			}
			if (right == true){
				lookingLeft = false;
				x+=4;
			}


		///////  JUMP ///////////
			if (up == true){
				counter2 += 0.05;
				y = y + (int) (Math.sin(counter2) + Math.cos(counter2)) * 6; 
				if (counter2 >= 7){
					counter2 = 4;
				}
			///////   JUMP WHILE STANDING ///////
				if (counter <= 5 && up == true){
					if(lookingLeft)
						person = j1L;
					else
						person = j1;
				}
				if (counter >= 5 && counter <= 10 && up == true){
					if(lookingLeft)
						person = j2L;
					else
						person = j2;
				}

				if ( right == true){
					person = j1;
				}
				if (left == true){
					person = j1L;
				}
			}

		/////// TO KNEEL ////////////////////

			if (down == true){
				y++;
			//////// TO TAKE A KNEE WHILE STANDING //////////////
				if (counter <= 5 && down == true){
					if(lookingLeft)
						person = d1L;
					else
						person = d1;
				}
				if (counter >= 5 && counter <= 10 && down == true){
					if(lookingLeft)
						person = d2L;
					else
						person = d2;
				}

			/////////  LOW WALK ////////////
				if (counter <= 4 && right == true){
					person = dw1;
				}
				if (counter >= 5 && counter <= 8 && right == true){
					person = dw2;
				}
				if (counter >= 8 && counter <= 12 && right == true){
					person = d2;
				}
				if (counter <= 4 && left == true){
					lookingLeft = true;
					person = dw1L;
				}
				if (counter >= 5 && counter <= 8 && left == true){
					person = dw2L;
				}
				if (counter >= 8 && counter <= 12 && left == true){
					person = d2L;
				}
			} // to kneel
			
		///////// TO SHOOT //////////////////
			if (fire == true){
				
				if(lookingLeft){
					person = shoot_left;
					nx3 = x;
					y3 = y+7;
					fired_left = true;
				}
				else{
					person = shoot;
					x3 = x+119;
					y3 = y+7;
					fired_left = false;
				}
				fired = true;
			
			}
			if(fired_left){
				nx3 = nx3 + nx3vel;
			}
			if (fired){
				x3 = x3 + x3vel;
			}
			

				

			
			

		/////////////////////////////// BLACK SCORE BOX PROPERTIES /////////////////////////////
			
			if (x >= 600 && x <= 705 && y >= 196 && y<= 205){
				y = 195;
			}
			if(x >= 432 && x <= 530 && y >= 135 && y <= 150){
				y = 140;
			}
			if(x >= 248 && x <= 320 && y >= 85 && y <= 95){
				y = 90;
			}
			if( y>= 279){
					y = 279;
				}
		///////////////////////////////////////////////////////////////////////////////////////////
			
			
				
			  if( x2 <= 0 || x2 >= 690)
				  xvel = -xvel; 
			  if( y2 <= 0 || y2 >= 260)
				  yvel = -yvel;
			  
			  if(xvel > 0)
				  enemy = enemy_stance;
			  else
				  enemy = enemy_stance_left;
			  
			   if(counter <= 15 && good_shot){
			   }
			   else{
			 	x2 = x2 + xvel;
			  	y2 = y2 + yvel;
			   }
			  	
				if (x2 >= 600 && x2 <= 705 && y2 >= 196 && y2<= 215){
					 xvel = -xvel; 
					 yvel = -yvel;
				}
				if(x2 >= 432 && x2 <= 530 && y2 >= 135 && y2 <= 290){
					 xvel = -xvel; 
					 
				}
				if(x2 >= 248 && x2 <= 320 && y2 >= 85 && y2 <= 230){
					 
					 yvel = -yvel;
				}
				
				if(Math.abs(x2-x) <= 50 && Math.abs(y2-y) <= 50 ){
					if(counter <= 8){
					person = hit2;
					}
					if(counter <= 15){
					enemy = hit;
					}
				}
				
				if(Math.abs(x2-x3) <= 80 && Math.abs(y2-y3) <= 100 ){
					if(counter <= 45)
						enemy = hit;
					score++;
					good_shot = true;
					
					
					
				}else
				if(Math.abs(x2-nx3) <= 80 && Math.abs(y2-y3) <= 100 ){
					if(counter <= 45)
						enemy = hit2;
					score++;
					good_shot = true;
				}else
					good_shot = false;
	
			
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
		if (e.getKeyCode() == 49){
			fire = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 37){
			left = false;
			person = stance_left;
		}
		if (e.getKeyCode() == 39){
			right = false;
			person = stance;
		}
		if (e.getKeyCode() == 38){
			up = false;
			counter2 = 4;
			person = stance;
		}
		if (e.getKeyCode() == 40){
			down = false;
			if(lookingLeft){
				person = stance_left;
			}
			else
			person = stance;
		}
		if (e.getKeyCode() == 49){
			fire = false;
			if(lookingLeft){
				person = stance_left;
			}
			else
			person = stance;
		}
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
