package domain;

import java.io.Serializable;

public abstract class ScenarioItem extends GameObject implements Serializable{
 public ScenarioItem(int x, int y, int width, int height) {
	 super(x,y, width, height);
 }
 public abstract void effect(Player p);
}
