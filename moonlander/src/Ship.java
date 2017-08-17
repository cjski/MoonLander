import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/*
 * ship class
 * by: hannah ft chris
 */
public class Ship {
	
	//Game variables
	private int x;
	private int y;
	private int xspeed;
	private int yspeed;
	public int angle;
	private int boost;
	private int fuel;
	public String name;
	
	/*
	 * Constructor, initializes all variables
	 * parm x0 - inital x coordinate
	 * parm y0 - intial y coordinate
	 */
	public Ship(int x0, int y0){
		this.x = x0;
		this.y = y0;
		this.angle = 90;
		this.boost = 0;
		this.xspeed = 3;
		this.yspeed = -5;
	}
	
	/*
	 * Returns yspeed of the ship
	 */
	public int getXPos() {
		return this.x;
	}
	
	/*
	 * Returns yspeed of the ship
	 */
	public int getYPos() {
		return this.y;
	}
	
	/*
	 * Returns yspeed of the ship
	 */
	public int getYSpeed() {
		return this.yspeed;
	}
	
	/*
	 * Returns fuel of the ship
	 */
	public int getFuel() {
		return this.fuel;
	}
	
	/*
	 * Sets fuel of the ship
	 * parm newFuel - new fuel level
	 */
	public void setFuel(int newFuel){
		this.fuel = newFuel;
	}
	
	/*
	 * Sets boost of the ship
	 */
	public void setBoost(int boost){
		this.boost = boost;
	}
	
	/*
	 * Changes the angle the ship is aimed in
	 * parm arg0 - key on the keyboard that has been pressed
	 */
	public void changeAngle(KeyEvent arg0) {
		//If the user pressed left turn counterclockwise
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
			this.angle += 10;
		//if user pressed right turn clockwise
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
			this.angle += 10;
		} 
	
	/*
	 * Updates the speed based on gravity and the boost
	 */
	public void updatespeed() {
			//If the angle is greater than 360 degrees, subtract 360 to ensure angle is between 0 and 359
			while(Math.abs(this.angle) >=360 ) {
				this.angle -= 360;
			}
		
			//Update speeds
			//this.xspeed += this.boost*Math.cos(this.angle);
			//Yspeed is -= because positive is in the down direction
			this.yspeed -= this.boost*Math.sin(this.angle) - 1;
		}
	
	/*
	 * Updates the position of the ship based on speed
	 */
	public void updatepos() {
			this.x += this.xspeed;
			this.y += this.yspeed;
		}
	
	/**
	 * Draws Ship
	 * @param g -  Graphics
	 */
	public void draw(Graphics g){
		
		//Dir is 0-360
		//draw square based on angle of each point
		int drawDir = this.angle%90;
		
		//Draws a square around the centre
		g.drawLine(this.x + (int)(10*Math.cos(drawDir*Math.PI/180)), this.y + (int)(10*Math.sin(drawDir*Math.PI/180)), this.x - (int)(10*Math.sin(drawDir*Math.PI/180)), this.y + (int)(10*Math.cos(drawDir*Math.PI/180)));
		g.drawLine(this.x - (int)(10*Math.sin(drawDir*Math.PI/180)), this.y + (int)(10*Math.cos(drawDir*Math.PI/180)), this.x - (int)(10*Math.cos(drawDir*Math.PI/180)), this.y - (int)(10*Math.sin(drawDir*Math.PI/180)));
		g.drawLine(this.x - (int)(10*Math.cos(drawDir*Math.PI/180)), this.y - (int)(10*Math.sin(drawDir*Math.PI/180)), this.x + (int)(10*Math.sin(drawDir*Math.PI/180)), this.y - (int)(10*Math.cos(drawDir*Math.PI/180)));
		g.drawLine(this.x + (int)(10*Math.sin(drawDir*Math.PI/180)), this.y - (int)(10*Math.cos(drawDir*Math.PI/180)), this.x + (int)(10*Math.cos(drawDir*Math.PI/180)), this.y + (int)(10*Math.sin(drawDir*Math.PI/180)));
	}
}
