package view;

import java.util.concurrent.Future;
import java.util.logging.Logger;
import generator.GeneratorAsync;
import observer.ObserverGenerator;


public class Display implements ObserverGenerator {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private Integer value;
	private int id; 
	
	public Display(int id) {
		LOGGER.info("Constructor: ");
		this.id = id;
		this.value = 0;
	}

	@Override
	public void update(GeneratorAsync g) throws Exception {
		LOGGER.info("update: ");
		Future<Integer> future = g.getValue();
		value = future.get();
		System.out.println("Afficheur " + id + " : " + value);
	}

	public Integer getValue() {
		LOGGER.info("getValue: "+ this.value);
		return this.value;
	}

}
