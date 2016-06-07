public class SnakeGame
{
	public class Node
	{
		int [] coordinate;
		Node prev;
		Node next;

		Node(int [] coordinate, Node prev, Node next)
		{
			this.coordinate = new int [2];
			this.coordinate[0] = coordinate[0];
			this.coordinate[1] = coordinate[1];
			this.prev = prev;
			this.next = next;
		}
	}

	/** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

	int [][] food;
	int foodPointer;
	int score;
	Node snakeHead;
	Node snakeTail;
	int width;
	int height;

	SnakeGame(int width, int height, int [][] food)
	{
		this.food = food;
		snakeHead = new Node(new int [] {0,0},null,null);
		snakeTail = snakeHead;
		this.width = width;
		this.height = height;
	}

	/** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */

	public int move(String direction)
	{
		int [] dir = getDirection(direction.charAt(0));

		if(isOver(snakeHead, dir))
			return -1;

		int [] nextCoordinate = new int [2];
		nextCoordinate[0] = snakeHead.coordinate[0] + dir[0];
		nextCoordinate[1] = snakeHead.coordinate[1] + dir[1];

		Node newHead = new Node(nextCoordinate,null,snakeHead);
		snakeHead.prev = newHead;
		snakeHead = newHead;

		if(foodPointer < food.length && nextCoordinate[0] == food[foodPointer][0] && nextCoordinate[1] == food[foodPointer][1])
		{
			score++;
			foodPointer++;
			return score;
		}

		snakeTail = snakeTail.prev;
		snakeTail.next = null;

		return score;
	}

	private int [] getDirection(char dir)
	{
		if(dir == 'U')
			return new int [] {-1,0};
		if(dir == 'D')
			return new int [] {1,0};
		if(dir == 'L')
			return new int [] {0,-1};

		return new int [] {0,1};
	}

	private boolean isOver(Node node, int [] direction)
	{
		Node p = node;

		int [] nextCoordinate = new int [2];
		nextCoordinate[0] = node.coordinate[0] + direction[0];
		nextCoordinate[1] = node.coordinate[1] + direction[1];

		if(nextCoordinate[0] >= height || nextCoordinate[0] < 0 || nextCoordinate[1] >= width || nextCoordinate[1] < 0)
			return true;

		while(p != null)
		{
			if(nextCoordinate[0] == p.coordinate[0] && nextCoordinate[1] == p.coordinate[1] && p != snakeTail)
				return true;

			p = p.next;
		}

		return false;
	}
}