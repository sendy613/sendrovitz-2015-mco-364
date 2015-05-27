package sendrovitz.paint;

import java.awt.Graphics;

public class RectangleListener extends BrushListener {

	public RectangleListener(Canvas canvas) {
		super(canvas);
	}

	@Override
	public void draw(Graphics g) {
		// dont have x and y because its private so make the protected- child
		// classes can access them
		g.setColor(canvas.getColor());
		if (startX > lastX && startY > lastY) {
			g.drawRect(lastX, lastY, (startX - lastX), (startY - lastY));
		} else if (startX > lastX && startY < lastY) {
			g.drawRect(lastX, startY, (startX - lastX), (lastY-startY));
		} else if (startX < lastX && startY > lastY) {
			g.drawRect(startX, lastY, (lastX-startX), (startY - lastY));
		} else {
			g.drawRect(startX, startY, (lastX-startX), (lastY- startY));

		}
	}

	@Override
	public void drawPreview(Graphics g) {
	draw(g);

	}
}
