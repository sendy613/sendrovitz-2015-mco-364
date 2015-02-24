package sendrovitz.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class Food {
	private Coord c;
	private final Integer foodSize = 10;

	public Food() {
		this.c = new Coord();
		Random random = new Random();
		c.setX((random.nextInt(42) + 5) * foodSize);
		c.setY((random.nextInt(42) + 5) * foodSize);
	}

	public Coord getFood() {
		return c;
	}

	public void setFood(Integer x, Integer y) {
		c.setX(x);
		c.setY(y);
	}

	public Integer getFoodSize() {
		return foodSize;
	}

}
