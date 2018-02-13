package edu.unl.raikes.pacman;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javafx.util.Pair;

/**
 * Class contains static method for finding a path through a given grid of GameBoard cells.
 * @author Stephanie Valentine
 */
public class PathFinder {

	/**
	 * Given a grid of GameBoardCells, find a path from one cell to another. If no path exists, 
	 * returns null.
	 * @param start The starting cell
	 * @param end The cell to which the algorithm is finding a path
	 * @param grid the grid of GameBoardCells through which the algorithm finds a path
	 * @return an array of directions
	 */
	public static ArrayList<Integer> findPath(GameBoardCell start, GameBoardCell end, GameBoardCell[][] grid) {
		// keep track of how we got to each cell
		Map<GameBoardCell, Pair<Integer, GameBoardCell>> parents = new HashMap<GameBoardCell, Pair<Integer, GameBoardCell>>();
		
		// keep track of the cells we've already visited
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		// BFS uses queue data structure
		Queue<Pair<Integer, GameBoardCell>> queue = new LinkedList<Pair<Integer, GameBoardCell>>();
		
		// seed the queue and parents map with the start cell
		Pair<Integer, GameBoardCell> startPair = new Pair<Integer, GameBoardCell>(0, start);
		queue.add(startPair);
		parents.put(start, null);
		
		// begin search
		while (!queue.isEmpty()) {
			// pop from the queue
			Pair<Integer, GameBoardCell> pair = queue.remove();
			// marks as visited
			visited[pair.getValue().getRow()][pair.getValue().getCol()] = true;
			// if the cell we're visiting is the goal cell
			if (pair.getValue() == end) {
				// retrace from parents and return it
				ArrayList<Integer> path = getPath(parents,pair);
				return path;
			} 
			// if the cell we're visiting is not the goal cell
			else {
				// get any unvisited neighbors
				ArrayList<Pair<Integer,GameBoardCell>> neighbors = getUnvisitedNeighbors(pair.getValue(), grid, visited);
				// add the neighbors to the queue and parents list if they haven't already been added
				for (int i=0;i<neighbors.size();i++) {
					if(parents.get(neighbors.get(i).getValue())==null) {
						queue.add(neighbors.get(i));
						parents.remove(neighbors.get(i).getValue());
						parents.put(neighbors.get(i).getValue(), pair);
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Retraces the path from the destination back to the source and generates a list of 
	 * navigation directions.
	 * @param parents a mapping from each cell to its parent in the navigation
	 * @param destinationPair the final destination and the direction it took to arrive there.
	 * @return
	 */
	private static ArrayList<Integer> getPath(Map<GameBoardCell, Pair<Integer, GameBoardCell>> parents, Pair<Integer, GameBoardCell> destinationPair) {
		// initialize path and add the last direction
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(0,destinationPair.getKey());
		
		// initialize the loop variable with the destination cell
		GameBoardCell cell = destinationPair.getValue();
		
		// loop through until we reach the source (the pair with a key of 0)
		while(parents.get(cell) != null && parents.get(cell).getKey()!=0) {
			// add the new direction in the first position of the path of directions
			path.add(0,parents.get(cell).getKey());
			// set cell as the next item in the path
			cell = parents.get(cell).getValue();
		}
		
		return path;
	}
	
	/**
	 * Gets all non-wall neighbor cells that have not yet been visited by the algorithm.
	 * @param cell the cell whose neighbors you are trying to retrieve
	 * @param grid the grid of cells through which the algorithm is trying to find a path
	 * @param visited a parallel to grid that indicates whether each cell has been visited
	 * @return a list of the cell's unvisited neighbors, along with directions as to which direction traveled
	 */
	private static ArrayList<Pair<Integer,GameBoardCell>> getUnvisitedNeighbors(GameBoardCell cell, GameBoardCell[][] grid, boolean[][] visited) {
		// get all the neighbors
		ArrayList<Pair<Integer,GameBoardCell>> neighbors = getNeighbors(cell,grid);
		
		// make a new list that filters out visited  neighbors
		ArrayList<Pair<Integer,GameBoardCell>> unvisitedNeighbors = new ArrayList<Pair<Integer,GameBoardCell>>();
		
		// loop through and filter out unvisited neighbors
		for(int i=0;i<neighbors.size();i++) {
			Pair<Integer,GameBoardCell> neighbor = neighbors.get(i);
			if (!visited[neighbor.getValue().getRow()][neighbor.getValue().getCol()]) {
				unvisitedNeighbors.add(neighbor);
			}
		}
		
		return unvisitedNeighbors;
	}
	
	/**
	 * Gets all non-wall neighbor cells.
	 * @param cell the cell whose neighbors you are trying to retrieve
	 * @param grid the grid of cells through which the algorithm is trying to find a path
	 * @return a list of the cell's neighbors, along with directions as to which direction traveled
	 */
	private static ArrayList<Pair<Integer,GameBoardCell>> getNeighbors(GameBoardCell cell,GameBoardCell[][] grid){
		int row = cell.getRow();
		int col = cell.getCol();
		
		ArrayList<Pair<Integer,GameBoardCell>> neighbors = new ArrayList<Pair<Integer,GameBoardCell>>();
		
		// see if the cell above the given cell can be visited
		if(row > 0 && grid[row-1][col].getCellType() != GameBoardCellType.WALL) {
			neighbors.add(new Pair<Integer,GameBoardCell>(KeyEvent.VK_UP,grid[row-1][col]));
		}
		
		// see if the cell below the given cell can be visited
		if(row < grid.length - 1 && grid[row+1][col].getCellType()  != GameBoardCellType.WALL) {
			neighbors.add(new Pair<Integer,GameBoardCell>(KeyEvent.VK_DOWN,grid[row+1][col]));
		}
		
		// see if the cell to the left of the given cell can be visited
		if(col > 0 && grid[row][col-1].getCellType() != GameBoardCellType.WALL) {
			neighbors.add(new Pair<Integer,GameBoardCell>(KeyEvent.VK_LEFT,grid[row][col-1]));
		}
		
		// see if the cell to the right of the given cell can be visited
		if(col < grid[row].length -1 && grid[row][col+1].getCellType()  != GameBoardCellType.WALL) {
			neighbors.add(new Pair<Integer,GameBoardCell>(KeyEvent.VK_RIGHT,grid[row][col+1]));
		}
		
		return neighbors;
	}
	
	

}
