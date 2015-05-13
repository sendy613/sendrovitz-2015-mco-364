package sendrovitz.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawListener implements MouseListener, MouseMotionListener {

	private Canvas canvas;
	private int oldX;
	private int oldY;
	private Color color;
	private String tool;
	// private Rectangle rectangle;
	private int rectX;
	private int rectY;

	public DrawListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		// need to make sure that it is connected because doesn't update as fast
		// as you move the mouse
		int x = event.getX();
		int y = event.getY();

		color = canvas.getColor();
		tool = canvas.getTool();
		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(color);
		

		if (tool == "Pencil") {
			graphics.drawLine(oldX, oldY, x, y);
			oldX = x;
			oldY = y;

		} else {
			graphics.setColor(color);
			graphics.fillRect(rectX, rectY, (rectX -x)*-1, (rectY - y)*-1);
		}
		// repaint() is called because need to paint it the first time
		canvas.repaint();

	}

	@Override
	public void mousePressed(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();

		color = canvas.getColor();
		tool = canvas.getTool();
		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(color);

		if (tool == "Pencil") {
			graphics.drawLine(x, y, x, y);
			oldX = x;
			oldY = y;
		} else {
			rectX = x;
			rectY = y;
		}

		canvas.repaint();

	}

	@Override
	public void mouseClicked(MouseEvent event) {
		// both pressed and released

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
