package main.callable;

import java.util.concurrent.Callable;

import main.canal.Promise;
import main.view.Display;
/**
 * @author Noureddine KADRI  
 * @author Fahim MERZOUK
 * 
 * Update Causal value
 */
@SuppressWarnings("rawtypes")
public class UpdatePromise implements Callable {

	private Promise promise;
	private Display display;

	public UpdatePromise(Promise promise, Display display) {
		this.promise = promise;
		this.display = display;
	}

	public Object call() throws Exception {
		display.update(promise);
		return null;
	}
}
