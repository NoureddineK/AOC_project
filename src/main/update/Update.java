package main.update;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

import main.canal.Canal;
import main.view.Display;

@SuppressWarnings("rawtypes")
public class Update implements Callable {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private Canal canal;
	private Display display;
	
	public Update(Canal canal, Display display) {
		LOGGER.info("Constructor: ");
		this.canal = canal;
		this.display = display;
	}

	public Object call() throws Exception {
		LOGGER.info("call: ");
		this.display.update(this.canal);
		return null;
	}

}
