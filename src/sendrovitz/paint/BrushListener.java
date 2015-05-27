package sendrovitz.paint;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

//super class for all the listener
public abstract class BrushListener implements MouseListener, MouseMotionListener {
	protected Canvas canvas;
	protected int startX;
	protected int startY;
	protected int lastX;
	protected int lastY;

	public BrushListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		lastX = event.getX();
		lastY = event.getY();
		canvas.repaint();

	}

	@Override
	public void mousePressed(MouseEvent event) {
		startX = event.getX();
		startY = event.getY();

	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// when release the mouse you want it to draw to the image's graphics
		// (not the canvas' graphics)
		draw(canvas.getImage().getGraphics());
	}

	// can be used to draw both the preview and for the drawing to image
	// (depends on which graphics you send it)

	// this methods doesn't get implemented here. only in subclass cuz depends
	// which listener
	// abstract method
	abstract public void draw(Graphics g);

	abstract public void drawPreview(Graphics g);

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
