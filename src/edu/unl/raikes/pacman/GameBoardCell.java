package edu.unl.raikes.pacman;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * GameBoardCell objects handle the display and the functionality of a single
 * cell of the gameboard.
 * @author Stephanie Valentine
 */
@SuppressWarnings("serial")
public class GameBoardCell extends Sprite {
	private GameBoardCellType cellType;
	private GameBoardCellImageType imageType;
	private int row;
	private int col;
	private boolean hasCoin;
	private ArrayList<Agent> agents;
	private static final BufferedImage DOUBLE_CORNER_IMAGE = Sprite.loadImage("images/double_corner.png");
	private static final BufferedImage DOUBLE_LINE_IMAGE = Sprite.loadImage("images/double_line.png");
	private static final BufferedImage SINGLE_CORNER_IMAGE = Sprite.loadImage("images/single_corner.png");
	private static final BufferedImage SINGLE_LINE_IMAGE = Sprite.loadImage("images/single_line.png");
	private static final BufferedImage COIN_IMAGE = Sprite.loadImage("images/coin.png");
	private static final BufferedImage LAIR_ENTRANCE_IMAGE = Sprite.loadImage("images/lair_entrance.png");
	private static final BufferedImage BLANK_IMAGE = Sprite.loadImage("images/blank.png");
	private static HashMap<GameBoardCellImageType, BufferedImage> imageMap = new HashMap<GameBoardCellImageType, BufferedImage>();

	/**
	 * Constructor that accepts a the type of cell, the type of image that 
	 * represents the cell, and the row/column of the cell in the gameboard
	 * @param type the type of cell to create
	 * @param imgType the type of image used to represent that cell
	 * @param row the cell's row in the gameboard
	 * @param col the cell's column in the gameboard
	 */
	public GameBoardCell(GameBoardCellType type, GameBoardCellImageType imgType, int row, int col) {
		initialize(type, imgType, row, col);
	}

	/**
	 * Constructor that accepts a char depicting the type of cell desired
	 * as well as the row and column of the cell in the gameboard
	 * @param ciType a char representing the type of cell desired
	 * @param row the cell's row in the gameboard
	 * @param col the cell's column in the gameboard
	 */
	public GameBoardCell(char ciType, int row, int col) {
		GameBoardCellType ct = GameBoardCellType.getType(ciType);
		GameBoardCellImageType it = GameBoardCellImageType.getType(ciType);
		initialize(ct, it, row, col);
	}

	/**
	 * Initializes the cell
	 * @param cellType type the type of cell to initialize
	 * @param imageType the type of image used to represent that cell
	 * @param row the cell's row in the gameboard
	 * @param col the cell's column in the gameboard
	 */
	private void initialize(GameBoardCellType cellType, GameBoardCellImageType imageType, int row, int col) {
		initializeImageMap();
		this.setCellType(cellType);
		this.setImageType(imageType);
		if(imageType == GameBoardCellImageType.COIN) {
			this.hasCoin = true;
		}
		this.row = row;
		this.col = col;
		this.agents = new ArrayList<Agent>();
	}

	/**
	 * Returns the type of the cell
	 * @return the type of the cell
	 */
	public GameBoardCellType getCellType() {
		return cellType;
	}

	/**
	 * Sets the type of the cell
	 * @param type the desired type of the cell
	 */
	public void setCellType(GameBoardCellType type) {
		this.cellType = type;
	}

	/**
	 * Sets the type of image that represents the cell
	 * @param type the desired type of image to represent the cell
	 */
	public void setImageType(GameBoardCellImageType type) {
		this.imageType = type;
	}

	/**
	 * Gets the row of the cell in the gameboard
	 * @return the row of the cell in the gameboard
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Gets the column of the cell in the gameboard
	 * @return the column of the cell in the gameboard
	 */
	public int getCol() {
		return col;
	}
	
	/**
	 * Returns whether the cell has a coin
	 * @return whether the cell has a coin
	 */
	public boolean getHasCoin() {
		return hasCoin;
	}
	
	/**
	 * Sets whether the cell has a coin
	 * @param hasCoin whether the cell should have a coin
	 */
	public void setHasCoin(boolean hasCoin) {
		this.hasCoin = hasCoin;
	}

	/**
	 * Returns the list of agents that occupy the cell
	 * @return the agents
	 */
	public ArrayList<Agent> getAgents() {
		return agents;
	}
	
