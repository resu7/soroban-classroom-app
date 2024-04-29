//š Key Event ‚ğŒŸo‚·‚é
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class KeyTest extends JFrame implements KeyListener{
	// Main
	public static void main(String args[]){
		new KeyTest();
	}
	// Constructor
	public KeyTest(){
		super("Key Down");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);
		setSize(200, 100);
		setVisible(true);
	}
	// KeyEvent Listener
	public void keyPressed(KeyEvent e){
		System.out.println("Press: " + e.getKeyText(e.getKeyCode()));
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
}
