package sendrovitz.paint;

import java.awt.Graphics;

public class PencilListener extends BrushListener {
	
	private Canvas canvas;

	public PencilListener(Canvas canvas) {
		super(canvas);
		this.canvas = canvas;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(canvas.getColor());
		g.drawLine(startX, startY, lastX, lastY);
		startX = lastX;
		startY = lastY;
	}

	@Override
	public void drawPreview(Graphics g) {
		Graphics otherGraphics = canvas.getImage().getGraphics();
		otherGraphics.setColor(canvas.getColor());
		otherGraphics.drawLine(startX, startY, lastX, lastY);
		startX = lastX;
		startY = lastY;
	}

}
