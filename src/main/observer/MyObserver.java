package main.observer;

import main.canal.Promise;

/**
 * @author Noureddine KADRI
 * @author Fahim MERZOUK
 */
public interface MyObserver<T> {
	/**
	 * 
	 * @param subject
	 */
	public void update(T subject);

	/**
	 * Used for Causal Diffusion
	 * 
	 * @param promise
	 */
	public void update(Promise promise);
}
