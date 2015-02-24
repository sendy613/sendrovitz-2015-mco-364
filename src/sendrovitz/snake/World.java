package sendrovitz.snake;

//holds game component

//see if snake is eating the food
//create more food
//grow the snake
//check if bumped into walls or itself
//make sure food doesnt go below walls

public class World {
	private Snake snake;
	private Board board;
	private Food food;
	private String input;

	public World() {
		this.snake = new Snake();
		this.board = new Board();
		this.food = new Food();
		checkIfFoodCovered(food);

	}

	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Food getFood() {
		// check if food is on top of snake
		food = checkIfFoodCovered(food);
		return food;
	}

	public void setFood(Food food) {
		// check if food is on top of snake
		checkIfFoodCovered(food);
		this.food = food;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		if (input == null) {
			this.input = snake.getHead().getDirection();
		} else {
			if (input.compareTo("NumPad-4") == 0) {
				input = "Left";
			} else if (input.compareTo("NumPad-6") == 0) {
				input = "Right";
			} else if (input.compareTo("NumPad-8") == 0) {
				input = "Up";
			} else if (input.compareTo("NumPad-2") == 0) {
				input = "Down";
			}

			this.input = input;
		}

	}

	// moveSnake
	public void moveSnake() {
		Integer x = snake.getFirst().getX();
		Integer y = snake.getFirst().getY();
		snake.getHead().setDirection(input);

		switch (input) {
		case "Left":
			x -= snake.getSizeOfSquare();
			break;

		case "Right":
			x += snake.getSizeOfSquare();
			break;

		case "Up":
			y -= snake.getSizeOfSquare();
			break;

		case "Down":
			y += snake.getSizeOfSquare();
			break;
		}
		snake.addHead(new Coord(x, y));
		if (getIfAteFood()) {
			snake.setNumOfSquares();
		} else {
			snake.removeLast();
		}

	}

	// check if ate food
	public boolean getIfAteFood() {
		if (snake.getFirst().getX().compareTo(food.getFood().getX()) == 0
				&& snake.getFirst().getY().compareTo(food.getFood().getY()) == 0) {
			food = new Food();
			return true;
		}

		return false;
	}

	public Food checkIfFoodCovered(Food f) {
		boolean covered = false;

		for (int i = 0; i < snake.getNumOfSquares(); i++) {
			if (f.getFood().getX().compareTo(snake.getX(i)) == 0 && f.getFood().getY().compareTo(snake.getY(i)) == 0) {
				covered = true;
				break;
			}
		}
		if (food.getFood().getX().compareTo(0) < 0 || food.getFood().getX().compareTo(board.getWidth()) > 0
				|| food.getFood().getY().compareTo(0) < 0 || food.getFood().getY().compareTo(board.getHeight()) > 0) {
			covered= true;
		}

		if (covered == true) {
			f = new Food();
			f = checkIfFoodCovered(f);
		}

		return f;
	}

	public boolean gameOver() {
		if (snake.getFirst().getX().compareTo(0) < 0 || snake.getFirst().getX().compareTo(board.getWidth()-10) > 0
				|| snake.getFirst().getY().compareTo(0) < 0 || snake.getFirst().getY().compareTo(board.getHeight()-10) > 0) {
			return true;
		} else {
			for (int i = 1; i < snake.getNumOfSquares(); i++) {
				if (snake.getX(i).compareTo(snake.getFirst().getX()) == 0
						&& snake.getY(i).compareTo(snake.getFirst().getY()) == 0) {
					return true;
				}
			}

		}
		return false;
	}

}
