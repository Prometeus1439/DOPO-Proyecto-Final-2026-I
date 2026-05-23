package domain;

import java.awt.Rectangle;
import java.util.Random;

public class RandomMachine extends MachinePlayer {

	public RandomMachine(PlayerType type, int x, int y, int width, int height) {
		super(type, x, y, width, height);
	}
	public Rectangle think(){
		Random r= new Random();
		int mov= r.nextInt(4);
		int dx = 0;
		int dy = 0;	  
		double speed = getSpeed();
		  
		switch(mov) {
		   case 0:
		   dy = (int) -speed;
		   break;

		   case 1:
		   dy = (int) speed;
		   break;

		   case 2:
		   dx = (int) -speed;
		   break;
		   
		   case 3:
		   dx = (int) speed;
		   break;
		   }
		Rectangle rect= new Rectangle(getX()+ dx, getY() + dy, getWidth(), getHeight());
		return rect;

		
	}
	
}
