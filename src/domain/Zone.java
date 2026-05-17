package domain;

import java.io.Serializable;

public abstract class Zone extends GameObject implements Serializable{
 public Zone(int x, int y, int width,int height) {
  super(x,y, width, height);
 }
 public abstract void effect(Player p);
 public boolean isTriggered(java.awt.Rectangle playerHitbox) {
  return hitbox.intersects(playerHitbox);
 }
}
 