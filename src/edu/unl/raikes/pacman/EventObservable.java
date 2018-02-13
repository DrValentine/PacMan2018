package edu.unl.raikes.pacman;

/**
 * The subject interface for the observer pattern. Implementing classes keep a
 * list of observers. Use the add/remove functions to add/remove observers. Notify
 * the observers when an important change in state occurs.
 * @author Stephanie Valentine
 */
public interface EventObservable {
	/**
	 * Notify add an event observer so it can be notified when an important change
	 * in state occurs.
	 * @param observer the observer that wants to be notified
	 */
	public void addEventObserver(EventObserver observer);
	
	/**
	 * Remove an observer that no longer wants to be notified when an important 
	 * change in state occurs.
	 * @param observer the observer that no longer wants to be notified
	 */
	public void removeEventObserver(EventObserver observer);
	
	/**
	 * Notify the observers that an important change of state occurred.
	 */
	public void notifyObservers();
}
