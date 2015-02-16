package sendrovitz.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {
	private boolean wink;
	private Integer width;
	private Integer height;

	public SmileComponent() {
		this.wink = false;

	}

	// you never call this method. the vm calls it when nec
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.width = getWidth();
		this.height = getHeight();
		// face
		g.setColor(Color.YELLOW);
		g.fillOval(10, 20, width - 20, height - 50);
		// smile
		g.setColor(Color.RED);
		g.drawArc((int) (width / 3.25), (int) (2.5 * (height / 5)), (int) (width / 2.3), (int) (height / 3.8), 0, -180);
		// eyes
		g.setColor(Color.green);
		g.fillOval((int) (width / 3.5), height / 3, width / 15, height / 15);
		g.fillOval(2 * (width / 3), height / 3, width / 15, height / 15);

		if (wink) {

			g.fillOval((int) (width / 3.5), height / 3, width / 15, height / 15);

			wink = false;

		} else {
			g.setColor(Color.yellow);
			int i = height / 30;
			while (i <= (height / 15) - (height / 70)) {

				g.fillOval((int) (width / 3.5), height / 3, width / 15, i);

				i++;
			}

			wink = true;
		}

	}

}
