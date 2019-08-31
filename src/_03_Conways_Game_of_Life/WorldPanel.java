package _03_Conways_Game_of_Life;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class WorldPanel extends JPanel implements MouseListener, ActionListener {
	private static final long serialVersionUID = 1L;
	private int cellsPerRow;
	private int cellSize;

	private Timer timer;

	// 1. Create a 2D array of Cells. Do not initialize it.

	Cell[][] cells;

	int[][] livingNeighbors = new int[cellsPerRow][cellsPerRow];

	public WorldPanel(int w, int h, int cpr) {
		setPreferredSize(new Dimension(w, h));
		addMouseListener(this);
		timer = new Timer(500, this);
		this.cellsPerRow = cpr;

		// 2. Calculate the cell size.

		int cellSize = ConwaysGameOfLife.WIDTH / cellsPerRow;

		// 3. Initialize the cell array to the appropriate size.

		cells = new Cell[cellsPerRow][cellsPerRow];

		// 3. Iterate through the array and initialize each cell.
		// Don't forget to consider the cell's dimensions when
		// passing in the location.

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {

				cells[i][j] = new Cell(cellSize * i, cellSize * j, cellSize);

			}
		}

	}

	public void randomizeCells() {
		// 4. Iterate through each cell and randomly set each
		// cell's isAlive memeber to true of false

		Random rand = new Random();

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {

				int randInt = rand.nextInt(2);

				if (randInt == 0) {
					cells[i][j].isAlive = false;
				} else {
					cells[i][j].isAlive = true;
				}
			}
		}

		repaint();
	}

	public void clearCells() {
		// 5. Iterate through the cells and set them all to dead.

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {

				cells[i][j].isAlive = false;

			}
		}

		repaint();
	}

	public void startAnimation() {
		timer.start();
	}

	public void stopAnimation() {
		timer.stop();
	}

	public void setAnimationDelay(int sp) {
		timer.setDelay(sp);
	}

	@Override
	public void paintComponent(Graphics g) {
		// 6. Iterate through the cells and draw them all

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {

				g.setColor(Color.blue);
				cells[i][j].draw(g);

				g.setColor(Color.BLACK);
				g.drawRect(cells[i][j].getX(), cells[i][j].getY(), cellSize, cellSize);
			}
		}

	}

	// advances world one step
	public void step() {
		// 7. iterate through cells and fill in the livingNeighbors array
		// . using the getLivingNeighbors method.


		// 8. check if each cell should live or die

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {

				cells[i][j].liveOrDie(getLivingNeighbors(i, j));

			}
		}

		repaint();
	}

	// 9. Complete the method.
	// It returns an int of 8 or less based on how many
	// living neighbors there are of the
	// cell identified by x and y
	public int getLivingNeighbors(int x, int y) {

		System.out.println(x + " " + y);
		
		int numNeighbors = 0;

		if (x - 1 >= 0) {

			if (cells[x - 1][y].isAlive) {
				numNeighbors++;
				System.out.println("-x");
			}
		}

		if (x + 1 <= cellsPerRow - 1) {

			if (cells[x + 1][y].isAlive) {
				numNeighbors++;
				System.out.println("+x");
			}
		}

		if (y - 1 >= 0) {

			if (cells[x][y - 1].isAlive) {
				numNeighbors++;
				System.out.println("-y");
			}
		}

		if (y + 1 <= cellsPerRow - 1) {

			if (cells[x][y + 1].isAlive) {
				numNeighbors++;
				System.out.println("+y");
			}
		}

		if (x + 1 <= cellsPerRow - 1 && y + 1 <= +cellsPerRow - 1) {

			if (cells[x + 1][y + 1].isAlive) {
				numNeighbors++;
				System.out.println("+x +y");
			}
		}

		if (x + 1 <= cellsPerRow - 1 && y - 1 >= +0) {

			if (cells[x + 1][y - 1].isAlive) {
				numNeighbors++;
				System.out.println("+x -y");
			}
		}

		if (x - 1 >= 0 && y + 1 <= +cellsPerRow - 1) {

			if (cells[x - 1][y + 1].isAlive) {
				numNeighbors++;
				System.out.println("-x +y");
			}
		}

		if (x - 1 >= 0 && y - 1 >= 0) {

			if (cells[x - 1][y - 1].isAlive) {
				numNeighbors++;
				System.out.println("-x -y");
			}
		}
		System.out.println(numNeighbors);
		System.out.println();
		return numNeighbors;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// 10. Use e.getX() and e.getY() to determine
		// which cell is clicked. Then toggle
		// the isAlive variable for that cell.

		cellSize = ConwaysGameOfLife.WIDTH / cellsPerRow;
//		System.out.println("asdf");
//		System.out.println("mouse" + e.getX() + " " + e.getY());
//		System.out.println("cell" + cells[3][3].getX() + " " + cells[3][3].getY());

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {

				if (e.getX() > cells[i][j].getX() && e.getX() < cells[i][j].getX() + cellSize
						&& e.getY() > cells[i][j].getY() && e.getY() < cells[i][j].getY() + cellSize) {

					cells[i][j].isAlive = !cells[i][j].isAlive;

				}
			}
		}

		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		step();
	}
}
