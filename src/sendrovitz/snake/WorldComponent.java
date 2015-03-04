package sendrovitz.snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

//job is to paint everything
public class WorldComponent extends JComponent {
	private World world;
	private Image gameOver;
	private Image head;
	private Image apple;

	public WorldComponent(World world) {
		this.world = world;
		try {
			this.gameOver = ImageIO.read(new File("gameover2.png"));
			this.head = ImageIO.read(new File("head.png"));
			this.apple = ImageIO.read(new File("apple-red.png"));
		} catch (IOException e) {
		}
	}

	public World getWorld() {
		return world;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (world.gameOver()) {
			g.drawImage(gameOver, 0, 0, world.getBoard().getWidth(), world.getBoard().getHeight(), null);
			g.setColor(Color.WHITE);
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
			g.drawString("Press Enter for new game", world.getBoard().getWidth() / 3, 20);
		} else {
			// board
			g.setColor(new Color(54584));
			g.fillRect(0, 0, world.getBoard().getWidth(), world.getBoard().getHeight());

			// snake
			Snake snake = world.getSnake();
			g.setColor(Color.BLACK);
			for (int i = 0; i < snake.getNumOfSquares(); i++) {
				if (i == 0) {
					g.drawImage(head, snake.getX(i), snake.getY(i), snake.getSizeOfSquare(), snake.getSizeOfSquare(),
							null);
				} else {
					g.setColor(Color.YELLOW);
					g.fillRect(snake.getX(i), snake.getY(i), snake.getSizeOfSquare(), snake.getSizeOfSquare());
				}

			}

			// food
			g.drawImage(apple, world.getFood().getFood().getX(), world.getFood().getFood().getY(), world.getFood()
					.getFoodSize(), world.getFood().getFoodSize(), null);

		}
	}

}
