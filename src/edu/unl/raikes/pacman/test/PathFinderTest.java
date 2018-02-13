package edu.unl.raikes.pacman.test;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.junit.Test;

import edu.unl.raikes.pacman.GameBoard;
import edu.unl.raikes.pacman.GameBoardCell;
import edu.unl.raikes.pacman.PathFinder;

public class PathFinderTest {

	@Test
	public void testGetPathOnSimpleOnePathToTheRightGameBoard() {
		// setup
		GameBoard gameBoard = new GameBoard(
				"R====&\n" + 
				"I****I\n" + 
				"I*rl*I\n" + 
				"I====I");
		GameBoardCell start = gameBoard.getCell(2, 1);
		GameBoardCell end = gameBoard.getCell(2, 4);
		// expected path
		ArrayList<Integer> expectedPath = new ArrayList<Integer>();
		expectedPath.add(KeyEvent.VK_UP);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT); 
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_DOWN);
		
		// execute
		ArrayList<Integer> path = PathFinder.findPath(start, end, gameBoard.getGrid());
		
		// test
		assertEquals("PathFinder did not find the only path",expectedPath,path);
	}
	
	@Test
	public void testGetPathOnSimpleOnePathToTheLeftGameBoard() {
		// setup
		GameBoard gameBoard = new GameBoard(
				"R====&\n" + 
				"I****I\n" + 
				"I*rl*I\n" + 
				"I====I");
		GameBoardCell start = gameBoard.getCell(2, 4);
		GameBoardCell end = gameBoard.getCell(2, 1);
		// expected path
		ArrayList<Integer> expectedPath = new ArrayList<Integer>();
		expectedPath.add(KeyEvent.VK_UP);
		expectedPath.add(KeyEvent.VK_LEFT);
		expectedPath.add(KeyEvent.VK_LEFT);
		expectedPath.add(KeyEvent.VK_LEFT);
		expectedPath.add(KeyEvent.VK_DOWN);
		
		// execute
		ArrayList<Integer> path = PathFinder.findPath(start, end, gameBoard.getGrid());
		
		// test
		assertEquals("PathFinder did not find the only path",expectedPath,path);
	}
	
	@Test
	public void testGetPathOnSimpleTwoPathGameBoard() {
		// setup
		GameBoard gameBoard = new GameBoard(
				"R====&\n" + 
				"I****I\n" + 
				"I*rl*I\n" + 
				"I*rl*I\n" + 
				"I*rl*I\n" + 
				"I*rl*I\n" + 
				"I****I\n" + 
				"I====I");
		GameBoardCell start = gameBoard.getCell(2, 1);
		GameBoardCell end = gameBoard.getCell(2, 4);
		// expected path
		ArrayList<Integer> expectedPath = new ArrayList<Integer>();
		expectedPath.add(KeyEvent.VK_UP);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_DOWN);
		
		// execute
		ArrayList<Integer> path = PathFinder.findPath(start, end, gameBoard.getGrid());
		
		// test
		assertEquals("PathFinder did not find the only path",expectedPath,path);
	}

	
	@Test
	public void testGetPathOnMediumTwoPathGameBoard() {
		// setup
		GameBoard gameBoard = new GameBoard(
				"R====&\n" + 
				"I***lI\n" + 
				"I*r**I\n" + 
				"I*rl*I\n" + 
				"I*r**I\n" + 
				"I*rl*I\n" + 
				"I****I\n" + 
				"I====I");
		GameBoardCell start = gameBoard.getCell(2, 1);
		GameBoardCell end = gameBoard.getCell(4, 3);
		// expected path
		ArrayList<Integer> expectedPath = new ArrayList<Integer>();
		expectedPath.add(KeyEvent.VK_UP);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_LEFT);
		
		// execute
		ArrayList<Integer> path = PathFinder.findPath(start, end, gameBoard.getGrid());
		
		// test
		assertEquals("PathFinder did not find the only path",expectedPath,path);
	}
	
	@Test
	public void testGetPathOnMediumTwoPathGameBoardIntoLair() {
		// setup
		GameBoard gameBoard = new GameBoard(
				"R=====&\n" + 
				"I*****I\n" + 
				"I*r*l*I\n" + 
				"I*r*l*I\n" + 
				"I*rEl*I\n" + 
				"I*rol*I\n" + 
				"I*===*I\n" + 
				"I*****I\n" + 
				"I=====I");
		GameBoardCell start = gameBoard.getCell(5, 1);
		GameBoardCell end = gameBoard.getCell(5, 3);
		// expected path
		ArrayList<Integer> expectedPath = new ArrayList<Integer>();
		expectedPath.add(KeyEvent.VK_UP);
		expectedPath.add(KeyEvent.VK_UP);
		expectedPath.add(KeyEvent.VK_UP);
		expectedPath.add(KeyEvent.VK_UP);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		
		// execute
		ArrayList<Integer> path = PathFinder.findPath(start, end, gameBoard.getGrid());
		
		// test
		assertEquals("PathFinder did not find the only path",expectedPath,path);
	}
	
	@Test
	public void testGetPathOnMediumTwoPathGameBoardFromLair() {
		// setup
		GameBoard gameBoard = new GameBoard(
				"R=====&\n" + 
				"I*****I\n" + 
				"I*r*l*I\n" + 
				"I*r*l*I\n" + 
				"I*rEl*I\n" + 
				"I*rol*I\n" + 
				"I*===*I\n" + 
				"I*****I\n" + 
				"I=====I");
		GameBoardCell start = gameBoard.getCell(5, 3);
		GameBoardCell end = gameBoard.getCell(5, 1);
		// expected path
		ArrayList<Integer> expectedPath = new ArrayList<Integer>();
		expectedPath.add(KeyEvent.VK_UP);
		expectedPath.add(KeyEvent.VK_UP);
		expectedPath.add(KeyEvent.VK_UP);
		expectedPath.add(KeyEvent.VK_UP);
		expectedPath.add(KeyEvent.VK_LEFT);
		expectedPath.add(KeyEvent.VK_LEFT);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		
		// execute
		ArrayList<Integer> path = PathFinder.findPath(start, end, gameBoard.getGrid());
		
		// test
		assertEquals("PathFinder did not find the only path",expectedPath,path);
	}
	
	@Test
	public void testGetPathOnHardGameBoard() {
		// setup
		GameBoard gameBoard = new GameBoard(
				"R============&R============&\n" +
				"I************II************I\n" +
				"I*r--7*r---7*II*r---7*r--7*I\n" +
				"I*ixxi*ixxxi*II*ixxxi*ixxi*I\n" +
				"I*ixxi*ixxxi*II*ixxxi*ixxi*I\n" +
				"I*l--j*l---j*LJ*l---j*l--j*I\n" +
				"I**************************I\n" +
				"I*r--7*r7*r------7*r7*r--7*I\n" +
				"I*l--j*ii*l--7r--j*ii*l--j*I\n" +
				"I******ii****ii****ii******I\n" +
				"L====&*il--7@ii@r--ji*R====J\n" +
				"xxxxxI*ir--j@lj@l--7i*Ixxxxx\n" +
				"xxxxxI*ii@@@@@@@@@@ii*Ixxxxx\n" +
				"=====J*lj@R==EE==&@lj*L=====\n" +
				"@@@@@@*@@@IooooooI@@@*@@@@@@\n" +
				"=====&*r7@L======J@r7*R=====\n" +
				"xxxxxI*ii@@@@@@@@@@ii*Ixxxxx\n" +
				"xxxxxI*ii@r------7@ii*Ixxxxx\n" +
				"R====J*lj@l--7r--j@lj*L====&\n" +
				"I************ii************I\n" +
				"I*r--7*r---7*ii*r---7*r--7*I\n" +
				"I*l-7i*l---j*lj*l---j*ir-j*I\n" +
				"I***ii****************ii***I\n" +
				"L=&*ii*r7*r------7*r7*ii*R=J\n" +
				"R=J*lj*ii*l--7r--j*ii*lj*L=&\n" +
				"I******ii****ii****ii******I\n" +
				"I*r----jl--7*ii*r--jl----7*I\n" +
				"I*l--------j*lj*l--------j*I\n" +
				"I**************************I\n" +
				"L==========================J");
		GameBoardCell start = gameBoard.getCell(1, 1);
		GameBoardCell end = gameBoard.getCell(28, 26);
		// expected path
		ArrayList<Integer> expectedPath = new ArrayList<Integer>();

		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_DOWN);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);
		expectedPath.add(KeyEvent.VK_RIGHT);

		
		// execute
		ArrayList<Integer> path = PathFinder.findPath(start, end, gameBoard.getGrid());
		
		// test
		assertEquals("PathFinder did not find the only path",expectedPath,path);
	}
	
	
}
