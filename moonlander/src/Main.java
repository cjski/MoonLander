import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

/*
 * Moon Lander Game Main run
 * start game here and control screen and all objects here
 * 
 * By Chris Janowski and Hannah Luo
 */
public class Main extends JComponent implements KeyListener{
	
	//Jframe variable
	private static final long serialVersionUID = -688856155579961348L;
	
	private JFrame frame;
	
	private long time;
	
	/*
	 * Constructor for the game object
	 * initializes JFrame
	 */
	
	private Ship s;
	
	public Main(){
		
		//Creates a new Frame to draw graphics to
		this.frame = new JFrame(); 
		//Sets the default shutdown and close operation
	    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //Sets the size of the frame
	    this.frame.setSize(1080,760); 
	    //Adds the game object onto the frame to draw to it
	    this.frame.add(this);
	    //Makes the frame visible to the user
	    this.frame.setVisible(true);
	    this.addKeyListener(this);
	    //Not using mouse clicks yet, uncomment when needed
	    /*
	    //Tells the frame to respond to mouse actions
	    this.addMouseListener(this);
	    */
	    this.s = new Ship(100, 100);
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
			this.s.angle += 10;
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		s.changeAngle(arg0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void paint(Graphics g){
		this.s.draw(g);
	}
}