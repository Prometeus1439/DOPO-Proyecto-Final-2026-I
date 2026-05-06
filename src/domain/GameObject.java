package domain;

import java.awt.Rectangle;
import java.io.Serializable;

public class GameObject implements Serializable {
protected int x;
protected int y;
protected Rectangle hitbox;

public GameObject(int x, int y, int width, int height) {
	this.hitbox=new Rectangle (x, y, width, height);
}
public int getX() {
	return hitbox.x;
}
public int getY() {
	return hitbox.y;
}

}
