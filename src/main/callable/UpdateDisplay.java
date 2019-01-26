package main.callable;

import java.util.concurrent.Callable;

import main.canal.Canal;
import main.view.Display;

@SuppressWarnings("rawtypes")
public class UpdateDisplay implements Callable {

	private Canal canal;
	private Display display;

	public UpdateDisplay(Canal canal, Display display) {
		this.canal = canal;
		this.display = display;
	}

	public Object call() throws Exception {
		display.update(canal);
		return null; 
	}

}