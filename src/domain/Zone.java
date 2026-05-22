package domain;

import java.io.Serializable;

public abstract class Zone extends GameObject implements Serializable{

 private int ownerPlayer = -1;

 public Zone(int x, int y, int width, int height) {
  super(x, y, width, height);
 }

 public Zone(int x, int y, int width, int height, int ownerPlayer) {
  super(x, y, width, height);
  this.ownerPlayer = ownerPlayer;
 }

 public int getOwnerPlayer() {
  return ownerPlayer;
 }

 public abstract void effect(Player p);

 public boolean isTriggered(java.awt.Rectangle playerHitbox) {
  return hitbox.intersects(playerHitbox);
 }
}
 