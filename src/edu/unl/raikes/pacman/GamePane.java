package edu.unl.raikes.pacman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

/** 
 * Purely view-related class that handles the rendering of the grid-based gameboard.
 * @author Stephanie Valentine
 */
@SuppressWarnings("serial")
public class GamePane extends JPanel{
	private double paneWidth = 510;
	private double paneHeight = 600;

	/**
	 * Default instructor that initializes a panel to house the visuals of the gameboard.
	 */
	public GamePane() {
		super();
		this.setPreferredSize(new Dimension((int)paneWidth, (int)paneHeight));
		this.setBackground( Color.BLACK );
	}

	/**
	 * Returns the width of the pane
	 * @return the width of the pane
	 */
	public double getPaneWidth() {
		return paneWidth;
	}

	/**
	 * Sets the width of the pane
	 * @param paneWidth the desired width of the pane
	 */
	public void setPaneWidth(double paneWidth) {
		this.paneWidth = paneWidth;
	}

	/** 
	 * Gets the height of the pane
	 * @return the height of the pane
	 */
	public double getPaneHeight() {
		return paneHeight;
	}

	/**
	 * Sets the height of the pane
	 * @param paneHeight the desired height of the pane
	 */
	public void setPaneHeight(double paneHeight) {
		this.paneHeight = paneHeight;
	}
	
	/**
	 * Sets the dimensions of the GridLayout that rules the gameboard (e.g. 
	 * how many rows and columns are in your gameboard)
	 * @param rows the desired number of rows in the gameboard
	 * @param columns the desired number of columns in the gameboard
	 */
	public void setGridDimensions(int rows, int columns) {
		this.setLayout(new GridLayout(rows,columns));
	}
}