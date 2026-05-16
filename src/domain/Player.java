package domain;

import java.awt.Color;
import java.awt.*;
import java.io.Serializable;

public abstract class Player extends GameObject implements Serializable{
	
	private int xRespawn;
	private int yRespawn;
	private int life = 1;
	private double speed = 1.0;
	private int width;
	private int height;
	private Rectangle hitbox;
	private int lives;
	private Color currentColor;
	private PlayerType originalType;
	private PlayerType currentType;
	private boolean inmunne;
	private int score;
	private boolean finished;
	
	public Player(PlayerType type, int x, int y, int width, int height) {
		super(x,y, width, height);
		originalType = type;
		currentType = type;
		applyCurrentType();
		this.width = width;
		this.height = height;
	}
	
	public void move(Rectangle newHitbox) {
		//hitbox = newHitbox;
		this.x = (int) newHitbox.getX();
		this.y = (int) newHitbox.getY();
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
	public void setInmune (boolean inm) {
		inmunne=inm;
	}
	public void setFinished(boolean finished) {
		this.finished=finished;
	}
	public Rectangle getHitbox() {
		return hitbox;
	}
	public  void setRespawnX(int x) {
		xRespawn=x;
	}
	public  void setRespawnY(int y) {
		yRespawn=y;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int s) {
		score=s;
	}
	public int getLife() {
		return life;
	}
	public int getRespawnX() {
		return xRespawn;
	}
	public int getRespawnY() {
		return yRespawn;
	}
}
