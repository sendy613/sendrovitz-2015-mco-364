package sendrovitz.snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class SnakeFrame extends JFrame implements KeyListener {
	private String pressed;
	private WorldComponent comp;

	public SnakeFrame() {
		setSize(506, 500);
		setTitle("SNAKE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		this.comp = new WorldComponent(new World());
		comp.addKeyListener(this);
		comp.setFocusable(true);
		contentPane.add(comp);
		pressed = "Right";

	}

	public String getPressed() {
		return pressed;
	}

	public void setPressed(String p) {
		pressed = p;
	}

	public WorldComponent getWorldComponent() {
		return comp;
	}

	public static void main(String args[]) {
		final SnakeFrame snake = new SnakeFrame();
		snake.setVisible(true);

		// animation thread- bec you are constantly calling repaint
		Thread thread = new Thread() {
			public void run() {
				while (true) {
					World world = snake.getWorldComponent().getWorld();
					// check input from user and sends it to world
					world.setInput(snake.pressed);
					// upates game objects
					world.moveSnake();
					// redraw
					snake.repaint();
					// see if game over

					if (world.gameOver()) {
						break;
					}

					try {
						Thread.sleep(100);

					} catch (InterruptedException e) {

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
		if (e.getKeyChar() == '4' || e.getKeyChar() == '6' || e.getKeyChar() == '8' || e.getKeyChar() == '2'
				|| (e.getKeyCode() == KeyEvent.VK_LEFT) || e.getKeyCode() == KeyEvent.VK_RIGHT
				|| (e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_DOWN)
				|| (e.getKeyCode() == KeyEvent.VK_ENTER)) {

			pressed = KeyEvent.getKeyText(e.getKeyCode());
			if (pressed.compareTo("Enter") == 0) {
				SnakeFrame.main(null);
			}
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