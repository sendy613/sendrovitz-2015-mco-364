package sendrovitz.snake;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class World extends JComponent {
	private SnakeComponent snake;
	private BoardComponent board;
	private FoodComponent food;

	public World() {
		this.snake = new SnakeComponent();
		this.board = new BoardComponent();
		this.food = new FoodComponent();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawRect(0, 0, 500, 500);
	}
	
	public SnakeComponent getSnake() {
		return snake;
	}

	public BoardComponent getBoard() {
		return board;
	}

	public FoodComponent getFood() {
		return food;
	}

	
}
