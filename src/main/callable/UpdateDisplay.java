package main.callable;

import java.util.concurrent.Callable;

import main.canal.Canal;
import main.view.Display;
/**
 * @author Noureddine KADRI & Fahim MERZOUK
 * Update Monitors value
 */
@SuppressWarnings("rawtypes")
public class UpdateDisplay implements Callable {

	private Canal canal;
	private Display display;
/**
 * 
 * @param canal
 * @param display
 */
	public UpdateDisplay(Canal canal, Display display) {
		this.canal = canal;
		this.display = display;
	}
/**
 * Return Display canal, dont need a return value
 * @return Object
 */
	public Object call() throws Exception {
		display.update(canal);
		return null; 
	}

}