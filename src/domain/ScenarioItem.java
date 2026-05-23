package domain;

import java.io.Serializable;
import java.awt.Color;

public abstract class ScenarioItem extends GameObject implements Serializable{
protected Color color;
protected boolean collected;
	
public ScenarioItem(int x, int y, int width, int height) {
	 super(x,y, width, height);
 }
 public abstract void effect(Player p);
 
 public Color getColor() {
	 return color;
 }

 public boolean isCollected() {
	 return collected;
 }
 
 public void effect(Obstacle o) {};
 
}
