package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int width;
	private static int height;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	public static Maze generateMaze(int w, int h) {
		width = w;
		height = h;
		maze = new Maze(width, height);

		// 4. select a random cell to start

		// 5. call selectNextPath method with the randomly selected cell

		selectNextPath(maze.cells[randGen.nextInt(maze.cells.length)][randGen.nextInt(maze.cells.length)]);

		return maze;
	}

	// 6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {

		int cellsPerRow = maze.cells.length;

		System.out.println(cellsPerRow);

		// A. mark cell as visited

		currentCell.setBeenVisited(true);
		Cell[][] unvisitedNeighbors = new Cell[maze.cells.length][maze.cells.length];

		// B. check for unvisited neighbors using the cell

		if (currentCell.getX() - 1 >= 0) {
			unvisitedNeighbors[currentCell.getX() - 1][currentCell
					.getY()] = maze.cells[currentCell.getX() - 1][currentCell.getY()];

		}

		if (currentCell.getX() + 1 <= cellsPerRow - 1) {
			unvisitedNeighbors[currentCell.getX() + 1][currentCell
					.getY()] = maze.cells[currentCell.getX() + 1][currentCell.getY()];

		}

		if (currentCell.getY() - 1 >= 0) {
			unvisitedNeighbors[currentCell.getX()][currentCell.getY()
					- 1] = maze.cells[currentCell.getX()][currentCell.getY() - 1];

		}

		if (currentCell.getY() + 1 <= cellsPerRow - 1) {
			unvisitedNeighbors[currentCell.getX()][currentCell.getY()
					+ 1] = maze.cells[currentCell.getX()][currentCell.getY() + 1];

		}

		if (currentCell.getX() + 1 <= cellsPerRow - 1 && currentCell.getY() + 1 <= +cellsPerRow - 1) {

			unvisitedNeighbors[currentCell.getX() + 1][currentCell.getY()
					+ 1] = maze.cells[currentCell.getX() + 1][currentCell.getY() + 1];
		}

		if (currentCell.getX() + 1 <= cellsPerRow - 1 && currentCell.getY() - 1 >= +0) {
			unvisitedNeighbors[currentCell.getX() + 1][currentCell.getY()
					- 1] = maze.cells[currentCell.getX() + 1][currentCell.getY() - 1];

		}

		if (currentCell.getX() - 1 >= 0 && currentCell.getY() + 1 <= +cellsPerRow - 1) {
			unvisitedNeighbors[currentCell.getX() - 1][currentCell.getY()
					+ 1] = maze.cells[currentCell.getX() - 1][currentCell.getY() + 1];

		}

		if (currentCell.getX() - 1 >= 0 && currentCell.getY() - 1 >= 0) {
			unvisitedNeighbors[currentCell.getX() - 1][currentCell.getY()- 1] = maze.cells[currentCell.getX() - 1][currentCell.getY() - 1];

		}

//		for (int i = 0; i < unvisitedNeighbors.length; i++) {
//			for (int j = 0; j < unvisitedNeighbors[i].length; j++) {
//
//				System.out.println(i + " " + j);
//
//			}
//		}

//		Cell selectedCell = unvisitedNeighbors[randInt][randInt];

//		uncheckedCells.push(selectedCell);
//
//		removeWalls(currentCell, selectedCell);

		// C. if has unvisited neighbors,

		// C1. select one at random.

		// C2. push it to the stack

		// C3. remove the wall between the two cells

		// C4. make the new cell the current cell and mark it as visited

		// C5. call the selectNextPath method with the current cell

		// D. if all neighbors are visited

		// D1. if the stack is not empty

		// D1a. pop a cell from the stack

		// D1b. make that the current cell

		// D1c. call the selectNextPath method with the current cell

	}

	// 7. Complete the remove walls method.
	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {

		System.out.println(c1.getX() + " " + c1.getY());
		System.out.println(c2.getX() + " " + c2.getY());

		if (Math.abs(c1.getY() - c2.getY()) == 1 || Math.abs(c1.getX() - c2.getX()) == 1) {

			if (c1.getX() - c2.getX() == 1) {
				c1.setWestWall(false);
				System.out.println("w");
			}

			else if (c1.getX() - c2.getX() == -1) {
				c1.setEastWall(false);
				System.out.println("e");
			}

			else if (c1.getY() - c2.getY() == 1) {
				c1.setNorthWall(false);
				System.out.println("n");
			}

			else if (c1.getY() - c2.getY() == -1) {
				c1.setSouthWall(false);
				System.out.println("s");
			}

		}

	}

	// 8. Complete the getUnvisitedNeighbors method
	// Any unvisited neighbor of the passed in cell gets added
	// to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		return null;
	}
}
