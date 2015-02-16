package sendrovitz.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class FoodComponent extends JComponent{
	public FoodComponent() {

	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Random random = new Random();
		Integer food = random.nextInt(49)*10;
		Integer food2 = random.nextInt(49)*10;
		g.setColor(Color.RED);
		g.fillRect(food, food2, 10,10);
		
	}
}
