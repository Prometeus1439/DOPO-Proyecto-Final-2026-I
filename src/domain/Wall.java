package domain;

import java.io.Serializable;

public class Wall extends ScenarioItem implements Serializable{
 private int width, height;
 public Wall(int x, int y, int width, int height) {
	 super(x,y);
	 this.width=width;
	 this.height=height;
	 
 }
}
