package sendrovitz.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class Board {
	private final Integer width;
	private final Integer height;

	public Board() {
		this.width = 500;
		this.height = 500;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeight() {
		return height;
	}

}
