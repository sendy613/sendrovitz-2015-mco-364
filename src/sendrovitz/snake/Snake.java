package sendrovitz.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import sendrovitz.smile.Smile;

public class Snake extends JFrame implements KeyListener {
	public Snake() {
		setSize(500, 500);
		setTitle("SNAKE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		World comp = new World();
		comp.addKeyListener(this);
		comp.setFocusable(true);
		contentPane.add(comp);
		
	}

	public static void main(String args[]) {
		final Snake snake = new Snake();
		snake.setVisible(true);

		// animation thread- bec you are constantly calling repaint
		Thread thread = new Thread() {
			public void run() {
				while (true) {
					snake.repaint();
					try {
						Thread.sleep(1000); // stops the thread for 1 sec (1000
											// ml sec)
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
	}

	@Override
	// happens once- when press it
	public void keyPressed(KeyEvent e) {
		//4 or left arrow, then turns left
		//6 or right arrow, then turns right
		if(e.getKeyChar()=='4' || e.getKeyChar()=='6' || (e.getKeyCode() == e.VK_LEFT) || e.getKeyCode()==e.VK_RIGHT){
		System.out.println("key pressed");
		}
	}

	@Override
	// when release key
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	// keyPressed and keyReleased together (goes once release button)
	public void keyTyped(KeyEvent arg0) {

	}
}