package sendrovitz.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class BoardComponent extends JComponent {
	public BoardComponent() {

	}@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 500, 500);
		
	}
}
