package p4_group_8_repo;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Frogger extends Actor {
	Image imgUP;
	Image imgLEFT;
	Image imgDOWN;
	Image imgRIGHT;
	Image imgUPJ;
	Image imgLEFTJ;
	Image imgDOWNJ;
	Image imgRIGHTJ;
	int points = 0;
	int end = 0;
	private boolean second = false;
	boolean noMove = false;
	double movement = 18.5;
	double movementX = 18.5;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int carD = 0;
	double w = 600;
	ArrayList<End> inter = new ArrayList<End>();
	
	public Frogger() {
		setImage(new Image("file:src/p4_group_8_repo/img/froggerUp.png"));
		setX(195);
		setY(530);
		imgUP = new Image("file:src/p4_group_8_repo/img/froggerUp.png");
		imgLEFT = new Image("file:src/p4_group_8_repo/img/froggerLeft.png");
		imgDOWN = new Image("file:src/p4_group_8_repo/img/froggerDown.png");
		imgRIGHT = new Image("file:src/p4_group_8_repo/img/froggerRight.png");
		imgUPJ = new Image("file:src/p4_group_8_repo/img/froggerUpJump.png");
		imgLEFTJ = new Image("file:src/p4_group_8_repo/img/froggerLeftJump.png");
		imgDOWNJ = new Image("file:src/p4_group_8_repo/img/froggerDownJump.png");
		imgRIGHTJ = new Image("file:src/p4_group_8_repo/img/froggerRightJump.png");
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) { 
					
				}
				else { 
				if (second) {
					if (event.getCode() == KeyCode.UP) {	  
		                move(0, -movement);
		                changeScore = false;
		                setImage(imgUP);
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.LEFT) {	            	
		            	 move(-movementX, 0);
		            	 setImage(imgLEFT);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.DOWN) {	            	
		            	 move(0, movement);
		            	 setImage(imgDOWN);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.RIGHT) {	            	
		            	 move(movementX, 0);
		            	 setImage(imgRIGHT);
		            	 second = false;
		            } 
				}
				else if (event.getCode() == KeyCode.UP) {	            	
	                move(0, -movement);
	                setImage(imgUPJ);
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.LEFT) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgLEFTJ);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.DOWN) {	            	
	            	 move(0, movement);
	            	 setImage(imgDOWNJ);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.RIGHT) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgRIGHTJ);
	            	 second = true;
	            }
	        }
			}
		});	
		
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.UP) {	  
					if (getY() < w) {
						changeScore = true;
						w = getY();
						points+=10;
					}
	                move(0, -movement);
	                setImage(imgUP);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.LEFT) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgLEFT);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.DOWN) {	            	
	            	 move(0, movement);
	            	 setImage(imgDOWN);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.RIGHT) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgRIGHT);
	            	 second = false;
	            }
	        }
			}
			
		});
	}
	
	@Override
	public void act(long now) {
		int bounds = 0;
		if (getY()<0 || getY()>530) {
			setY(530);
		}
		if (getX()<0) {
			move(movement, 0);
		}
		if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath1.png"));
			}
			if (carD==2) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath2.png"));
			}
			if (carD==3) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath3.png"));
			}
			if (carD == 4) {
				setX(195);
				setY(530);
				carDeath = false;
				carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/froggerUp.png"));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/p4_group_8_repo/img/waterdeath1.png"));
			}
			if (carD==2) {
				setImage(new Image("file:src/p4_group_8_repo/img/waterdeath2.png"));
			}
			if (carD==3) {
				setImage(new Image("file:src/p4_group_8_repo/img/waterdeath3.png"));
			}
			if (carD == 4) {
				setImage(new Image("file:src/p4_group_8_repo/img/waterdeath4.png"));
			}
			if (carD == 5) {
				setX(195);
				setY(530);
				waterDeath = false;
				carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/img/froggerUp.png"));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		
		if (getX()>400) {
			move(-movement, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) 
			move(getIntersectingObjects(Log.class).get(0).getSpeed(),0);		
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(getIntersectingObjects(Turtle.class).get(0).getSpeed(),0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(getIntersectingObjects(WetTurtle.class).get(0).getSpeed(),0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(195);
			setY(530);
		}
		else if (getY()<280){
			waterDeath = true;
			setX(230);
			setY(530);
		}
	}
	public boolean getStop() {
		return end==5;
	} 
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	

}
