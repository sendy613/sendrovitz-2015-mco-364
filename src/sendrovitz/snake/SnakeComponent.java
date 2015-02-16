package sendrovitz.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Stack;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import javax.swing.JComponent;

public class SnakeComponent extends JComponent {

	private String direction;
	private Integer numOfSquares;

	private Stack<Integer> stack;

	public SnakeComponent() {
		this.direction = "Straight";
		this.numOfSquares = 2;
		this.stack = new Stack<Integer>();
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Integer getNumOfSquares() {
		return numOfSquares;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// each snake square is 10x10
		g.setColor(Color.BLACK);
		Rectangle rect = new Rectangle();
		rect.setX(25);
		rect.setY(25);
		rect.setHeight(10);
		rect.setWidth(20);
		//g.fillRect(25, 25, 20, 10);
		if (direction == "Right") {

		} else if (direction == "Left") {

		} else {

		}

	}
}
