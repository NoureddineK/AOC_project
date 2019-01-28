package main.observer;
/**
 * 
 * @author Noureddine KADRI & Fahim MERZOUK
 *
 */
public interface MySubject {
	public void attach(Object o);
	public void detach(Object o);
}
