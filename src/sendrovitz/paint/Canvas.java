package sendrovitz.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	private BufferedImage image;
//	private List<BufferedImage> rectangleList;
	private Color color;
	private String tool;

	public Canvas(int width, int height, Color color, String tool) {
		// need to save the pixels in an image so that can recover it and redraw
		// that when recall paint
		// imageType is last argument.
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// clear screen
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height);
		this.color = color;
		this.tool = tool;
//		rectangleList = new ArrayList<BufferedImage>();
	}

	@Override
	// every time it is called it clears the info stored in memory. so lose
	// what's on the screen
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	/*	Graphics2D g2 = image.createGraphics();
		g2.setColor(Color.WHITE);
		for(BufferedImage image: rectangleList){
			g2.drawImage(image,image.getMinX(),image.getMinTileY(),null);
		}*/
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

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

/*	public List<BufferedImage> getRectangleList() {
		return rectangleList;
	}*/

}
