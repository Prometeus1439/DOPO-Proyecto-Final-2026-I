package domain;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

public class HGame implements Serializable {
 private int difficult;
 private ArrayList<Player> players;
 private ArrayList<Level> levels;
 
 public void move(char direction, int player) {
	 int dx = 0;
	    int dy = 0;
	    Player p= players.get(player);

	    double speed = p.getSpeed();

	    switch(direction) {

	        case 'W':
	            dy = (int) -speed;
	            break;

	        case 'S':
	            dy = (int) speed;
	            break;

	        case 'A':
	            dx = (int) -speed;
	            break;

	        case 'D':
	            dx = (int) speed;
	            break;
	    }
	    Rectangle future =
	            new Rectangle(
	                p.getX()+ dx,
	                p.getY() + dy,
	                p.getWidth(),
	                p.getHeight()
	            );

	 
 }
 public void createPlayer(String playerType, int player, PlayerType pType) {
	 Player p = null;
	 if(player==1) {
		 p = new HumanPlayer(pType,1,1,1,1);
		 }
	 else if (player==2) {
		 p= new MachinePlayer(pType,1,1,1,1);
	 }
	 players.add(p);
 }
 
 public void level1() {
	 
 }
 
}
