package domain;

import java.io.Serializable;

public class Zone extends GameObject implements Serializable{
	public Zone(int x, int y, int width,int height) {
		super(x,y, width, height);
	}
}
