package domain;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

public class HGame implements Serializable {

 private static final long serialVersionUID = 1L; 

 private ArrayList<Player> players;
 private ArrayList<Level> levels;
 private Level actualLevel;
 
 private String mode;
 private int deaths;

 public HGame() {
  players = new ArrayList<>();
  levels = new ArrayList<>();
 }

 public int getDeaths() {	
  return deaths;
 }
 
 public void startGame(String mode, PlayerType playerType) {
	 this.mode = mode;
	 
	 players.clear();
	 levels.clear();
	  
	 createPlayer("human", 1, playerType);
	  
	 level1();
} 
 
 public void startGame(String mode, PlayerType playerOneType, PlayerType playerTwoType) {
	 	this.mode = mode;
	 
	    players.clear();
	    levels.clear();
	    deaths = 0;

	    createPlayer("human", 1, playerOneType);

	    if(mode.equals("PVP")) {
	        createPlayer("human", 2, playerTwoType);
	    }
	    else if(mode.equals("PVM")) {
	        createPlayer("machine", 2, playerTwoType);
	    }

	    level1();
	}
 
 public void move(char direction, int player) {
  int dx = 0;
  int dy = 0;
  Player p= players.get(player);
  
  double speed = p.getSpeed();
  
  switch(direction) {
   case 'W':
   dy = (int) -speed;
   break;

   case 'S':
   dy = (int) speed;
   break;

   case 'A':
   dx = (int) -speed;
   break;
   
   case 'D':
   dx = (int) speed;
   break;
   }
     
  Rectangle future = new Rectangle(p.getX()+ dx, p.getY() + dy, p.getWidth(), p.getHeight());
  
  if(actualLevel.isWall(future)) {
   p.move(future);
  }
  
 }
 
 public void createPlayer(String controlType, int player, PlayerType pType) {
  Player p = null;
  
  if(controlType.equals("human")) {
   p = new HumanPlayer(pType,1,1,20,20);
  }
  
  else if (controlType.equals("machine")) {
   p= new MachinePlayer(pType,1,1,20,20);
  }
  
  if(p != null) {
   p.setPlayerNumber(player);
   players.add(p);
  }
  
 }
 
 public void tictac() {
  if (actualLevel == null) return;
  actualLevel.moveThings();
  for(Player p: players) {
   actualLevel.checkZone(p);
   actualLevel.checkThing(p);
   actualLevel.checkScenarioItems(p);
   if(p.getLife()==0) {
    deaths++;
    p.addDeath();
    
    p.setLife(1);
    p.setX(p.getRespawnX());
    p.setY(p.getRespawnY());
    
    p.setScore(0);
    
    actualLevel.resetCoins();
    }
   }
}
 
 public int getPlayerDeaths(int index) {
	 return players.get(index).getDeaths();
}

public int getPlayerScore(int index) {
	return players.get(index).getScore();
}
 
 public void level1() {

     ArrayList<Wall> walls = new ArrayList<>();
     ArrayList<Zone> zones= new ArrayList<>();
     ArrayList<Thing> things= new ArrayList<>();

     int size = 500; 
     int thickness = 5;

     walls.add(new Wall(0, 0, thickness, size));
     walls.add(new Wall(0, 0, size, thickness));
     walls.add(new Wall(0,size - thickness,size,thickness));
     walls.add(new Wall(size - thickness,0,thickness,size));
     
     Start start = new Start(0,220,60,60);
     Goal goal = new Goal(440,220,60,60);
     
     zones.add(goal);
     zones.add(start);
     
     if(mode.equals("PVP") || mode.equals("PVM")) {
    	    things.add(new YellowCoin(400, 100, 20, 20, 1));
    	    things.add(new YellowCoin(400, 100, 20, 20, 2));
    	}
    	else {
    	    things.add(new YellowCoin(400, 100, 20, 20));
    }
     
     Guard guard = new Guard(400, 100,20,20,1,100,500);
     
     things.add(guard);
     
     for(int i = 0; i < players.size(); i++) {
    	    Player p = players.get(i);

    	    if(i == 0) {
    	        p.setRespawnX(20);
    	        p.setRespawnY(240);
    	        p.setX(20);
    	        p.setY(240);
    	    }
    	    else {
    	        p.setRespawnX(460);
    	        p.setRespawnY(240);
    	        p.setX(460);
    	        p.setY(240);
    	    }
    	}
     
     actualLevel = new Level(walls, zones, things, size, size);
     levels.add(actualLevel);
}
 
 public Level getActualLevel(){
  return actualLevel;
 }
 
 public ArrayList<Player> getPlayers(){
  return players;
  }
 
}
 