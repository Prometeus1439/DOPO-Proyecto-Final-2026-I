package domain;

import java.io.Serializable;

public class Goal extends Zone implements Serializable{
 public Goal(int x, int y, int width, int height) {
  super(x, y, width, height);
 }
 public Goal(int x, int y, int width, int height, int ownerPlayer) {
  super(x, y, width, height, ownerPlayer);
 }
 public void effect(Player p) {
  p.setFinished(true);
 }
}
 