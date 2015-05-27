package sendrovitz.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	private BufferedImage image;
	private Color color;
	private BrushListener listener;


	public Canvas(int width, int height, Color color) {
		// need to save the pixels in an image so that can recover it and redraw
		// that when recall paint
		// imageType is last argument.
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// clear screen
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height);
		this.color = color;

	
	}




	@Override
	// every time it is called it clears the info stored in memory. so lose
	// what's on the screen
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// draws buffered image to screen
		// must use the graphics obj from paint component
		g.drawImage(image, 0, 0, null);
		// gets repainted e time mouse mouse. draws to graphics obj as opposed
		// to drawing to the image
		// short term
		
		
		if(listener!=null){
		listener.drawPreview(g);
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setBrushListener(BrushListener listener) {
		this.listener = listener;

	
	}

}
