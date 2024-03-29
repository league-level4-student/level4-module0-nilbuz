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

		maze.cells[0][randGen.nextInt(5)].setWestWall(false);
		maze.cells[4][randGen.nextInt(5)].setEastWall(false);
		
		selectNextPath(maze.cells[randGen.nextInt(maze.cells.length)][randGen.nextInt(maze.cells.length)]);

		return maze;
	}

	// 6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		
		
		// A. mark cell as visited
		
		currentCell.setBeenVisited(true);

		ArrayList<Cell> unvisitedNeighbors = getUnvisitedNeighbors(currentCell);

		// B. check for unvisited neighbors using the cell

		if (!unvisitedNeighbors.isEmpty()) {

			Cell selectedCell = unvisitedNeighbors.get(randGen.nextInt(unvisitedNeighbors.size()));
			uncheckedCells.push(selectedCell);
			removeWalls(currentCell, selectedCell);
			currentCell = selectedCell;
			selectNextPath(currentCell);

		} else if (!uncheckedCells.isEmpty()) {

			currentCell = uncheckedCells.pop();
			selectNextPath(currentCell);

		}

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

		System.out.println("(" + c1.getX() + ", " + c1.getY() + ")");
		System.out.println("(" + c2.getX() + ", " + c2.getY() + ")");

		if (Math.abs(c1.getY() - c2.getY()) == 1 || Math.abs(c1.getX() - c2.getX()) == 1) {

			if (c1.getX() - c2.getX() == 1) {
				c1.setWestWall(false);
				c2.setEastWall(false);
				System.out.println("west");
			}

			else if (c1.getX() - c2.getX() == -1) {
				c1.setEastWall(false);
				c2.setWestWall(false);
				System.out.println("east");
			}

			else if (c1.getY() - c2.getY() == 1) {
				c1.setNorthWall(false);
				c2.setSouthWall(false);
				System.out.println("north");
			}

			else if (c1.getY() - c2.getY() == -1) {
				c1.setSouthWall(false);
				c2.setNorthWall(false);
				System.out.println("south");
			}

			System.out.println();

		}

	}

	// 8. Complete the getUnvisitedNeighbors method
	// Any unvisited neighbor of the passed in cell gets added
	// to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {

		ArrayList<Cell> unvisitedNeighbors2 = new ArrayList<Cell>();

		if (c.getX() - 1 >= 0) {
			if (!maze.cells[c.getX() - 1][c.getY()].hasBeenVisited()) {
				unvisitedNeighbors2.add(maze.cells[c.getX() - 1][c.getY()]);
			}
		}

		if (c.getX() + 1 <= maze.cells.length - 1) {
			if (!maze.cells[c.getX() + 1][c.getY()].hasBeenVisited()) {
				unvisitedNeighbors2.add(maze.cells[c.getX() + 1][c.getY()]);
			}
		}

		if (c.getY() - 1 >= 0) {
			if (!maze.cells[c.getX()][c.getY() - 1].hasBeenVisited()) {
				unvisitedNeighbors2.add(maze.cells[c.getX()][c.getY() - 1]);
			}
		}

		if (c.getY() + 1 <= maze.cells.length - 1) {
			if (!maze.cells[c.getX()][c.getY() + 1].hasBeenVisited()) {
				unvisitedNeighbors2.add(maze.cells[c.getX()][c.getY() + 1]);
			}
		}

		return unvisitedNeighbors2;
	}
}
