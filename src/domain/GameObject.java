package domain;

import java.io.Serializable;

public class GameObject implements Serializable {
protected int x;
protected int y;

public GameObject(int x, int y) {
	this.x=x;
	this.y=y;
}
public int getX() {
	return x;
}
public int getY() {
	return y;
}
}
