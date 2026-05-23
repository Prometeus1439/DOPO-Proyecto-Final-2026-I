package domain;

import java.awt.Color;
import java.awt.*;
import java.io.Serializable;

public abstract class Player extends GameObject implements Serializable{
 
 private int xRespawn;
 private int yRespawn;
 private int life = 1;
 private double speed = 2.0;
 private int width;
 private int height;
 private Color currentColor;
 private PlayerType originalType;
 private PlayerType currentType;
 private boolean inmunne;
 private int score;
 private boolean finished;
 private int playerNumber;
 private int deaths;
 private boolean tochedCheckPoint;
 
 
 public Player(PlayerType type, int x, int y, int width, int height) {
	    super(x,y, width, height);

	    originalType = type;
	    currentType = type;

	    this.width = width;
	    this.height = height;

	    this.tochedCheckPoint = false;

	    applyCurrentType();
	}
 
 public void move(Rectangle newHitbox) {
  this.x = (int) newHitbox.getX();
  this.y = (int) newHitbox.getY();
  this.hitbox.x = this.x;
  this.hitbox.y = this.y;
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

 public void setTouchedCheckPoint(boolean touched) {
     this.tochedCheckPoint = touched;
 }

 public boolean getTouchedCheckPoint() {
     return tochedCheckPoint;
 }
 
 public double getSpeed() {
  return speed;
 }
 
 public void setWidth(int width) {
  this.width = width;
  this.hitbox.width = width;
 }

 public int getWidth() {
  return width;
 }

 public int getHeight() {
  return height;
 }

 public void setHeight(int height) {
  this.height = height;
  this.hitbox.height = height;
 }
 public int getX() {
  return hitbox.x;
 }
 public int getY() {
  return hitbox.y;
 }
 public void setPlayerNumber(int playerNumber) {
     this.playerNumber = playerNumber;
}
 public int getPlayerNumber() {
  return playerNumber;
}
 public void setInmune(boolean inm) {
  inmunne = inm;
 }
 public boolean isInmune() {
  return inmunne;
 }
 public void setFinished(boolean finished) {
  this.finished=finished;
 }
 public boolean isFinished() {
  return finished;
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
public void addDeath() {
  deaths++;
}
public int getDeaths() {
 return deaths;
}
public void receiveDamage() {
    if(!this.inmunne) {
    	life--;
    }

    if(currentType instanceof GreenSkin && life == 1) {
        speed = speed * 0.5;
    }
}

public void respawn() {
    hitbox.x = xRespawn;
    hitbox.y = yRespawn;

    x = xRespawn;
    y = yRespawn;

    score = 0;

    resetType();
    
}

}

 