package edu.unl.raikes.pacman;

/**
 * Defines the types of cells in the PacMan Game
 * @author Stephanie Valentine
 */
public enum GameBoardCellType {
	WALL, PASSAGEWAY, LAIR_ENTRANCE, LAIR, BLANK;

	/**
	 * Returns the type of cell represented by a provided char
	 * @param c the char representing a cell type
	 * @return the cell type represented by the char
	 */
	public static GameBoardCellType getType(char c) {
		switch (c) {
		case '-':
		case '=':
		case 'I':
		case 'i':
		case 'L':
		case 'l':
		case 'R':
		case 'r':
		case '&':
		case '7':
		case 'J':
		case 'j':
			return WALL;
		case '*':
		case '@':
			return PASSAGEWAY;
		case 'E':
			return LAIR_ENTRANCE;
		case 'o':
			return LAIR;
		default:
			return BLANK;
		}
	}
}
