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
	
	//Jframe variable
	private static final long serialVersionUID = -688856155579961348L;
	
	private JFrame frame;
	private MyListener myL;
	private long time;
	/*
	 * Constructor for the game object
	 * initializes JFrame
	 */
	
	private Ship s;
	
	public Main(){
		
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
	    this.myL = new MyListener(this.s);
	    this.frame.addKeyListener(this.myL);
	    this.setFocusable(true);
	    //Not using mouse clicks yet, uncomment when needed
	    /*
	    //Tells the frame to respond to mouse actions
	    this.addMouseListener(this);
	    */
	    this.time = System.currentTimeMillis();
	    
	    
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
		if(System.currentTimeMillis() - this.time > 100){
			this.time = System.currentTimeMillis();
			this.s.updatepos();
			this.s.updatespeed();
			//this.s.dir += 10;
		}
	}
	
	public void paint(Graphics g){
		this.s.draw(g);
	}
}
