package sendrovitz.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {
	private boolean wink;

	public SmileComponent() {
		this.wink = false;
	}

	// you never call this method. the vm calls it when nec
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillOval(200, 100, 400, 400);// (numbers are start of circle, height,
										// width )
		g.setColor(Color.RED);
		g.drawArc(325, 290, 150, 150, 0, -180);
		g.setColor(Color.green);
		g.fillOval(450, 200, 30, 30);
		g.fillOval(325, 200, 30, 30);
		if (wink) {
			g.fillOval(325, 200, 30, 30);
			wink = false;
		} else {
			g.setColor(Color.yellow);
			int i = 10;
			while (i <= 25) {
				g.fillOval(325, 200, 30, i);
				i++;
			}
			// g.drawArc(325, 215, 30, 20, 0, -180);
			wink = true;
		}

	}

}
