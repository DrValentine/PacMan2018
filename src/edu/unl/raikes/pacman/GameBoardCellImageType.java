package edu.unl.raikes.pacman;

/**
 * Types of images that visually define GameBoardCells.
 * @author Stephanie Valentine
 */
public enum GameBoardCellImageType {
	BORDER_HORIZONTAL, BORDER_VERTICAL,
	BORDER_UP_RIGHT, BORDER_RIGHT_DOWN, BORDER_DOWN_RIGHT, BORDER_RIGHT_UP, 
	HORIZONTAL, VERTICAL, UP_RIGHT, RIGHT_DOWN, DOWN_RIGHT, RIGHT_UP, 
	LAIR_ENTRANCE, COIN, EMPTY;

	/**
	 * Given a char c, returns the GameBoardCellImageType.
	 * @param c the char whose type needs determining
	 * @return the type represented by the char
	 */
	public static GameBoardCellImageType getType(char c) {
		switch (c) {
		case '=':
			return BORDER_HORIZONTAL;
		case '-':
			return HORIZONTAL;
		case 'R':
			return BORDER_UP_RIGHT;
		case 'r':
			return UP_RIGHT;
		case 'L':
			return BORDER_DOWN_RIGHT;
		case 'l':
			return DOWN_RIGHT;
		case '&':
			return BORDER_RIGHT_DOWN;
		case '7':
			return RIGHT_DOWN;
		case 'J':
			return BORDER_RIGHT_UP;
		case 'j':
			return RIGHT_UP;
		case 'I':
			return BORDER_VERTICAL;
		case 'i':
			return VERTICAL;
		case '*':
			return COIN;
		case 'E':
			return LAIR_ENTRANCE;
		case '@':
			return EMPTY;
		default:
			return EMPTY;
		}
	}
}
