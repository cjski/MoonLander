import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Moon Lander Game Main run
 * start game here and control screen and all objects here
 * 
 * By Chris Janowski and Hannah Luo
 */
public class Main extends JComponent{
	
	//Jframe variables
	private static final long serialVersionUID = -688856155579961348L;
	private JFrame frame;
	//Objects that takes care of key listening
	private MyListener myL;
	
	//Game variables
	private long time;
	private Ship s;
	
	/*
	 * Constructor for the game object
	 * initializes JFrame and sets the listener to listen to the keys
	 */
	public Main(){
		
		//Creates a new ship
		this.s = new Ship(100,100);
		
		//Creates a new Frame to draw graphics to
		this.frame = new JFrame();
		//Sets the default shutdown and close operation
	   	this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	//Sets the size of the frame
	   	this.frame.setSize(1080,700); 
	   	//Adds the game object onto the frame to draw to it
	    	this.frame.add(this);
	   	//Makes the frame visible to the user
	    	this.frame.setVisible(true);
		
		//Creates a new listener to listen to the key presses
		//Uses ship class in order to update the ship parameters
	   	this.myL = new MyListener(this.s);
		
		//The frame adds the keylistener to be able to update its graphics
	   	this.frame.addKeyListener(this.myL);
	    	this.setFocusable(true);
	    	
		//Initalizes the time
	    	this.time = System.currentTimeMillis();
	    
	    //Starts the game loop - infinite loop, will end when the game is closed
	    while(true){
	    	//Updates game - positions of ship and map
	    	this.update();
	    	//Updates graphics on JFrame
	    	this.repaint();
	    }
	}
	
	/*
	 * MAIN - Is run upon start of code, creates Main Object and starts game
	 */
	public static void main(String Args[]){
		new Main();
	}
	
	/*
	 * Updates all game variables and entities
	 */
	public void update(){
		//Waits until 100 milliseconds has passed before running
		if(System.currentTimeMillis() - this.time > 100){
			//Resets the time to check against
			this.time = System.currentTimeMillis();
			
			//Updates the ship position and speed
			this.s.updatepos();
			this.s.updatespeed();
		}
	}
	
	/*
	 * Draws the graphics on the screen
	 */
	public void paint(Graphics g){
		
		//Draws the ship onto the screen
		this.s.draw(g);
	}
}
