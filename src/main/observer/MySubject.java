package main.observer;

public interface MySubject {
	public void attach(Object o);
	public void detach(Object o);
}
