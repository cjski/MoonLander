import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * Class to listen to Key Presses
 * Date: 8/14/2017
 * Chris Janowski, Hannah Luo
 */
public class MyListener implements KeyListener{
	
	//Ship that is used in game
	private Ship s;
	
	/*
	 * Constructor class
	 * parm Ship, sets the ship used in the game
	 */
	public MyListener(Ship s){
		this.s = s;
	}

	@Override
	/*
	 * Runs when a key is pressed
	 */
	public void keyPressed(KeyEvent arg0) {
		//If the user presses the boost button
		if(arg0.getKeyCode() == KeyEvent.VK_W){
			
			//Sets the ships boost
			this.s.setBoost(3);
			//Reduces the fuel of the ship
			this.s.setFuel(this.s.getFuel()-1);
		}
	}

	@Override
	/*
	 * Runs when a key is released
	 */
	public void keyReleased(KeyEvent arg0) {
		// If the boost key is released
		if(arg0.getKeyCode() == KeyEvent.VK_W){
		
			//Resets the boost speed back to 0
			this.s.setBoost(0);
		}
	}

	@Override
	/*
	 * Runs when a key is typed
	 */
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

}
