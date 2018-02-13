package edu.unl.raikes.pacman;

/**
 * The observer interface for the observer design pattern. Contains a
 * function that responds to the state change of the subject.
 * @author Stephanie Valentine
 */
public interface EventObserver {
	/**
	 * Responds to the state change of the subject. Must determine what
	 * part of the state changed and respond to the change accordingly.
	 */
	public void respondToEvent();
}
