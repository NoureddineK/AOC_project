package callable;

import java.util.concurrent.Callable;
import canal.Promise;
import view.Display;

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
