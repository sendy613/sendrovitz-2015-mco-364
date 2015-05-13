package sendrovitz.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawListener implements MouseListener, MouseMotionListener {

	private Canvas canvas;
	private int oldX;
	private int oldY;

	public DrawListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		// need to make sure that it is connected because doesn't update as fast
		// as you move the mouse
		int x = event.getX();
		int y = event.getY();

		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(Color.BLACK);
		graphics.drawLine(oldX, oldY, x, y);
		oldX = x;
		oldY = y;

		//repaint() is called because need to paint it the first time
		canvas.repaint();

	}

	@Override
	public void mousePressed(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();

		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(Color.BLACK);
		graphics.drawLine(x, y, x, y);
		oldX = x;
		oldY = y;

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
