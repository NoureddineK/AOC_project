package main.observer;

import main.canal.Promise;
/**
 * 
 * @author Noureddine KADRI & Fahim MERZOUK
 *
 */
public interface MyObserver<T> {
	public void update(T subject);
	public void update(Promise promise);
}
