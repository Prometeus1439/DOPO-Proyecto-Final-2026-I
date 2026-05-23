package domain;

import java.io.Serializable;

public class Start extends Zone implements Serializable{
 public Start(int x, int y, int width, int height) {
  super(x, y, width, height);
 }
 public Start(int x, int y, int width, int height, int ownerPlayer) {
  super(x, y, width, height, ownerPlayer);
 }
 public void effect(Player p) {
  p.setInmune(true);
 }
 
 public void onExit(Player p) {
	  p.setInmune(false);
}
 
}
 