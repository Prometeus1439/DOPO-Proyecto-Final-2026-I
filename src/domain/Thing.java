package domain;

import java.io.Serializable;

public class Thing extends GameObject implements Serializable{
	public Thing(int x, int y, int width, int height) {
		super(x,y, width, height);
		
	}
}
