package sendrovitz.snake;

public class SnakeHead {
	private String direction;
	private Coord c;

	public SnakeHead() {
		this.direction = "Right";
		this.c = new Coord(20, 20);
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Coord getCoord() {
		return c;
	}

	public void setCoord(Coord c) {
		this.c = c;
	}
}
