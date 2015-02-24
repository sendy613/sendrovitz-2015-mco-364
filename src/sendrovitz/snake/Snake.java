package sendrovitz.snake;

import java.util.ArrayList;

public class Snake {

	private SnakeHead head;
	private Integer numOfSquares;
	private final Integer sizeOfSquare = 10;
	private ArrayList<Coord> array;

	public Snake() {
		this.head = new SnakeHead();
		this.numOfSquares = 2;
		this.array = new ArrayList<Coord>();
		array.add(head.getCoord());
		array.add(new Coord(head.getCoord().getX(), 20));

	}

	public void setX(Integer i, Integer x) {
		array.get(i).setX(x);
	}

	public void setY(Integer i, Integer y) {
		array.get(i).setY(y);
	}

	public Integer getX(Integer i) {
		return array.get(i).getX();
	}

	public Integer getY(Integer i) {
		return array.get(i).getY();
	}

	public Integer getNumOfSquares() {
		return numOfSquares;
	}

	public void setNumOfSquares() {
		numOfSquares++;
	}

	public Integer getSizeOfSquare() {
		return sizeOfSquare;
	}

	public SnakeHead getHead() {
		return head;
	}

	public void removeLast() {
		array.remove(array.size() - 1);
	}

	public Coord getFirst() {
		return array.get(0);
	}

	public void addHead(Coord c) {
		head.setCoord(c);
		array.add(0, c);
	}

	public Coord getLast() {
		return array.get(array.size() - 1);
	}

}
