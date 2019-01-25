package Callable;

import java.util.concurrent.Callable;

import canal.Promise;
import view.Display;

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
