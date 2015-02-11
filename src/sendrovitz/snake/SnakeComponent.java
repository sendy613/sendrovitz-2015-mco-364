package sendrovitz.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javafx.scene.shape.Circle;

import javax.swing.JComponent;

public class SnakeComponent extends JComponent{

	public SnakeComponent(){
	
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 500, 500);
		//each snake square is 10x10
		g.setColor(Color.BLACK);
		g.fillRect(25, 25, 20, 10);
		Random random = new Random();
		Integer food = random.nextInt(50)*10;
		Integer food2 = random.nextInt(50)*10;
		g.setColor(Color.RED);
		g.fillRect(food, food2, 10,10);
		
	}
}
