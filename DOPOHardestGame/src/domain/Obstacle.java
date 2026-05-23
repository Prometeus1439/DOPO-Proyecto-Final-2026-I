package domain;

import java.io.Serializable;

public abstract class  Obstacle extends Thing implements Serializable{
 
 private static final long serialVersionUID = 1L;
	
 public Obstacle(int x, int y, int width, int height) {
  super(x, y, width, height);
 }
 public void touch(Player p) {
	 p.receiveDamage();
 }
 
 public void eliminated() {
	 collected = true;
 }
 
}
 