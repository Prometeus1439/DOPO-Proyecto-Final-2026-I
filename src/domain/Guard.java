package domain;

import java.io.Serializable;
import java.awt.Color;

public class Guard extends Obstacle implements Serializable  {
 private int horizontal;
 private int vertical;
 private int start;
 private int end;
 private int direction;
 public Guard(int x, int y, int width, int height, int orientation, int start, int end) {
  super(x, y, width, height);
  if (orientation==0) {
   horizontal=1;
   vertical=0;
  }
  else {
   horizontal=0;
   vertical=1;
  }
  this.start=start;
  this.end=end;
  color = Color.BLUE;
 }
 public void move() {

     hitbox.x += horizontal * direction;
     hitbox.y += vertical * direction;

     if(horizontal == 1) {

         if(hitbox.x >= end) {
             direction = -1;
         }

         if(hitbox.x <= start) {
             direction = 1;
         }
     }

     if(vertical == 1) {

         if(hitbox.y >= end) {
             direction = -1;
         }

         if(hitbox.y <= start) {
             direction = 1;
         }
     }
 }

}
 