	/**
	 * Adds an agent to occupy the cell (more than one agent may occupy a cell)
	 * @param agent the agent that will occupy the cell
	 */
	public void addAgent(Agent agent) {
		this.agents.add(agent);
		repaint();
	}
	
	/**
	 * Removes an agent from the cell
	 * @param agent the agent to remove from the cell
	 */
	public void removeAgent(Agent agent) {
		this.agents.remove(agent);
	}

	/**
	 * Initializes the map of images used to speed up rendering time
	 */
	public void initializeImageMap() {
		if(imageMap.size() > 0) {
			return;
		}
		// BORDER_UP_RIGHT
		BufferedImage bur = DOUBLE_CORNER_IMAGE;
		bur = Sprite.reflectImgHorizontally(bur);
		imageMap.put(GameBoardCellImageType.BORDER_UP_RIGHT, bur);
		
		// UP RIGHT
		BufferedImage ur = SINGLE_CORNER_IMAGE;
		ur = Sprite.reflectImgHorizontally(ur);
		imageMap.put(GameBoardCellImageType.UP_RIGHT, ur);
		
		// BORDER RIGHT DOWN
		BufferedImage brd = DOUBLE_CORNER_IMAGE;
		imageMap.put(GameBoardCellImageType.BORDER_RIGHT_DOWN, brd);
		

		// BORDER RIGHT DOWN
		BufferedImage rd = SINGLE_CORNER_IMAGE;
		imageMap.put(GameBoardCellImageType.RIGHT_DOWN, rd);
		
		// BORDER HORIZONTAL 
		BufferedImage bh = DOUBLE_LINE_IMAGE;
		imageMap.put(GameBoardCellImageType.BORDER_HORIZONTAL, bh);
		
		// HORIZONTAL
		BufferedImage h = SINGLE_LINE_IMAGE;
		imageMap.put(GameBoardCellImageType.HORIZONTAL, h);
		
		// BORDER VERTICAL 
		BufferedImage bv = DOUBLE_LINE_IMAGE;
		bv = Sprite.rotateImg(bv, 90);
		imageMap.put(GameBoardCellImageType.BORDER_VERTICAL, bv);
		
		// VERTICAL 
		BufferedImage v = SINGLE_LINE_IMAGE;
		v = Sprite.rotateImg(v, 90);
		imageMap.put(GameBoardCellImageType.VERTICAL, v);
		
		// BORDER RIGHT UP
		BufferedImage bru = DOUBLE_CORNER_IMAGE;
		bru = Sprite.rotateImg(bru, 90);
		imageMap.put(GameBoardCellImageType.BORDER_RIGHT_UP, bru);
		
		// BORDER RIGHT UP
		BufferedImage ru = SINGLE_CORNER_IMAGE;
		ru = Sprite.rotateImg(ru, 90);
		imageMap.put(GameBoardCellImageType.RIGHT_UP, ru);
		
		// BORDER DOWN RIGHT
		BufferedImage bdr = DOUBLE_CORNER_IMAGE;
		bdr = Sprite.rotateImg(bdr, 90);
		bdr = Sprite.reflectImgHorizontally(bdr);
		imageMap.put(GameBoardCellImageType.BORDER_DOWN_RIGHT, bdr);
		
		// DOWN RIGHT
		BufferedImage dr = SINGLE_CORNER_IMAGE;
		dr = Sprite.rotateImg(dr, 90);
		dr = Sprite.reflectImgHorizontally(dr);
		imageMap.put(GameBoardCellImageType.DOWN_RIGHT, dr);
		
		// LAIR ENTRANCE
		BufferedImage le = LAIR_ENTRANCE_IMAGE;
		imageMap.put(GameBoardCellImageType.LAIR_ENTRANCE, le);
				
		// COIN
		BufferedImage c = COIN_IMAGE;
		imageMap.put(GameBoardCellImageType.COIN, c);
		
		// empty
		BufferedImage img = BLANK_IMAGE;
		imageMap.put(GameBoardCellImageType.EMPTY, img);
	}

	@Override
	public void paint(Graphics g) {
		// draw self
		double left = 0;
		double top = 0;
		double width = this.getWidth();
		double height = this.getHeight();
		this.drawImage(g, this.getImage(), top, left, width, height);
		
		// TODO: Assignment 4: draw all the agents residing in this cell
	}

	@Override
	public BufferedImage getImage() {
		return imageMap.get(this.imageType);
	}

	@Override
	public String toString() {
		return "row="+this.getRow() 
				+ " col="+this.getCol()
				+" type="+this.getCellType()
				+" imageType="+this.imageType;
	}

}
