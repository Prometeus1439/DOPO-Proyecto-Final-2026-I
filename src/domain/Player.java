package domain;

import java.awt.Color;
import java.awt.*;
import java.io.Serializable;

public abstract class Player extends GameObject implements Serializable{
	
	private int life = 1;
	private double speed = 1.0;
	private int width = 1;
	private int height = 1;
	private Rectangle hitbox;
	private int lives;
	private Color currentColor;
	private PlayerType originalType;
	private PlayerType currentType;
	private int score;
	public Player(PlayerType type, int x, int y, int width, int height) {
		super(x,y, width, height);
		originalType = type;
		currentType = type;
		applyCurrentType();
	}
	public void move(char dir) {
		
	}
	public void changeType(PlayerType type) {
		currentType = type;
		applyCurrentType();
	}
	
	public void resetType(){
		currentType = originalType;
		applyCurrentType();
	}
	
	private void applyCurrentType() {
		currentType.apply(this);
		currentColor = currentType.getColor();
	}
	
	public PlayerType getCurrentType() {
		return currentType;
	}
	
	public void setLife(int life) {
		this.life = life;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	public int getX() {
		return hitbox.x;
	}
	public int getY() {
		return hitbox.y;
	}
}
