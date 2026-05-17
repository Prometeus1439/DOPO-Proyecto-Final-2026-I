package domain;

import java.awt.Color;
import java.io.Serializable;

public abstract class  Obstacle extends Thing implements Serializable{
 public Obstacle(int x, int y, int width, int height) {
  super(x, y, width, height);
 }
 public void touch(Player p) {
  p.setLife(p.getLife()-1);
 }
 
}
 