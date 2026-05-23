package domain;

import java.awt.Rectangle;
import java.io.Serializable;

public class GameObject implements Serializable {
protected int x;
protected int y;
protected Rectangle hitbox;

public GameObject(int x, int y, int width, int height) {
	this.x = x;
    this.y = y;

    hitbox = new Rectangle(x, y, width, height);
}
public int getX() {
	return hitbox.x;
}
public int getY() {
	return hitbox.y;
}
public void setX( int x) {
	hitbox.x=x;
	this.x=x;
}
public void setY( int y) {
	hitbox.y=y;
	this.y=y;
}
public Rectangle getHitbox() {
	return hitbox;
}
}
