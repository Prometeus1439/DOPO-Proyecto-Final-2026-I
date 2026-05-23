package domain;

import java.awt.Color;
import java.io.Serializable;

public class Coin extends Thing implements Serializable {
	
	protected int ownerPlayer;
	
	public Coin(int x, int y, int width, int height) {
	    super(x, y, width, height);
	    this.ownerPlayer = -1;
	}
	
	public Coin(int x, int y, int width, int height, int ownerPlayer) {
	    super(x, y, width, height);
	    this.ownerPlayer = ownerPlayer;
	}
	
	public int getOwnerPlayer() {
	     return ownerPlayer;
	 }
	
	public void touch(Player p) {
	    if(ownerPlayer == -1 || p.getPlayerNumber() == ownerPlayer) {
	        p.setScore(p.getScore() + 1);
	        collected = true;
	        }
	    }
}