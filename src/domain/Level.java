package domain;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

public class Level implements Serializable {
 private ArrayList<ScenarioItem> scenarioItems;
 private ArrayList<Zone> zones;
 private ArrayList<Thing> things;
 private ArrayList<Wall> walls;
 private static int width;
 private static int height;
 
 public Level(ArrayList<Wall> walls ,ArrayList<Zone> zones,ArrayList<Thing> things, int width, int height) {
  this.walls=walls;
  this.zones=zones;
  this.things=things;
  this.scenarioItems = new ArrayList<>();
  this.width = width;
  this.height = height;
 }
 public boolean isWall(Rectangle ghost) {
  for(Wall w: walls) {
   if(ghost.intersects(w.hitbox)) {
    return false;
   }
  }
  return true;
 }
 public void start() {
  
 }
 public boolean allCoinsCollected() {
  for (Thing t : things) {
   if (t instanceof Coin && !t.isCollected()) return false;
  }
  return true;
 }

 public boolean allCoinsCollected(Player p) {
  for (Thing t : things) {
   if (!(t instanceof Coin)) continue;
   Coin c = (Coin) t;
   if (c.getOwnerPlayer() == -1 || c.getOwnerPlayer() == p.getPlayerNumber()) {
    if (!c.isCollected()) return false;
   }
  }
  return true;
 }

 public void resetCoins() {
  for (Thing t : things) {
   if (t instanceof Coin) t.reset();
  }
 }
 
 public void resetCoins(int ownerPlayer) {

	    for(Thing t : things) {

	        if(t instanceof Coin) {

	            Coin coin = (Coin) t;

	            if(coin.getOwnerPlayer() == ownerPlayer) {
	                coin.reset();
	            }
	        }
	    }
	}

 public void checkZone(Player p) {
  for (Zone z : zones) {
   if (z instanceof Goal && !allCoinsCollected(p)) continue;
   if (z.getOwnerPlayer() != -1 && z.getOwnerPlayer() != p.getPlayerNumber()) continue;
   if (z.isTriggered(p.getHitbox())) {
    z.effect(p);
   }
   else {
	   z.onExit(p);
   }
  }
 }
 public void moveThings() {
  for (Thing t : things) {
   t.move();
  }
 }

 public void checkThing(Player p) {
  for (Thing t : things) {
   if (t.isCollected()) continue;
   if (p.getHitbox().intersects(t.hitbox)) {
    t.touch(p);
   }
  }
 }
 public void checkScenarioItems(Player p) {
  for(ScenarioItem s: scenarioItems) {
   if(p.getHitbox().intersects(s.hitbox)) {
    s.effect(p);
   }
  }
 }
 public void finish() {
 }
 public ArrayList<Wall> getWalls(){
  return walls;
 }
 public ArrayList<Zone> getZones(){
  return zones;
 }
 public ArrayList<Thing>getThings(){
  return things;
 }
 public ArrayList<ScenarioItem> getScenarioItems(){
  return scenarioItems;
 }
 
 public int getHeight() {
  return height;
 }
 
 public int getWidth() {
  return width;
 }
}
 