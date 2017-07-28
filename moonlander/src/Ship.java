import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/*
 * ship class
 * by: hannah ft chris
 */
public class Ship {
	
	private int x;
	private int y;
	private int xspeed;
	private int yspeed;
	public int angle;
	private int boost;
	private int fuel;
	public String name;
	
	public Ship(int x0, int y0){
		this.x = x0;
		this.y = y0;
		this.angle = 45;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in); //console input/output
		
		int x = getNum(sc);
		
		System.out.println(x);
		
		sc.close();
	}
	
	public int getYSpeed() {
		return this.yspeed;
	}
	
	public int getFuel() {
		return this.fuel;
	}
	
	public static int getNum(Scanner sc) {
		System.out.println("Enter a number:");
		int x = sc.nextInt(); // input next int as console input
		
		return x;
	}
	
	public void changeAngle(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
			this.angle += 10;
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
			this.angle += 10;
		} 

	public void booster(KeyEvent arg0) {
		while(arg0.getKeyCode() == KeyEvent.VK_UP) {
			this.boost++;
			this.fuel--;
			}
		}
	
	private void updatespeed() {
			while(Math.abs(this.angle) >=360 ) {
				if(this.angle < 0)
					this.angle += 360;
				else
					this.angle -= 360;
			}
			this.xspeed += this.boost*Math.cos(this.angle);
			this.yspeed += this.boost*Math.sin(this.angle) - 2;
		}

	private void updatepos() {
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
